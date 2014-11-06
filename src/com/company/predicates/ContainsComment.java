package com.company.predicates;

import com.company.Predicate;
/**
 * Created by ikanisamani on 10/8/14.
 */
public class ContainsComment implements Predicate {

    @Override
    public boolean execute(Object o) {
        String strWithNumber = o.toString();
        if(strWithNumber.contains("#")){
            return true;
        } else{
            return false;
        }
    }
}
