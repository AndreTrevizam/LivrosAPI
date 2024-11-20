package com.andretrevizam.livrosapi.service;

import com.andretrevizam.livrosapi.model.Livro;
import com.andretrevizam.livrosapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    // listar todos os livros
    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    // adicionar um livro
    public Livro addLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    // deletar livro por id
    public void removerPorId(Long id) {
        livroRepository.deleteById(id);
    }

    // pesquisar livro por titulo, autor, genero
    public List<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    // atualizar o stauts do livro (lido, não lido, quer ler)
    public Livro atualizarStatus(Long id, String status) {
        return livroRepository.findById(id).map(livro -> {
            livro.setStatus(status);
            return livroRepository.save(livro);
        }).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

}
