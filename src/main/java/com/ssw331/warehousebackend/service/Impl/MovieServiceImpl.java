package com.ssw331.warehousebackend.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ssw331.warehousebackend.MySQLDTO.Movie;
import com.ssw331.warehousebackend.MySQLDTO.MovieProduct;
import com.ssw331.warehousebackend.MySQLDTO.Product;
import com.ssw331.warehousebackend.mapper.MovieMapper;
import com.ssw331.warehousebackend.mapper.MovieProductMapper;
import com.ssw331.warehousebackend.mapper.ProductMapper;
import com.ssw331.warehousebackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private MovieProductMapper movieProductMapper;

    @Override
    public List<Movie> getMoviesWithHighGradeProducts() {
        List<Product> products = productMapper.selectList(new QueryWrapper<Product>().gt("grade", 4));
        List<Movie> movies = new ArrayList<>();

        for (Product product : products) {
            String productId = product.getProductId().replace("\r", "");
            List<MovieProduct> movieProducts = movieProductMapper.selectList(new QueryWrapper<MovieProduct>().eq("product_id", productId));

            for (MovieProduct movieProduct : movieProducts) {
                Movie movie = movieMapper.selectById(movieProduct.getMovieId());
                if (movie != null && !movies.contains(movie)) {
                    movies.add(movie);
                }
            }
        }

        return movies;
    }
}
