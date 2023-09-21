package ChessPieces;

import chessgame.Square;

public class Knight extends Piece{
    public String imagePathWhite = "images\\knight_white.png";
    public String imagePathBlack = "images\\knight_black.png";

    public Knight(String description, int xCoordinate, int yCoordinate){
        super(description);
        if (pieceIsWhite) this.setImagePath(imagePathWhite);
        if (!pieceIsWhite) this.setImagePath(imagePathBlack);
        this.pieceType = "knight";
        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);
    }

    @Override
    public void showPossibleMoves(Square[][] blocks){

        // Far Down
        if (xCoordinate + 2 < 8){
            if (yCoordinate + 1 < 8){
                xPossibleMoves[0] = xCoordinate + 2;
                yPossibleMoves[0] = yCoordinate + 1;
            }
            if (yCoordinate - 1 >= 0){
                xPossibleMoves[1] = xCoordinate + 2;
                yPossibleMoves[1] = yCoordinate - 1;
            }
        }
        // Far Up
        if (xCoordinate - 2 >= 0){
            if (yCoordinate + 1 < 8){
                xPossibleMoves[2] = xCoordinate - 2;
                yPossibleMoves[2] = yCoordinate + 1;
            }
            if (yCoordinate - 1 >= 0){
                xPossibleMoves[3] = xCoordinate - 2;
                yPossibleMoves[3] = yCoordinate - 1;
            }
        }
        // near Down
        if (xCoordinate + 1 < 8){
            if (yCoordinate + 2 < 8){
                xPossibleMoves[4] = xCoordinate + 1;
                yPossibleMoves[4] = yCoordinate + 2;
            }
            if (yCoordinate - 2 >= 0){
                xPossibleMoves[5] = xCoordinate + 1;
                yPossibleMoves[5] = yCoordinate - 2;
            }
        }
        // Near Up
        if (xCoordinate - 1 >= 0){
            if (yCoordinate + 2 < 8){
                xPossibleMoves[6] = xCoordinate - 1;
                yPossibleMoves[6] = yCoordinate + 2;
            }
            if (yCoordinate - 2 >= 0){
                xPossibleMoves[7] = xCoordinate - 1;
                yPossibleMoves[7] = yCoordinate - 2;
            }
        }


        // Handle Collisions
        for (int i = 0; i < xPossibleMoves.length; i++) {
            try {
                System.out.println("Block Color: " + blocks[xPossibleMoves[i]][yPossibleMoves[i]].getTenant());
                if (blocks[xPossibleMoves[i]][yPossibleMoves[i]].getTenant().contains(this.getPieceColor())) {
                    System.out.println("Piece Color: " + this.getPieceColor());
                    xPossibleMoves[i] = -1;
                    yPossibleMoves[i] = -1;
                }
            } catch(Exception e){
            }
        }
        
    }

}
