package com.project.educacaogamificada;

import com.project.educacaogamificada.controller.AlunosController;
import com.project.educacaogamificada.controller.dto.AlunosDto;
import com.project.educacaogamificada.controller.form.AlunosForm;
import com.project.educacaogamificada.modelo.Alunos;
import com.project.educacaogamificada.repository.AlunosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AlunosControllerTest {
    @Mock
    private AlunosRepository alunosRepository;

    @InjectMocks
    private AlunosController alunosController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarAlunos() {
        List<Alunos> alunosList = new ArrayList<>();
        alunosList.add(new Alunos("João", "senha123", "plano1"));

        when(alunosRepository.findAll()).thenReturn(alunosList);

        ResponseEntity<List<AlunosDto>> response = alunosController.listarAlunos();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(alunosRepository, times(1)).findAll();
    }

    @Test
    public void testConsultaPorId() {
        long alunoId = 1L;
        Alunos aluno = new Alunos("João", "senha123", "plano1");
        aluno.setAlunoID(alunoId);

        when(alunosRepository.findById(alunoId)).thenReturn(java.util.Optional.of(aluno));

        ResponseEntity<Alunos> response = alunosController.consultaPorId(alunoId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(aluno, response.getBody());
        verify(alunosRepository, times(1)).findById(alunoId);
    }

    @Test
    public void testValidandoLogin() {
        AlunosForm form = new AlunosForm();
        form.setAlunoNome("João");
        form.setAlunoSenha("senha123");

        when(alunosRepository.existsByAlunoNome("João")).thenReturn(true);
        when(alunosRepository.existsByAlunoSenha("senha123")).thenReturn(true);

        ResponseEntity<?> response = alunosController.validandoLogin(form);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Login realizado com sucesso", response.getBody());
        verify(alunosRepository, times(1)).existsByAlunoNome("João");
        verify(alunosRepository, times(1)).existsByAlunoSenha("senha123");
    }

    @Test
    public void testCadastrarAluno() {
        AlunosForm form = new AlunosForm();
        form.setAlunoNome("João");
        form.setAlunoSenha("senha123");
        form.setTipoPlano("plano1");

        when(alunosRepository.existsByAlunoNome("João")).thenReturn(false);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance(); // Criar um novo UriComponentsBuilder

        ResponseEntity<?> response = alunosController.cadastrarAluno(form, uriBuilder);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(alunosRepository, times(1)).existsByAlunoNome("João");
        verify(alunosRepository, times(1)).save(any(Alunos.class));
    }
}
