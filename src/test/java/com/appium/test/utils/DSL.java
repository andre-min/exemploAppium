package com.appium.test.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

public class DSL extends DriverFactory{

    public String obterTexto(By by) {

        return getDriver().findElement(by).getText();


    }

    public void clicar (By by) {

        getDriver().findElement(by).click();

    }

    public void clicarPorTexto (String texto) {

        clicar(By.xpath("//*[@text='"+ texto.trim() +"']"));
    }

    public void aguardarPorTexto(String texto){
        WebDriverWait aguardando = new WebDriverWait(getDriver(),40);
        aguardando.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='"+ texto.trim() +"']")));
    }

    public void aguardandoBy(By by){
        WebDriverWait aguardando = new WebDriverWait(getDriver(),40);
        aguardando.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void aguardarPagina (String className){
        WebDriverWait aguardarElemento = new WebDriverWait(getDriver(),40);
        aguardarElemento.until(ExpectedConditions.presenceOfElementLocated(By.className(className.trim())));
    }
    public void scrollDown() { scroll(0.2, 0.9); }
    public void scrollUp() { scroll(0.8, 0.2); }
    public void scrollUpHalf() { scroll(0.5, 0.3); }

    public void scroll(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height*inicio);
        int end_y = (int) (size.height*fim);
        new TouchAction(getDriver())
                .press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, end_y))
                .release()
                .perform();

    }

    public void esperar(long tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void gerarEvidenciaDoTest() {
        File imagem = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(imagem, new File("target/evidencia/" + UUID.randomUUID().toString() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
