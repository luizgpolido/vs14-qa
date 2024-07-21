const gameMenu = document.getElementById("gameMenu")
const gameBattle = document.getElementById("gameBattle")
const gameSelectCharacter = document.getElementById("gameSelectCharacter")
const gameClassification = document.getElementById("gameClassification")

const gameLogo = '<img id="mainDisplayImg" src="../assets/logo-hero.png" alt="logo placeholder do jogo">'
const characterSelectionScreen = '<img src="../assets/webGameCharacter/javoso.png" alt="imagem do javoso"><img src="../assets/webGameCharacter/reactero.png" alt="imagem do reactero"><img src="../assets/webGameCharacter/portugolino.png" alt="imagem do portugolino">'
const classificationScreen = '<div></div>'
const battleScreen = ' <div class="center-column"><img id="playerImg"><p id="playerName"></p><div><span>Vida: </span><span id="playerHp"></span></div></div><div class="center-column"><img id="npcImg"><p id="npcName"></p><div><span>Vida: </span><span id="npcHp"></span></div></div>'

let classificationScores = [
    {id: 1, name: "Géssica", victories: 1000},
    {id: 2, name: "Mateus", victories: 329}
]

if (!localStorage.classificationScores){
    localStorage.classificationScores = JSON.stringify(classificationScores)
} else {
    classificationScores = JSON.parse(localStorage.classificationScores)
}

let user = {
    name: "",
    selectedStack: "",
    bag: [],
    ram: 0,
    victories: 0
}

if (!localStorage.user){
    localStorage.user = JSON.stringify(user)
} else {
    user = JSON.parse(localStorage.user)
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
document.getElementById("classification").addEventListener('click', () => classification())

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



function play() {
    gameMenu.classList.add("hidden")
    gameSelectCharacter.classList.remove("hidden");
    renderToDisplay(characterSelectionScreen, ["gameDiv", "center-column", "flex", "space-around","characterImg"])
}

function classification() {
    gameMenu.classList.add("hidden")
    gameClassification.classList.remove("hidden");
    attClassification()
}

function attClassification() {
    const classificationDiv = document.createElement("div")
    classificationDiv.id = "classificationDiv"
    classificationDiv.class = "classificationDiv"
    const display = document.getElementById("mainDisplay")
    display.innerHTML = '';

    const divTitle = document.createElement("div")
    const pTitle = document.createElement("p")
    pTitle.innerText = "Jogador"
    divTitle.appendChild(pTitle)

    const pTitleTwo = document.createElement("p")
    pTitleTwo.innerText = "Vitórias"
    divTitle.appendChild(pTitleTwo)

    classificationDiv.appendChild(divTitle)

    localStorage.classificationScores = JSON.stringify(classificationScores) 
    localStorage.user = JSON.stringify(user) 

    for (let person of JSON.parse(localStorage.classificationScores)) {
        const div = document.createElement("div")
        const p = document.createElement("p")
        p.innerText = person.name
        div.appendChild(p)

        const pTwo = document.createElement("p")
        pTwo.innerText = person.victories
        div.appendChild(pTwo)

        classificationDiv.appendChild(div)
    }

    display.appendChild(classificationDiv)
}


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

    renderToDisplay(battleScreen, ["gameDiv",  "flex", "space-around","characterCombatStats"])
    const playerImg = document.getElementById("playerImg")
    const npcImg =  document.getElementById("npcImg")
    playerImg.src = `../assets/webGameCharacter/${fighting[0].name}.png`
    npcImg.src = `../assets/webGameCharacter/${fighting[1].name}.png`
    document.getElementById("playerHp").innerText = fighting[1].hp
    document.getElementById("npcHp").innerText = fighting[0].hp

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
        document.getElementById("playerHp").innerText = fighting[1].hp
    } else {
        fighting[0].hp -= attack;
        document.getElementById("npcHp").innerText = fighting[0].hp
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
            user.victories += 1

            const userIndex = classificationScores.findIndex(n => n.name === user.name)

            if(userIndex !== -1 && user.name !== "") {
                classificationScores[userIndex].victories = user.victories 
                localStorage.classificationScores = JSON.stringify(classificationScores) 
                localStorage.user = JSON.stringify(user)
            } else {
                if (user.name !== "") {
                    classificationScores.push({
                        id: classificationScores.length + 1,
                        name: user.name,
                        victories: user.victories
                    })
                }
            }
        } else {
            createMessage(`Você perdeu!`)
        }

        return true
    }

    return false
}

function alterName() {
    const newName = document.getElementById("nameUser")
    console.log(newName.value.length)

    if(newName.value.length < 1){
        newName.classList.add("input-error")
        return
    }

    const userIndex = classificationScores.findIndex(n => n.name === newName.value)

    if (userIndex !== -1) {
        newName.classList.add("input-error")
        return
    }

    if(user.name.length > 0) {
        user.victories = 0
    }

    user.name = newName.value

    classificationScores.push({
        id: classificationScores.length + 1,
        name: user.name,
        victories: user.victories
    })

    newName.classList.remove("input-error")
    attClassification()
}

function backToMenu() {
    renderToDisplay(gameLogo, ["gameDiv","center-column"])
    document.getElementById("gameMenuOpt").classList.remove("hidden")
    gameBattle.classList.add("hidden");
    gameClassification.classList.add("hidden");
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