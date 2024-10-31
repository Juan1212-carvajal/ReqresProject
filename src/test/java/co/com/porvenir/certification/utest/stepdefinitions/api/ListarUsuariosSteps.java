package co.com.porvenir.certification.utest.stepdefinitions.api;

import io.cucumber.java.en.And;
import net.serenitybdd.rest.SerenityRest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class ListarUsuariosSteps {

    private static final String BASE_URL = "https://reqres.in";
    private int responseStatus;
    private String responseBody;

    @Given("que accedo al servicio de listar usuarios de ReqRes")
    public void queAccedoAlServicioDeListarUsuarios() {
    }

    @When("realizo una solicitud GET al endpoint {string}")
    public void realizoUnaSolicitudGETAlEndpoint(String endpoint) {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .when()
                .get(endpoint);

        responseBody = SerenityRest.lastResponse().getBody().asString();
        responseStatus = SerenityRest.lastResponse().getStatusCode();
    }

    @Then("la respuesta debe contener la lista de usuarios en la pagina {int}")
    public void laRespuestaDebeContenerLaListaDeUsuariosEnLaPagina(int page) {
        assertThat(responseBody).contains("\"page\":" + page);
    }

    @And("el estado de la respuesta debe ser {int}")
    public void elEstadoDeLaRespuestaDebeSer(int expectedStatus) {
        assertThat(responseStatus).isEqualTo(expectedStatus);
    }


}
