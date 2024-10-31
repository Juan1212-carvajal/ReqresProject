Feature: Eliminar usuario existente

  @scenario:
  Scenario: Eliminar un usuario existente
    Given obtengo un ID de usuario existente
    When realizo una solicitud DELETE para eliminar el usuario en el endpoint /api/users/{id}
    Then la respuesta debe devolver un estado de 204, indicando que el usuario fue eliminado exitosamente.


