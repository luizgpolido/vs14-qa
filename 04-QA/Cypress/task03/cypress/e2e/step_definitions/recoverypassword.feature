Feature: Recuperar Senha

  Scenario: Recuperar Senha com dados válidos
    Given Estou na pagina de recuperar senha
    When Digitar os dados de uma conta existente
    And Clico no botão de recuperar senha
    Then Devo receber uma mensagem de conta recuperada

Scenario: Recuperar senha com nome vazio
  Given Estou na pagina de recuperar senha
  When Digitar os dados de uma conta sem o first name
  And Clico no botão de recuperar senha
  Then Devo receber uma mensagem de First Name Required