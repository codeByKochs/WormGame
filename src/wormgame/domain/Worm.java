package wormgame.domain;

import wormgame.Direction;

import java.util.ArrayList;
import java.util.List;

public class Worm {
    private Direction direction;
    private List<Piece> pieceList;
    private int wormSizeLimiter;

    public Worm(int originalX, int originalY, Direction originalDirection){
        this.direction = originalDirection;
        this.pieceList = new ArrayList<Piece>();
        this.wormSizeLimiter = 3;
        pieceList.add(new Piece(originalX, originalY));
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction dir){
        this.direction = dir;
    }

    public int getLength() {
        return pieceList.size();
    }

    public List<Piece> getPieces(){
        return pieceList;
    }

    public void move(){

        if (direction == Direction.UP){
            pieceList.add(new Piece(pieceList.get(pieceList.size()-1).getX(), pieceList.get(pieceList.size()-1).getY()-1));
        }
        if (direction == Direction.RIGHT){
            pieceList.add(new Piece(pieceList.get(pieceList.size()-1).getX()+1, pieceList.get(pieceList.size()-1).getY()));
        }
        if (direction == Direction.DOWN){
            pieceList.add(new Piece(pieceList.get(pieceList.size()-1).getX(), pieceList.get(pieceList.size()-1).getY()+1));
        }
        if (direction == Direction.LEFT){
            pieceList.add(new Piece(pieceList.get(pieceList.size()-1).getX()-1, pieceList.get(pieceList.size()-1).getY()));
        }
        if (getLength() > wormSizeLimiter){
            pieceList.remove(0);
        }
    }

    public void grow(){
        if (getLength() >= 3){
            wormSizeLimiter++;
        }
    }

    public boolean runsInto(Piece piece){
        for (Piece pieceOfWorm : pieceList){
            if (pieceOfWorm.runsInto(piece)){
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself(){
        Piece head = pieceList.get(pieceList.size()-1);
        int counter = 0;

        for (Piece pieceOfWorm : pieceList){
            if (head.runsInto(pieceOfWorm)){
                counter++;
            }
        }
        if (counter > 1){
            return true;
        }
        return false;
    }
}
