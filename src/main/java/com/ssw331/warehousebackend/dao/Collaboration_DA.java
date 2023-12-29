package com.ssw331.warehousebackend.dao;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Data
public class Collaboration_DA {

    private String director;

    private String actor;

    private int collaborationNumber;
}
