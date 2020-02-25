package CS4200;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.util.List;
import javafx.util.Pair;
import javax.swing.*;

@SuppressWarnings("serial")
public class Board extends JPanel implements MouseListener, MouseMotionListener {
	// Resource location constants for piece images
	private static final String RESOURCES_QUEEN_PNG = "resources/bqueen.png";

    private static final int DEPTH_LEVEL = 3;

	// Logical and graphical representations of board
	private Square[][] board;
    private GameWindow g;
    
    // List of pieces and whether they are movable

    public List<Square> movable;

    private boolean whiteTurn;

    public Board(GameWindow g) {
        initializeBoard(g);
    }

    public Board(GameWindow g, boolean init) {
        if (init) {
            initializeBoard(g);
        }
        else {
            this.g = g;
            board = new Square[8][8];
            whiteTurn = true;
        }
    }

    public void initializeBoard(GameWindow g) {
        this.g = g;
        setLayout(new GridLayout(8, 8, 0, 0));

        this.setPreferredSize(new Dimension(400, 400));
        this.setMaximumSize(new Dimension(400, 400));
        this.setMinimumSize(this.getPreferredSize());
        this.setSize(new Dimension(400, 400));


    }

    public Square[][] getSquareArray() {
        return this.board;
    }

    public boolean getTurn() {
        return whiteTurn;
    }

    public void setCurrPiece(Piece p) {
        this.currPiece = p;
    }

    public Piece getCurrPiece() {
        return this.currPiece;
    }

    // Irrelevant methods, do nothing for these mouse behaviors
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}