let pedidos =  [
    { cliente: "Claudino", pizza: "Calabresa", bebida: "Refrigerante" },
  { cliente: "Ana Banana", pizza: "Mafiosa", bebida: "Refrigerante" },
  { cliente: "Jacinto", pizza: "Calabresa", bebida: "Refrigerante" },
  { cliente: "Olimpo", pizza: "Mussarela", bebida: "Refrigerante" },
  { cliente: "Pafúncio", pizza: "Quatro Queijos", bebida: "Suco" },
  { cliente: "Felisberta", pizza: "Mussarela", bebida: "Suco" },
  { cliente: "Raimundo", pizza: "Quatro Queijos", bebida: "Cerveja" },
  { cliente: "Mike", pizza: "Quatro Queijos", bebida: "Cerveja" },
]

const pizzasPedidas = pedidos.map(pizzas => `Pizza ${pizzas.pizza}`);
console.log("No dia de hoje as pizzas pedidas foram: ");
console.log(`${pizzasPedidas}`);

function clientesPorBebida(bebida){
    return pedidos.filter(item => item.bebida === bebida).map(item => item.cliente);
}

const clientesRefrigerante = clientesPorBebida("Refrigerante");
console.log("\nClientes que Pediram Refrigerante:");
console.log(clientesRefrigerante);

const clientesSuco = clientesPorBebida("Suco");
console.log("\nClientes que Pediram Suco:");
console.log(clientesSuco);

const clientesCerveja = clientesPorBebida("Cerveja");
console.log("\nClientes que Pediram Cerveja:");
console.log(clientesCerveja);
