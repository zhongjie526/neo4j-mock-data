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
@Node("Table")
public class TableEntity {
    @Id @GeneratedValue
    @Getter @Setter private Long id;
    @Getter @Setter private String name;

    @Getter @Setter
    @Relationship(type ="FROM_SOURCE",direction = Relationship.Direction.OUTGOING)
    private Set<DatasourceEntity> datasources = new HashSet<>();

    @Getter @Setter
    @Relationship(type ="CONTAINS",direction = Relationship.Direction.OUTGOING)
    private Set<ColumnEntity> columns = new HashSet<>();

    @Getter @Setter
    @Relationship(type ="IS_ATTACHED",direction = Relationship.Direction.OUTGOING)
    private Set<RoleEntity> roles = new HashSet<>();
}
