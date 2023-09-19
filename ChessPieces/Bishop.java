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

        int counter = 1;
        boolean right_down_free = true;
        boolean right_up_free = true;
        boolean left_down_free = true;
        boolean left_up_free = true;

        while(!exitLoop){

            // Right Up Direction
            if (xCoordinate + counter < 8 && right_down_free){
                if (yCoordinate + counter < 8) {
                    if ( ! blocks[xCoordinate + counter][yCoordinate + counter].getTenant().contains(pieceColor)){
                        xPossibleMoves[index] = xCoordinate + counter;
                        yPossibleMoves[index] = yCoordinate + counter;
                        System.out.println("right down (x+var) (y+var)");
                        System.out.println("i="+index + " x0="+xCoordinate + " y0="+yCoordinate +  " x="+xPossibleMoves[index] + " y="+yPossibleMoves[index] + " var="+counter);
                        index++;
                    }else {
                        right_down_free = false;
                    }
                }
            }
            // Left Up
            if (xCoordinate + counter < 8 && right_up_free){
                if (yCoordinate - counter >= 0) {
                    if ( ! blocks[xCoordinate + counter][yCoordinate - counter].getTenant().contains(pieceColor)){
                        xPossibleMoves[index] = xCoordinate + counter;
                        yPossibleMoves[index] = yCoordinate - counter;
                        System.out.println("right up (x+var) (y-var)");
                        System.out.println("i="+index + " x0="+xCoordinate + " y0="+yCoordinate +  " x="+xPossibleMoves[index] + " y="+yPossibleMoves[index] + " var="+counter);
                        index++;
                    }else {
                        right_up_free = false;
                    }
                }
            }
            // Left Down
            if (xCoordinate - counter >= 0 && left_down_free){
                if (yCoordinate + counter < 8) {
                    if ( ! blocks[xCoordinate - counter][yCoordinate + counter].getTenant().contains(pieceColor)){
                        xPossibleMoves[index] = xCoordinate - counter;
                        yPossibleMoves[index] = yCoordinate + counter;
                        System.out.println("left down (x-var) (y+var)");
                        System.out.println("i="+index + " x0="+xCoordinate + " y0="+yCoordinate +  " x="+xPossibleMoves[index] + " y="+yPossibleMoves[index] + " var="+counter);
                        index++;
                    }else {
                        left_down_free = false;
                    }
                }
            }
            // Left up
            if (xCoordinate - counter >= 0 && left_up_free){
                if (yCoordinate - counter >= 0) {
                    if ( ! blocks[xCoordinate - counter][yCoordinate - counter].getTenant().contains(pieceColor)){
                        xPossibleMoves[index] = xCoordinate - counter;
                        yPossibleMoves[index] = yCoordinate - counter;
                        System.out.println("left up (x-var) (y-var)");
                        System.out.println("i="+index + " x0="+xCoordinate + " y0="+yCoordinate +  " x="+xPossibleMoves[index] + " y="+yPossibleMoves[index] + " var="+counter);
                        index++;
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
