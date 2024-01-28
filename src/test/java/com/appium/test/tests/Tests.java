package com.appium.test.tests;

import com.appium.test.pages.Cadastro;
import com.appium.test.pages.Login;
import com.appium.test.utils.DSL;
import org.junit.After;
import org.junit.Test;

public class Tests extends DSL {
    @After
    public void tearDown() { killDriver();}

    @Test
    public void deveTestarLogin(){
        Login login = new Login();
        login.deveFazerLogi();
    }
    @Test
    public void deveTestarCadastro(){
        Cadastro cadastro = new Cadastro();
        cadastro.deveFazerCadastro();
    }
}
