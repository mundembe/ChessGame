package ChessPieces;

public class Rook extends Piece{
    public String imagePathWhite = "images\\rook_white.png";
    public String imagePathBlack = "images\\rook_black.png";

    public Rook(String description, int xCoordinate, int yCoordinate){
        super(description);
        if (pieceIsWhite) this.setImagePath(imagePathWhite);
        if (!pieceIsWhite) this.setImagePath(imagePathBlack);
        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);
    }
}
