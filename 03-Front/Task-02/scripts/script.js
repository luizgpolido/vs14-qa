//Ex 01
function destacarParagrafo(){
    let paragrafo = document.getElementById('paragrafo');
    paragrafo.classList.toggle('destacado');
    paragrafo.innerText ='O CSS do site não é muito mas é honesto';
}

function recarregarPagina(){
    location.reload();
}

//Ex 02

function mudarCor() {
    let elemento = document.getElementById('paragrafoMudaCor');
    // Conceito do .value retirado do exemplo do funcionamento do input color no W3Schools
    let cor = document.getElementById('corSelecionada').value;
    elemento.style.color = cor;
}

//Ex 03

let incremento = 0;

function incrementarNumero(){
    atualizar(++incremento);
}

function resetarNumero(){
    incremento = 0;
    atualizar(incremento);
}

function atualizar(count){
    document.getElementById('numTrocar').innerText = count;
}

//Ex 04

function fotoPretoBranco(){
    let foto = document.getElementById('fotoQuokka');
    foto.src = "./assets/quokka-pb.jpg";
}

function fotoSaturado(){
    let foto = document.getElementById('fotoQuokka');
    foto.src = "./assets/quokka-iluminado.jpg";
}

function fotoNormal(){
    let foto = document.getElementById('fotoQuokka');
    foto.src = "./assets/quokka.webp";
}

//Ex 05

function calcular(){
    let numeroUm = document.getElementById("numeroUm").value;
    let numeroDois = document.getElementById("numeroDois").value;
    let opcao = document.getElementById("operacao").value;
    let resultado = document.getElementById("resultado");

    switch(opcao) {
        case '+':
            resultado.innerText = parseInt(numeroUm) + parseInt(numeroDois);
            break;
        case '-':
            resultado.innerText = numeroUm - numeroDois;
            break;
        case '*':
            resultado.innerText = numeroUm * numeroDois;
            break;
        case '/':
            resultado.innerText = numeroUm / numeroDois;
            break;
        default:
            resultado.innerText = 'Insira opções válidas!';
            break;
    }
}

function limpar(){
    resultado.innerText = '';
}

//Ex 06

const operacoes = ['+' , '-' , '*', '/'];

function inserirValor(valorInserido){
   let valor = document.getElementById('result-calc').innerHTML;
   if (operacoes.includes(valor.slice(-1)) && operacoes.includes(valorInserido)) {
        alert("Ops, você duplicou a operação!")
    } else {
        document.getElementById('result-calc').innerHTML = valor + valorInserido;
    
    }
    
}

function limpar(){
    document.getElementById('result-calc').innerHTML = "";
}

function apagar(){
    let numTemp = document.getElementById('result-calc').value;
    document.getElementById('result-calc').innerHTML = numTemp.slice(0, -1);
}

function calcular_v2()
{
    var resultado = document.getElementById('result-calc').innerHTML;
    if(resultado){
        document.getElementById('result-calc').innerHTML = eval(resultado);
    }
    else{
        document.getElementById('result-calc').innerHTML = "Você não inseriu valores";
    }
}