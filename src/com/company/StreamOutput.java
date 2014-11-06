package com.company;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by ikanisamani on 10/6/14.
 *
 */

public class StreamOutput implements Output {
    // StreamOutput.java
    private Writer sink;


    public StreamOutput(Writer stream) {
        this.sink = stream;
    }

    public void write(Object o) {
        try {
            sink.write(o.toString());
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
