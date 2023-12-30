

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
@RequestMapping("/relation")
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



    @GetMapping("/director-actor")
    public Result<Object> getTop20DirectorActorCollaborations() {
        List<Long> modelTimes = new ArrayList<>();
        List<String> modelLogs = new ArrayList<>();
        long startTime1 = System.currentTimeMillis();
        List< StaticDirectorActor> directorActors=relationService.getTop20DirectorActorCollaborations();
        modelTimes.add(System.currentTimeMillis() - startTime1);
        modelLogs.add("SELECT d.*, a.* " +
                "FROM Director d " +
                "JOIN StaticDirectorActor sda ON d.director_id = sda.director_id " +
                "JOIN Actor a ON sda.actor_id = a.actor_id " +
                "ORDER BY sda.collaboration_number DESC " +
                "LIMIT 20");


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



    @GetMapping("/actor-actor")
    public Result<Object> getTop20ActorActorCollaborations() {
        List<Long> modelTimes = new ArrayList<>();
        List<String> modelLogs = new ArrayList<>();
        long startTime1 = System.currentTimeMillis();
        List<StaticActorActor> actorActors=relationService.getTop20ActorActorCollaborations();
        modelTimes.add(System.currentTimeMillis() - startTime1);
        modelLogs.add("SELECT a.* " +
                "FROM Actor a " +
                "JOIN StaticActorActor saa ON a.actor_id = saa.actor_id " +
                "ORDER BY saa.collaboration_number DESC " +
                "LIMIT 20");


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


    @GetMapping("/director-director")
    public Result<Object> getTop20DirectorDirectorCollaborations() {
        List<Long> modelTimes = new ArrayList<>();
        List<String> modelLogs = new ArrayList<>();
        long startTime1 = System.currentTimeMillis();
        List<StaticDirectorDirector> directorDirectors=relationService.getTop20DirectorDirectorCollaborations();
        modelTimes.add(System.currentTimeMillis() - startTime1);
        modelLogs.add("SELECT p.* " +
                "FROM Product p " +
                "JOIN StaticDirectorDirector sdd ON p.product_id = sdd.product_id " +
                "ORDER BY sdd.collaboration_number DESC " +
                "LIMIT 20");


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