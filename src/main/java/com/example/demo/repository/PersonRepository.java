package com.example.demo.repository;

import com.example.demo.domain.PersonEntity;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface PersonRepository extends Neo4jRepository<PersonEntity, Long> {

    @Query("MATCH (n:Person)-[*0..2]->(adjacentNode) WHERE id(n) = $nodeId RETURN id(adjacentNode)")
    Iterable<Integer> traverseNodes(@Param("nodeId") Long nodeId);
}
