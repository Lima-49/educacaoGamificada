const container = document.querySelector(".container");
const cadastroBtn = document.getElementById("cadastroBtn")
var planoSelecionado = null;

function selectedColor(idPlanoSelecionado) {
    if (planoSelecionado) {
        var planoAnterior = document.getElementById(planoSelecionado);
        planoAnterior.style.backgroundColor = '';
    }

    planoSelecionado = idPlanoSelecionado;

    var elementoPlano = document.getElementById(planoSelecionado);
    elementoPlano.style.backgroundColor = '#7cb0ff';
}


container.addEventListener('click', function (event) {
    var planoBanner = event.target.closest('.plano-banner');

    if (planoBanner) {
        var idClicado = planoBanner.id;

        if (idClicado === planoSelecionado) {
            planoSelecionado = null;
            selectedColor(idClicado);
        } else {
            selectedColor(idClicado);
        }
    }
});


async function cadastraAluno(){
    var nomeAluno = document.getElementById("usuario").value
    var senhaAluno = document.getElementById("senha").value

    if ((usuario !== "") && (senha !== "")){
        
        const responseBD = await fetch('http://localhost:8080/alunos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ alunoNome: nomeAluno, alunoSenha: senhaAluno, tipoPlano: planoSelecionado}),
        });

        resultTEXT = await responseBD.text()
        resultCode = responseBD.status
        console.log(resultCode )
        if (resultCode == 201){
            atualizaQtdCursos(planoSelecionado, nomeAluno)
            window.alert("Aluno Cadastrado com sucesso, retorne para a pagina de Login")
        }else{
            window.alert(resultTEXT)
        }

    }
}

async function atualizaQtdCursos(planoSelecionado, nomeAluno){
    var qtdCursos = 0
    if (planoSelecionado == "basico"){
        qtdCursos = 5
    }else if(planoSelecionado == "premium"){
        qtdCursos = 10
    }

    console.log(JSON.stringify({ alunoCurso: nomeAluno, cursoQtd: qtdCursos, cursoAndamento: "nenhum", mediaFinal: parseFloat(21)}))
    const responseBD = await fetch('http://localhost:8080/cursos/updAtributo', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ alunoCurso: nomeAluno, cursoQtd: qtdCursos, cursoAndamento: "", mediaFinal: parseFloat(0)}),
    });

    resultTEXT = await responseBD.text()
    console.log(resultTEXT)

}

cadastroBtn.addEventListener("click", async function (event){
    event.preventDefault()
    await cadastraAluno()
})