package co.com.porvenir.certification.utest.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InterfacePagina {

    public static final Target BOTON_CATEGORIA_AGRADECIMIENTOS = Target.the("Botón para seleccionar la categoría 'Agradecimientos'")
            .located(By.xpath("//a[@href='https://www.floristeriamundoflor.com/product-category/agradecimientos/'][contains(text(), 'Agradecimientos')]"));

    public static final Target TITULO_CATEGORIA_AGRADECIMIENTOS = Target.the("Título de la página de la categoría 'Agradecimientos'")
            .located(By.xpath("//h1[@class='page-title' and text()='Agradecimientos']"));

    public static final Target CUADRO_PRIMER_PRODUCTO = Target.the("Cuadro del primer producto 'MDF 00015'")
            .located(By.xpath("//a[@class='product-image image-loaded' and @href='https://www.floristeriamundoflor.com/product/mdf-00015/']"));

    public static final Target BOTON_ANADIR_AL_CARRITO_PRIMER_PRODUCTO = Target.the("Botón para añadir el primer producto 'MDF 00015' al carrito")
            .located(By.xpath("//button[@name='add-to-cart' and @value='4079' and @class='single_add_to_cart_button button alt']"));

    public static final Target CUADRO_SEGUNDO_PRODUCTO = Target.the("Cuadro del segundo producto 'Botella de vino gato negro 750 ml'")
            .located(By.xpath("//a[text()='Botella de vino gato negro 750 ml']"));

    public static final Target BOTON_ANADIR_AL_CARRITO_SEGUNDO_PRODUCTO = Target.the("Botón para añadir el segundo producto 'Botella de vino gato negro 750 ml' al carrito")
            .located(By.xpath("//button[@name='add-to-cart']"));

    public static final Target BOTON_VER_CARRITO = Target.the("Botón para ver el carrito de compras")
            .located(By.xpath("//a[@class='dropdown-toggle mini-cart' and @title='Ver su carrito de compras']"));

    public static final Target TEXT_PRODUCTO_CARRITO_1 = Target.the("Texto del primer producto 'MDF 00015' en el carrito")
            .located(By.xpath("(//a[@class='product-name' and text()='MDF 00015'])[2]"));

    public static final Target TEXT_PRODUCTO_CARRITO_2 = Target.the("Texto del segundo producto 'Botella de vino gato negro 750 ml' en el carrito")
            .located(By.xpath("(//a[@class='product-name' and contains(text(), 'Botella de vino gato negro 750 ml')])[2]"));

}
