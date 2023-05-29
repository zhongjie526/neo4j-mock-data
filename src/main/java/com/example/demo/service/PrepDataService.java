package com.example.demo.service;

import org.neo4j.driver.Record;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jOperations;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class PrepDataService {

    private final Neo4jOperations neo4jOperations;
   private final Neo4jTemplate neo4jTemplate;
   private final Neo4jClient neo4jClient;

    public PrepDataService(Neo4jOperations neo4jOperations, Neo4jTemplate neo4jTemplate, Neo4jClient neo4jClient) {
        this.neo4jOperations = neo4jOperations;
        this.neo4jTemplate = neo4jTemplate;
        this.neo4jClient = neo4jClient;
    }

    public void createCustomConstraint(){
        String cypherQuery = "MATCH (n) RETURN n limit 5";
        Iterable<Map<String,Object>> result  = neo4jClient.query(cypherQuery).fetch().all();

        result.forEach(v->System.out.println(v));

    }
}
