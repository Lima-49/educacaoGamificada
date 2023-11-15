package com.project.educacaogamificada.controller.form;

import com.project.educacaogamificada.modelo.Alunos;
import com.project.educacaogamificada.repository.AlunosRepository;

public class AlunosForm {

    private String alunoNome;
    private String alunoSenha;
    private String tipoPlano;

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public String getAlunoSenha() {
        return alunoSenha;
    }

    public void setAlunoSenha(String alunoSenha) {
        this.alunoSenha = alunoSenha;
    }

    public String getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(String tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public Alunos converter(AlunosRepository alunosRepository) {
        return new Alunos(alunoNome, alunoSenha, tipoPlano);
    }
}
