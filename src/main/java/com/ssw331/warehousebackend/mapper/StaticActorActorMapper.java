package com.ssw331.warehousebackend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssw331.warehousebackend.MySQLDTO.StaticActorActor;
import com.ssw331.warehousebackend.MySQLDTO.StaticDirectorActor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaticActorActorMapper extends BaseMapper<StaticDirectorActor> {
    List<StaticActorActor> selectList(QueryWrapper<StaticActorActor> queryWrapper);
}