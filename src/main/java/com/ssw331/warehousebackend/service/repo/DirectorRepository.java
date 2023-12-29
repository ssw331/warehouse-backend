package com.ssw331.warehousebackend.service.repo;

import com.ssw331.warehousebackend.dao.Collaboration_DD;
import com.ssw331.warehousebackend.dao.Director;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface DirectorRepository extends Neo4jRepository<Director, String> {
    List<Director> findDirectorsByDirectorName(String directorName);

    @Query("MATCH (a:Actor)-[:ACTED_IN]->(m)<-[:DIRECTED]-(d:Director) WHERE a.actor_name = $actorName RETURN d.director_name;")
    List<String> findDirectorsWithActor(String actorName);

    @Query("MATCH (d1:Director)-[r:COOPERATE]->(d2:Director) RETURN d1.director_name AS director1, d2.director_name AS director2, r.counts AS collaborationNumber ORDER BY r.counts DESC LIMIT 50;")
    List<Collaboration_DD> findCollaborationBTDD();
}
