Feature: Login

  Scenario: Login Válido
    Given Estou na pagina de login
    When Eu digitar um login e senha válidos
    And Clico no botão de login
    Then Devo ser logado com sucesso
