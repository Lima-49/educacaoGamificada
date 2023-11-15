const userName = localStorage.getItem("userName")
const cursos = {
    1: { nome: "Curso de Desenvolvimento Web Básico", descricao: "Introdução ao desenvolvimento web com HTML, CSS e JavaScript." },
    2: { nome: "Curso de Desenvolvimento Web Avançado", descricao: "Boas praticas em desenvolvimento web e aplicação com banco de dados" },
    3: { nome: "Curso de Python Básico", descricao: "Aprenda o básico para programar em Python." },
    4: { nome: "Curso de Python Intermediário", descricao: "Aprenda Estruturas de dados com Python" },
    5: { nome: "Curso de Python Avançado", descricao: "Aprendendo manipulação de arquivos com Python" },
    6: { nome: "Front End", descricao: "Principais ferramentas para front end" },
    7: { nome: "POO com Java", descricao: "Aprenda programação orientada a objetos com Java." },
    8: { nome: "Back End com Java", descricao: "Aprenda como integrar um banco de dados com a pagina web" },
    9: { nome: "Back End com C#", descricao: "Aprenda como integrar um banco de dados com a pagina web" },
    10: { nome: "Arduino I", descricao: "Introdução a Arduino." },
    11: { nome: "Arduino II", descricao: "Aprenda funções do Arduino." },
    12: { nome: "Arduino III", descricao: "Projeto completo utilizando Arduino." },
    13: { nome: "Python para QA", descricao: "Aprenda as principais bibliotecas para testar software" },
    14: { nome: "Python para RPA", descricao: "Aprenda as principais bibliotecas para automação de processos" },
    15: { nome: "Python para Engenharia de dados", descricao: "Aprenda as principais bibliotecas para engenharia de dados" },
    16: { nome: "Python para Cientista de dados", descricao: "Aprenda as principais bibliotecas para cientista de dados." },
    17: { nome: "Devops", descricao: "Aprenda como gerenciar projetos." },
    18: { nome: "Power BI", descricao: "Aprenda como criar graficos informativos no Power BI." },
    19: { nome: "Java Spring Boot", descricao: "Aprenda como criar endpoints utilizando Java." },
    20: { nome: "MySQL", descricao: "Como gerenciar e manipular tabelas no SQL." },
};

function gerarTabelaCursos(qtdCursos) {
    var cursosTableBody = $("#cursosTableBody");

    for (var i = 1; i <= qtdCursos; i++) {
        var curso = cursos[i];
        var newRow = $("<tr>").append(
            $("<td>").text(i),
            $("<td>").text(curso.nome),
            $("<td>").text(curso.descricao),
            $("<td>").html('<button class="btn btn-success" onclick="matricular(' + i + ', \'' + curso.nome + '\')">Matricular</button>')
        );

        cursosTableBody.append(newRow);
    }
}

async function matricular(cursoId, cursoNome){

    var data = await getByName();
    var qtdCursos = data.cursoQtd
    var media = data.mediaFinal

    const response = await fetch('http://localhost:8080/cursos/updAtributo', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ alunoCurso: userName, cursoQtd: qtdCursos, cursoAndamento: cursoNome, mediaFinal: media}),
    });

    if (response.ok){
        window.alert("Aluno Matriculado com sucesso no curso " + cursoNome)
    }
    
}

async function getByName() {
    if (userName !== undefined) {
        var response = await fetch("http://localhost:8080/cursos/" + userName, {
            method: "GET",
            headers: {
                'Content-Type': 'application/json',
            }
        });

        if (response.ok) {
            var responseText = await response.text();
            var responseJson = JSON.parse(responseText)

            return responseJson;
        } else {
            window.alert("Problema no servidor");
            return 0;
        }
    } else {
        window.alert("Usuário não informado");
        return 0;
    }
}

async function getAndGenerateCursos() {
    var data = await getByName();
    var qtdCursos = data.cursoQtd
    gerarTabelaCursos(qtdCursos);
}

$(document).ready(function () {
    getAndGenerateCursos();
});