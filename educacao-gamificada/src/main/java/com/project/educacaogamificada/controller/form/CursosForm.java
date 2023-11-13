package com.project.educacaogamificada.controller.form;

import com.project.educacaogamificada.modelo.Cursos;
import com.project.educacaogamificada.repository.CursosRepository;

public class CursosForm {

    private String alunoCurso;
    private int cursoQtd;
    private String cursoAndamento;
    private float mediaFinal;

    public Cursos converter(CursosRepository cursosRepository) {

        return new Cursos(alunoCurso, cursoQtd, cursoAndamento, mediaFinal);
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
