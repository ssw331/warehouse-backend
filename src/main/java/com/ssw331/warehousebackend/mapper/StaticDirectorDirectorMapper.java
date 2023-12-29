package com.ssw331.warehousebackend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssw331.warehousebackend.MySQLDTO.StaticDirectorActor;
import com.ssw331.warehousebackend.MySQLDTO.StaticDirectorDirector;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaticDirectorDirectorMapper extends BaseMapper<StaticDirectorActor> {
    List<StaticDirectorDirector> selectList(QueryWrapper<StaticDirectorDirector> queryWrapper);
}
