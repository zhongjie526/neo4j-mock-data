package com.example.demo.repository;

import com.example.demo.domain.TableEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends Neo4jRepository<TableEntity,Long> {

  boolean existsByName(String name);

  TableEntity findByName(String name);
}
