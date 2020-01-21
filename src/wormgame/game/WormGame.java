package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;

        this.worm = new Worm(width/2, height/2, Direction.DOWN);

        // if the apple spawns inside the worm it gets spawned with new coordinates
        while (apple == null || worm.runsInto(apple)){
            this.apple = new Apple(new Random().nextInt(width), new Random().nextInt(height));
        }
        addActionListener(this);
        setInitialDelay(2000);
    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (continues) {
            worm.move();
            if (worm.runsInto(apple)){
                worm.grow();
                setApple(new Apple(new Random().nextInt(width-1), new Random().nextInt(height-1)));
            }
            if (worm.runsIntoItself()){
                continues = false;
            }
            //TODO continues=false, if worm runs into wall
            List<Piece> wormPieces = worm.getPieces();
            for (Piece wormPiece : wormPieces){
                if (wormPiece.getX() < 0){
                    continues = false;
                }
                if (wormPiece.getX() > width-1){
                    continues = false;
                }
                if (wormPiece.getY() < 0){
                    continues = false;
                }
                if (wormPiece.getY() > height-1){
                    continues = false;
                }
            }

            updatable.update();
            setDelay(1000/worm.getLength());
        }
    }

    public Worm getWorm() {
        return this.worm;
    }

    public void setWorm(Worm worm){
        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple){
        this.apple = apple;
    }
}
