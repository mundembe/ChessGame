package chessgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.*;

import ChessPieces.Bishop;
import ChessPieces.King;
import ChessPieces.Knight;
import ChessPieces.Pawn;
import ChessPieces.Piece;
import ChessPieces.Queen;
import ChessPieces.Rook;

public class Game {
    JFrame frame;
    JPanel map;
    Square[][] blocks = new Square[8][8];
    Piece[][] pieces = new Piece[8][8];
    // Dimensions
    final int W = 1000;
    final int H = 750;
    final int mW = 662;
    final int mH = 662;

    public Piece excitedPiece;
    public ArrayList<Integer> xAffectedBlocks = new ArrayList<Integer>();
    public ArrayList<Integer> yAffectedBlocks = new ArrayList<Integer>();
    public int xLaunch;
    public int yLaunch;
    public boolean whitesMove = true;
    public Color highlightColor = Color.yellow;

    public Game() {
        createWindow();
        createMap();
        createBlocks();
        addPieces();
        actionProcessor();

        frame.setVisible(true);
    }

    public void createWindow() {
        frame = new JFrame("Game");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, W, H);
    }

    public void createMap() {
        map = new JPanel();
        map.setBounds(10, 30, mW, mH);
        map.setLayout(null);
        map.setVisible(true);
        map.setBackground(Color.DARK_GRAY);

        frame.add(map);
    }

    public void createBlocks() {
        int y = 4;
        int xPadding = 82;
        int yPadding = 82;
        int size = 80;
        boolean switchColorPhase = true;

        for (int i = 0; i < 8; i++) {
            int x = 5;
            switchColorPhase = !switchColorPhase;
            for (int j = 0; j < 8; j++) {

                Square block = new Square();
                block.setTenant("empty");

                block.setBounds(x, y, size, size);
                if ((j % 2 == 0) && (i % 2 == 0) || (j % 2 == 1) && switchColorPhase)
                    block.setBlockColor(Color.DARK_GRAY);
                else
                    block.setBlockColor(Color.WHITE);
                blocks[i][j] = block;

                map.add(block);
                x += xPadding;

            }
            y += yPadding;
        }
    }

    public void addPieces() {
        for (int i = 0; i < 8; i++) {
            // White Pawns
            pieces[1][i] = new Pawn("player=white", 1, i);
            pieces[1][i].add(blocks[1][i], pieces[1][i].imagePath);
            blocks[1][i].setTenant("white");
            // Black Pawns
            pieces[6][i] = new Pawn("player=black", 6, i);
            pieces[6][i].add(blocks[6][i], pieces[6][i].imagePath);
            blocks[6][i].setTenant("black");
        }

        // King
        pieces[0][4] = new King("player=white", 0, 4);
        pieces[0][4].add(blocks[0][4], pieces[0][4].imagePath);
        blocks[0][4].setTenant("white");
        pieces[7][4] = new King("player=black", 7, 4);
        pieces[7][4].add(blocks[7][4], pieces[7][4].imagePath);
        blocks[7][4].setTenant("black");
        // Queen
        pieces[0][3] = new Queen("player=white", 0, 3);
        pieces[0][3].add(blocks[0][3], pieces[0][3].imagePath);
        blocks[0][3].setTenant("white");
        pieces[7][3] = new Queen("player=black", 7, 3);
        pieces[7][3].add(blocks[7][3], pieces[7][3].imagePath);
        blocks[7][3].setTenant("black");

        // White Rook
        pieces[0][0] = new Rook("player=white", 0, 0);
        pieces[0][0].add(blocks[0][0], pieces[0][0].imagePath);
        blocks[0][0].setTenant("white");
        pieces[0][7] = new Rook("player=white", 0, 7);
        pieces[0][7].add(blocks[0][7], pieces[0][7].imagePath);
        blocks[0][7].setTenant("white");
        // Black Rook
        pieces[7][0] = new Rook("player=black", 7, 0);
        pieces[7][0].add(blocks[7][0], pieces[7][0].imagePath);
        blocks[7][0].setTenant("black");
        pieces[7][7] = new Rook("player=black", 7, 7);
        pieces[7][7].add(blocks[7][7], pieces[7][7].imagePath);
        blocks[7][7].setTenant("black");

        // White Knight
        pieces[0][1] = new Knight("player=white", 0, 1);
        pieces[0][1].add(blocks[0][1], pieces[0][1].imagePath);
        blocks[0][1].setTenant("white");
        pieces[0][6] = new Knight("player=white", 0, 6);
        pieces[0][6].add(blocks[0][6], pieces[0][6].imagePath);
        blocks[0][6].setTenant("white");
        // Black Knight
        pieces[7][1] = new Knight("player=black", 7, 1);
        pieces[7][1].add(blocks[7][1], pieces[7][1].imagePath);
        blocks[7][1].setTenant("black");
        pieces[7][6] = new Knight("player=black", 7, 6);
        pieces[7][6].add(blocks[7][6], pieces[7][6].imagePath);
        blocks[7][6].setTenant("black");

        // White Bishop
        pieces[0][2] = new Bishop("player=white", 0, 2);
        pieces[0][2].add(blocks[0][2], pieces[0][2].imagePath);
        blocks[0][2].setTenant("white");
        pieces[0][5] = new Bishop("player=white", 0, 5);
        pieces[0][5].add(blocks[0][5], pieces[0][5].imagePath);
        blocks[0][5].setTenant("white");
        // Black Bishop
        pieces[7][2] = new Bishop("player=black", 7, 2);
        pieces[7][2].add(blocks[7][2], pieces[7][2].imagePath);
        blocks[7][2].setTenant("black");
        pieces[7][5] = new Bishop("player=black", 7, 5);
        pieces[7][5].add(blocks[7][5], pieces[7][5].imagePath);
        blocks[7][5].setTenant("black");
    }

    public void actionProcessor() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) { // Creating an action processor for each piece;
                int x = i;
                int y = j;
                blocks[i][j].addActionListener(new ActionListener() {

                    public void refresh() {
                        // Reset bg color
                        for (int i = 0; i < xAffectedBlocks.size(); i++) {
                            Square b = blocks[xAffectedBlocks.get(i)][yAffectedBlocks.get(i)];
                            b.setBackground(b.getBlockColor());
                            b.setReadyForMove(false);

                        }
                        // Display tenants
                        for (int k = 0; k < blocks.length; k++) {
                            for (int l = 0; l < blocks.length; l++) {
                               // blocks[k][l].setText("x=" + k + "y=" + l);
                               try {
                                    blocks[k][l].setText(blocks[k][l].getTenant());
                               } catch (Exception e) {
                                // TODO: handle exception
                               }
                            }
                        }

                        xAffectedBlocks.clear();
                        yAffectedBlocks.clear();

                    }

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Piece p = pieces[x][y]; // Launching action processor for each piece

                        // Move a piece
                        if (blocks[x][y].getReadyForMove() && !Objects.isNull(excitedPiece) && excitedPiece.pieceIsWhite==whitesMove) {

                            blocks[excitedPiece.getxCoordinate()][excitedPiece.getyCoordinate()].setIcon(null);
                            whitesMove = blocks[x][y].place(excitedPiece, whitesMove);
                            blocks[xLaunch][yLaunch].setTenant("empty");
                            switch (excitedPiece.getPieceType().toLowerCase()) {
                                case "pawn":
                                    pieces[x][y] = new Pawn(excitedPiece.getDescription(), x, y);
                                    break;
                                case "rook":
                                    pieces[x][y] = new Rook(excitedPiece.getDescription(), x, y);
                                    break;
                                case "knight":
                                    pieces[x][y] = new Knight(excitedPiece.getDescription(), x, y);
                                    break;
                                case "bishop":
                                    pieces[x][y] = new Bishop(excitedPiece.getDescription(), x, y);
                                    break;
                                case "queen":
                                    pieces[x][y] = new Queen(excitedPiece.getDescription(), x, y);
                                    break;
                                case "king":
                                    pieces[x][y] = new King(excitedPiece.getDescription(), x, y);
                                    break;
                                default:
                                    System.out.println(
                                            "Error: The result of \'excitedPiece.getPieceType().toLowerCase()\' isn't a recognised case in the Game\'s switch statement");
                                    break;

                            }
                            pieces[excitedPiece.getxCoordinate()][excitedPiece.getyCoordinate()] = null; // destroying the piece

                            refresh();

                        } 
                        
                        // Show Possible moves
                        else if (!(blocks[x][y].getTenant().equals("empty"))) {
                            refresh();
                            xLaunch = x;
                            yLaunch = y;
                            p.actionProcessor(blocks);

                            try {
                                if (whitesMove == p.pieceIsWhite)
                                    highlightColor = Color.yellow;
                                else 
                                    highlightColor = Color.cyan;

                            } catch (NullPointerException NullPointerException) {
                                System.out.println("Failed");
                            }
                            // Highlight the Possible Moves
                            for (int k = 0; k < 16; k++) {
                                try {
                                    if (p.xPossibleMoves[k] != -1 && p.yPossibleMoves[k] != -1) {
                                        xAffectedBlocks.add(p.xPossibleMoves[k]);
                                        yAffectedBlocks.add(p.yPossibleMoves[k]);
                                    }
                                    blocks[p.xPossibleMoves[k]][p.yPossibleMoves[k]].setBackground(highlightColor);
                                    blocks[p.xPossibleMoves[k]][p.yPossibleMoves[k]].setReadyForMove(true);
                                } catch (Exception exception) {
                                }
                            }
                            excitedPiece = p; // Keeping track of which piece is ready to move

                        }
                    }
                });
            }
        }
    }

}
