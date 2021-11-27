package com.carvajal.common.error;

import com.carvajal.common.ResponseEnum;
import lombok.Generated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Generated
public class CoreException  extends Exception{
    private static final long serialVersionUID = 1L;
    private final ResponseEnum error;
    private transient final List<Object> paramsList;

    public ResponseEnum getError()
    {
        return error;
    }

    public CoreException(ResponseEnum errormessage){
        this.paramsList = new ArrayList<>();
        error = errormessage;
    }

    public CoreException(ResponseEnum errormessage, Throwable cause){
        super(errormessage.name(), cause);
        this.paramsList = new ArrayList<>();
        error = errormessage;
    }

    public CoreException(ResponseEnum errormessage, Throwable cause, Object... params){
        super(errormessage.name(), cause);
        this.paramsList = new ArrayList<>();
        paramsList.addAll(Arrays.asList(params));
        error = errormessage;
    }

    public CoreException(ResponseEnum errormessage, Object... params){
        this.paramsList = new ArrayList<>();
        paramsList.addAll(Arrays.asList(params));
        error = errormessage;
    }
}