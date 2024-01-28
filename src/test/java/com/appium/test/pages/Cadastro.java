package com.appium.test.pages;

import com.appium.test.utils.DSL;
import com.appium.test.utils.Locators;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

public class Cadastro extends DSL {
    public void deveFazerCadastro(){
        aguardarPorTexto("agendaqui");
        getDriver().hideKeyboard();
        MobileElement btnCadastro = getDriver().findElement(By.id(Locators.idBtnCadastro));
        btnCadastro.click();

        aguardarPorTexto("Preencha seu dados!");
        MobileElement nomeCadastro = getDriver().findElement(By.id(Locators.idCampoNomeCompletoCadastro));
        nomeCadastro.sendKeys("Andre Minato");
        assertEquals("Andre Minato", nomeCadastro.getText());
        getDriver().hideKeyboard();

        MobileElement cpfCadastro = getDriver().findElement(By.id(Locators.idCampoCpfCadastro));
        cpfCadastro.sendKeys("51040561047");
        assertEquals("51040561047", cpfCadastro.getText());
        getDriver().hideKeyboard();

        MobileElement emailCadastro = getDriver().findElement(By.id(Locators.idCampoEmailCadastro));
        emailCadastro.sendKeys("andre@teste.com.br");
        assertEquals("andre@teste.com.br", emailCadastro.getText());
        getDriver().hideKeyboard();

        MobileElement telefoneCadastro = getDriver().findElement(By.id(Locators.idCampoTelefoneCadastro));
        telefoneCadastro.sendKeys("11992223344");
        assertEquals("11992223344", telefoneCadastro.getText());
        getDriver().hideKeyboard();

        MobileElement senhaCadastro = getDriver().findElement(By.id(Locators.idCampoCriacaoSenhaCadastro));
        senhaCadastro.sendKeys("123456");
        getDriver().hideKeyboard();

        gerarEvidenciaDoTest();

        scrollUp();

        MobileElement btnCadastrar = getDriver().findElement(By.id(Locators.idBtnSalvarCadastro));
        btnCadastrar.click();

        aguardarPagina("android.view.ViewGroup");
        assertEquals("Nome: Andre Minato", obterTexto(By.id("com.example.agendaqui:id/person_txt")));
        assertEquals("CPF: 51040561047", obterTexto(By.id("com.example.agendaqui:id/cpf_txt")));
        assertEquals("E-mail: andre@teste.com.br", obterTexto(By.id("com.example.agendaqui:id/email_txt")));
        assertEquals("Telefone: 11992223344", obterTexto(By.id("com.example.agendaqui:id/telefone_txt")));

        gerarEvidenciaDoTest();

        scrollUp();
        clicarPorTexto("ACESSO A HOME");
        aguardarPorTexto("Estamos em Construção");
        esperar(100);

        scrollUpHalf();

        gerarEvidenciaDoTest();

        clicarPorTexto("SAIR");
    }
}
