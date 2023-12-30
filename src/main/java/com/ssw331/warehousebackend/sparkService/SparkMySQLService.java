package com.ssw331.warehousebackend.sparkService;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.*;
import org.springframework.stereotype.Service;

@Service
public interface SparkMySQLService {
    int getMovieCountByYear(int year) throws AnalysisException;
    int getMovieCountByYearAndMonth(int year, int month) throws AnalysisException;
    int getMovieCountByYearAndMonthAndDay(int year, int month, int day) throws AnalysisException;
    int getMovieCountByQuarter(int year, String quarter) throws AnalysisException;
}
