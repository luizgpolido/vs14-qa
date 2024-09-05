const cucumber = require('cypress-cucumber-preprocessor').default
const { defineConfig } = require("cypress");

module.exports = defineConfig({
  projectId: 'e2mmvt',
  e2e: {
    screenshotOnRunFailure: true,
    video: true,
    videoCompression: true,
    projectId: "e2mmvt",
    setupNodeEvents(on, config) {
      on('file:preprocessor', cucumber())

    },
    specPattern: "cypress/e2e/step_definitions/*.feature",
    baseUrl: "https://parabank.parasoft.com/parabank/about.htm"
  },
});
