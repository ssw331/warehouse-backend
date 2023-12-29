package com.ssw331.warehousebackend.service.Impl;

import com.ssw331.warehousebackend.dao.*;
import com.ssw331.warehousebackend.service.MovieRepository;
import com.ssw331.warehousebackend.service.Neo4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Neo4jServiceImpl implements Neo4jService {

    MovieRepository movieRepository;

    @Autowired
    private void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public int searchMoviesByYear(int year) {
        return movieRepository.countMoviesByReleaseTimeContaining(Integer.toString(year));
    }

    @Override
    public int searchMoviesByYM(int year, int month) {
        return movieRepository.countMoviesByReleaseTimeContaining(year + "/" + month);
    }

    @Override
    public int searchMoviesByYMD(int year, int month, int day) {
        return movieRepository.countMoviesByReleaseTimeContaining(year + "/" + month + "/" + day);
    }

    @Override
    public int searchMoviesByYS(int year, String season) {
        return 0;
    }

    @Override
    public List<Movie> searchMoviesByName(String name) {
        return movieRepository.findMoviesByMovieNameContaining(name);
    }

    @Override
    public List<String> searchMoviesByActor(String actorName) {
        return null;
    }

    @Override
    public List<String> searchActorByDirector(String directorName) {
        return null;
    }

    @Override
    public List<String> searchDirectorByDirector(String directorName) {
        return null;
    }

    @Override
    public List<String> searchActorByActor(String actorName) {
        return null;
    }

    @Override
    public List<String> searchDirectorByActor(String actorName) {
        return null;
    }

    @Override
    public List<String> searchMoviesByCategory(String category) {
        List<Movie> movies = movieRepository.findMoviesByTypeContaining(category);
        List<String> mNames = new ArrayList<>();
        movies.forEach((e) -> {
            mNames.add(e.getMovieName());
        });
        return mNames;
    }

    @Override
    public List<String> searchMoviesByReviewBetter(String grade) {
        return null;
    }

    @Override
    public List<String> searchMoviesByReviewPositive() {
        return null;
    }

    @Override
    public List<Collaboration_DA> searchCollaborationInDA() {
        return null;
    }

    @Override
    public List<Collaboration_DD> searchCollaborationInDD() {
        return null;
    }

    @Override
    public List<Collaboration_AA> searchCollaborationInAA() {
        return null;
    }

    @Override
    public List<ReviewMax_AA> searchByReviewAA() {
        return null;
    }

    @Override
    public int searchMoviesByYearType(int year, String type) {
        return movieRepository.countMoviesByTypeContainingAndReleaseTimeContaining(type, Integer.toString(year));
    }

    @Override
    public int searchMoviesByYearDirector(int year, String directorName) {
        return movieRepository.countMoviesWithYearAndDirector(Integer.toString(year), directorName);
    }
}
