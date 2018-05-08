package DataGenerator;

import com.sun.jna.platform.win32.OaIdl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element {
    private EventFiringWebDriver driver;
    private WebElement webElement;
    private String windowsHandle;
    public Page page;

    public Element(Page page, String xPath) throws NoSuchElementException {
        this.page=page;
        this.driver = page.drive;
        this.windowsHandle = driver.getWindowHandle();
        this.webElement = driver.findElement(By.xpath(xPath));
    }

    public Element(Page page, String xPath, long waitTime) throws NoSuchElementException {
        this.page=page;
        this.driver = page.drive;
        this.windowsHandle = driver.getWindowHandle();
        this.webElement = new WebDriverWait(driver, waitTime).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }

    public Element enter(){
        this.webElement.sendKeys(Keys.RETURN);
        return this;
    }

    public Element click() {
        this.webElement.click();
        return this;
    }

    public  Element sendKeys(String keys){
        this.webElement.sendKeys(keys);
        return this;
    }

    public void waitFroElement() {

    }
}
