package com.example.springproject.entity.base;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;
import java.util.UUID;

/**
 * Base entity class serving as a template for other entities in the system.
 * It includes common fields like id, createdBy, createdAt, and ensures the generation of a unique ID.
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Id
    private String id;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private Long createdAt;

    /**
     * Ensures that the entity has a valid ID before persisting.
     * If the ID is null, generates a new UUID and assigns it to the ID field.
     */
    @PrePersist
    public void ensureId() {
        this.id = Objects.isNull(this.id) ? UUID.randomUUID().toString() : this.id;
    }
}
