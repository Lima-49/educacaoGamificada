package com.project.educacaogamificada.modelo;

import com.project.educacaogamificada.controller.form.CursosForm;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_cursos")
public class Cursos {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "alunoCurso")
    private String alunoCurso;

    @Column(name = "cursoQtd")
    private int cursoQtd;

    @Column(name = "cursoAndamento")
    private String cursoAndamento;

    @Column(name = "mediaFinal")
    private float mediaFinal;

    public Cursos(){}

    public Cursos(String alunoCurso, int cursoQtd, String cursoAndamento, float mediaFinal){
        this.alunoCurso = alunoCurso;
        this.cursoQtd = cursoQtd;
        this.cursoAndamento = cursoAndamento;
        this.mediaFinal = mediaFinal;
    }

    public void atualizaAtributos(CursosForm form){
        this.setAlunoCurso(form.getAlunoCurso());
        this.setCursoQtd(form.getCursoQtd());
        this.setCursoAndamento(form.getCursoAndamento());
        this.setMediaFinal(form.getMediaFinal());
    }

    public String getAlunoCurso() {
        return alunoCurso;
    }

    public void setAlunoCurso(String alunoCurso) {
        this.alunoCurso = alunoCurso;
    }

    public int getCursoQtd() {
        return cursoQtd;
    }

    public void setCursoQtd(int cursoQtd) {
        this.cursoQtd = cursoQtd;
    }

    public String getCursoAndamento() {
        return cursoAndamento;
    }

    public void setCursoAndamento(String cursoAndamento) {
        this.cursoAndamento = cursoAndamento;
    }

    public float getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(float mediaFinal) {
        this.mediaFinal = mediaFinal;
    }
}
