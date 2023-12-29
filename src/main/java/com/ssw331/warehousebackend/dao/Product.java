package com.ssw331.warehousebackend.dao;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@Node("Product")
public class Product {
    @Id
    @Property("product_id")
    private String productId;

    @Property("movie_id")
    private String movieId;

    @Property("Grade")
    private String grade;

    @Property("Format")
    private String format;

    @Property("Cost")
    private String cost;

    @Property("Comments")
    private String comments;
}
