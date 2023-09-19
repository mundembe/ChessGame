package ChessPieces;

import chessgame.Square;

public class Pawn extends Piece{
    public String imagePathWhite = "images\\pawn_white.png";
    public String imagePathBlack = "images\\pawn_black.png";

    public Pawn(String description, int xCoordinate, int yCoordinate){
        super(description);
        if (pieceIsWhite) this.setImagePath(imagePathWhite);
        if (!pieceIsWhite) this.setImagePath(imagePathBlack);
        
        this.pieceType = "pawn";
        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);
    }

    @Override
    public void showPossibleMoves(Square[][] blocks){
        if (this.pieceIsWhite && xCoordinate+1 < 8){
            if (blocks[xCoordinate+1][yCoordinate].getTenant().contains("empty")){
                xPossibleMoves[0] = xCoordinate + 1;
                yPossibleMoves[0] = yCoordinate;

                if (xCoordinate == 1){
                    xPossibleMoves[1] = xCoordinate + 2;
                    yPossibleMoves[1] = yCoordinate;
                }
            }
            if (yCoordinate + 1 < 8) {
                if (blocks[xCoordinate+1][yCoordinate+1].getTenant().contains("black")) {
                    xPossibleMoves[2] = xCoordinate + 1;
                    yPossibleMoves[2] = yCoordinate + 1;
                }
            }
            if (yCoordinate - 1 >= 0) {
                if (blocks[xCoordinate+1][yCoordinate-1].getTenant().contains("black")) {
                    xPossibleMoves[3] = xCoordinate + 1;
                    yPossibleMoves[3] = yCoordinate - 1;
                    System.out.println(xPossibleMoves[3] + " y " + yPossibleMoves[3]);
                }
            }

        }
        // Black Pawns
        if ( ! this.pieceIsWhite && xCoordinate-1 >= 0){
            if (blocks[xCoordinate-1][yCoordinate].getTenant().contains("empty")){
                xPossibleMoves[0] = xCoordinate - 1;
                yPossibleMoves[0] = yCoordinate;
                
                if (xCoordinate == 6){
                    xPossibleMoves[1] = xCoordinate - 2;
                    yPossibleMoves[1] = yCoordinate;
                }
            }
            if (yCoordinate - 1 >= 0){
                if (blocks[xCoordinate-1][yCoordinate-1].getTenant().contains("white")){
                    xPossibleMoves[2] = xCoordinate - 1;
                    yPossibleMoves[2] = yCoordinate - 1;
                }
            }
            if (yCoordinate + 1 < 8) {
                if (blocks[xCoordinate-1][yCoordinate+1].getTenant().contains("white")){
                xPossibleMoves[3] = xCoordinate - 1;
                yPossibleMoves[3] = yCoordinate + 1;
            }
            }
            
        }
    }
    
}
