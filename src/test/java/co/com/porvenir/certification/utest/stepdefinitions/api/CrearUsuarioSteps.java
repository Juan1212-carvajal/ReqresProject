package co.com.porvenir.certification.utest.stepdefinitions.api;

import net.serenitybdd.rest.SerenityRest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

public class CrearUsuarioSteps {

    private static final String BASE_URL = "https://reqres.in";
    private int responseStatus;
    private String responseBody;
    private int createdUserId;

    @Given("que tengo los datos para crear un nuevo usuario")
    public void queTengoLosDatosParaCrearUnNuevoUsuario() {
    }

    @When("realizo una solicitud POST al endpoint {string} con los datos del usuario")
    public void realizoUnaSolicitudPOSTAlEndpointConLosDatosDelUsuario(String endpoint) {
        String jsonData = "{ \"name\": \"John Doe\", \"job\": \"Software Engineer\" }";

        SerenityRest.given()
                .baseUri(BASE_URL)
                .body(jsonData)
                .when()
                .post(endpoint);

        responseBody = SerenityRest.lastResponse().getBody().asString();
        responseStatus = SerenityRest.lastResponse().getStatusCode();


        createdUserId = SerenityRest.lastResponse().jsonPath().getInt("id");
    }

    @Then("la respuesta debe indicar que el usuario fue creado exitosamente con un estado de {int}")
    public void laRespuestaDebeIndicarQueElUsuarioFueCreadoExitosamente(int expectedStatus) {
        assertThat(responseStatus).isEqualTo(expectedStatus);
    }

    @Then("debe devolver el ID del usuario creado")
    public void debeDevolverElIDDelUsuarioCreado() {
        assertThat(createdUserId).isGreaterThan(0);
    }
}
