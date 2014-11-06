package com.company.decorators;

import com.company.Output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by ikanisamani on 10/8/14.
 *
 */
public class TeeOutput extends Decorator {
    private Output original;
    private String fileName;

    public TeeOutput(Output o){
        this.original = o;
    }

    public void setFileName(String str){
        this.fileName = str;
    }

    @Override
    public void write(Object o) {
        try{
            Writer w = new BufferedWriter(new FileWriter(fileName, true));
            w.write(original.toString());
            w.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        original.write(o.toString());

    }
}
