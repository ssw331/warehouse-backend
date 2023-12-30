package com.ssw331.warehousebackend.sparkService.Impl;

import com.ssw331.warehousebackend.sparkService.DirectorActorService;
import com.ssw331.warehousebackend.sparkService.MovieActorService;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import java.util.List;

@Component
public class SparkMovieActorServiceImpl implements MovieActorService {

    private final SparkSession sparkSession;

    @Autowired
    public SparkMovieActorServiceImpl(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    @Override
    public List<String> getMovieNamesByActorName(String actorName) {
        String sql = "SELECT m.movie_name FROM Movie m JOIN MovieActor ma ON m.movie_id = ma.movie_id " +
                "WHERE ma.actor_name LIKE '%" + actorName + "%'";
        Dataset<Row> result = sparkSession.sql(sql);
        return result.as(Encoders.STRING()).collectAsList();
    }
}

