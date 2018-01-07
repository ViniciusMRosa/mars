package com.contaazul.mars.model;

import com.contaazul.mars.exceptions.InvalidMoveException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class RobotUnitTest {

    @Rule
    public ExpectedException expectedException =  ExpectedException.none();
    private Robot robot ;

    @Test
    public void testMoveRight(){
        robot =  new Robot();

        robot.moveRigth();

        assertEquals(0,robot.getY());
        assertEquals(1,robot.getX());
        assertEquals("N",robot.getOrientation());
    }


    @Test
    public void testMoveLeft(){
        robot =  new Robot(3,3);
        robot.moveRigth();
        robot.moveRigth();
        robot.moveLeft();

        assertEquals(0,robot.getY());
        assertEquals(1,robot.getX());
        assertEquals("N",robot.getOrientation());
    }


    @Test
    public void testMoveUp(){
        robot =  new Robot();

        robot.moveUp();

        assertEquals(1,robot.getY());
        assertEquals(0,robot.getX());
        assertEquals("N",robot.getOrientation());
    }


    @Test
    public void testMoveDown(){
        robot =  new Robot();
        robot.moveUp();
        robot.moveUp();
        robot.moveDown();


        assertEquals(1,robot.getY());
        assertEquals(0,robot.getX());
        assertEquals("N",robot.getOrientation());
    }


    @Test
    public void testInvalidMoveRight_MustThrowException(){
        robot =  new Robot();
        robot.moveRigth();
        robot.moveRigth();
        robot.moveRigth();
        robot.moveRigth();

        expectedException.expect(InvalidMoveException.class);
        expectedException.expect(hasProperty("message",is("Cannot move to right")));
        robot.moveRigth();

    }


    @Test
    public void testInvalidMoveLeft_MustThrowException(){
        robot =  new Robot();

        expectedException.expect(InvalidMoveException.class);
        expectedException.expect(hasProperty("message",is("Cannot move to left")));
        robot.moveLeft();

    }


    @Test
    public void testInvalidMoveUp_MustThrowException(){
        robot =  new Robot();
        robot.moveUp();
        robot.moveUp();
        robot.moveUp();
        robot.moveUp();

        expectedException.expect(InvalidMoveException.class);
        expectedException.expect(hasProperty("message",is("Cannot move up")));
        robot.moveUp();

    }


    @Test
    public void testInvalidMoveDown_MustThrowException(){
        robot =  new Robot();

        expectedException.expect(InvalidMoveException.class);
        expectedException.expect(hasProperty("message",is("Cannot move down")));
        robot.moveDown();

    }
}
