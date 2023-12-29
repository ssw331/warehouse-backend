package com.ssw331.warehousebackend.service;

import com.ssw331.warehousebackend.MySQLDTO.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MySQLService {
    List<Product> getProductsByMovieName(String movieName);
}
