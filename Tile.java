import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Tile extends JLabel{
    
    private int value;
    private boolean blocked;
    
    public Tile(){
        this.value = Math.random() < 0.9 ? 2 : 4;
        paintTile();
    }
    
    public Tile(int value){
        this.value = value;
        paintTile();
    }
    
    public void setValue(int value){
        this.value = value;
        paintTile();
    }
    
    public int getValue(){
        return value;
    }
    
    public void block(boolean blocked){
        this.blocked = blocked;
    }
    
    public boolean isBlocked(){
        return blocked;
    }    
    private void paintTile(){
        if (value == 0)
            setText("");
        else
            setText("" + value);
        setHorizontalAlignment(SwingConstants.CENTER);
        setOpaque(true);
        setBackground(determineBackgroundColor(value));
        setForeground(determineForegroundColor(value));
        setFont(determineFont(value));
    }
	
    private Color determineBackgroundColor(int value){
	switch (value){
            case 0: return new Color(238, 228, 218, 89);
            case 2: return new Color(238, 228, 218);
            case 4: return new Color(237, 224, 200);
            case 8: return new Color(242, 177, 121);
            case 16: return new Color(245, 149, 99);
            case 32: return new Color(246, 124, 95);
            case 64: return new Color(246, 94, 59);
            case 128: return new Color(237, 207, 114);
            case 256: return new Color(237, 204, 97);
            case 512: return new Color(237, 200, 80);
            case 1024: return new Color(237, 197, 63);
            case 2048: return new Color(237, 194, 46);
            default: return new Color(60, 58, 50); 
	}
    }
    
    private Color determineForegroundColor(int value){
        switch (value){
            case 2: case 4: return new Color(119, 110, 101);
            default: return new Color(249, 246, 242);    
        }
    }
    
    private Font determineFont(int value){
        switch (value){
            case 2: case 4: case 8: case 16: case 32: case 64:  return new Font("Tahoma", Font.BOLD, 55);
            case 128: case 256: case 512: return new Font("Tahoma", Font.BOLD, 45);
            case 1024: case 2048: return new Font("Tahoma", Font.BOLD, 35);
            default: return new Font("Tahoma", Font.BOLD, 30);
        }
    }
    
    public boolean isAvailable(){
        return value == 0;
    }
    
    public boolean isFilled(){
        return value != 0;
    }
}
