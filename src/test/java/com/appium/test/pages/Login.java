package com.appium.test.pages;

import com.appium.test.utils.DSL;
import com.appium.test.utils.Locators;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class Login extends DSL {
    public void deveFazerLogi(){
        aguardarPorTexto("agendaqui");
        MobileElement cpf = getDriver().findElement(By.id(Locators.idCampoCpf));
        cpf.sendKeys("51040561047");
        getDriver().hideKeyboard();
        assertEquals("51040561047", cpf.getText());

        MobileElement senha = getDriver().findElement(By.id(Locators.idCampoSenha));
        senha.sendKeys("12345");
        getDriver().hideKeyboard();
        assertEquals("12345", senha.getText());

        gerarEvidenciaDoTest();

        MobileElement btnEntrar = getDriver().findElement(By.id(Locators.idBtnEntrar));
        btnEntrar.click();
        aguardarPagina("androidx.recyclerview.widget.RecyclerView");

        MobileElement salao = getDriver().findElement(By.xpath(Locators.xpathSalaoBlz));
        salao.isDisplayed();

        MobileElement fisioterapia = getDriver().findElement(By.xpath(Locators.xpathFisio));
        fisioterapia.isDisplayed();

        MobileElement mecanica = getDriver().findElement(By.xpath(Locators.xpathMecanica));
        mecanica.isDisplayed();

        gerarEvidenciaDoTest();

        scrollUp();
        MobileElement restaurante = getDriver().findElement(By.xpath(Locators.xpathRestaurante));
        restaurante.isDisplayed();

        MobileElement academia = getDriver().findElement(By.xpath(Locators.xpathAcademia));
        academia.isDisplayed();
        esperar(100);

        gerarEvidenciaDoTest();

        esperar(100);
        scrollDown();
        esperar(100);
        getDriver().navigate().back();
    }
}
