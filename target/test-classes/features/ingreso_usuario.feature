Feature: Ingreso de nombre de usuario

  Scenario: Ingreso exitoso de nombre de usuario con datos almacenados en BD
    Given que tengo datos válidos en la base de datos
    When ingreso el nombre de usuario correcto
    Then debería ser redirigido a la página principal

  Scenario: Ingreso fallido de nombre de usuario con datos erróneos
    Given que tengo datos inválidos en la base de datos
    When ingreso un nombre de usuario incorrecto y una contraseña incorrecta
    Then debería ver un mensaje de error en la página de inicio de sesión

  Scenario: Registro exitoso de hora médica veterinaria
    Given que estoy en la página de registro de hora médica
    When ingreso la información requerida para la hora médica veterinaria
    Then debería ver un mensaje de confirmación

  Scenario: Intento de registro sin información requerida
    Given que estoy en la página de registro de hora médica
    When intento registrar una hora médica sin proporcionar la información requerida
    Then debería ver un mensaje de error indicando los campos obligatorios
