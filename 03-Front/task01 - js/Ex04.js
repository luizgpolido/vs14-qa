let menu = ["Mussarela", "Minas", "Parmesão", "Prato", "Gorgonzola"];

console.log(`Cardápio de queijos: ${menu}`)

menu.push("Mascarpone", "Ricota", "Provolone");
console.log(`\nLista atualizada: ${menu}`);

menu.sort();

console.log(`\nLista atualizada em ordem alfabética: ${menu}`);
console.log(`${menu}`);

menu.unshift("Cottage");

console.log(`\nLista atualizada: ${menu}`);
