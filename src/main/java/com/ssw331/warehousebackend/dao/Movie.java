package com.ssw331.warehousebackend.dao;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@Node("Movie")
public class Movie {
    @Id
    @Property
    private String movie_id;

    @Property
    private String Type;

    @Property("movie_name")
    private String movieName;

    @Property("release_time")
    private String releaseTime;

    @Property
    private String time;
}
