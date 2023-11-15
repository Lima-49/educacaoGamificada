package com.project.educacaogamificada;

import com.project.educacaogamificada.repository.AlunosRepository;
import com.project.educacaogamificada.service.AlunosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AlunosRepositoryTest {

    @Mock
    private AlunosRepository alunosRepository;

    @InjectMocks
    private AlunosService alunosService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExistsByAlunoNome() {
        String alunoNome = "joao123";

        when(alunosRepository.existsByAlunoNome(alunoNome)).thenReturn(true);

        assertTrue(alunosService.existsByAlunoNome(alunoNome));

        verify(alunosRepository, times(1)).existsByAlunoNome(alunoNome);
    }

    @Test
    public void testExistsByAlunoSenha() {
        String alunoSenha = "senha123";

        when(alunosRepository.existsByAlunoSenha(alunoSenha)).thenReturn(true);

        assertTrue(alunosService.existsByAlunoSenha(alunoSenha));

        verify(alunosRepository, times(1)).existsByAlunoSenha(alunoSenha);
    }
}
