/*
 * Team : AGF AM / OSI / SI / BO
 *
 * Copyright (c) 2001 AGF Asset Management.
 */
package net.codjo.mad.server.handler;
import java.io.PrintStream;
import java.io.PrintWriter;
/**
 * Exception avec une cause.
 */
class WithCauseException extends Exception {
    private Exception causedBy;

    WithCauseException(String message, Exception cause) {
        super(message);
        this.causedBy = cause;
    }

    public Exception getCausedBy() {
        return causedBy;
    }


    public void printStackTrace(PrintWriter writer) {
        super.printStackTrace(writer);
        if (getCausedBy() != null) {
            writer.println(" ---- cause ---- ");
            getCausedBy().printStackTrace(writer);
        }
    }


    public void printStackTrace() {
        super.printStackTrace();
        if (getCausedBy() != null) {
            System.err.println(" ---- cause ---- ");
            getCausedBy().printStackTrace();
        }
    }


    public void printStackTrace(PrintStream stream) {
        super.printStackTrace(stream);
        if (getCausedBy() != null) {
            stream.println(" ---- cause ---- ");
            getCausedBy().printStackTrace(stream);
        }
    }
}
