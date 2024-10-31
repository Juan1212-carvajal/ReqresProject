package co.com.porvenir.certification.utest.stepdefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static net.serenitybdd.rest.RestRequests.given;
import static org.junit.Assert.assertTrue;

public class ActualizarUsuarioSteps {

    private String userId;
    private String responseBody;

    @Given("tengo un ID de usuario existente")
    public void tengoUnIDDeUsuarioExistente() {
        userId = "2";
    }

    @When("realizar una solicitud PUT al endpoint \\/api\\/users\\/\\{id} con datos actualizados")
    public void realizarUnaSolicitudPUTAlEndpointApiUsersIdConDatosActualizados() {
        String updatedUserData = "{ \"name\": \"Juan\", \"job\": \"Junior Software Engineer\" }";
        responseBody = given()
                .contentType("application/json")
                .body(updatedUserData)
                .when()
                .put("https://reqres.in/api/users/" + userId)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();
    }

    @Then("la respuesta debe indicar que el usuario fue actualizado exitosamente con un estado de 200")
    public void laRespuestaDebeIndicarQueElUsuarioFueActualizadoExitosamente() {
        assertTrue("Response should not be empty", responseBody != null && !responseBody.isEmpty());
    }

    @And("debe devolver los datos actualizados")
    public void debeDevolverLosDatosActualizados() {
        assertTrue("Response should contain the updated user data", responseBody.contains("Juan"));
        assertTrue("Response should contain the updated job", responseBody.contains("Junior Software Engineer"));
    }

}
