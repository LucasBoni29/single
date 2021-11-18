function logar(){
    var objeto = {
        "nome" : document.getElementById("txtnome").value,
        "patente" : document.getElementById("txtpatente").value
    }

    var cabecalho = {
        method: "POST",
        body: JSON.stringify(objeto),
        headers:{
            "Content-type":"application/json"
        }
    }

    fetch("http://localhost:8080/login", cabecalho)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("logado",JSON.stringify(res));
            //window.location="usuario.html";
            document.getElementsById("id").innerText = res.id
            document.getElementsById("nome").innerText = res.nome
            document.getElementsById("patente").innerText = res.patente
            document.getElementsById("nivel").innerText = res.nivel
            document.getElementsById("descricao").innerText = res.descricao
        })
        .catch(err => {
			console.log(err)
            window.alert("Deu ruim");
        });
    

}