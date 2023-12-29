package com.ssw331.warehousebackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssw331.warehousebackend.MySQLDTO.MovieDirector;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface MovieDirectorMapper extends BaseMapper<MovieDirector> {
}

