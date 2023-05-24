package com.example.demo.repository;

import com.example.demo.domain.ColumnEntity;
import com.example.demo.domain.RoleEntity;
import com.example.demo.domain.TableEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends Neo4jRepository<RoleEntity,Long> {

  boolean existsByName(String name);

  RoleEntity findByName(String name);
}
