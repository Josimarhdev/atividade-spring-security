package com.uniamerica.atividadeSpringSecurity.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(schema = "app", name = "todo")
@Entity
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lembrete;

}