let numeros = [];
preencherArray(30);

retornarPares(numeros);

function preencherArray(quantidadeNumeros){
    for(let i = 1; i <= quantidadeNumeros; i++){
        numeros.push(i);
    }
}

function retornarPares(numeros){
    for(let i = 0; i <= numeros.length; i++){
        if(numeros[i] % 2 == 0){
            console.log(`Os num pares da lista são: ${numeros[i]} e possuem o índice: ${i}`)
        }
    }
}

