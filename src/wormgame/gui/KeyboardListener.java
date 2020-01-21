package wormgame.gui;

import wormgame.Direction;
import wormgame.domain.Worm;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    private Worm worm;

    public KeyboardListener(Worm worm){
        this.worm = worm;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT){
            worm.setDirection(Direction.LEFT);
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT){
            worm.setDirection(Direction.RIGHT);
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP){
            worm.setDirection(Direction.UP);
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN){
            worm.setDirection(Direction.DOWN);
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
