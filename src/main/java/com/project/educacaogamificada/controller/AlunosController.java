package com.project.educacaogamificada.controller;

import com.project.educacaogamificada.controller.dto.AlunosDto;
import com.project.educacaogamificada.controller.form.AlunosForm;
import com.project.educacaogamificada.modelo.Alunos;
import com.project.educacaogamificada.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/alunos")
public class AlunosController {

    @Autowired
    AlunosRepository alunosRepository;

    @GetMapping
    public ResponseEntity<List<AlunosDto>> listarAlunos() {
        List<Alunos> alunos = alunosRepository.findAll();
        if (alunos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(AlunosDto.converter(alunos));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Alunos> consultaPorId(@PathVariable Long id){
        return ResponseEntity.ok(alunosRepository.findById(id).get());
    }

    @PostMapping(value = "/login")
    @CrossOrigin
    public ResponseEntity<?> validandoLogin(@RequestBody AlunosForm form){

        if (!alunosRepository.existsByAlunoNome(form.getAlunoNome())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome do aluno invalido");
        }else if (!alunosRepository.existsByAlunoSenha(form.getAlunoSenha())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Senha invalida");
        }
        return ResponseEntity.ok("Login realizado com sucesso");
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> cadastrarAluno(@RequestBody AlunosForm form, UriComponentsBuilder uriBuilder) {

        if (alunosRepository.existsByAlunoNome(form.getAlunoNome())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome de aluno ja existe. Escolha outro nome.");
        }

        Alunos alunos = form.converter(alunosRepository);
        alunosRepository.save(alunos);

        URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(alunos.getAlunoID()).toUri();
        return ResponseEntity.created(uri).body(new AlunosDto(alunos));
    }

}
