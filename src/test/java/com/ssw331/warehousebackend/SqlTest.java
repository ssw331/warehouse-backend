package com.ssw331.warehousebackend;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.ssw331.warehousebackend.DTO.TestItem;
import com.ssw331.warehousebackend.mapper.TestItemMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DS("mysql")
public class SqlTest {
    @Autowired
    private TestItemMapper testItemMapper;

    @Test
    void connect() {
        List<TestItem> items = testItemMapper.selectList(null);
        items.forEach(System.out::println);
    }

}
