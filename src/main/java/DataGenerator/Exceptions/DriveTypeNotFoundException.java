package DataGenerator.Exceptions;

public class DriveTypeNotFoundException extends Exception {
    public String driveType;
    public DriveTypeNotFoundException(String type){
        this.driveType=type;
    }
}
