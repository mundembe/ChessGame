package ChessPieces;

public class King extends Piece{
    public String imagePathWhite = "images\\king_white.png";
    public String imagePathBlack = "images\\king_black.png";

    public King(String description, int xCoordinate, int yCoordinate){
        super(description);
        if (pieceIsWhite) this.setImagePath(imagePathWhite);
        if (!pieceIsWhite) this.setImagePath(imagePathBlack);
        this.pieceType = "king";
        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);
    }
}
