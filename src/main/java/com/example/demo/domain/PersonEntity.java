package com.example.demo.domain;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Person")
public class PersonEntity {

    @Id @Getter
    private Long id;
}
