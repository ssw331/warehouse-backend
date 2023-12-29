package com.ssw331.warehousebackend.service;

import com.ssw331.warehousebackend.dao.Movie;
import org.junit.runners.Parameterized;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, String> {
    int countMoviesByReleaseTimeContaining(String date);

    List<Movie> findMoviesByMovieNameContaining(String name);

    List<Movie> findMoviesByTypeContaining(String Type);

    int countMoviesByTypeContainingAndReleaseTimeContaining(String Type, String year);

    @Query("MATCH (m:Movie)<-[r:DIRECTED]-(d:Director) WHERE m.release_time contains $year and d.director_name = $directorName return count(m);")
    int countMoviesWithYearAndDirector(String year, String directorName);

}
