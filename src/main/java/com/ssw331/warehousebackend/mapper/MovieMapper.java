package com.ssw331.warehousebackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssw331.warehousebackend.MySQLDTO.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieMapper extends BaseMapper<Movie> {
    @Select("SELECT m.* FROM Movie m " +
            "JOIN MovieProduct mp ON m.movie_id = mp.movie_id " +
            "JOIN Product p ON mp.product_id = p.product_id " +
            "WHERE p.grade > 4")
    List<Movie> findMoviesWithHighGradeProducts();
    @Select("SELECT movie_name FROM Movie WHERE Type LIKE CONCAT('%', #{type}, '%')")
    List<String> findMoviesByType(String type);
}

