package com.ssw331.warehousebackend.sparkService;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieActorService {
    List<String> getMovieNamesByActorName(String actorName) throws AnalysisException;
}
