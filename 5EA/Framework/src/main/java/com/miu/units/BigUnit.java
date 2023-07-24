package com.miu.units;

import com.miu.framework.annotations.*;

@Unit(type = UnitType.CONTEXT)
public class BigUnit {

    @Inject(value = "myValue")
    public String value;

    private BigUnit(){}

    @Invoke(type = InvokeType.PRE_DESTROY)
    public void preDestroy(){
        System.out.println("before destroy");
    }

    @Invoke(type = InvokeType.POST_CONSTRUCT)
    public void postConstruct(){
        System.out.println("Post construct");
    }
}
