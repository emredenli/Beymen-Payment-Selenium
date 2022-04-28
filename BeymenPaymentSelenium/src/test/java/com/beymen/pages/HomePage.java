package com.beymen.pages;

import com.beymen.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    Methods methods;
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.methods = new Methods();
        this.driver = driver;
    }

    public void home(){

        methods.click(By.cssSelector(".o-header__logo--img"));
        methods.waitBySeconds(2);

    }

    public void infoClose(){

        methods.click(By.cssSelector(".accept-btn-container>#onetrust-accept-btn-handler"));
    }

}
