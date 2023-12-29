package com.ssw331.warehousebackend.service.Impl;

import com.ssw331.warehousebackend.dao.*;
import com.ssw331.warehousebackend.service.repo.ActorRepository;
import com.ssw331.warehousebackend.service.repo.DirectorRepository;
import com.ssw331.warehousebackend.service.repo.MovieRepository;
import com.ssw331.warehousebackend.service.Neo4jService;
import com.ssw331.warehousebackend.service.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Neo4jServiceImpl implements Neo4jService {

    MovieRepository movieRepository;

    ProductRepository productRepository;

    ActorRepository actorRepository;

    DirectorRepository directorRepository;

    @Autowired
    private void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Autowired
    private void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    private void setActorRepository(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Autowired
    private void setDirectorRepository(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    /**
     *
     * @param year
     * @return
     */
    @Override
    public int searchMoviesByYear(int year) {
        return movieRepository.countMoviesByReleaseTimeContaining(Integer.toString(year));
    }

    /**
     *
     * @param year
     * @param month
     * @return
     */
    @Override
    public int searchMoviesByYM(int year, int month) {
        return movieRepository.countMoviesByReleaseTimeContaining(year + "/" + month);
    }

    /**
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    @Override
    public int searchMoviesByYMD(int year, int month, int day) {
        return movieRepository.countMoviesByReleaseTimeContaining(year + "/" + month + "/" + day);
    }

    /**
     *
     * @param year
     * @param season
     * @return
     */
    @Override
    public int searchMoviesByYS(int year, String season) {
        int res1 = 0, res2 = 0, res3 = 0;
        switch (season) {
            case "Q1":
                res1 = movieRepository.countMoviesByReleaseTimeContaining(year + "/" + 1);
                res2 = movieRepository.countMoviesByReleaseTimeContaining(year + "/" + 2);
                res3 = movieRepository.countMoviesByReleaseTimeContaining(year + "/" + 3);
                break;
            case "Q2":
                res1 = movieRepository.countMoviesByReleaseTimeContaining(year + "/" + 4);
                res2 = movieRepository.countMoviesByReleaseTimeContaining(year + "/" + 5);
                res3 = movieRepository.countMoviesByReleaseTimeContaining(year + "/" + 6);
                break;
            case "Q3":
                res1 = movieRepository.countMoviesByReleaseTimeContaining(year + "/" + 7);
                res2 = movieRepository.countMoviesByReleaseTimeContaining(year + "/" + 8);
                res3 = movieRepository.countMoviesByReleaseTimeContaining(year + "/" + 9);
                break;
            case "Q4":
                res1 = movieRepository.countMoviesByReleaseTimeContaining(year + "/" + 10);
                res2 = movieRepository.countMoviesByReleaseTimeContaining(year + "/" + 11);
                res3 = movieRepository.countMoviesByReleaseTimeContaining(year + "/" + 12);
                break;
        }
        return res1 + res2 + res3;
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public List<Movie> searchMoviesByName(String name) {
        return movieRepository.findMoviesByMovieNameContaining(name);
    }

    /**
     *
     * @param actorName
     * @return
     */
    @Override
    public List<String> searchMoviesByActor(String actorName) {
        return movieRepository.findMoviesByActor(actorName);
    }

    /**
     *
     * @param directorName
     * @return
     */
    @Override
    public List<String> searchActorByDirector(String directorName) {
        return actorRepository.findActorWithDirector(directorName);
    }

    /**
     *
     * @param directorName
     * @return
     */
    @Override
    public List<String> searchDirectorByDirector(String directorName) {
        List<String> directorNames = new ArrayList<>();
        directorRepository.findDirectorsByDirectorName(directorName).forEach((e) -> {
            directorNames.add(e.getDirectorName());
        });
        return directorNames;
    }

    /**
     *
     * @param actorName
     * @return
     */
    @Override
    public List<String> searchActorByActor(String actorName) {
        List<String> actorNames = new ArrayList<>();
        actorRepository.findActorsByActorName(actorName).forEach((e) -> {
            actorNames.add(e.getActorName());
        });
        return actorNames;
    }

    /**
     *
     * @param actorName
     * @return
     */
    @Override
    public List<String> searchDirectorByActor(String actorName) {
        return directorRepository.findDirectorsWithActor(actorName);
    }

    /**
     *
     * @param category
     * @return
     */
    @Override
    public List<String> searchMoviesByCategory(String category) {
        List<Movie> movies = movieRepository.findMoviesByTypeContaining(category);
        List<String> mNames = new ArrayList<>();
        movies.forEach((e) -> {
            mNames.add(e.getMovieName());
        });
        return mNames;
    }

    /**
     *
     * @param grade
     * @return
     */
    @Override
    public List<String> searchMoviesByGradeBetter(double grade) {
        return movieRepository.findWithGrade(grade);
    }


    /**
     *
     * @return
     */
    @Override
    public List<String> searchMoviesByReviewPositive() {
        return movieRepository.findWithGrade(4.0);
    }

    /**
     * TODO
     * @return
     */
    @Override
    public List<Collaboration_DA> searchCollaborationInDA() {
        List<Collaboration_DA> res = actorRepository.findCollaborationBTDA();
        res.remove(0);
        return res;
    }

    /**
     * TODO
     * @return
     */
    @Override
    public List<Collaboration_DD> searchCollaborationInDD() {
        return directorRepository.findCollaborationBTDD();
    }

    /**
     * TODO
     * @return
     */
    @Override
    public List<Collaboration_AA> searchCollaborationInAA() {
        return actorRepository.findCollaborationBTAA();
    }

    /**
     * TODO
     * @return
     */
    @Override
    public List<ReviewMax_AA> searchByReviewAA(String type) {
        return null;
    }

    /**
     *
     * @param year
     * @param type
     * @return
     */
    @Override
    public int searchMoviesByYearType(int year, String type) {
        return movieRepository.countMoviesByTypeContainingAndReleaseTimeContaining(type, Integer.toString(year));
    }

    /**
     *
     * @param year
     * @param directorName
     * @return
     */
    @Override
    public int searchMoviesByYearDirector(int year, String directorName) {
        return movieRepository.countMoviesWithYearAndDirector(Integer.toString(year), directorName);
    }
}
