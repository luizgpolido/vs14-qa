const gameMenu = document.getElementById("gameMenu")
const gameBattle = document.getElementById("gameBattle")
const gameSelectCharacter = document.getElementById("gameSelectCharacter")

const gameLogo = '<img id="mainDisplayImg" src="../assets/logo-hero.png" alt="logo placeholder do jogo">'
const characterSelectionScreen = '<img src="../assets/webGameCharacter/javoso.png" alt="imagem do javoso"><img src="../assets/webGameCharacter/reactero.png" alt="imagem do reactero"><img src="../assets/webGameCharacter/portugol.png" alt="imagem do portugol">'


let character = null;

//functions
function renderToDisplay(html, classes) { //recebe uma string de html e coloca na tela(pode passar um array de classes tbm)
    const gameDiv = document.createElement("div")
    if (classes) {
        classes.forEach(classe => gameDiv.classList.add(classe))
    }
    gameDiv.id = "gameDiv" 
    gameDiv.innerHTML = html
    const display = document.getElementById("mainDisplay")
    display.innerHTML = '';
    display.appendChild(gameDiv) 
};



//eventListeners
document.getElementById("play").addEventListener('click', () => play())

document.querySelectorAll('.selectCharacter').forEach(button => { //character is defined when btn is pressed
    button.addEventListener('click', function() {
      character = this.value;

      console.log("Character selected: " + character);
      gameSelectCharacter.classList.add("hidden");
      gameBattle.classList.remove("hidden");
    });
  });



// page starts with animation
//render game menu
setTimeout(()=> {
    renderToDisplay(gameLogo, ["gameDiv","center-column"])
    document.getElementById("gameMenuOpt").classList.remove("hidden")
}, 3000);



//main game loop
function play() {
    gameMenu.classList.add("hidden")
    gameSelectCharacter.classList.remove("hidden");
    renderToDisplay(characterSelectionScreen, ["gameDiv", "center-column", "flex", "space-around"])
    
    
    console.log("QUE COMECE A BATALHA!")
}


//click sair redirect to index 

/*  click jogar {

select character

start battle

}*/

