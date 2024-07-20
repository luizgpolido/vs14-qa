const gameMenu = document.getElementById("gameMenu")
const gameBattle = document.getElementById("gameBattle")
const gameSelectCharacter = document.getElementById("gameSelectCharacter")

const gameLogo = '<img id="mainDisplayImg" src="../assets/logo-hero.png" alt="logo placeholder do jogo">'
const characterSelectionScreen = '<img src="../assets/webGameCharacter/javoso.png" alt="imagem do javoso"><img src="../assets/webGameCharacter/reactero.png" alt="imagem do reactero"><img src="../assets/webGameCharacter/portugol.png" alt="imagem do portugol">'

const user = {
    selectedStack: ""
}

const stacks = [
    {id: 1, name: "Javoso", strengthModifier: 2, luckyModifier: 0, hp: 20},
    {id: 2, name: "Reactero", strengthModifier: 0, luckyModifier: 3, hp: 18},
    {id: 3, name: "Portugolino", strengthModifier: 1, luckyModifier: 2, hp: 15},
]

let fighting = []

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
    button.addEventListener('click', async function() {
      user.selectedStack = this.value;

      battle()
      createMessage(`Um ${fighting[1].name} selvagem apareceu!`)

      console.log("Character selected: " + user.selectedStack);
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

function battle() {
    fighting = []

    const userStack = stacks.filter(p => p.name === user.selectedStack)[0]
    fighting.push({
        id: userStack.id,
        name: userStack.name,
        strengthModifier: userStack.strengthModifier,
        luckyModifier: userStack.luckyModifier,
        hp: userStack.hp
    })

    const randomStack = stacks.filter(p => p.name !== user.selectedStack)[random(2)-1]
    fighting.push({
        id: randomStack.id,
        name: randomStack.name,
        strengthModifier: randomStack.strengthModifier,
        luckyModifier: randomStack.luckyModifier,
        hp: randomStack.hp
    })
}


function mob(){
    if (!fighting[1]) return;
    const attackChance = random(3)

    switch(attackChance){
        case 1:
            if (fighting[0].hp <= 0) break
            hit(1, (2 + fighting[1].strengthModifier))
            break
        case 2:
            if (fighting[0].hp <= 0) break
            if (random(10) <= 4){
                hit(1, (4 + fighting[1].strengthModifier))
            } else (hit(1, 1))
            break
        case 3:
            if (fighting[0].hp <= 0) break
            if (random(10) <= 2){
                hit(1, (6 + fighting[1].strengthModifier))
            } else (hit(1, 1))
            break
        default:
            throw new Error("Invalid choose in mob attack!")
    }
}

function basicAttack() {
    hit(0, (2 + fighting[0].strengthModifier))

    mob()
}

function heavyAttack() {
    if (random(10) <= 4){
        hit(0, (4 + fighting[0].strengthModifier))
    } else (hit(0, 1))

    mob()
}

function specialAttack() {
    if (random(10) <= 2){
        hit(0, (6 + fighting[0].strengthModifier))
    } else (hit(0, 1))

    mob()
}

function hit(id, attack) {

    if(checkFinal()){
        setTimeout(() => {
        backToMenu();
        }, 1500);
        return;
    };

    if(dodge(id)){
        createMessage(`${id === 0?fighting[1].name:fighting[0].name} desviou[🍃] de ${fighting[id].name}`)
        return;
    }

    createMessage(`${fighting[id].name} ataca[🔪] ${id === 0?fighting[1].name:fighting[0].name}`, attack, id)

    damage(id, attack)
}


function dodge(id) {
    if (id === 0){
        const chance = (random(10) + fighting[1].luckyModifier)

        if (chance >= 8) {
            return true
        }
    } else if (id === 1) {
        const chance = (random(10) + fighting[0].luckyModifier)

        if (chance >= 8) {
            return true
        }
    }
    return false
}

function damage(id, attack) {
    if (id === 0) {
        fighting[1].hp -= attack;
    } else {
        fighting[0].hp -= attack;
    }
}

function random(max) {
    return Math.floor((Math.random() * max) + 1)
}

function createMessage(message, attack, id){
    const iframe = document.getElementById("iframeLog");
    const iframeDocument = iframe.contentDocument || iframe.contentWindow.document;
    const logMessage = iframeDocument.getElementById('console-log')

    const div = document.createElement("div")
    div.classList.add("log-row")
    const p = document.createElement("p")
    p.innerText = message
    const pHour = document.createElement("p")
    const hour = new Date().toLocaleTimeString()
    pHour.innerText = hour;
    div.appendChild(p)

    if (attack) {
        const damage = document.createElement("p")
        damage.innerText = `${fighting[id].name} desferiu ${attack} de dano!`
        div.appendChild(damage)
    }

    div.appendChild(pHour)

    logMessage.appendChild(div)
    iframeDocument.documentElement.scrollTop = iframeDocument.documentElement.scrollHeight;
}

function clearLog(){
    const iframe = document.getElementById("iframeLog");
    const iframeDocument = iframe.contentDocument || iframe.contentWindow.document;
    const logMessage = iframeDocument.getElementById('console-log')

    logMessage.innerHTML = ""
}

function checkFinal() {
    if (fighting[0].hp <= 0 || fighting[1].hp <= 0) {
        stopButton()

        if (fighting[1].hp <= 0 ) {
            createMessage(`Você venceu!`)
        } else {
            createMessage(`Você perdeu!`)
        }

        return true
    }

    return false
}

function backToMenu() {
    renderToDisplay(gameLogo, ["gameDiv","center-column"])
    document.getElementById("gameMenuOpt").classList.remove("hidden")
    gameBattle.classList.add("hidden");
    gameMenu.classList.remove("hidden")

    fighting = []
    clearLog()
}

function stopButton() {
    const buttonOne = document.getElementById("buttonAttackOne")
    const buttonTwo = document.getElementById("buttonAttackTwo")
    const buttonThree = document.getElementById("buttonAttackThree")

    buttonOne.disabled = true
    buttonTwo.disabled = true
    buttonThree.disabled = true

    setTimeout(() => {
        buttonOne.disabled = false
        buttonTwo.disabled = false
        buttonThree.disabled = false
    }, 1500);
}