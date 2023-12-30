package com.ssw331.warehousebackend.sparkService;

import com.ssw331.warehousebackend.MySQLDTO.Product;
import org.springframework.stereotype.Service;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.*;
import java.util.List;

@Service
public interface SparkProductByNameService {
    List<Product> getProductsByMovieName(String movieName) throws AnalysisException;
}
