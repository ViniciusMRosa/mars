package com.contaazul.mars.service.movements;

import com.contaazul.mars.exceptions.InvalidMoveException;
import com.contaazul.mars.model.Robot;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SouthOrientationUnitTest {


    private SouthOrientation southOrientation = new SouthOrientation();

    @Rule
    public ExpectedException expectedException =  ExpectedException.none();

    @Test
    public void move() {
        Robot r = getRobot();
        r.setY(4);
        r = southOrientation.move(r);
        r = southOrientation.move(r);
        assertEquals(2,r.getY());
        assertEquals(0,r.getX());
        assertEquals("S",r.getOrientation());

    }

    @Test
    public void Invalidmove_MustThrowException() {
        Robot r = getRobot();

        expectedException.expect(InvalidMoveException.class);
        expectedException.expect(hasProperty("message",is("Cannot move down")));
        southOrientation.move(r);

    }

    @Test
    public void testRotationRight(){
        Robot r = getRobot();
        r = southOrientation.rotate(r,"R");


        assertEquals(0,r.getY());
        assertEquals(0,r.getX());
        assertEquals("W",r.getOrientation());
    }

    @Test
    public void testRotationLeft(){
        Robot r = getRobot();
        r = southOrientation.rotate(r,"L");


        assertEquals(0,r.getY());
        assertEquals(0,r.getX());
        assertEquals("E",r.getOrientation());
    }


    @Test
    public void testInvalidRotationRight_mustNotRotateTwice() {
        Robot r = getRobot();
        r = southOrientation.rotate(r,"R");
        r = southOrientation.rotate(r,"R");


        assertEquals(0, r.getY());
        assertEquals(0, r.getX());
        assertEquals("W", r.getOrientation());
    }

    @Test
    public void testInvalidRotationLeft_mustNotRotateTwice(){
        Robot r = getRobot();
        r = southOrientation.rotate(r,"L");
        r = southOrientation.rotate(r,"L");


        assertEquals(0,r.getY());
        assertEquals(0,r.getX());
        assertEquals("E",r.getOrientation());
    }

    @Test
    public void getOrientationRight() {

        assertEquals("W", southOrientation.getOrientation("R"));

    }

    @Test
    public void getOrientationLeft() {

        assertEquals("E", southOrientation.getOrientation("L"));

    }

    private Robot getRobot() {
        Robot r = new Robot();
        r.setOrientation("S");
        return r;
    }
}