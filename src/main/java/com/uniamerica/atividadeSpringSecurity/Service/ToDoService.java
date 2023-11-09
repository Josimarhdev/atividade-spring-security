package com.uniamerica.atividadeSpringSecurity.Service;

import com.uniamerica.atividadeSpringSecurity.Entity.ToDoEntity;
import com.uniamerica.atividadeSpringSecurity.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository repository;

    public List<ToDoEntity> listAll() {
        return repository.findAll();
    }
}
