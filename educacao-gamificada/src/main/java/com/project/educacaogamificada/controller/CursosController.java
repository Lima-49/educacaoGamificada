package com.project.educacaogamificada.controller;

import com.project.educacaogamificada.controller.dto.AlunosDto;
import com.project.educacaogamificada.controller.dto.CursosDto;
import com.project.educacaogamificada.controller.form.AlunosForm;
import com.project.educacaogamificada.controller.form.CursosForm;
import com.project.educacaogamificada.modelo.Alunos;
import com.project.educacaogamificada.modelo.Cursos;
import com.project.educacaogamificada.repository.AlunosRepository;
import com.project.educacaogamificada.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/cursos")
public class CursosController {

    @Autowired
    CursosRepository cursosRepository;

    @Autowired
    AlunosRepository alunosRepository;

    @GetMapping
    public ResponseEntity<List<CursosDto>> listarCursos() {
        List<Cursos> cursos = cursosRepository.findAll();
        if (cursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(CursosDto.converter(cursos));
    }

    @PostMapping(value = "/updAtributo")
    @CrossOrigin
    public ResponseEntity<?> updAtributo(@RequestBody CursosForm form, UriComponentsBuilder uriBuilder) {

        String alunoCurso = form.getAlunoCurso();
        boolean alunoExiste = alunosRepository.existsByAlunoNome(alunoCurso);

        if (alunoExiste) {

            Optional<Cursos> cursoExist = cursosRepository.findByAlunoCurso(alunoCurso);
            if (cursoExist.isPresent()) {

                // Atualiza diretamente os atributos do curso existente
                Cursos curso = cursoExist.get();
                curso.atualizaAtributos(form);
                cursosRepository.save(curso);

                URI uri = uriBuilder.path("/cursos/{alunoCurso}").buildAndExpand(curso.getAlunoCurso()).toUri();
                return ResponseEntity.created(uri).body(new CursosDto(curso));
            } else {
                Cursos novoCurso = form.converter(cursosRepository);
                cursosRepository.save(novoCurso);
                URI uri = uriBuilder.path("/cursos/{alunoCurso}").buildAndExpand(novoCurso.getAlunoCurso()).toUri();
                return ResponseEntity.created(uri).body(new CursosDto(novoCurso));
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado.");
        }
    }
}
