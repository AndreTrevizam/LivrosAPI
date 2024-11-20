package com.andretrevizam.livrosapi.controller;

import com.andretrevizam.livrosapi.model.Livro;
import com.andretrevizam.livrosapi.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public Livro adicionarLivro(@RequestBody Livro livro) {
        return livroService.addLivro(livro);
    }

    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.listarTodos();
    }

    @GetMapping("/buscar-titulo")
    public List<Livro> buscarPorTitulo(@RequestParam String titulo) {
        return livroService.buscarPorTitulo(titulo);
    }

    @DeleteMapping("/{id}")
    public void removerPorId(@PathVariable Long id) {
        livroService.removerPorId(id);
    }

    @PutMapping("/{id}")
    public Livro atualizarStatus(@PathVariable Long id, @RequestBody String status) {
        return livroService.atualizarStatus(id, status);
    }
}
