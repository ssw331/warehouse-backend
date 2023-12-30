package com.ssw331.warehousebackend;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.ssw331.warehousebackend.mapper.TimeMapper;
import com.ssw331.warehousebackend.service.MySQLTimeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ssw331.warehousebackend.mapper.*;

import java.util.List;

@SpringBootTest
public class SqlTest {
    @Autowired
private TimeMapper timeMapper;
@Autowired
private MySQLTimeService mySQLTimeService;
    @Test
    void ceshi(){
        int dataFromMySQL = mySQLTimeService.getMovieCountByYear(2000);
    }

}