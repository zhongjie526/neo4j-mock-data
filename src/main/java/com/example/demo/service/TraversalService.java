package com.example.demo.service;

import com.example.demo.domain.PersonEntity;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TraversalService {

    private final PersonRepository personRepository;

    @Autowired
    public TraversalService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void performTraversal(Long nodeId) {
        Iterable<Integer> results = personRepository.traverseNodes(nodeId);

        for (Integer person : results) {
            // process the traversal results

            System.out.println("Node:"+person);
        }
    }
}
