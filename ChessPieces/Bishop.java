package ChessPieces;

import chessgame.Square;

public class Bishop extends Piece{
    public String imagePathWhite = "images\\bishop_white.png";
    public String imagePathBlack = "images\\bishop_black.png";

    public Bishop(String description, int xCoordinate, int yCoordinate){
        super(description);
        if (pieceIsWhite) this.setImagePath(imagePathWhite);
        if (!pieceIsWhite) this.setImagePath(imagePathBlack);
        this.setPieceType("bishop");
        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);
    }

    @Override
    public void showPossibleMoves(Square[][] blocks    ){
        int index = 0;
        boolean exitLoop = false;
        int loopControl = 0;

        // for(int i = -7; i < 8; i++){
        //     if(xCoordinate + i >= 0 && xCoordinate + i < 8){
        //         // Descending right diagonal
        //         if(yCoordinate + i >= 0 && yCoordinate + i < 8){
        //             xPossibleMoves[index] = xCoordinate + i;
        //             yPossibleMoves[index] = yCoordinate + i;
        //             index++;
        //         }
        //         // Ascending diagonal
        //         if(yCoordinate - i >= 0 && yCoordinate - i < 8){
        //             xPossibleMoves[index] = xCoordinate + i;
        //             yPossibleMoves[index] = yCoordinate - i;
        //             index++;
        //         }
        //     }
        // }

        int counter = 1;
        boolean right_down_free = true;
        boolean right_up_free = true;
        boolean left_down_free = true;
        boolean left_up_free = true;

        while(!exitLoop){

            // Right down Direction
            if (xCoordinate + counter < 8 && right_down_free){
                if (yCoordinate + counter < 8) {
                    if ( ! blocks[xCoordinate + counter][yCoordinate + counter].getTenant().contains(pieceColor)){
                        xPossibleMoves[index] = xCoordinate + counter;
                        yPossibleMoves[index] = yCoordinate + counter;
                        index++;
                        // Forcing diagonal to be blocked after an enemy is encountered
                        if (blocks[xCoordinate + counter][yCoordinate + counter].getTenant().contains(enemy))
                            right_down_free = false;
                    }else {
                        right_down_free = false;
                    }
                }
            }
            // Left down
            if (xCoordinate + counter < 8 && left_down_free){
                if (yCoordinate - counter >= 0) {
                    if ( ! blocks[xCoordinate + counter][yCoordinate - counter].getTenant().contains(pieceColor)){
                        xPossibleMoves[index] = xCoordinate + counter;
                        yPossibleMoves[index] = yCoordinate - counter;
                        index++;
                        // Forcing diagonal to be blocked after an enemy is encountered
                        if (blocks[xCoordinate + counter][yCoordinate - counter].getTenant().contains(enemy))
                            left_down_free = false;
                    }else {
                        left_down_free = false;
                    }
                }
            }
            // Right Up
            if (xCoordinate - counter >= 0 && right_up_free){
                if (yCoordinate + counter < 8) {
                    if ( ! blocks[xCoordinate - counter][yCoordinate + counter].getTenant().contains(pieceColor)){
                        xPossibleMoves[index] = xCoordinate - counter;
                        yPossibleMoves[index] = yCoordinate + counter;
                        index++;
                        if (blocks[xCoordinate - counter][yCoordinate + counter].getTenant().contains(enemy))
                            right_up_free = false;
                    }else {
                        right_up_free = false;
                    }
                }
            }
            // Left up
            if (xCoordinate - counter >= 0 && left_up_free){
                if (yCoordinate - counter >= 0) {
                    if ( ! blocks[xCoordinate - counter][yCoordinate - counter].getTenant().contains(pieceColor)){
                        xPossibleMoves[index] = xCoordinate - counter;
                        yPossibleMoves[index] = yCoordinate - counter;
                        index++;
                        if (blocks[xCoordinate - counter][yCoordinate - counter].getTenant().contains(enemy))
                            left_up_free = false;
                    }else {
                        left_up_free = false;
                    }
                }
            }

            counter++;
            loopControl++;
            if (loopControl > 16)
                exitLoop = true;
            
        }

    }
}
