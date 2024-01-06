package com.example.springproject.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class IndexableEntity {
    @Id
    private Long id;
}
