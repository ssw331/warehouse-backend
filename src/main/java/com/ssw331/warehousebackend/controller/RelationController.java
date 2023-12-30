

package com.ssw331.warehousebackend.controller;

import com.ssw331.warehousebackend.MySQLDTO.*;
import com.ssw331.warehousebackend.Neo4jDTO.serialization.Result;
import com.ssw331.warehousebackend.Neo4jDTO.serialization.ResultResponse;
import com.ssw331.warehousebackend.service.Neo4jService;
import com.ssw331.warehousebackend.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Relation")
public class RelationController {

    @Autowired
    private RelationService relationService;
    @Autowired
    private Neo4jService neo4jService;

    @Autowired
    private void setNeo4jService(Neo4jService neo4jService){
        this.neo4jService=neo4jService;
    }
    @Autowired
    private void setMySQLService(RelationService relationService) {
        this.relationService=relationService;
    }



    @GetMapping("/topDirectorActorCollaborations")
    public Result<Object> getTop20DirectorActorCollaborations() {
        List<Long> modelTimes = new ArrayList<>();
        List<String> modelLogs = new ArrayList<>();
        long startTime1 = System.currentTimeMillis();
        List< StaticDirectorActor> directorActors=relationService.getTop20DirectorActorCollaborations();
        modelTimes.add(System.currentTimeMillis() - startTime1);
        modelLogs.add("SELECT p.* " +
                "FROM Product p " +
                "JOIN MovieProduct mp ON p.product_id = mp.product_id " +
                "JOIN Movie m ON mp.movie_id = m.movie_id " +
                "WHERE m.movie_name LIKE "+";");

        //hive待写
        long startTime2 = System.currentTimeMillis();
        modelTimes.add(0L);
        modelLogs.add("");

        long startTime3 = System.currentTimeMillis();
        List<com.ssw331.warehousebackend.Neo4jDTO.Collaboration_DA> data = neo4jService.searchCollaborationInDA();
        modelTimes.add(System.currentTimeMillis() - startTime3);
        modelLogs.add("aaaaaaaaa");
        return ResultResponse.success(data, modelTimes, modelLogs);

    }



    @GetMapping("/topActorActorCollaborations")
    public Result<Object> getTop20ActorActorCollaborations() {
        List<Long> modelTimes = new ArrayList<>();
        List<String> modelLogs = new ArrayList<>();
        long startTime1 = System.currentTimeMillis();
        List<StaticActorActor> actorActors=relationService.getTop20ActorActorCollaborations();
        modelTimes.add(System.currentTimeMillis() - startTime1);
        modelLogs.add("SELECT p.* " +
                "FROM Product p " +
                "JOIN MovieProduct mp ON p.product_id = mp.product_id " +
                "JOIN Movie m ON mp.movie_id = m.movie_id " +
                "WHERE m.movie_name LIKE "+";");

        //hive待写
        long startTime2 = System.currentTimeMillis();
        modelTimes.add(0L);
        modelLogs.add("");

        long startTime3 = System.currentTimeMillis();
        List<com.ssw331.warehousebackend.Neo4jDTO.Collaboration_AA> data = neo4jService.searchCollaborationInAA();
        modelTimes.add(System.currentTimeMillis() - startTime3);
        modelLogs.add("aaaaaaaaa");
        return ResultResponse.success(data, modelTimes, modelLogs);

    }


    @GetMapping("/topDirectorDirectorCollaborations")
    public Result<Object> getTop20DirectorDirectorCollaborations() {
        List<Long> modelTimes = new ArrayList<>();
        List<String> modelLogs = new ArrayList<>();
        long startTime1 = System.currentTimeMillis();
        List<StaticDirectorDirector> directorDirectors=relationService.getTop20DirectorDirectorCollaborations();
        modelTimes.add(System.currentTimeMillis() - startTime1);
        modelLogs.add("SELECT p.* " +
                "FROM Product p " +
                "JOIN MovieProduct mp ON p.product_id = mp.product_id " +
                "JOIN Movie m ON mp.movie_id = m.movie_id " +
                "WHERE m.movie_name LIKE "+";");

        //hive待写
        long startTime2 = System.currentTimeMillis();
        modelTimes.add(0L);
        modelLogs.add("");

        long startTime3 = System.currentTimeMillis();
        List<com.ssw331.warehousebackend.Neo4jDTO.Collaboration_AA> data = neo4jService.searchCollaborationInAA();
        modelTimes.add(System.currentTimeMillis() - startTime3);
        modelLogs.add("aaaaaaaaa");
        return ResultResponse.success(data, modelTimes, modelLogs);

    }




}
