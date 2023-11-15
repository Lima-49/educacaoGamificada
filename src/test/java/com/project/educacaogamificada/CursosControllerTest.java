package com.project.educacaogamificada;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.educacaogamificada.controller.CursosController;
import com.project.educacaogamificada.controller.form.CursosForm;
import com.project.educacaogamificada.modelo.Cursos;
import com.project.educacaogamificada.repository.AlunosRepository;
import com.project.educacaogamificada.repository.CursosRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.Optional;

@WebMvcTest(CursosController.class)
@AutoConfigureMockMvc
public class CursosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CursosRepository cursosRepository;

    @MockBean
    private AlunosRepository alunosRepository;

    @Test
    public void testListarCursos() throws Exception {
        // Configuração do Mock
        Mockito.when(cursosRepository.findAll()).thenReturn(Collections.singletonList(new Cursos()));

        // Executa o teste
        mockMvc.perform(MockMvcRequestBuilders.get("/cursos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1));
    }

    @Test
    public void testUpdAtributo() throws Exception {
        // Configuração do Mock
        String alunoCurso = "Aluno Teste";
        CursosForm cursosForm = new CursosForm();
        cursosForm.setAlunoCurso(alunoCurso);
        Mockito.when(alunosRepository.existsByAlunoNome(alunoCurso)).thenReturn(true);
        Mockito.when(cursosRepository.findByAlunoCurso(alunoCurso)).thenReturn(Optional.of(new Cursos()));

        // Executa o teste
        mockMvc.perform(MockMvcRequestBuilders.post("/cursos/updAtributo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cursosForm)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testUpdAtributo_UsuarioNaoEncontrado() throws Exception {
        // Configuração do Mock
        String alunoCurso = "Aluno Inexistente";
        CursosForm cursosForm = new CursosForm();
        cursosForm.setAlunoCurso(alunoCurso);
        Mockito.when(alunosRepository.existsByAlunoNome(alunoCurso)).thenReturn(false);

        // Executa o teste
        mockMvc.perform(MockMvcRequestBuilders.post("/cursos/updAtributo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cursosForm)))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}