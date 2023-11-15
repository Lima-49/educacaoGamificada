package com.project.educacaogamificada.repository;

import com.project.educacaogamificada.modelo.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CursosRepository extends JpaRepository<Cursos, Long> {

    Optional<Cursos> findByAlunoCurso(String alunoCurso);

}
