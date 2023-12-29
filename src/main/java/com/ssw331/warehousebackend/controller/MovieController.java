package com.ssw331.warehousebackend.controller;

import com.ssw331.warehousebackend.MySQLDTO.Product;
import com.ssw331.warehousebackend.MySQLservice.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movie")
    public List<Product> getProductsByMovieName(@RequestParam String movieName) {
        return movieService.getProductsByMovieName(movieName);
    }
}

