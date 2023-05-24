package com.example.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Node("Column")
public class ColumnEntity {
    @Id @GeneratedValue
    @Getter @Setter private Long id;
    @Getter @Setter private String name;

    @Getter @Setter
    @Relationship(type ="ACCESSED_BY",direction = Relationship.Direction.INCOMING)
    private Set<RoleEntity> datasources = new HashSet<>();
}
