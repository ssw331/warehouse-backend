package com.ssw331.warehousebackend.DTO;

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

    @Property
    private String movie_name;

    @Property
    private String release_time;

    @Property
    private String time;
}
