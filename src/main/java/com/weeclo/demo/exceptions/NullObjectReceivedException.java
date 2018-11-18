package com.weeclo.demo.exceptions;

public class NullObjectReceivedException extends NullPointerException{
    private static final String message = "A null object was passed into method: ";
    private String methodName;
    private int lineNumber;
    public NullObjectReceivedException(String methodName, int lineNumber){
        super();
        this.lineNumber = lineNumber;
        this.methodName = methodName;
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }


    @Override
    public String getMessage() {
        return super.getMessage()+message+methodName+" at line: "+lineNumber;
    }

    public String getCrazyMessage(){
        return "YEEHAAA";
    }
}
