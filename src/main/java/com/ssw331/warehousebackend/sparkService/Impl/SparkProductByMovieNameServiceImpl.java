package com.ssw331.warehousebackend.sparkService.Impl;

import com.ssw331.warehousebackend.MySQLDTO.Product;
import com.ssw331.warehousebackend.sparkService.SparkProductByNameService;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import java.util.List;

@Component
public class SparkProductByMovieNameServiceImpl implements SparkProductByNameService {
    private SparkSession sparkSession;

    @Autowired
    public void SparkProductByNameServiceImpl(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    public SparkProductByMovieNameServiceImpl(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    @Override
    public List<Product> getProductsByMovieName(String movieName) {
        String sql = "SELECT p.* FROM Product p JOIN MovieProduct mp ON p.product_id = mp.product_id " +
                "JOIN Movie m ON mp.movie_id = m.movie_id WHERE m.movie_name LIKE '%" + movieName + "%'";
        Dataset<Row> result = sparkSession.sql(sql);
        return result.as(Encoders.bean(Product.class)).collectAsList();
    }
}

