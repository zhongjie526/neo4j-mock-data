package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@NoArgsConstructor
@AllArgsConstructor
@Node("Datasource")
public class DatasourceEntity {

    @Id @GeneratedValue
    @Getter @Setter private Long id;
    @Getter @Setter private String name;
}
