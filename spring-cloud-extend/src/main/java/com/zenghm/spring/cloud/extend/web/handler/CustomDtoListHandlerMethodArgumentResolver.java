package com.zenghm.spring.cloud.extend.web.handler;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

/**
 * @author Airlen
 * @date 2021/4/18
 * @description xxx
 */
public class CustomDtoListHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    private Logger logger = LoggerFactory.getLogger(CustomDtoListHandlerMethodArgumentResolver.class);
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        logger.info("判断当前解析器是否支持当前参数的解析");
        //属于集合类型
       if(Collection.class.isAssignableFrom(methodParameter.getParameterType())){
           if(methodParameter.getGenericParameterType() instanceof ParameterizedType){
               ParameterizedType parameterizedType = (ParameterizedType) methodParameter.getGenericParameterType();
               Type[] actTypes =  parameterizedType.getActualTypeArguments();
               if(actTypes[0] instanceof Class){
                   if(Map.class.isAssignableFrom((Class<?>) actTypes[0])){
                       return true;
                   }else if(((Class<?>) actTypes[0]).isInterface()){
                       return false;
                   }
               }
               return true;
           }
       }
       return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        logger.info("进入自定义参数解析器");
        ParameterizedType parameterizedType = (ParameterizedType) methodParameter.getGenericParameterType();
        Type[] actTypes =  parameterizedType.getActualTypeArguments();
        String className ;
        if(actTypes.length>0){
            className = actTypes[0].getTypeName();
        }else {
            //解析异常
            return null;
        }
        Class actClass = Class.forName(className);
        //获取请求参数在request 中的key值
        String requestParamName;
        //检测是否存在注解
        if(methodParameter.hasParameterAnnotation(RequestParam.class)){
            RequestParam requestParam = methodParameter.getParameterAnnotation(RequestParam.class);
            requestParamName = requestParam.value();
        }else {
            requestParamName = methodParameter.getParameterName();
        }
        String paramValue = nativeWebRequest.getParameter(requestParamName);
        return JSONUtil.toList(paramValue,actClass);
    }
}
