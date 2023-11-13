// Dicionário de cursos

var cursos = {
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

// Função para gerar a tabela de cursos
function gerarTabelaCursos() {
    var cursosTableBody = $("#cursosTableBody");

    for (var cursoId in cursos) {
        if (cursos.hasOwnProperty(cursoId)) {
            var curso = cursos[cursoId];
            var newRow = $("<tr>").append(
                $("<td>").text(cursoId),
                $("<td>").text(curso.nome),
                $("<td>").text(curso.descricao),
                $("<td>").html('<button class="btn btn-success" onclick="matricular(' + cursoId + ')">Matricular</button>')
            );

            cursosTableBody.append(newRow);
        }
    }
}

// Função para simular a matrícula em um curso
function matricular(cursoId) {
    // Simulação de uma requisição AJAX para matricular o usuário no curso
    $.ajax({
        type: "POST",
        url: "/matricula",
        data: {
            cursoId: cursoId
        },
        success: function(response) {
            alert("Matrícula realizada com sucesso!");
            // Você pode redirecionar o usuário para outra página ou fazer outras ações aqui
        },
        error: function(xhr, status, error) {
            alert("Erro ao realizar a matrícula: " + error);
        }
    });
}

// Chame a função para gerar a tabela ao carregar a página
$(document).ready(function() {
    gerarTabelaCursos();
});