Feature: Bill Pay

  Background: Estou logado e possuo uma conta

  Scenario: Bill Pay Válido
    Given Estou na página de services
    And Clico em Bill Pay
    When Eu digitar um bill payment service válido
    And Clico no botão Send Payment
    Then Devo receber uma mensagem de sucesso

  Scenario: Bill Pay Invalido
    Given Estou na página de services
    And Clico em Bill Pay
    When Eu digitar um bill payment service com o amount vazio
    And Clico no botão Send Payment
    Then Devo receber uma mensagem de amount cannot be empty