Feature: Visualizacion de productos en la categoria Agradecimientos

  Background:
    Given que estoy en la pagina principal de la tienda
    When selecciono la categoria "Agradecimientos"
    And de clic en la opcion Anadir al carrito para el primer producto
    And de clic en la opcion Anadir al carrito para el segundo producto

  @Scenario1
  Scenario: Visualizacion de productos de la categoria
    Then se visualizaran los productos para esta categoria

  @Scenario2
  Scenario: Anadir dos productos de la categoria Agradecimientos al carrito de compras
    Then el producto se agregara al carrito de compras

  @Scenario3
  Scenario: Validar que los productos se muestran correctamente en la opcion Carro
    When doy clic en la opcion CARRO
    Then deberia visualizar el primer producto en el carrito
    And deberia visualizar el segundo producto en el carrito
