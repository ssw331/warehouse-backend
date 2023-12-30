package com.ssw331.warehousebackend.sparkService.Impl;

import com.ssw331.warehousebackend.sparkService.MovieDirectorService;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import java.util.List;

@Component
public class SparkMovieDirectorServiceImpl implements MovieDirectorService {
    private final SparkSession sparkSession;

    @Autowired
    public SparkMovieDirectorServiceImpl(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    @Override
    public List<String> getMovieNamesByDirectorName(String directorName) {
        String sql = "SELECT m.movie_name FROM Movie m JOIN MovieDirector md ON m.movie_id = md.movie_id " +
                "WHERE md.director_name LIKE '%" + directorName + "%'";
        Dataset<Row> result = sparkSession.sql(sql);
        return result.as(Encoders.STRING()).collectAsList();
    }
}

