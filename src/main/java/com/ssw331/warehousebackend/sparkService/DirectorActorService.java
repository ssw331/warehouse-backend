package com.ssw331.warehousebackend.sparkService;

import org.apache.spark.sql.AnalysisException;
import org.springframework.stereotype.Service;
import org.apache.spark.sql.SparkSession;
import java.util.List;

public interface DirectorActorService {
    List<String> getActorNamesByDirectorName(String directorName);

    List<String> getDirectorNamesByDirectorName(String directorName);

    List<String> getActorNamesByActorName(String actorName);

    List<String> getDirectorNamesByActorName(String actorName);

    @Service
    public interface SparkDirectorActorService {
        List<String> getActorNamesByDirectorName(String directorName) throws AnalysisException;
        List<String> getDirectorNamesByDirectorName(String directorName) throws AnalysisException;
        List<String> getActorNamesByActorName(String actorName) throws AnalysisException;
        List<String> getDirectorNamesByActorName(String actorName) throws AnalysisException;
    }
}
