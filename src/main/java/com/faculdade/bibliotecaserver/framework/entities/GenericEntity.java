package com.faculdade.bibliotecaserver.framework.entities;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@MappedSuperclass
public abstract class GenericEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;

}
