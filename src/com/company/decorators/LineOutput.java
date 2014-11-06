package com.company.decorators;


import com.company.Output;
import com.company.decorators.Decorator;

/**
 * Created by ikanisamani on 10/8/14.
 *
 */

// LineOutput: adds a newline with every write
public class LineOutput extends Decorator {
    private Output original;

    public LineOutput(Output o){
        this.original = o;
    }


    @Override
    public void write(Object o) {
        original.write(o.toString() + "\n");
    }
}
