package org.progmatic.nov23;

public class Door extends DoorsAndWIndows{

    public Door() {
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
            return "\u25AF";
        }
        return "\u25AE";
    }
}
