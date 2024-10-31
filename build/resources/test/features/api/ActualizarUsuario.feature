Feature: Actualizar usuario existente

  @Scenario:
  Scenario: Actualizar un usuario existente
    Given tengo un ID de usuario existente
    When realizar una solicitud PUT al endpoint /api/users/{id} con datos actualizados
    Then la respuesta debe indicar que el usuario fue actualizado exitosamente con un estado de 200
    And debe devolver los datos actualizados