package com.uniamerica.atividadeSpringSecurity.Controller;

import com.uniamerica.atividadeSpringSecurity.Entity.UserEntity;
import com.uniamerica.atividadeSpringSecurity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
public class UserController {

    @Autowired
    UserRepository usuarioRep;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<?> findById(@PathVariable("id") final long id){
        final UserEntity usuario = this.usuarioRep.findById(id).orElse(null);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/teste")
    public String teste(){
        return "<h1>Teste</h1>";
    }

    @GetMapping("/lista")
    public ResponseEntity<?> lista(){
        return ResponseEntity.ok(this.usuarioRep.findAll());
    }

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody final UserEntity usuario) {
        try {
            String encodedPassword = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(encodedPassword);

            this.usuarioRep.save(usuario);
            return ResponseEntity.ok("Cadastrou");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }


}
