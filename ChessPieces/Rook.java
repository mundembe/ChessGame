package ChessPieces;

import chessgame.Square;

public class Rook extends Piece{
    public String imagePathWhite = "images\\rook_white.png";
    public String imagePathBlack = "images\\rook_black.png";

    public Rook(String description, int xCoordinate, int yCoordinate){
        super(description);
        if (pieceIsWhite) this.setImagePath(imagePathWhite);
        if (!pieceIsWhite) this.setImagePath(imagePathBlack);
        this.pieceType = "rook";
        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);
    }

    @Override
    public void showPossibleMoves(Square[][] blocks){
        for (int i = 0; i < 8; i++){
            
        }
    }

}
