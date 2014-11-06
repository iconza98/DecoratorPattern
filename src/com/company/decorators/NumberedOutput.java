package com.company.decorators;

import com.company.Output;

/**
 *
 * Created by ikanisamani on 10/8/14.
 */
public class NumberedOutput extends Decorator {
    static int count = 1;
    private Output original;

    public NumberedOutput(Output o){
        this.original = o;
    }
    @Override
    public void write(Object o) {

        original.write((count++) + ": " + o.toString() + "\n");
    }
}
