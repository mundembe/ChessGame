package ChessPieces;

import chessgame.Square;

public class King extends Piece {
    public String imagePathWhite = "images\\king_white.png";
    public String imagePathBlack = "images\\king_black.png";

    public King(String description, int xCoordinate, int yCoordinate) {
        super(description);
        if (pieceIsWhite)
            this.setImagePath(imagePathWhite);
        if (!pieceIsWhite)
            this.setImagePath(imagePathBlack);
        this.pieceType = "king";
        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);
    }

    @Override
    public void showPossibleMoves(Square[][] blocks) {
        // down
        if (xCoordinate + 1 < 8 && !blocks[xCoordinate + 1][yCoordinate].getTenant().contains(pieceColor)) {
            xPossibleMoves[0] = xCoordinate + 1;
            yPossibleMoves[0] = yCoordinate;
        }
        // up
        if (xCoordinate - 1 >= 0 && !blocks[xCoordinate - 1][yCoordinate].getTenant().contains(pieceColor)) {
            xPossibleMoves[1] = xCoordinate - 1;
            yPossibleMoves[1] = yCoordinate;
        }
        //down right
        if ( (xCoordinate+1<8) && (yCoordinate+1<8) && !blocks[xCoordinate + 1][yCoordinate+1].getTenant().contains(pieceColor)) {
            xPossibleMoves[2] = xCoordinate + 1;
            yPossibleMoves[2] = yCoordinate+1;
        }
        // up right
        if ( (xCoordinate-1>=0) && (yCoordinate+1<8) && !blocks[xCoordinate - 1][yCoordinate+1].getTenant().contains(pieceColor)) {
            xPossibleMoves[3] = xCoordinate - 1;
            yPossibleMoves[3] = yCoordinate+1;
        }
        //down left
        if ( (xCoordinate+1<8) && (yCoordinate-1>=0) && !blocks[xCoordinate + 1][yCoordinate-1].getTenant().contains(pieceColor)) {
            xPossibleMoves[4] = xCoordinate + 1;
            yPossibleMoves[4] = yCoordinate-1;
        }
        // up left
        if ( (xCoordinate-1>=0) && (yCoordinate-1>=0) && !blocks[xCoordinate - 1][yCoordinate-1].getTenant().contains(pieceColor)) {
            xPossibleMoves[5] = xCoordinate - 1;
            yPossibleMoves[5] = yCoordinate - 1;
        }
        // right
        if (yCoordinate + 1 < 8 && !blocks[xCoordinate][yCoordinate + 1].getTenant().contains(pieceColor)) {
            xPossibleMoves[6] = xCoordinate;
            yPossibleMoves[6] = yCoordinate + 1;
        }
        // left
        if (yCoordinate - 1 >= 0 && !blocks[xCoordinate][yCoordinate - 1].getTenant().contains(pieceColor)) {
            xPossibleMoves[7] = xCoordinate - 1;
            yPossibleMoves[7] = yCoordinate;
        }
    }
}   
