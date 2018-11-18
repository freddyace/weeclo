package com.weeclo.demo.standardization;

import com.weeclo.demo.exceptions.NullObjectReceivedException;

import java.util.List;


public class NullChecker{
    Object objects[];
    String methodName_String;
    int lineNumber_int;
    public NullChecker(String methodName_String, int lineNumber_int, Object...objects){
        this.objects = objects;
        this.methodName_String = methodName_String;
        this.lineNumber_int = lineNumber_int;


    }
    public boolean objecIsNull(Object object){
        if(object==null) {
            return true;
        }else {
            return false;
        }
    }
    public void performCheck(){
        for(Object object: objects){
            if(objecIsNull(object)){
                throw new NullObjectReceivedException(methodName_String, lineNumber_int);
            }
            else{continue;}
        }
    }
}
