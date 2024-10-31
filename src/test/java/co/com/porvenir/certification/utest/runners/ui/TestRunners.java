package co.com.porvenir.certification.utest.runners.ui;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/ui/PaginaProductos.feature", // Ruta a tu archivo .feature
        glue = "co.com.porvenir.certification.utest.stepdefinitions.ui" // Paquete donde están tus definiciones de pasos
)
public class TestRunners {
}
