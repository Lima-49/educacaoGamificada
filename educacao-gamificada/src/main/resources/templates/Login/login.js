const submitBTN = document.getElementById("submitBtn");
const errorMsg = document.getElementById("errorMessage")

async function validLogin(){
    var userName = document.getElementById("usuario").value;
    var senha = document.getElementById("senha").value;

    if ((usuario !== "") && (senha !== "")){

        const responseBD = await fetch('http://localhost:8080/alunos/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ alunoNome: userName, alunoSenha: senha }),
        });

        
        resultTEXT = await responseBD.text()
        resultCode = responseBD.status

        if (resultCode == 200){
            window.location.href = "../TabelaCursos/cursos.html"
        }else{
            errorMsg.innerText = resultTEXT
            errorMsg.classList.add("text-center");
        }

    }
}

submitBTN.addEventListener("click", async function (event) {
    event.preventDefault();
    await validLogin();
});

