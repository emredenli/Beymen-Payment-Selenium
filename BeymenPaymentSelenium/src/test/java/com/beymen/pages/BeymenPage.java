package com.beymen.pages;

import com.beymen.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class BeymenPage {

    Methods methods;
    WebDriver driver;

    Logger logger = LogManager.getLogger(BeymenPage.class);

    public BeymenPage(WebDriver driver) {
        this.methods = new Methods();
        this.driver = driver;
    }

    //'Beymen.com – Lifestyle Destination'-Kontrol
    public void textControl() {

        /*WebElement element = driver.findElement(By.cssSelector(".o-productSlider__title.seg-qa-title"));
        System.out.println("title : " + element.getText());
        logger.info("element : " + element);
        methods.waitBySeconds(2);*/

        String title = methods.getText(By.cssSelector("head>title"));
        System.out.println("'Beymen.com – Lifestyle Destination' kontrol edildi." + title);
        logger.info("'Beymen.com – Lifestyle Destination' kontrol edildi." + title);
        methods.waitBySeconds(2);
    }

    //Search-Buton-Kontrolu
    public void searchButtonControl() {

        boolean searchButton = methods
                .isElementVisible(By.cssSelector(".o-header__search.bwi-search-o>button"));

        if (searchButton == false) {
            System.out.println("Search-Button goruntulenemedi.");
            logger.info("Search-Button goruntulenemedi.");
        } else {
            System.out.println("Search-Button goruntulendi.");
            logger.info("Search-Button goruntulendi.");
        }

    }

    //Pantolon-Yaz
    public void sendSearch() {
        methods.sendKeys(By.cssSelector(".default-input.o-header__search--input"), "Pantolon");
        System.out.println("'Pantolon'-Word-Searched.");
        methods.waitBySeconds(2);
    }

    //Search-Button
    public void clickSearchButton() {
        methods.click(By.cssSelector("button.o-header__search--btn.bmi-search"));
        System.out.println("Click-Search-Button");
        methods.waitBySeconds(5);
    }

    //Random-Urun-Secimi
    public void randomChoose() {

        Random random = new Random();
        List<WebElement> elements = driver
                .findElements(By.cssSelector("#productList>.col-sm-4.col-md-4.col-lg-4.o-productList__itemWrapper"));
        long elm = elements.stream().count();
        int elementCount = (int) elm;
        elements.get(random.nextInt(elementCount)).click();
        System.out.println("Product-Selected.");
        methods.waitBySeconds(5);
    }

    //Random-Beden-Secimi
    public void sizeChoose() {

        Random random = new Random();
        List<WebElement> elements = driver
                .findElements(By.cssSelector(".m-variation__item.-criticalStock"));
        long elm = elements.stream().count();
        int elementCount = (int) elm;
        elements.get(random.nextInt(elementCount)).click();
        methods.waitBySeconds(5);
        System.out.println("Size-Selected.");
    }

    public void addBasket() {
        //urunun-fiyatı
        WebElement elements = driver.findElement(By.cssSelector(".m-price__new"));
        String price = elements.getText();
        System.out.println("Price : " + price);
        methods.waitBySeconds(3);

        //sepete-ekle-butonu
        methods.click(By.id("addBasket"));
        methods.waitBySeconds(10);

        //sepetime-tikla
        methods.click(By.xpath("/html/body/header/div/div/div[3]/div/a[3]"));
        methods.waitBySeconds(3);

        //fiyat-kiyaslama
        WebElement basketPrice = driver.findElement(By.cssSelector(".m-productPrice__salePrice"));
        String bPrice = basketPrice.getText();
        System.out.println("basketPrice : " + bPrice);

        if (price.equals(bPrice)) {
            System.out.println("Fiyatlar esit");
            methods.waitBySeconds(5);
        } else {
            System.out.println("Fiyatlar esit degil");
            methods.waitBySeconds(5);
        }
    }

    //Adet-Secimi
    public void amountIncreases() {

        methods.click(By.id("quantitySelect0-key-0"));

        List<WebElement> items = driver.findElements(By.cssSelector("#quantitySelect0-key-0>option"));
        long itm = items.stream().count();
        int itemsCount = (int) itm;

        if (itemsCount == 1) {
            items.get(0).click();
        } else {
            items.get(1).click();
        }
        System.out.println("Adet-Secildi");
        methods.waitBySeconds(5);

        /*methods.selectByText(By.cssSelector(".a-selectControl.-small"), " 2 adet");
        methods.waitBySeconds(3);*/
    }

    public void continueButton() {
        methods.click(By.id("nextBtn"));
        methods.waitBySeconds(3);
    }

    public void forgotPasswordButton() {
        //Sifremi-Unuttum-Butonu
        methods.click(By.id("forgotPasswordBtn"));
        methods.waitBySeconds(3);

        //Hatalı-ePosta
        methods.sendKeys(By.id("email"), "emredenli");
        methods.waitBySeconds(3);

        //Gonder-Butonu
        methods.click(By.id("sendBtn"));
        methods.waitBySeconds(3);

        //Uye-Olmadan-Satın-Al-Butonu
        methods.click(By.id("guestCheckoutBtn"));
        methods.waitBySeconds(3);
    }

    //Form-Doldur
    public void formFill() {

        methods.sendKeys(By.id("nameSurname"), "Emre Denli");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("email"), "emre.denli@testinium.com");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("phone"), "5548657092");
        methods.waitBySeconds(1);
        methods.selectByText(By.id("country"), "Manisa");
        methods.waitBySeconds(1);
        methods.selectByText(By.id("district"), "Yunusemre");
        methods.waitBySeconds(1);
        methods.selectByText(By.id("neighborhood"), "Merkez Efendi");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("addressDescription"), "Merkezefendi Mah. Yunusemre/Manisa");
        methods.waitBySeconds(1);
        methods.selectByText(By.id("billingType"), "Bireysel");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("tckn"), "25364301532");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("addressName"), "abc");
        methods.waitBySeconds(1);
        methods.click(By.id("saveAddressBtn"));
        methods.waitBySeconds(5);

    }

}
