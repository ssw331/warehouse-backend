package com.ssw331.warehousebackend.sparkService;

import com.ssw331.warehousebackend.MySQLDTO.StaticActorActor;
import com.ssw331.warehousebackend.MySQLDTO.StaticDirectorActor;
import com.ssw331.warehousebackend.MySQLDTO.StaticDirectorDirector;
import org.springframework.stereotype.Service;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.*;
import java.util.List;

@Service
public interface SparkRelationService {
    List<StaticDirectorActor> getTop20DirectorActorCollaborations() throws AnalysisException;
    List<StaticActorActor> getTop20ActorActorCollaborations() throws AnalysisException;
    List<StaticDirectorDirector> getTop20DirectorDirectorCollaborations() throws AnalysisException;
}
