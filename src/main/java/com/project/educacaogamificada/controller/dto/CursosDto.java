package com.project.educacaogamificada.controller.dto;

import com.project.educacaogamificada.modelo.Cursos;

import java.util.List;
import java.util.stream.Collectors;

public class CursosDto {

    private String alunoCurso;
    private int cursoQtd;
    private String cursoAndamento;
    private float mediaFinal;

    public CursosDto(Cursos cursos){
        super();
        this.alunoCurso = cursos.getAlunoCurso();
        this.cursoQtd = cursos.getCursoQtd();
        this.cursoAndamento = cursos.getCursoAndamento();
        this.mediaFinal = cursos.getMediaFinal();
    }

    public static List<CursosDto> converter(List<Cursos> cursos) {
        return cursos.stream().map(CursosDto::new).collect(Collectors.toList());
    }

    public String getAlunoCurso() {
        return alunoCurso;
    }

    public int getCursoQtd() {
        return cursoQtd;
    }

    public String getCursoAndamento() {
        return cursoAndamento;
    }

    public float getMediaFinal() {
        return mediaFinal;
    }
}
