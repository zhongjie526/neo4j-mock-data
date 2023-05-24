package com.example.demo.repository;

import com.example.demo.domain.ColumnEntity;
import com.example.demo.domain.TableEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColumnRepository extends Neo4jRepository<ColumnEntity,Long> {

  boolean existsByName(String name);

  ColumnEntity findByName(String name);

}
