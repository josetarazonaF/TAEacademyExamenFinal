package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchPage extends BasePage {

    @FindBy(css = "li[class= 'pillar watch']")
    private WebElement watchButton;
    @FindBy(css = ".BucketsContainer section:nth-child(1) > .Carousel__Wrapper > .Carousel__Outer > ul")
    private WebElement carouselList;
    private List<WebElement> liCarouselItems = carouselList.findElements(By.tagName("li"));
    @FindBy(css = "button.lightbox__closebtn")
    private WebElement cardCloseXButton;

    public WatchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleAndDescriptionDisplayedForEachCard() {
        boolean output = true;
        for (WebElement item : liCarouselItems) {
            if (item.findElement(By.cssSelector(".WatchTile__Title")) == null && item.findElement(By.cssSelector(".WatchTile__Meta")) == null) {
                output = false;
            }
        }
        return output;
    }

    public void clickCarouselCardTwo() {
        clickElement(liCarouselItems.get(1));
    }

    public void clickCardCloseXButton() {
        clickElement(cardCloseXButton);
    }

    public boolean isAtLeastOneCarouselDisplayed() {
        return carouselList.isDisplayed();
    }

    public boolean isCardCloseXButtonDisplayed() {
        return cardCloseXButton.isDisplayed();
    }

    public HomePage goToHomePage() {
        switchDefaultContent();
        getDriver().navigate().back();
        return new HomePage(getDriver());
    }

}
