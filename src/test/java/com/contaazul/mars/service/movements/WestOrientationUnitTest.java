package com.contaazul.mars.service.movements;

import com.contaazul.mars.exceptions.InvalidMoveException;
import com.contaazul.mars.model.Robot;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class WestOrientationUnitTest {
    private WestOrientation westOrientation = new WestOrientation();

    @Rule
    public ExpectedException expectedException =  ExpectedException.none();

    @Test
    public void move() {
        Robot r = getRobot();
        r.setX(3);
        r = westOrientation.move(r);
        r = westOrientation.move(r);
        assertEquals(0,r.getY());
        assertEquals(1,r.getX());
        assertEquals("W",r.getOrientation());

    }

    @Test
    public void Invalidmove_MustThrowException() {
        Robot r = getRobot();

        expectedException.expect(InvalidMoveException.class);
        expectedException.expect(hasProperty("message",is("Cannot move to left")));
        westOrientation.move(r);

    }

    @Test
    public void testRotationRight(){
        Robot r = getRobot();
        r = westOrientation.rotate(r,"R");


        assertEquals(0,r.getY());
        assertEquals(0,r.getX());
        assertEquals("N",r.getOrientation());
    }

    @Test
    public void testRotationLeft(){
        Robot r = getRobot();
        r = westOrientation.rotate(r,"L");


        assertEquals(0,r.getY());
        assertEquals(0,r.getX());
        assertEquals("S",r.getOrientation());
    }


    @Test
    public void testInvalidRotationRight_mustNotRotateTwice() {
        Robot r = getRobot();
        r = westOrientation.rotate(r,"R");
        r = westOrientation.rotate(r,"R");


        assertEquals(0, r.getY());
        assertEquals(0, r.getX());
        assertEquals("N", r.getOrientation());
    }

    @Test
    public void testInvalidRotationLeft_mustNotRotateTwice(){
        Robot r = getRobot();
        r = westOrientation.rotate(r,"L");
        r = westOrientation.rotate(r,"L");


        assertEquals(0,r.getY());
        assertEquals(0,r.getX());
        assertEquals("S",r.getOrientation());
    }

    @Test
    public void getOrientationRight() {

        assertEquals("N", westOrientation.getOrientation("R"));

    }

    @Test
    public void getOrientationLeft() {

        assertEquals("S", westOrientation.getOrientation("L"));

    }

    private Robot getRobot() {
        Robot r = new Robot();
        r.setOrientation("W");
        return r;
    }
}