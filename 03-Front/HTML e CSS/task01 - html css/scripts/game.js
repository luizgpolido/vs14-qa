const gameMenu = document.getElementById("gameMenu")
const gamebattle = document.getElementById("gameBattle")

const gameLogo = '<img id="mainDisplayImg" src="../assets/logo-hero.png" alt="logo placeholder do jogo">'

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






//render game logo
setTimeout(()=> renderToDisplay(gameLogo, ["gameDiv","center-column"]), 3000);

//main menu: when click "[Jogar]" change to hidden and show gameBattle


setTimeout(()=> renderToDisplay(gameMenu),3000)



//click sair redirect to index 

/*  click jogar {

select character

start battle

}*/

