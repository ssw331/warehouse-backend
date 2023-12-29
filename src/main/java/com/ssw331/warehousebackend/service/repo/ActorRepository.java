package com.ssw331.warehousebackend.service.repo;

import com.ssw331.warehousebackend.dao.Actor;
import com.ssw331.warehousebackend.dao.Collaboration_AA;
import com.ssw331.warehousebackend.dao.Collaboration_DA;
import com.ssw331.warehousebackend.dao.ReviewMax_AA;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor, String> {

    @Query("MATCH (a:Actor)-[:ACTED_IN]->(m)<-[:DIRECTED]-(d:Director) WHERE d.director_name = $directorName RETURN a.actor_name;")
    List<String> findActorWithDirector(String directorName);

    List<Actor> findActorsByActorName(String actorName);

    @Query("MATCH (d:Director)-[r:COOPERATE]->(a:Actor) RETURN d.director_name AS director, a.actor_name AS actor, r.counts AS collaborationNumber ORDER BY r.counts DESC LIMIT 51;")
    List<Collaboration_DA> findCollaborationBTDA();

    @Query("MATCH (a1:Actor)-[r:COOPERATE]->(a2:Actor) RETURN a1.actor_name AS actor1, a2.actor_name AS actor2, r.counts AS collaborationNumber ORDER BY r.counts DESC LIMIT 50;")
    List<Collaboration_AA> findCollaborationBTAA();

    @Query("")
    List<ReviewMax_AA> findActorsWithReviewsAndType(String type);
}
