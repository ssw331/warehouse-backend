package com.ssw331.warehousebackend.hiveMapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssw331.warehousebackend.MySQLDTO.StaticDirectorActor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DS("hive")
public interface HiveStaticDirectorActorMapper extends BaseMapper<StaticDirectorActor> {
}
