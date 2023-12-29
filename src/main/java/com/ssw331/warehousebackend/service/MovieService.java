package com.ssw331.warehousebackend.service;

import com.ssw331.warehousebackend.MySQLDTO.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getMoviesWithHighGradeProducts();
}