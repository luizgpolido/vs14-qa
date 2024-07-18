const idadeCarlos = 18;
const idadeAna = 15;

console.log(`A diferença de idade entre eles é: ${calcularDiferenca(idadeAna, idadeCarlos)}`);

function calcularDiferenca(idade1, idade2){
    const diferenca = idade1 - idade2;
    return diferenca; 
}