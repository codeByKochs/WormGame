package wormgame.gui;

import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.game.WormGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingBoard extends JPanel implements Updatable{
    private WormGame wormGame;
    private int pieceLength;

    public DrawingBoard(WormGame wormGame, int pieceLength){
        super.setBackground(Color.GRAY);
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        List<Piece> wormPieces = wormGame.getWorm().getPieces();
        Piece apple = wormGame.getApple();

        // draw pieces of worm
        g.setColor(Color.BLACK);
        for (Piece wormPiece : wormPieces){
            g.fill3DRect(pieceLength*wormPiece.getX(), pieceLength*wormPiece.getY(), pieceLength, pieceLength, true);
        }

        // draw apple
        g.setColor(Color.RED);
        g.fillOval(pieceLength*apple.getX(), pieceLength*apple.getY(), pieceLength, pieceLength);
    }

    @Override
    public void update() {
        repaint();
    }
}
