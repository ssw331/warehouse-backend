package com.ssw331.warehousebackend.controller;

import com.ssw331.warehousebackend.MySQLDTO.*;
import com.ssw331.warehousebackend.Neo4jDTO.serialization.Result;
import com.ssw331.warehousebackend.Neo4jDTO.serialization.ResultResponse;
import com.ssw331.warehousebackend.service.Impl.Neo4jServiceImpl;
import com.ssw331.warehousebackend.service.MySQLService;
import com.ssw331.warehousebackend.service.Neo4jService;
import com.ssw331.warehousebackend.service.TimeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "按照电影名称查询")
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MySQLService mySQLService;
    @Autowired
    private  Neo4jService neo4jService;

    @Autowired
    private void setNeo4jService(Neo4jService neo4jService){
        this.neo4jService=neo4jService;
    }
    @Autowired
    private void setMySQLService(MySQLService mySQLService) {
        this.mySQLService=mySQLService;
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<Object> timeYear(@RequestParam String movieName) {
        List<Long> modelTimes = new ArrayList<>();
        List<String> modelLogs = new ArrayList<>();
        long startTime1 = System.currentTimeMillis();
        List<Product> dataFromMySQL=mySQLService.getProductsByMovieName(movieName);
        modelTimes.add(System.currentTimeMillis() - startTime1);
        modelLogs.add("SELECT p.* " +
                "FROM Product p " +
                "JOIN MovieProduct mp ON p.product_id = mp.product_id " +
                "JOIN Movie m ON mp.movie_id = m.movie_id " +
                "WHERE m.movie_name LIKE "+movieName+";");

        //hive待写
        long startTime2 = System.currentTimeMillis();
        modelTimes.add(0L);
        modelLogs.add("");

        long startTime3 = System.currentTimeMillis();
        List<com.ssw331.warehousebackend.Neo4jDTO.Product> data = neo4jService.searchMoviesByName(movieName);
        modelTimes.add(System.currentTimeMillis() - startTime3);
        modelLogs.add("MATCH (m:Movie)-[r:INCLUDE]->(p:Product) WHERE m.movie_name contains "+movieName+" RETURN p;");
        return ResultResponse.success(data, modelTimes, modelLogs);
    }
}
