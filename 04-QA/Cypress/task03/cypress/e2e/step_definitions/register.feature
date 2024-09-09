Feature: Registro

  Scenario: Registro Válido
    Given Estou na pagina de registro
    When Eu digitar um registro válidos
    And Clico no botão de registro
    Then Devo ser logado com sucesso

  Scenario: Registro Invalido
    Given Estou na pagina de registro
    When Eu digitar um registro com senhas diferentes
    And Clico no botão de registro
    Then Devo ser avisado que os campos estão diferentes e impedir o registro
