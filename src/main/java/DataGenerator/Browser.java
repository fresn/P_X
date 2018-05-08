package DataGenerator;

import DataGenerator.Exceptions.*;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Singleton
 **/
public class Browser extends DataGeneratorBaseClass{
    protected EventFiringWebDriver event_drive;
    private HashMap<String ,Page> pages=new HashMap<String, Page>();
    public Page currentPage;

    private Browser(String type) throws DriveTypeNotFoundException {

        if(type.equals("Chrome")){
            event_drive=new EventFiringWebDriver(new ChromeDriver());
            event_drive.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
        }else{
            throw new DriveTypeNotFoundException(type);
        }

    }

    private Browser() throws DriveTypeNotFoundException {
        event_drive=new EventFiringWebDriver(new ChromeDriver());
        event_drive.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
    }

    static public Browser getBrowser(String type) throws DriveTypeNotFoundException {
        return new Browser(type);
    }

    static public Browser getBrowser() throws DriveTypeNotFoundException {
        return new Browser();
    }

    public Page page(String url,String pageName) throws WebDriverException {
        Page localPage=new Page(url,this);
        pages.put(pageName,localPage);
        currentPage=localPage;
        return localPage;
    }

    public  HashMap<String ,Page> Pages(){return pages;}

    public Page getPage(String pageName) throws PageNotFoundException {
        Page localPage =this.pages.get(pageName);
        if (localPage == null){
            throw new PageNotFoundException();
        }else{
            return localPage;
        }
    }

    public void quit(){
        event_drive.quit();
    }

    public  Browser sleep(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            /* todo when this Exception happens */
            e.printStackTrace();
        }
        return this;
    }
}
