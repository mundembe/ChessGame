package ChessPieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import chessgame.Square;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Piece {
    public String imagePath = "";
    public String description;
    public boolean pieceIsWhite;
    public String pieceType;
    public String pieceColor = "white";
    public int xCoordinate;
    public int yCoordinate;
    public int xPossibleMoves[] = new int[32];
    public int yPossibleMoves[] = new int[32];
    boolean readyForMove;
    public String enemy = "";

    public String getImagePath() { return this.imagePath; }
    public void setXCoordinate(int xCoordinate) { this.xCoordinate = xCoordinate; }
    public void setYCoordinate(int yCoordinate) { this.yCoordinate = yCoordinate; }
    public int getxCoordinate() { return xCoordinate; }
    public void setxCoordinate(int xCoordinate) { this.xCoordinate = xCoordinate; }
    public int getyCoordinate() { return yCoordinate; }
    public void setyCoordinate(int yCoordinate) { this.yCoordinate = yCoordinate; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
    public void setPieceType(String pieceType) { this.pieceType = pieceType; }
    public String getPieceType() { return this.pieceType; }
    public String getPieceColor() { return this.pieceColor; }
    public void setPieceColor(String pieceColor) { this.pieceColor = pieceColor; }
    public void setReadyForMove(boolean readyForMove) { this.readyForMove = readyForMove; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Piece(String description){
        this.description = description;
        if (description.contains("player=white")){
            pieceIsWhite = true;
        }
        else if (description.contains("player=black")){
            pieceIsWhite = false;
            this.pieceColor = "black";
        }
        
        // Make initial value of array -1 to represent empty
        for (int i = 0; i < xPossibleMoves.length; i++) {
            xPossibleMoves[i] = -1;
            yPossibleMoves[i] = -1;
        }

        
        if (pieceIsWhite) 
            enemy = "black";
        else
            enemy = "white";
    }

    // Sets the Image Icon to a square
    public void add(Square block, String imagePath){
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
            Image image = bufferedImage.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            ImageIcon imageIcon = new ImageIcon(image);
            block.setIcon(imageIcon);
        } catch (IOException e) {
            System.out.println("IOException ERROR: " + this.imagePath + " Failed to load to BufferedImage");
        }
    }

    
    public void actionProcessor(Square[][] blocks){
        showPossibleMoves(blocks);
        
    }

    public void showPossibleMoves(Square[][] blocks){
        System.out.println("Im Not the Overide");
    }

    public void move(int x, int y){
        setXCoordinate(x);
        setYCoordinate(y);
    }

}
