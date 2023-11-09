package com.uniamerica.atividadeSpringSecurity.Repository;

import com.uniamerica.atividadeSpringSecurity.Entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {

}