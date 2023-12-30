package com.ssw331.warehousebackend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssw331.warehousebackend.MySQLDTO.StaticActorActor;
import com.ssw331.warehousebackend.MySQLDTO.StaticDirectorActor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StaticActorActorMapper extends BaseMapper<StaticActorActor> {
    @Select("SELECT actor_name2 FROM StaticActorActor WHERE actor_name1 = #{actorName}")
    List<String> selectActorNamesByActorName(@Param("actorName") String actorName);
}
