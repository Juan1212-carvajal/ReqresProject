package co.com.porvenir.certification.utest.stepdefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static net.serenitybdd.rest.RestRequests.given;
import static org.junit.Assert.assertEquals;

public class EliminarUsuarioSteps {

    private String userId;

    @Given("obtengo un ID de usuario existente")
    public void tengoUnIDDeUsuarioExistente() {
        userId = "2";
    }

    @When("realizo una solicitud DELETE para eliminar el usuario en el endpoint \\/api\\/users\\/\\{id}")
    public void realizoUnaSolicitudDELETEParaEliminarElUsuarioEnElEndpointApiUsersId() {
        given()
                .when()
                .delete("https://reqres.in/api/users/" + userId)
                .then()
                .statusCode(204);
    }

    @Then("la respuesta debe devolver un estado de {int}, indicando que el usuario fue eliminado exitosamente.")
    public void laRespuestaDebeDevolverUnEstadoDeIndicarQueElUsuarioFueEliminadoExitosamente(Integer statusCode) {
        assertEquals("Estado de respuesta incorrecto", Integer.valueOf(204), statusCode);
    }
}
