package com.ssw331.warehousebackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssw331.warehousebackend.MySQLDTO.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DirectorDirectorMapper extends BaseMapper<StaticDirectorDirector> {
    @Select("SELECT * FROM StaticDirectorDirector ORDER BY collaboration_number DESC LIMIT 20")
    List<StaticDirectorDirector> findTop20DirectorDirectorCollaborations();
}
