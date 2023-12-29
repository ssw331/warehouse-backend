package com.ssw331.warehousebackend.MySQLDTO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@TableName("Movie")
public class Movie {
    @Id
    @Property
    @Getter
    private int movie_id;

    @Property
    @Getter
    private String Type;

    @Property
    @Getter
    private String movie_name;

    @Property
    @Getter
    private int release_time_id;

    @Property
    @Getter
    private String time;


}
