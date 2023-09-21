package chessgame;

import java.awt.Color;

import javax.swing.JButton;

import ChessPieces.Piece;

public class Square extends JButton{

    String tenant = "empty";
    boolean readyForMove = false;
    Color blockColor = Color.red;


    public Square(){
        super();
        
    }

    
    public void setTenant(String tenant) { this.tenant = tenant; }
    public String getTenant() { return this.tenant; }
    public void setReadyForMove(boolean readyForMove) { this.readyForMove = readyForMove; }
    public boolean getReadyForMove() { return this.readyForMove; }
    public void setBlockColor(Color blockColor){ 

        this.setBackground(blockColor); 
        this.blockColor = blockColor;
    }
    public Color getBlockColor() { return this.blockColor; }

    public boolean place(Piece captor, boolean whitesMove){
        this.setTenant(captor.description);
        captor.add(this, captor.getImagePath());
        return whitesMove = !whitesMove;
        // TODO: if not working, separate return and assignment
    }
    

}