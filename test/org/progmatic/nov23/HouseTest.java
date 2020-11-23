package org.progmatic.nov23;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTest {

    @Before
    public void setUp() {
    }

    @Test
    public void close() {
        House house = new House();
        house.close();
        int doorsAndWindowsNum = 0;
        for (DoorsAndWIndows doorsAndWIndows : house.getSecondFloor()) {
            if (!doorsAndWIndows.isOpen()) {
                doorsAndWindowsNum++;
            }
        }
        for (DoorsAndWIndows doorsAndWIndows : house.getFirstFloor()) {
            if (!doorsAndWIndows.isOpen()) {
                doorsAndWindowsNum++;
            }
        }
        assertEquals(8, doorsAndWindowsNum);
    }

    @Test
    public void heating() {
        House house = new House();
        house.heating();
        boolean isHeating = house.isHeating();
        assertTrue(isHeating);
    }

    @Test
    public void demist() {
        House house = new House();
        int smallWindowsNum = 0;
        house.demist();
        for (DoorsAndWIndows doorsAndWIndows : house.getFirstFloor()) {
            if (doorsAndWIndows instanceof SmallWindow && doorsAndWIndows.isOpen()) {
                smallWindowsNum++;
            }
        }
        for (DoorsAndWIndows doorsAndWIndows : house.getSecondFloor()) {
            if (doorsAndWIndows instanceof SmallWindow && doorsAndWIndows.isOpen()) {
                smallWindowsNum++;
            }
        }
        assertEquals(3, smallWindowsNum);
    }
}