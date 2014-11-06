package com.company.decorators;

import com.company.Output;

/**
 * Created by ikanisamani on 10/8/14.
 */
public abstract class Decorator implements Output {
    @Override
    public abstract void write(Object o);

}
