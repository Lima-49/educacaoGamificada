async function getByName(userName) {
    
    
    if (userName == undefined) {

        var apiUrl = "http://localhost:8080/cursos"

    } else {
        var apiUrl = "http://localhost:8080/cursos/"+userName
    }

    var response = await fetch(apiUrl, {
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
}

async function updateAtribute(media, userName){
    var data = await getByName(userName);
    var qtdCursos = data.cursoQtd
    var curso = data.cursoAndamento

    if(media >= 7){
        qtdCursos = qtdCursos+1
    }

    const response = await fetch('http://localhost:8080/cursos/updAtributo', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ alunoCurso: userName, cursoQtd: qtdCursos, cursoAndamento: curso, mediaFinal: media}),
    });

    if (response.ok){
        window.alert("Curso finalizado com sucesso")
    }

}

function abrirModal(aluno) {

    $("#notaModal").modal("show");

    document.getElementById('inserirNotaBtn').addEventListener('click', function () {

        var notaValue = document.getElementById('notaInput').value;
        updateAtribute(notaValue, aluno);

        $('#notaModal').modal('hide');
    });

}

function gerarTabelaCursos(data) {
    const tableBody = document.getElementById("cursosTableBody");

    if (!data) {
        const noDataMessage = document.createElement("tr");
        noDataMessage.innerHTML = "<td colspan='4'>Nenhum dado disponível</td>";
        tableBody.appendChild(noDataMessage);
        return;
    }

    const alunos = Array.isArray(data) ? data : [data];

    alunos.forEach(aluno => {
        const row = document.createElement("tr");
        row.innerHTML = `
        <td>${aluno.alunoCurso}</td>
        <td>${aluno.cursoQtd}</td>
        <td>${aluno.cursoAndamento}</td>
        <td>${aluno.mediaFinal}</td>
        <td><button class="btn btn-primary" onclick="abrirModal('${aluno.alunoCurso}')">Inserir Nota</button></td>
    `;
    
        tableBody.appendChild(row);
    });
}

async function generateTable() {
    var data = await getByName();
    gerarTabelaCursos(data);
}

$(document).ready(function () {
    generateTable();
});