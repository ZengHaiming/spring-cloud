package com.zenghm.spring.boot.mapper;

import com.zenghm.spring.boot.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create date:20/7/29.
 * Created by: zhm.
 * Class name:UsersMapper.
 */
@Mapper
public interface UsersMapper {
    public List<Users> getList();
}
