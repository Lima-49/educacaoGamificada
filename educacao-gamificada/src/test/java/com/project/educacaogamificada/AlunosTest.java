package com.project.educacaogamificada;

import com.project.educacaogamificada.modelo.Alunos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlunosTest {

    @Test
    public void testCriarAluno() {
        Alunos aluno = new Alunos("João", "senha123", "PlanoA");

        Assertions.assertNotNull(aluno);
        Assertions.assertEquals("João", aluno.getAlunoNome());
        Assertions.assertEquals("senha123", aluno.getAlunoSenha());
        Assertions.assertEquals("PlanoA", aluno.getTipoPlano());
    }

    @Test
    public void testDefinirAlunoID() {
        Alunos aluno = new Alunos();
        aluno.setAlunoID(1L);

        Assertions.assertEquals(1L, aluno.getAlunoID());
    }

    @Test
    public void testDefinirAlunoNome() {
        Alunos aluno = new Alunos();
        aluno.setAlunoNome("Maria");

        Assertions.assertEquals("Maria", aluno.getAlunoNome());
    }

    @Test
    public void testDefinirAlunoSenha() {
        Alunos aluno = new Alunos();
        aluno.setAlunoSenha("senha456");

        Assertions.assertEquals("senha456", aluno.getAlunoSenha());
    }

    @Test
    public void testDefinirTipoPlano() {
        Alunos aluno = new Alunos();
        aluno.setTipoPlano("PlanoB");

        Assertions.assertEquals("PlanoB", aluno.getTipoPlano());
    }
}
