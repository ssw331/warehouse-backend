package com.ssw331.warehousebackend.MySQLservice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ssw331.warehousebackend.MySQLDTO.Movie;
import com.ssw331.warehousebackend.MySQLDTO.MovieProduct;
import com.ssw331.warehousebackend.MySQLDTO.Product;
import com.ssw331.warehousebackend.mapper.MovieMapper;
import com.ssw331.warehousebackend.mapper.MovieProductMapper;
import com.ssw331.warehousebackend.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Service
public class MovieService {
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private MovieProductMapper movieProductMapper;

    public List<Product> getProductsByMovieName(String movieName) {
        QueryWrapper<Movie> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("movie_name", movieName);
        List<Movie> movies = movieMapper.selectList(queryWrapper);
        List<Product> products = new ArrayList<>();
        for (Movie movie : movies) {
            QueryWrapper<MovieProduct> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("movie_id", movie.getMovie_id());
            List<MovieProduct> movieProducts = movieProductMapper.selectList(queryWrapper2);
            for (MovieProduct movieProduct : movieProducts) {
                Product product = productMapper.selectById(movieProduct.getProduct_id());
                if (product != null) {
                    products.add(product);
                }
            }
        }
        return products;
    }

}