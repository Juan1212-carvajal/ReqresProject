package co.com.porvenir.certification.utest.tasks;

import co.com.porvenir.certification.utest.userinterface.InterfacePagina;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarCategoria implements Task {

    private final String categoriaName;

    public SeleccionarCategoria(String categoriaName) {
        this.categoriaName = categoriaName;
    }

    public static SeleccionarCategoria byName(String categoriaName) {
        return instrumented(SeleccionarCategoria.class, categoriaName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InterfacePagina.BOTON_CATEGORIA_AGRADECIMIENTOS)
        );

    }
}
