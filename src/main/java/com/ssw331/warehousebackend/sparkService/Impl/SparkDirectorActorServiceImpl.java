package com.ssw331.warehousebackend.sparkService.Impl;

import com.ssw331.warehousebackend.sparkService.DirectorActorService;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import java.util.List;

@Component
public class SparkDirectorActorServiceImpl implements DirectorActorService {

    private final SparkSession sparkSession;

    @Autowired
    public SparkDirectorActorServiceImpl(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    @Override
    public List<String> getActorNamesByDirectorName(String directorName) {
        String sql = "SELECT actor_name FROM StaticDirectorActor WHERE director_name = '" + directorName + "'";
        Dataset<Row> result = sparkSession.sql(sql);
        return result.as(Encoders.STRING()).collectAsList();
    }

    @Override
    public List<String> getDirectorNamesByDirectorName(String directorName) {
        String sql = "SELECT director_name2 FROM StaticDirectorDirector WHERE director_name1 = '" + directorName + "'";
        Dataset<Row> result = sparkSession.sql(sql);
        return result.as(Encoders.STRING()).collectAsList();
    }

    @Override
    public List<String> getActorNamesByActorName(String actorName) {
        String sql = "SELECT actor_name2 FROM StaticActorActor WHERE actor_name1 = '" + actorName + "'";
        Dataset<Row> result = sparkSession.sql(sql);
        return result.as(Encoders.STRING()).collectAsList();
    }

    @Override
    public List<String> getDirectorNamesByActorName(String actorName) {
        String sql = "SELECT director_name FROM StaticDirectorActor WHERE actor_name = '" + actorName + "'";
        Dataset<Row> result = sparkSession.sql(sql);
        return result.as(Encoders.STRING()).collectAsList();
    }
}
