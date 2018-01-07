package com.contaazul.mars.model;

import com.contaazul.mars.exceptions.InvalidMoveException;

public class Robot {

    private final int maxY;
    private final int maxX;

    public Robot(int maxY, int maxX) {
        this.maxY = maxY;
        this.maxX = maxX;
    }

    public Robot() {
        this.maxY = 4;
        this.maxX = 4;
    }

    private int x = 0;
    private int y = 0;
    private String orientation = "N";

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public void moveRigth() {
        if(this.x + 1 > maxX){
            throw new InvalidMoveException("Cannot move to right");
        }
        this.x += 1;
    }

    public void moveLeft(){
        if(this.x - 1 < 0 ){
            throw new InvalidMoveException("Cannot move to left");
        }
        this.x -= 1;

    }

    public void moveUp(){
        if(this.y + 1 > maxY){
            throw new InvalidMoveException("Cannot move up");
        }
        this.y += 1;
    }
    public void moveDown(){
        if(this.y - 1 < 0){
            throw new InvalidMoveException("Cannot move down");
        }
        this.y -= 1;
    }

    public String getFinalPositionFormatted(){
        return String.format("(%s, %s, %s)", this.getX(),this.getY(),this.getOrientation());
    }
}
