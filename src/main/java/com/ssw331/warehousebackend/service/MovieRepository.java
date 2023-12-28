package com.ssw331.warehousebackend.service;

import com.ssw331.warehousebackend.dao.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, String> {
    int countMoviesByReleaseTimeContaining(String Time);
}
