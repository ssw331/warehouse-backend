package com.ssw331.warehousebackend.sparkService.Impl;

import com.ssw331.warehousebackend.service.MySQLTimeService;
import org.apache.spark.sql.Dataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
@Component
public class SparkMySQLTimeServiceImpl implements MySQLTimeService {
    private final SparkSession sparkSession;

    @Autowired
    public SparkMySQLTimeServiceImpl(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    @Override
    public int getMovieCountByYear(int year) {
        String sql = "SELECT COUNT(*) FROM Movie m JOIN Time t ON m.release_time_id = t.release_time_id " +
                "WHERE t.year = " + year;
        Dataset<Row> result = sparkSession.sql(sql);
        return (int) result.collectAsList().get(0).getLong(0);
    }

    @Override
    public int getMovieCountByYearAndMonth(int year, int month) {
        String sql = "SELECT COUNT(*) FROM Movie m JOIN Time t ON m.release_time_id = t.release_time_id " +
                "WHERE t.year = " + year + " AND t.month = " + month;
        Dataset<Row> result = sparkSession.sql(sql);
        return (int) result.collectAsList().get(0).getLong(0);
    }

    @Override
    public int getMovieCountByYearAndMonthAndDay(int year, int month, int day) {
        String sql = "SELECT COUNT(*) FROM Movie m JOIN Time t ON m.release_time_id = t.release_time_id " +
                "WHERE t.year = " + year + " AND t.month = " + month + " AND t.day = " + day;
        Dataset<Row> result = sparkSession.sql(sql);
        return (int) result.collectAsList().get(0).getLong(0);
    }

    @Override
    public int getMovieCountByQuarter(int year, String quarter) {
        int season = convertQuarterToSeason(quarter);
        String sql = "SELECT COUNT(*) FROM Movie m JOIN Time t ON m.release_time_id = t.release_time_id " +
                "WHERE t.year = " + year + " AND t.season = " + season;
        Dataset<Row> result = sparkSession.sql(sql);
        return (int) result.collectAsList().get(0).getLong(0);
    }

    private int convertQuarterToSeason(String quarter) {
        switch (quarter) {
            case "Q1":
                return 1;
            case "Q2":
                return 2;
            case "Q3":
                return 3;
            case "Q4":
                return 4;
            default:
                throw new IllegalArgumentException("Invalid quarter: " + quarter);
        }
    }

}

