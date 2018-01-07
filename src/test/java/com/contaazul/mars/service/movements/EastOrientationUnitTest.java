package com.contaazul.mars.service.movements;

import com.contaazul.mars.exceptions.InvalidMoveException;
import com.contaazul.mars.model.Robot;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class EastOrientationUnitTest {

    private EastOrientation eastOrientation = new EastOrientation();

    @Rule
    public ExpectedException expectedException =  ExpectedException.none();

    @Test
    public void move() {
        Robot r = new Robot();
        r.setOrientation("E");
        r = eastOrientation.move(r);
        r = eastOrientation.move(r);
        assertEquals(0,r.getY());
        assertEquals(2,r.getX());
        assertEquals("E",r.getOrientation());

    }


    @Test
    public void Invalidmove_MustThrowException() {
        Robot r = new Robot();
        r.setOrientation("E");
        r = eastOrientation.move(r);
        r = eastOrientation.move(r);
        r = eastOrientation.move(r);
        r = eastOrientation.move(r);

        expectedException.expect(InvalidMoveException.class);
        expectedException.expect(hasProperty("message",is("Cannot move to right")));
        eastOrientation.move(r);

    }

    @Test
    public void testRotationRight(){
        Robot r = new Robot();
        r.setOrientation("E");
        r = eastOrientation.rotate(r,"R");


        assertEquals(0,r.getY());
        assertEquals(0,r.getX());
        assertEquals("S",r.getOrientation());
    }

    @Test
    public void testRotationLeft(){
        Robot r = new Robot();
        r.setOrientation("E");
        r = eastOrientation.rotate(r,"L");


        assertEquals(0,r.getY());
        assertEquals(0,r.getX());
        assertEquals("N",r.getOrientation());
    }


    @Test
    public void testInvalidRotationRight_mustNotRotateTwice() {
        Robot r = new Robot();
        r.setOrientation("E");
        r = eastOrientation.rotate(r,"R");
        r = eastOrientation.rotate(r,"R");


        assertEquals(0, r.getY());
        assertEquals(0, r.getX());
        assertEquals("S", r.getOrientation());
    }
    @Test
    public void testInvalidRotationLeft_mustNotRotateTwice(){
        Robot r = new Robot();
        r.setOrientation("E");
        r = eastOrientation.rotate(r,"L");
        r = eastOrientation.rotate(r,"L");


        assertEquals(0,r.getY());
        assertEquals(0,r.getX());
        assertEquals("N",r.getOrientation());
    }


    @Test
    public void getOrientationRight() {

        assertEquals("S",eastOrientation.getOrientation("R"));

    }

    @Test
    public void getOrientationLeft() {

        assertEquals("N",eastOrientation.getOrientation("L"));

    }

}