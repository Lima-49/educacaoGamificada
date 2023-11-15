package com.project.educacaogamificada;

import com.project.educacaogamificada.modelo.Cursos;
import com.project.educacaogamificada.repository.CursosRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CursosRepositoryTest {
    @Autowired
    private CursosRepository cursosRepository;

    @Test
    public void testFindByAlunoCurso() {
        // Cria um curso e salva no repositório
        Cursos curso = new Cursos("Aluno Teste", 3, "Andamento", 8.5f);
        cursosRepository.save(curso);

        // Busca pelo aluno do curso e verifica se foi encontrado
        Optional<Cursos> cursoEncontrado = cursosRepository.findByAlunoCurso("Aluno Teste");
        assertTrue(cursoEncontrado.isPresent());
        assertEquals("Aluno Teste", cursoEncontrado.get().getAlunoCurso());
        assertEquals(3, cursoEncontrado.get().getCursoQtd());
        assertEquals("Andamento", cursoEncontrado.get().getCursoAndamento());
        assertEquals(8.5f, cursoEncontrado.get().getMediaFinal(), 0.001);
    }

    @Test
    public void testFindByAlunoCurso_NaoEncontrado() {
        // Busca por um aluno que não existe e verifica se não foi encontrado
        Optional<Cursos> cursoEncontrado = cursosRepository.findByAlunoCurso("Aluno Inexistente");
        assertFalse(cursoEncontrado.isPresent());
    }
}
