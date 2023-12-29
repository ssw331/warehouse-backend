package com.ssw331.warehousebackend.service.repo;

import com.ssw331.warehousebackend.dao.Product;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ProductRepository extends Neo4jRepository<Product, String> {
    interface movieIdAndGrade {
        String getMovieId();
        String getGrade();
    }
//    @Query("MATCH (m:Movie)-[r:INCLUDE]->(p:Product) RETURN p.movie_id, p.Grade;")
//    List<HashMap<String, String>> searchProductsWithGrade();
}
