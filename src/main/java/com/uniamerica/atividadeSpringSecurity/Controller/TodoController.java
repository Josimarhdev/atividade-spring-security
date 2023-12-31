package com.uniamerica.atividadeSpringSecurity.Controller;


import com.uniamerica.atividadeSpringSecurity.Entity.ToDoEntity;
import com.uniamerica.atividadeSpringSecurity.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class TodoController {

    @Autowired
    private ToDoService service;

    @GetMapping
    public String todo() {
        return "<h1>Passou</h1> <h2>Teste2</h2>";
    }

    @GetMapping("/listall")
    public String listarTodos() {
        var lembretes = service.listAll();
        String toShow = "";
        for (ToDoEntity x:lembretes) {
            toShow +=
                    "<p>"+x.getLembrete()+"</p> <br>";
        }
        return toShow;
    }

    @GetMapping("/log")
    public String testeRotaLivre() {
        return "<h1> Rota livre </h1>";
    }
}
