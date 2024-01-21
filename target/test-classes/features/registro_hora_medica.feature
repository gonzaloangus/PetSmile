Feature: Registro de hora médica veterinaria

  Scenario: Registro exitoso de hora médica veterinaria
    Given que estoy en la página de registro de hora médica
    When ingreso la información requerida para la hora médica veterinaria
    Then debería ver un mensaje de confirmación

  Scenario: Intento de registro sin información requerida
    Given que estoy en la página de registro de hora médica
    When intento registrar una hora médica sin proporcionar la información requerida
    Then debería ver un mensaje de error indicando los campos obligatorios
