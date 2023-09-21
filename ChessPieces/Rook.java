package ChessPieces;

import chessgame.Square;

public class Rook extends Piece {
    public String imagePathWhite = "images\\rook_white.png";
    public String imagePathBlack = "images\\rook_black.png";

    public Rook(String description, int xCoordinate, int yCoordinate) {
        super(description);
        if (pieceIsWhite)
            this.setImagePath(imagePathWhite);
        if (!pieceIsWhite)
            this.setImagePath(imagePathBlack);
        this.pieceType = "rook";
        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);
    }

    @Override
    public void showPossibleMoves(Square[][] blocks) {
        int counter = 1;
        int index = 1;
        int loopControl = 0;
        boolean exitloop = false;
        boolean south_free = true;
        boolean north_free = true;
        boolean east_free = true;
        boolean west_free = true;
        while (!exitloop) {

            // North
            if (xCoordinate - counter >=0 && north_free){
                if (!blocks[xCoordinate - counter][yCoordinate].getTenant().contains(pieceColor)){
                    xPossibleMoves[index] = xCoordinate - counter;
                    yPossibleMoves[index] = yCoordinate;
                    index++;
                    if (blocks[xCoordinate-counter][yCoordinate].getTenant().contains(enemy))
                        north_free = false;
                }else {
                    north_free = false;
                }
            }
            
            // South
            if (xCoordinate + counter < 8 && south_free){
                if ( !blocks[xCoordinate+counter][yCoordinate].getTenant().contains(pieceColor)){
                    xPossibleMoves[index] = xCoordinate + counter;
                    yPossibleMoves[index] = yCoordinate;
                    index++;
                    if (blocks[xCoordinate+counter][yCoordinate].getTenant().contains(enemy))
                        south_free = false;
                }else {
                    south_free = false;
                }
            }
            
            // East
            if (yCoordinate - counter >= 0 && east_free){
                if (!blocks[xCoordinate][yCoordinate-counter].getTenant().contains(pieceColor)){
                    xPossibleMoves[index] = xCoordinate;
                    yPossibleMoves[index] = yCoordinate - counter;
                    index++;
                    if (blocks[xCoordinate][yCoordinate-counter].getTenant().contains(enemy))
                        east_free = false;
                }else {
                    east_free = false;
                }
            }

            // West
            if (yCoordinate + counter < 8 && west_free){
                if (! blocks[xCoordinate][yCoordinate+counter].getTenant().contains(pieceColor)){
                    xPossibleMoves[index] = xCoordinate;
                    yPossibleMoves[index] = yCoordinate + counter;
                    index++;
                    if (blocks[xCoordinate][yCoordinate+counter].getTenant().contains(enemy))
                        west_free = false;
                } else {
                    west_free = false;
                }
            }
        



            counter++;
            loopControl++;
            if (loopControl > 16)
                exitloop = true;
            
        }
    }

}
