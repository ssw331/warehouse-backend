package com.ssw331.warehousebackend.sparkService;

import org.springframework.stereotype.Service;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.*;
import java.util.List;

@Service
public interface MovieDirectorService {
    List<String> getMovieNamesByDirectorName(String directorName) throws AnalysisException;
}
