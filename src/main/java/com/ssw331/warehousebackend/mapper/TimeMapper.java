package com.ssw331.warehousebackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssw331.warehousebackend.MySQLDTO.Time;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeMapper extends BaseMapper<Time> {
}

