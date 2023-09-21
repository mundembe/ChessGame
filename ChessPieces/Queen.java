package ChessPieces;

import chessgame.Square;

public class Queen extends Piece {
    public String imagePathWhite = "images\\queen_white.png";
    public String imagePathBlack = "images\\queen_black.png";
    int index;

    public Queen(String description, int xCoordinate, int yCoordinate) {
        super(description);
        if (pieceIsWhite)
            this.setImagePath(imagePathWhite);
        if (!pieceIsWhite)
            this.setImagePath(imagePathBlack);
        this.pieceType = "queen";
        this.setXCoordinate(xCoordinate);
        this.setYCoordinate(yCoordinate);
    }

    @Override
    public void showPossibleMoves(Square[][] blocks) {
        index = bishopMoves(blocks);
        rookMoves(blocks);
    }

    public int bishopMoves(Square[][] blocks) {
        int index = 0;
        boolean exitLoop = false;
        int loopControl = 0;
        int counter = 1;
        boolean right_down_free = true;
        boolean right_up_free = true;
        boolean left_down_free = true;
        boolean left_up_free = true;

        while (!exitLoop) {

            // Right down Direction
            if (xCoordinate + counter < 8 && right_down_free) {
                if (yCoordinate + counter < 8) {
                    if (!blocks[xCoordinate + counter][yCoordinate + counter].getTenant().contains(pieceColor)) {
                        xPossibleMoves[index] = xCoordinate + counter;
                        yPossibleMoves[index] = yCoordinate + counter;
                        index++;
                        // Forcing diagonal to be blocked after an enemy is encountered
                        if (blocks[xCoordinate + counter][yCoordinate + counter].getTenant().contains(enemy))
                            right_down_free = false;
                    } else {
                        right_down_free = false;
                    }
                }
            }
            // Left down
            if (xCoordinate + counter < 8 && left_down_free) {
                if (yCoordinate - counter >= 0) {
                    if (!blocks[xCoordinate + counter][yCoordinate - counter].getTenant().contains(pieceColor)) {
                        xPossibleMoves[index] = xCoordinate + counter;
                        yPossibleMoves[index] = yCoordinate - counter;
                        index++;
                        // Forcing diagonal to be blocked after an enemy is encountered
                        if (blocks[xCoordinate + counter][yCoordinate - counter].getTenant().contains(enemy))
                            left_down_free = false;
                    } else {
                        left_down_free = false;
                    }
                }
            }
            // Right Up
            if (xCoordinate - counter >= 0 && right_up_free) {
                if (yCoordinate + counter < 8) {
                    if (!blocks[xCoordinate - counter][yCoordinate + counter].getTenant().contains(pieceColor)) {
                        xPossibleMoves[index] = xCoordinate - counter;
                        yPossibleMoves[index] = yCoordinate + counter;
                        index++;
                        if (blocks[xCoordinate - counter][yCoordinate + counter].getTenant().contains(enemy))
                            right_up_free = false;
                    } else {
                        right_up_free = false;
                    }
                }
            }
            // Left up
            if (xCoordinate - counter >= 0 && left_up_free) {
                if (yCoordinate - counter >= 0) {
                    if (!blocks[xCoordinate - counter][yCoordinate - counter].getTenant().contains(pieceColor)) {
                        xPossibleMoves[index] = xCoordinate - counter;
                        yPossibleMoves[index] = yCoordinate - counter;
                        index++;
                        if (blocks[xCoordinate - counter][yCoordinate - counter].getTenant().contains(enemy))
                            left_up_free = false;
                    } else {
                        left_up_free = false;
                    }
                }
            }

            counter++;
            loopControl++;
            if (loopControl > 16)
                exitLoop = true;

        }

        return index;

    }

    public void rookMoves(Square[][] blocks) {
        int counter = 1;
        int loopControl = 0;
        boolean exitloop = false;
        boolean south_free = true;
        boolean north_free = true;
        boolean east_free = true;
        boolean west_free = true;
        while (!exitloop) {

            // North
            if (xCoordinate - counter >= 0 && north_free) {
                if (!blocks[xCoordinate - counter][yCoordinate].getTenant().contains(pieceColor)) {
                    xPossibleMoves[index] = xCoordinate - counter;
                    yPossibleMoves[index] = yCoordinate;
                    index++;
                    if (blocks[xCoordinate - counter][yCoordinate].getTenant().contains(enemy))
                        north_free = false;
                } else {
                    north_free = false;
                }
            }

            // South
            if (xCoordinate + counter < 8 && south_free) {
                if (!blocks[xCoordinate + counter][yCoordinate].getTenant().contains(pieceColor)) {
                    xPossibleMoves[index] = xCoordinate + counter;
                    yPossibleMoves[index] = yCoordinate;
                    index++;
                    if (blocks[xCoordinate + counter][yCoordinate].getTenant().contains(enemy))
                        south_free = false;
                } else {
                    south_free = false;
                }
            }

            // East
            if (yCoordinate - counter >= 0 && east_free) {
                if (!blocks[xCoordinate][yCoordinate - counter].getTenant().contains(pieceColor)) {
                    xPossibleMoves[index] = xCoordinate;
                    yPossibleMoves[index] = yCoordinate - counter;
                    index++;
                    if (blocks[xCoordinate][yCoordinate - counter].getTenant().contains(enemy))
                        east_free = false;
                } else {
                    east_free = false;
                }
            }

            // West
            if (yCoordinate + counter < 8 && west_free) {
                if (!blocks[xCoordinate][yCoordinate + counter].getTenant().contains(pieceColor)) {
                    xPossibleMoves[index] = xCoordinate;
                    yPossibleMoves[index] = yCoordinate + counter;
                    index++;
                    if (blocks[xCoordinate][yCoordinate + counter].getTenant().contains(enemy))
                        west_free = false;
                } else {
                    west_free = false;
                }
            }

            counter++;
            loopControl++;
            if (loopControl > 16)
                exitloop = true;

        }
    }

}
