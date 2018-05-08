package Sys;

import DataGenerator.Browser;
import DataGenerator.Element;
import DataGenerator.Exceptions.PageClosedException;
import DataGenerator.Exceptions.PageNotFoundException;
import DataGenerator.Page;
import org.junit.Test;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.security.PublicKey;
import java.util.HashMap;

import static org.junit.Assert.*;

public class CoreTest {

    @Test
    public void getCore() throws PageClosedException, PageNotFoundException {
        Core myCore = Core.getCore();
        myCore.browser().page("https://www.google.com", "google");
        myCore.browser().getPage("google").close();
        myCore.browser().quit();

    }


    @Test
    public void sendKeys() throws PageNotFoundException, PageClosedException {
        (Core.getCore())
                .browser()
                .page("https://www.google.com","google")
                .browser
                .getPage("google")
                .element("//input[@id='lst-ib']","searchBox")
                .page
                .getElement("")
                .sendKeys("Ian.ma")
                .enter()
                .page
                .browser
                .sleep(10)
                .getPage("google")
                .close()
                .browser
                .quit();
//        Core myCore = Core.getCore();
//        Page googleHome = myCore.browser().page("https://www.google.com", "google");
//        Element searchBox = googleHome.element("//input[@id='lst-ib']","searchBox",10);
//        Element searchButton=googleHome.element("//*[@id=\"tsf\"]//input[@type='submit']","searchButton",10);
//        searchBox.sendKeys("Ian.ma");
//        searchButton.click();
//        myCore.browser().sleep(10);
//        myCore.browser().getPage("google").close();
//        myCore.browser().quit();
    }

}