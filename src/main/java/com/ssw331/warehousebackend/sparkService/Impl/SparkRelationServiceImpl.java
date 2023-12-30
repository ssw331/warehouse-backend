package com.ssw331.warehousebackend.sparkService.Impl;
import org.apache.spark.sql.*;

import com.ssw331.warehousebackend.MySQLDTO.StaticActorActor;
import com.ssw331.warehousebackend.MySQLDTO.StaticDirectorActor;
import com.ssw331.warehousebackend.MySQLDTO.StaticDirectorDirector;
import com.ssw331.warehousebackend.sparkService.SparkRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import java.util.List;

@Component
public class SparkRelationServiceImpl implements SparkRelationService {
    private final SparkSession sparkSession;

    @Autowired
    public SparkRelationServiceImpl(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    @Override
    public List<StaticDirectorActor> getTop20DirectorActorCollaborations() {
        String sql = "SELECT * FROM StaticDirectorActor ORDER BY collaboration_number DESC LIMIT 20";
        Dataset<Row> result = sparkSession.sql(sql);
        return result.as(Encoders.bean(StaticDirectorActor.class)).collectAsList();
    }

    @Override
    public List<StaticActorActor> getTop20ActorActorCollaborations() {
        String sql = "SELECT * FROM StaticActorActor ORDER BY collaboration_number DESC LIMIT 20";
        Dataset<Row> result = sparkSession.sql(sql);
        return result.as(Encoders.bean(StaticActorActor.class)).collectAsList();
    }

    @Override
    public List<StaticDirectorDirector> getTop20DirectorDirectorCollaborations() {
        String sql = "SELECT * FROM StaticDirectorDirector ORDER BY collaboration_number DESC LIMIT 20";
        Dataset<Row> result = sparkSession.sql(sql);
        return result.as(Encoders.bean(StaticDirectorDirector.class)).collectAsList();
    }



}

