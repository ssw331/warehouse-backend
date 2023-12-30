package com.ssw331.warehousebackend.sparkService.Impl;

import com.ssw331.warehousebackend.MySQLDTO.Movie;
import com.ssw331.warehousebackend.sparkService.MovieService;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import java.util.List;

@Component
public class SparkMovieServiceImpl implements MovieService {
    private final SparkSession sparkSession;

    @Autowired
    public SparkMovieServiceImpl(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    @Override
    public List<Movie> getMoviesWithHighGradeProducts() {
        String sql = "SELECT m.* FROM Movie m " +
                "JOIN MovieProduct mp ON m.movie_id = mp.movie_id " +
                "JOIN Product p ON mp.product_id = p.product_id " +
                "WHERE p.grade > 4.9 AND p.comment_number > 990";
        Dataset<Row> result = sparkSession.sql(sql);
        return result.as(Encoders.bean(Movie.class)).collectAsList();
    }

    @Override
    public List<String> getMoviesByType(String type) {
        String sql = "SELECT movie_name FROM Movie WHERE Type LIKE '%" + type + "%'";
        Dataset<Row> result = sparkSession.sql(sql);
        return result.as(Encoders.STRING()).collectAsList();
    }

    @Override
    public int countMoviesByYearAndType(int year, String type) {
        String sql = "SELECT COUNT(*) FROM Movie m JOIN Time t ON m.release_time_id = t.release_time_id " +
                "WHERE t.year = " + year + " AND m.Type LIKE '%" + type + "%'";
        Dataset<Row> result = sparkSession.sql(sql);
        return (int) result.collectAsList().get(0).getLong(0);
    }
}

