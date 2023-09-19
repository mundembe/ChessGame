package ChessPieces;

import chessgame.Square;

public class Bishop extends Piece{
    public String imagePathWhite = "images\\bishop_white.png";
    public String imagePathBlack = "images\\bishop_black.png";

    public Bishop(String description, int xCoordinate, int yCoordinate){
        super(description);
        if (pieceIsWhite) this.setImagePath(imagePathWhite);
        if (!pieceIsWhite) this.setImagePath(imagePathBlack);
        this.setPieceType("Bishop");
        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);
    }

    @Override
    public void showPossibleMoves(Square[][] blocks    ){
        int index = 0;
        boolean exitLoop = false;
        int loopControl = 0;
        System.out.println("ActionProcessor called in Bishop.");

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

        int right_down = 1;
        boolean right_down_free = true;
        int right_up = 1;
        boolean right_up_free = true;
        int left_down = 1;
        boolean left_down_free = true;
        int left_up = 1;
        boolean left_up_free = true;

        while(!exitLoop){

            // Right Down Direction
            if (xCoordinate + right_down < 8 && right_down_free){
                if (yCoordinate + right_down < 8) {
                    if ( ! blocks[xCoordinate + right_down][yCoordinate + right_down].getTenant().contains(pieceColor)){
                        xPossibleMoves[index] = xCoordinate + right_down;
                        yPossibleMoves[index] = yCoordinate + right_down;
                        System.out.println("right down - still in here");
                    }else {
                        right_down_free = false;
                        System.out.println("right down blocked");
                    }
                }
                right_down++;
            }
            // Right Up
            if (xCoordinate + right_up < 8 && right_up_free){
                System.out.println("right Up Entered");
                if (yCoordinate - right_up >= 0) {
                    if ( ! blocks[xCoordinate + right_up][yCoordinate - right_up].getTenant().contains(pieceColor)){
                        xPossibleMoves[index] = xCoordinate + right_up;
                        yPossibleMoves[index] = yCoordinate - right_up;
                        System.out.println("right up - still in here");
                    }else {
                        right_up_free = false;
                        System.out.println("right up - blocked");
                    }
                }
                right_up++;
            }else {
                //TODO: remove
                System.out.println("right up denied");
            }
            // Left Down
            if (xCoordinate - left_down >= 0 && left_down_free){
                if (yCoordinate + left_down < 8) {
                    if ( ! blocks[xCoordinate - left_down][yCoordinate + left_down].getTenant().contains(pieceColor)){
                        xPossibleMoves[index] = xCoordinate - left_down;
                        yPossibleMoves[index] = yCoordinate + left_down;
                        System.out.println("left down - still in here");
                    }else {
                        left_down_free = false;
                        System.out.println("left down - blocked");
                    }
                }
                left_down++;
            }
            // Left up
            if (xCoordinate - left_up >= 0 && left_up_free){
                if (yCoordinate - left_up >= 0) {
                    if ( ! blocks[xCoordinate - left_up][yCoordinate - left_up].getTenant().contains(pieceColor)){
                        xPossibleMoves[index] = xCoordinate - left_up;
                        yPossibleMoves[index] = yCoordinate - left_up;
                        System.out.println("left up - still in here");
                    }else {
                        left_up_free = false;
                        System.out.println("left up - blocked");
                    }
                }
                left_up++;
            }

            loopControl++;
            if (loopControl > 16)
                exitLoop = true;
            index++;
        }
        System.out.println("exitted loop");

    }
}
