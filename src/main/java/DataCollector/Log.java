package DataCollector;

public class Log {
    public void push(String message){
        StackTraceElement[] cu_t= Thread.currentThread().getStackTrace();
        System.out.println(cu_t[0].getMethodName()+" "+cu_t[1].getMethodName()+" "+cu_t[2].getMethodName()+" "+cu_t[3].getMethodName()+" "+message);
    }
}
