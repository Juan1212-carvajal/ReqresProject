package co.com.porvenir.certification.utest.stepdefinitions.ui;


import co.com.porvenir.certification.utest.tasks.OpenUp;
import co.com.porvenir.certification.utest.tasks.SeleccionarCategoria;
import co.com.porvenir.certification.utest.userinterface.InterfacePagina;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class VisualizacionProductosSteps {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        OnStage.theActorCalled("Juan").can(BrowseTheWeb.with(driver));
    }

    @Given("que estoy en la pagina principal de la tienda")
    public void queEstoyEnLaPaginaPrincipalDeLaTienda() {
        OnStage.theActorCalled("Juan").wasAbleTo(OpenUp.thePage());
    }

    @When("selecciono la categoria {string}")
    public void seleccionoLaCategoria(String categoria) {
        theActorInTheSpotlight().attemptsTo(SeleccionarCategoria.byName(categoria));

    }

    @Then("se visualizaran los productos para esta categoria")
    public void seVisualizanLosProductosParaEstaCategoria() {
        theActorInTheSpotlight().should(seeThat("Agradecimientos", the(InterfacePagina.TITULO_CATEGORIA_AGRADECIMIENTOS), isVisible()));
    }

    @When("de clic en la opcion Anadir al carrito para el primer producto")
    public void deClicEnLaOpcionAnadirAlCarritoParaElPrimerProducto() {
        theActorInTheSpotlight().attemptsTo(Click.on(InterfacePagina.CUADRO_PRIMER_PRODUCTO), Click.on(InterfacePagina.BOTON_ANADIR_AL_CARRITO_PRIMER_PRODUCTO));
    }

    @And("de clic en la opcion Anadir al carrito para el segundo producto")
    public void deClicEnLaOpcionAnadirAlCarritoParaElSegundoProducto() {
        theActorInTheSpotlight().attemptsTo(Click.on(InterfacePagina.CUADRO_SEGUNDO_PRODUCTO), Click.on(InterfacePagina.BOTON_ANADIR_AL_CARRITO_SEGUNDO_PRODUCTO));
    }

    @Then("el producto se agregara al carrito de compras")
    public void elProductoSeAgregaraAlCarritoDeCompras() {
        System.out.println("Productos agregados");
    }

    @When("doy clic en la opcion CARRO")
    public void doyClicEnLaOpcionCARRO() {
        theActorInTheSpotlight().attemptsTo(Click.on(InterfacePagina.BOTON_VER_CARRITO));
    }

    @Then("deberia visualizar el primer producto en el carrito")
    public void deberiaVisualizarElProductoEnElCarrito1() {
        theActorInTheSpotlight().should(seeThat("Visualizar el producto en el carrito", the(InterfacePagina.TEXT_PRODUCTO_CARRITO_1), isVisible()));
    }

    @And("deberia visualizar el segundo producto en el carrito")
    public void deberiaVisualizarElProductoEnElCarrito2() {
        theActorInTheSpotlight().should(seeThat("Visualizar el producto en el carrito", the(InterfacePagina.TEXT_PRODUCTO_CARRITO_2), isVisible()));
    }
}

