package com.ssw331.warehousebackend.sparkService;

import com.ssw331.warehousebackend.MySQLDTO.Movie;
import org.springframework.stereotype.Service;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.*;
import java.util.List;

@Service
public interface MovieService {
    List<Movie> getMoviesWithHighGradeProducts() throws AnalysisException;
    List<String> getMoviesByType(String type) throws AnalysisException;
    int countMoviesByYearAndType(int year, String type) throws AnalysisException;
}
