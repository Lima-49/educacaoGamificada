package com.project.educacaogamificada.repository;

import com.project.educacaogamificada.modelo.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<Alunos, Long> {
    boolean existsByAlunoNome(String alunoNome);
    boolean existsByAlunoSenha(String alunoSenha);
}
