package com.ssw331.warehousebackend.service.repo;

import com.ssw331.warehousebackend.dao.Actor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor, String> {

}
