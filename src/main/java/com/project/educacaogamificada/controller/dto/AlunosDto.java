package com.project.educacaogamificada.controller.dto;

import com.project.educacaogamificada.modelo.Alunos;
import jakarta.persistence.Column;

import java.util.List;
import java.util.stream.Collectors;

public class AlunosDto {

    private long alunoID;
    private String alunoNome;
    private String alunoSenha;
    private String tipoPlano;

    public AlunosDto(Alunos alunos){
        super();
        this.alunoID = alunos.getAlunoID();
        this.alunoNome = alunos.getAlunoNome();
        this.alunoSenha = alunos.getAlunoSenha();
        this.tipoPlano = alunos.getTipoPlano();
    }

    public static List<AlunosDto> converter(List<Alunos> alunos) {
        return alunos.stream().map(AlunosDto::new).collect(Collectors.toList());
    }

    public long getAlunoID() {
        return alunoID;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public String getAlunoSenha() {
        return alunoSenha;
    }

    public String getTipoPlano() {
        return tipoPlano;
    }
}
