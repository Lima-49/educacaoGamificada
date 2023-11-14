package com.project.educacaogamificada;

import com.project.educacaogamificada.controller.form.CursosForm;
import com.project.educacaogamificada.modelo.Cursos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CursosTest {
    @Test
    public void testConstrutor() {
        Cursos curso = new Cursos("Aluno Teste", 3, "Andamento", 8.5f);

        assertEquals("Aluno Teste", curso.getAlunoCurso());
        assertEquals(3, curso.getCursoQtd());
        assertEquals("Andamento", curso.getCursoAndamento());
        assertEquals(8.5f, curso.getMediaFinal(), 0.001); // Usando delta para comparar floats
    }

    @Test
    public void testAtualizaAtributos() {
        Cursos curso = new Cursos();
        CursosForm form = new CursosForm();
        form.setAlunoCurso("Novo Aluno");
        form.setCursoQtd(5);
        form.setCursoAndamento("Concluído");
        form.setMediaFinal(9.2f);

        curso.atualizaAtributos(form);

        assertEquals("Novo Aluno", curso.getAlunoCurso());
        assertEquals(5, curso.getCursoQtd());
        assertEquals("Concluído", curso.getCursoAndamento());
        assertEquals(9.2f, curso.getMediaFinal(), 0.001);
    }

    @Test
    public void testSettersAndGetters() {
        Cursos curso = new Cursos();
        curso.setAlunoCurso("Teste Aluno");
        curso.setCursoQtd(2);
        curso.setCursoAndamento("Pendente");
        curso.setMediaFinal(7.8f);

        assertEquals("Teste Aluno", curso.getAlunoCurso());
        assertEquals(2, curso.getCursoQtd());
        assertEquals("Pendente", curso.getCursoAndamento());
        assertEquals(7.8f, curso.getMediaFinal(), 0.001);
    }
}
