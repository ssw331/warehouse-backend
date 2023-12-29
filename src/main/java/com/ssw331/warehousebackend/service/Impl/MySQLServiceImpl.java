package com.ssw331.warehousebackend.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ssw331.warehousebackend.MySQLDTO.*;
import com.ssw331.warehousebackend.mapper.*;
import com.ssw331.warehousebackend.service.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//
//
import java.util.ArrayList;
import java.util.List;
@Component
public class MySQLServiceImpl implements MySQLService {
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private MovieProductMapper movieProductMapper;



    @Override
    public List<Product> getProductsByMovieName(String movieName) {
        QueryWrapper<Movie> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("movie_name", movieName);
        List<Movie> movies = movieMapper.selectList(queryWrapper);
        List<Product> products = new ArrayList<>();
        for (Movie movie : movies) {
            QueryWrapper<MovieProduct> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("movie_id", movie.getMovieId());
            List<MovieProduct> movieProducts = movieProductMapper.selectList(queryWrapper2);
            for (MovieProduct movieProduct : movieProducts) {
                Product product = productMapper.selectById(movieProduct.getProductId().substring(0, movieProduct.getProductId().length() - 1));
                if (product != null) {
                    products.add(product);
                }
            }
        }
        return products;
    }

}
