package com.example.demo.repository;

import com.example.demo.domain.DatasourceEntity;
import com.example.demo.domain.TableEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasourceRepository extends Neo4jRepository<DatasourceEntity,Long> {

    boolean existsByName(String name);

  DatasourceEntity findByName(String name);
}
