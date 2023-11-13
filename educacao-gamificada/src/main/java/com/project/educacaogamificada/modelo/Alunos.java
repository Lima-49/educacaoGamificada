package com.project.educacaogamificada.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_alunos")
public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alunoID")
    private long alunoID;

    @Column(name = "alunoNome")
    private String alunoNome;

    @Column(name = "alunoSenha")
    private String alunoSenha;

    @Column(name = "tipoPlano")
    private String tipoPlano;

    public Alunos(){}

    public Alunos(String alunoNome, String alunoSenha, String tipoPlano){
        this.alunoNome = alunoNome;
        this.alunoSenha = alunoSenha;
        this.tipoPlano = tipoPlano;
    }

    public long getAlunoID() {
        return alunoID;
    }

    public void setAlunoID(long alunoID) {
        this.alunoID = alunoID;
    }

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
}
