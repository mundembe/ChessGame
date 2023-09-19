package ChessPieces;

public class Queen extends Piece{
    public String imagePathWhite = "images\\queen_white.png";
    public String imagePathBlack = "images\\queen_black.png";

    public Queen(String description, int xCoordinate, int yCoordinate){
        super(description);
        if (pieceIsWhite) this.setImagePath(imagePathWhite);
        if (!pieceIsWhite) this.setImagePath(imagePathBlack);
        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);
    }
}
