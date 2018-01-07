package com.contaazul.mars.service.movements;

import com.contaazul.mars.exceptions.InvalidMoveException;
import com.contaazul.mars.model.Robot;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NorthOrientationUnitTest {

    private NorthOrientation northOrientation = new NorthOrientation();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Test
    public void move() {
        Robot r = getNewRobot();
        r.setOrientation("N");
        r = northOrientation.move(r);
        r = northOrientation.move(r);
        r = northOrientation.move(r);
        assertEquals(3, r.getY());
        assertEquals(0, r.getX());
        assertEquals("N", r.getOrientation());

    }


    @Test
    public void Invalidmove_MustThrowException() {
        Robot r = getNewRobot();
        r = northOrientation.move(r);
        r = northOrientation.move(r);
        r = northOrientation.move(r);
        r = northOrientation.move(r);

        expectedException.expect(InvalidMoveException.class);
        expectedException.expect(hasProperty("message", is("Cannot move up")));
        northOrientation.move(r);

    }

    @Test
    public void testRotationRight() {
        Robot r = getNewRobot();
        r = northOrientation.rotate(r, "R");


        assertEquals(0, r.getY());
        assertEquals(0, r.getX());
        assertEquals("E", r.getOrientation());
    }

    @Test
    public void testRotationLeft() {
        Robot r = getNewRobot();
        r = northOrientation.rotate(r, "L");


        assertEquals(0, r.getY());
        assertEquals(0, r.getX());
        assertEquals("W", r.getOrientation());
    }


    @Test
    public void testInvalidRotationRight_mustNotRotateTwice() {
        Robot r = getNewRobot();
        r = northOrientation.rotate(r, "R");
        r = northOrientation.rotate(r, "R");


        assertEquals(0, r.getY());
        assertEquals(0, r.getX());
        assertEquals("E", r.getOrientation());
    }

    @Test
    public void testInvalidRotationLeft_mustNotRotateTwice() {
        Robot r = getNewRobot();
        r = northOrientation.rotate(r, "L");
        r = northOrientation.rotate(r, "L");


        assertEquals(0, r.getY());
        assertEquals(0, r.getX());
        assertEquals("W", r.getOrientation());
    }


    @Test
    public void getOrientationRight() {

        assertEquals("E", northOrientation.getOrientation("R"));

    }

    @Test
    public void getOrientationLeft() {

        assertEquals("W", northOrientation.getOrientation("L"));

    }

    private Robot getNewRobot() {
        Robot r = new Robot();
        r.setOrientation("N");
        return r;
    }
}