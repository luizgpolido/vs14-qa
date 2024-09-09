// ***********************************************************
// This example support/e2e.js is processed and
// loaded automatically before your test files.
//
// This is a great place to put global configuration and
// behavior that modifies Cypress.
//
// You can change the location of this file or turn off
// automatically serving support files with the
// 'supportFile' configuration option.
//
// You can read more here:
// https://on.cypress.io/configuration
// ***********************************************************

// Import commands.js using ES2015 syntax:
import './commands'
import './pages/base'
import './pages/login'
import './pages/register'
import './pages/billpay'
import './pages/recoverypassword'
// Alternatively you can use CommonJS syntax:
// require('./commands')

beforeEach(() => {
     Cypress.Screenshot.defaults({
         overwrite: true,
         disableTimersAndAnimations: true,
     })
})

before(()=>{
    cy.visit('https://parabank.parasoft.com/parabank/about.htm')
    cy.clicar('.leftmenu > :nth-child(6) > a')
    cy.clicar('input[value="jdbc"]')
    cy.clicar('input[value="Submit"]')
})

afterEach(()=>{
    cy.visit('https://parabank.parasoft.com/parabank/about.htm')
    cy.clicar('.leftmenu > :nth-child(6) > a')
    cy.clicar('button[value="CLEAN"]')
})