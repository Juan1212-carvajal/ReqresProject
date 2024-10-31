package co.com.porvenir.certification.utest.runners.api;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/EliminarUsuario.feature",
        glue = "co.com.porvenir.certification.utest.stepdefinitions"
)
public class TestRunner {
}
