package ChessPieces;

public class Knight extends Piece{
    public String imagePathWhite = "images\\knight_white.png";
    public String imagePathBlack = "images\\knight_black.png";

    public Knight(String description, int xCoordinate, int yCoordinate){
        super(description);
        if (pieceIsWhite) this.setImagePath(imagePathWhite);
        if (!pieceIsWhite) this.setImagePath(imagePathBlack);
        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);
    }
}
