package com.ssw331.warehousebackend.service;

import com.ssw331.warehousebackend.dao.*;

import java.util.List;

public interface Neo4jService {

    int searchMoviesByYear(int year);

    int searchMoviesByYM(int year, int month);

    int searchMoviesByYMD(int year, int month, int day);

    int searchMoviesByYS(int year, String season);

    List<Movie> searchMoviesByName(String name);

    List<String> searchMoviesByActor(String actorName);

    List<String> searchActorByDirector(String directorName);

    List<String> searchDirectorByDirector(String directorName);

    List<String> searchActorByActor(String actorName);

    List<String> searchDirectorByActor(String actorName);

    List<String> searchMoviesByCategory(String category);

    List<String> searchMoviesByGradeBetter(double grade);

    List<String> searchMoviesByReviewPositive();

    List<Collaboration_DA> searchCollaborationInDA();

    List<Collaboration_DD> searchCollaborationInDD();

    List<Collaboration_AA> searchCollaborationInAA();

    List<ReviewMax_AA> searchByReviewAA();

    int searchMoviesByYearType(int year, String type);

    int searchMoviesByYearDirector(int year, String directorName);
}
