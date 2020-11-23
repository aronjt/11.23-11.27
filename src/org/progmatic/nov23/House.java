package org.progmatic.nov23;

import java.util.ArrayList;
import java.util.List;

public class House {

    private boolean isHeating;
    private List<DoorsAndWIndows> secondFloor = new ArrayList<>();
    private List<DoorsAndWIndows> firstFloor = new ArrayList<>();

    public House() {
        double random = Math.random();
        if (random < 0.5) {
            isHeating = true;
        }
        secondFloor.add(new BigWindow());
        secondFloor.add(new SmallWindow());
        secondFloor.add(new BigWindow());
        secondFloor.add(new SmallWindow());
        firstFloor.add(new Door());
        firstFloor.add(new BigWindow());
        firstFloor.add(new SmallWindow());
        firstFloor.add(new BigWindow());
    }

    public void close() {
        for (DoorsAndWIndows doorsAndWIndows : secondFloor) {
            if (doorsAndWIndows.isOpen()) {
                doorsAndWIndows.close();
            }
        }
        for (DoorsAndWIndows doorsAndWIndows : firstFloor) {
            if (doorsAndWIndows.isOpen()) {
                doorsAndWIndows.close();
            }
        }
    }

    public void heating() {
        close();
        isHeating = true;
    }

    public void demist() {
        for (DoorsAndWIndows doorsAndWIndows : secondFloor) {
            if (doorsAndWIndows instanceof SmallWindow) {
                doorsAndWIndows.open = true;
            }
        }
        for (DoorsAndWIndows doorsAndWIndows : firstFloor) {
            if (doorsAndWIndows instanceof SmallWindow) {
                doorsAndWIndows.open = true;
            }
        }
    }

    @Override
    public String toString() {
        if (isHeating) {
            return "Í" + "\n" +
                    secondFloor + "\n" +
                    firstFloor;
        }
        return "I" + "\n" +
                secondFloor + "\n" +
                firstFloor;
    }
}
