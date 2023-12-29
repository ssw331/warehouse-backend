package com.ssw331.warehousebackend.MySQLDTO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@TableName("Product")
public class Product {
    @Property
    @Id
    @Getter
    private String product_id;
    @Property
    private int comment_number;
    @Property
    private String cost;
    @Property
    private String format;
    @Property
    private String grade;
}
