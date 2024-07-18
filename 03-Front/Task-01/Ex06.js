let livros = [
    {id :1 , genero: "Terror", nome: "It" },
    {id :2 , genero: "Terror", nome: "O Exorcista" },
    {id :3 , genero: "Terror", nome: "Drácula" },
    {id :4 , genero: "Romance", nome: "O Morro dos Ventos Uivantes" },
    {id :5 , genero: "Policial", nome: "O Silêncio dos Inocentes" },
    {id :6 , genero: "Suspense", nome: "Boneco de Neve" },
    {id :7 , genero: "Suspense", nome: "Bird Box" },
    {id :8 , genero: "Romance", nome: "Orgulho e Preconceito" }
]


listrarLivros(livros);

listrarLivrosTerror(livros);

function listrarLivros(livros){
    console.log("Catálogo de livros");
    livros.forEach((livros) => {
        console.log(`${livros.nome}`);
    });
}


function listrarLivrosTerror(livros){
    console.log("\nCatálogo de livros de terror:");
    livros.forEach((livros) => {
        if(livros.genero === "Terror"){
            console.log(`${livros.nome}`);
        }
    });
}