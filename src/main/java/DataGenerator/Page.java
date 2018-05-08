package DataGenerator;

import DataGenerator.Exceptions.PageClosedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.HashMap;

public class Page extends DataGeneratorBaseClass {
    private HashMap<String, Element> elements=new HashMap<String, Element>();
    protected EventFiringWebDriver drive;
    public Element currentElement;
    private String windowsHandle;
    public Browser browser;

    public Page(String url, Browser browser) {
        this.browser=browser;
        this.drive = browser.event_drive;
        this.drive.get(url);
        windowsHandle = drive.getWindowHandle();
    }


    public Element element(String xPath, String name) throws PageClosedException {
        checkAndSwitchToWindowsHandle();
        Element localElement = new Element(this,xPath);
        this.elements.put(name, localElement);
        this.currentElement = localElement;
        return localElement;
    }



    public Element element (String xPath, String name,long waitingTime) throws PageClosedException {
        checkAndSwitchToWindowsHandle();
        Element localElement = new Element(this,xPath,waitingTime);
        this.elements.put(name, localElement);
        this.currentElement = localElement;
        return localElement;
    }

    public Element getElement(String name) throws PageClosedException {
        checkAndSwitchToWindowsHandle();
        Element localElement = this.elements.get(name);
        if (localElement != null) {
            return localElement;
        } else {
            throw new ElementNotInteractableException("element : " + name + " not found");
        }
    }

    private void checkAndSwitchToWindowsHandle() throws PageClosedException {
        if (windowsHandle==null){
            throw new PageClosedException();
        }
        if (!this.windowsHandle.equals(drive.getWindowHandle())) {
            this.drive.switchTo().window(windowsHandle);
        }
        ;
    }
    public Page close() throws PageClosedException {
        checkAndSwitchToWindowsHandle();
        drive.close();
        windowsHandle=null;
        return this;
    }
}
