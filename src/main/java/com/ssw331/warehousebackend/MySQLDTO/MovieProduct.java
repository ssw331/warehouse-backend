package com.ssw331.warehousebackend.MySQLDTO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@TableName("MovieProduct")
public class MovieProduct {
    @Property
    @Getter
    private int movie_id;
    @Property
    @Getter
    private String product_id;
}
