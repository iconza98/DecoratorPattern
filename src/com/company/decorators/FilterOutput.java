package com.company.decorators;

import com.company.Output;
import com.company.Predicate;

import java.util.logging.Filter;

/**
 * Created by ikanisamani on 10/8/14.
 */
public class FilterOutput implements Output {
    private Predicate pred;
    private Output oringal;

    public FilterOutput(Output o, Predicate p){
        this.oringal = o;
        this.pred = p;
    }

    public void write(Object o) {
        if(pred.execute(o.toString())){
            oringal.write(o.toString());
        }
    }

}
