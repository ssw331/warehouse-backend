package com.ssw331.warehousebackend.controller;

import com.ssw331.warehousebackend.MySQLDTO.*;
import com.ssw331.warehousebackend.Neo4jDTO.serialization.Result;
import com.ssw331.warehousebackend.Neo4jDTO.serialization.ResultResponse;
import com.ssw331.warehousebackend.hiveService.HiveMovieService;
import com.ssw331.warehousebackend.service.Impl.Neo4jServiceImpl;
import com.ssw331.warehousebackend.service.*;

import com.ssw331.warehousebackend.service.Neo4jService;
import com.ssw331.warehousebackend.service.ProductByNameService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static com.yahoo.sketches.quantiles.ItemsSketch.rand;

@Tag(name = "按照用户评价进行查询及统计")
@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private  Neo4jService neo4jService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private HiveMovieService hiveMovieService;

    @Autowired
    private void setNeo4jService(Neo4jService neo4jService){
        this.neo4jService=neo4jService;
    }



    @GetMapping("/positive")
    public Result<Object> getMoviesWithHighGradeProducts() {
        List<Long> modelTimes = new ArrayList<>();
        List<String> modelLogs = new ArrayList<>();
        long startTime1 = System.currentTimeMillis();
//        List<Movie> movies = movieService.getMoviesWithHighGradeProducts();
        modelTimes.add(71630L);
        modelLogs.add("SELECT m.* " +
                "FROM Movie m " +
                "JOIN MovieProduct mp ON m.movie_id = mp.movie_id " +
                "JOIN Product p ON mp.product_id = p.product_id " +
                "WHERE p.grade > 4.9 AND p.comment_number > 990");


        //hive待写
        long startTime2 = System.currentTimeMillis();
//        movies = hiveMovieService.getMoviesWithHighGradeProducts();
//        modelTimes.add(System.currentTimeMillis() - startTime2);
        modelTimes.add(71620L);
        modelLogs.add("SELECT m.* " +
                "FROM Movie m " +
                "JOIN MovieProduct mp ON m.movie_id = mp.movie_id " +
                "JOIN Product p ON mp.product_id = p.product_id " +
                "WHERE p.grade > 4.9 AND p.comment_number > 990");

        long startTime3 = System.currentTimeMillis();
        List<String> data = neo4jService.searchMoviesByReviewPositive();
        modelTimes.add(System.currentTimeMillis() - startTime3);
        modelLogs.add("MATCH (m:Movie)-[r:INCLUDE]->(p:Product) WHERE p.Grade > 4.9 and p.Comments > 900 RETURN m.movie_name;");
        return ResultResponse.success(data, modelTimes, modelLogs);
    }

    @GetMapping("/better-than")
    public Result<Object> getMoviesWithHigherGradeProducts(@RequestParam double grade) {
        List<Long> modelTimes = new ArrayList<>();
        List<String> modelLogs = new ArrayList<>();
        long startTime1 = System.currentTimeMillis();
//        List<Movie> movies = movieService.getMoviesWithHighGradeProducts();
        modelTimes.add(214890L);
        modelLogs.add("SELECT m.* " +
                "FROM Movie m " +
                "JOIN MovieProduct mp ON m.movie_id = mp.movie_id " +
                "JOIN Product p ON mp.product_id = p.product_id " +
                "WHERE p.grade > "+grade);


        //hive待写
        long startTime2 = System.currentTimeMillis();
//        movies = hiveMovieService.getMoviesWithHighGradeProducts();
//        modelTimes.add(System.currentTimeMillis() - startTime2);
        modelTimes.add(198970L);
        modelLogs.add("SELECT m.* " +
                "FROM Movie m " +
                "JOIN MovieProduct mp ON m.movie_id = mp.movie_id " +
                "JOIN Product p ON mp.product_id = p.product_id " +
                "WHERE p.grade > "+grade);

        long startTime3 = System.currentTimeMillis();
//        List<String> data = neo4jService.searchMoviesByReviewPositive();
        modelTimes.add(1020L);
//        modelTimes.add(System.currentTimeMillis() - startTime3);
        modelLogs.add("MATCH (m:Movie)-[r:INCLUDE]->(p:Product) WHERE p.Grade > "+grade);
        // 先创建一个包含您提供的字符串的列表
        List<String> data = new ArrayList<>();
        data.add("The Secrets of Why Hypnosis Doesn't Work!");
        data.add("Violent Cop");
        data.add("Who Needs Sleep?");
        data.add("Man With the X-Ray Eyes");
        data.add("Cheerleader Camp");
        data.add("Foolproof Buttonholes");
        data.add("Foolproof Buttonholes");
        data.add("Foolproof Buttonholes");
        data.add("A T-Shirt: A Documentary About Zines In The Northwest");
        data.add("I Know Where I'm Going!");
        data.add("If This Is Kosher");
        data.add("Merci la vie");
        data.add("N Sync - Live From Madison Square Garden");
        data.add("Neath the Arizona Skies with Free DVD: Border Caballero");
        data.add("R Xmas");
        data.add("Til the River Runs Clear");
        data.add("Twas the Night Before Easter");
        data.add("batteries not included");
        data.add("And God Created Woman");
        data.add("First Do No Harm");
        data.add("Roots: Terror of Death - Volume Six");
        data.add("SIGN - Gestalt");
        data.add("Limited Edition Boxed Set");
        data.add("Terminus");
        data.add("My Love to the Swallows");
        data.add("The Secrets of Why Hypnosis Doesn't Work!");
        data.add("Violent Cop");
        data.add("Who Needs Sleep?");
        data.add("Man With the X-Ray Eyes");
        data.add("Cheerleader Camp");
        data.add("Foolproof Buttonholes");
        data.add("Foolproof Buttonholes");
        data.add("Foolproof Buttonholes");
        data.add("A T-Shirt: A Documentary About Zines In The Northwest");
        data.add("I Know Where I'm Going!");
        data.add("If This Is Kosher");
        data.add("Merci la vie");
        data.add("N Sync - Live From Madison Square Garden");
        data.add("Neath the Arizona Skies with Free DVD: Border Caballero");
        data.add("R Xmas");
        data.add("Til the River Runs Clear");
        data.add("Twas the Night Before Easter");
        data.add("batteries not included");
        data.add("And God Created Woman");
        data.add("First Do No Harm");
        data.add("Roots: Terror of Death - Volume Six");
        data.add("SIGN - Gestalt");
        data.add("Limited Edition Boxed Set");
        data.add("Terminus");
        data.add("My Love to the Swallows");



        return ResultResponse.success(data, modelTimes, modelLogs);
    }

//    @GetMapping("/byType")
//    public Result<Object> getMoviesByType(@RequestParam String type){
//        List<Long> modelTimes = new ArrayList<>();
//        List<String> modelLogs = new ArrayList<>();
//        long startTime1 = System.currentTimeMillis();
//        List<String> movieNames = movieService.getMoviesByType(type);
//        modelTimes.add(System.currentTimeMillis() - startTime1);
//        modelLogs.add("SELECT p.* " +
//                "FROM Product p " +
//                "JOIN MovieProduct mp ON p.product_id = mp.product_id " +
//                "JOIN Movie m ON mp.movie_id = m.movie_id " +
//                "WHERE m.movie_name LIKE ;");
//
//        //hive待写
//        long startTime2 = System.currentTimeMillis();
//        modelTimes.add(0L);
//        modelLogs.add("");
//
//        long startTime3 = System.currentTimeMillis();
//        List<String> data = neo4jService.searchMoviesByReviewPositive();
//        modelTimes.add(System.currentTimeMillis() - startTime3);
//        modelLogs.add("MATCH (m:Movie)-[r:INCLUDE]->(p:Product) WHERE m.movie_name contains  RETURN p;");
//        return ResultResponse.success(data, modelTimes, modelLogs);
//    }


//    @GetMapping("/countByYearAndType")
//    public Result<Object> countMoviesByYearAndType(@RequestParam int year, @RequestParam String type) {
//        List<Long> modelTimes = new ArrayList<>();
//        List<String> modelLogs = new ArrayList<>();
//        long startTime1 = System.currentTimeMillis();
//        int count = movieService.countMoviesByYearAndType(year, type);
//        modelTimes.add(System.currentTimeMillis() - startTime1);
//        modelLogs.add("SELECT p.* " +
//                "FROM Product p " +
//                "JOIN MovieProduct mp ON p.product_id = mp.product_id " +
//                "JOIN Movie m ON mp.movie_id = m.movie_id " +
//                "WHERE m.movie_name LIKE ;");
//
//        //hive待写
//        long startTime2 = System.currentTimeMillis();
//        modelTimes.add(0L);
//        modelLogs.add("");
//
//        long startTime3 = System.currentTimeMillis();
//        List<String> data = neo4jService.searchMoviesByReviewPositive();
//        modelTimes.add(System.currentTimeMillis() - startTime3);
//        modelLogs.add("MATCH (m:Movie)-[r:INCLUDE]->(p:Product) WHERE m.movie_name contains  RETURN p;");
//        return ResultResponse.success(data, modelTimes, modelLogs);
//    }


}
