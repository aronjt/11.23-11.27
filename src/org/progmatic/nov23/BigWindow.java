package org.progmatic.nov23;

public class BigWindow extends DoorsAndWIndows{

    public BigWindow() {
        if (Math.random() < 0.5) {
            open = true;
        }
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public void close() {
        open = false;
    }

    @Override
    public String toString() {
        if (open) {
            return "\u25A1";
        }
        return "\u25A0";
    }
}
