package com.project.educacaogamificada.service;

import com.project.educacaogamificada.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunosService {
    @Autowired
    private AlunosRepository alunosRepository;

    public boolean existsByAlunoNome(String alunoNome) {
        return alunosRepository.existsByAlunoNome(alunoNome);
    }

    public boolean existsByAlunoSenha(String alunoSenha) {
        return alunosRepository.existsByAlunoSenha(alunoSenha);
    }
}
