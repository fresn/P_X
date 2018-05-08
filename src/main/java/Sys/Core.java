package Sys;


import DataCollector.Log;
import DataGenerator.Browser;
import DataGenerator.Exceptions.DriveTypeNotFoundException;

public class Core {
    private Browser browser;
    private Log logger;
    private Core(){
        logger=new Log();
        try {
            this.browser = Browser.getBrowser();
        } catch (DriveTypeNotFoundException e) {
                logger.push(e.driveType + " Not support currently.");
        }
    }

    public Browser browser(){
        return browser;
    }

    static public Core getCore(){
        return new Core();
    }
}
