
import javax.swing.JPanel;

public class Board extends JPanel{
    
    private final Tile[][] cells = new Tile[4][4];
    
    public Board(){
        fillBoard();
    }
    
    private void fillBoard(){        
        int x = 10;
        int y = 11;
        
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                cells[i][j] = new Tile(0);
                cells[i][j].setBounds(x, y, 103, 103);
                add(cells[i][j]);
                x += 113;
            }
            x = 10;
            y += 113;
        }
    }

    public void clear(){
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                cells[i][j].setValue(0);     
        redraw();
    }  
    
    private void unblockTiles(){
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                cells[i][j].block(false);
    }
        
    public void generateNewTile(){
        int x, y;
        do{
            x = generateTileSpot();
            y = generateTileSpot();
        } while (cells[x][y].isFilled());
        cells[x][y].setValue(Math.random() < 0.9 ? 2 : 4);
    }
   
    private int generateTileSpot(){
        return (int) (Math.random() * 4);
    }
    
    public boolean isFilled(){
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (cells[i][j].isAvailable())
                    return false;
        return true;
    }
    
    public boolean hasMergesAvailable(){
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++){
                if (j < 3)
                    if (cells[i][j].getValue() == cells[i][j + 1].getValue())
                        return true;  
                if (i < 3)
                    if (cells[i][j].getValue() == cells[i + 1][j].getValue())
                        return true;
            }
        return false;
    }
    
    public boolean moveLeft(){
        boolean boardModified = false;
        for (int i = 0; i < 4; i++){
            for (int j = 1; j < 4; j++){
                if (cells[i][j].isFilled()){
                    int t1Val = cells[i][j].getValue();
                    int previousPosition = j;
                    int x = j;
                    while ((x > 0) && (cells[i][x - 1].isAvailable()))
                        x--;
                    if (x == previousPosition)
                        if ((t1Val == cells[i][x - 1].getValue()) && (!cells[i][x - 1].isBlocked())){
                            cells[i][x].setValue(0);
                            cells[i][x - 1].setValue(mergeTiles(t1Val, cells[i][x - 1].getValue()));
                            cells[i][x - 1].block(true);
                            boardModified = true;
                        }
                    if (x != previousPosition){
                        cells[i][previousPosition].setValue(0);
                        if (x > 0){
                            int t2Val = cells[i][x - 1].getValue();
                            if ((t1Val == t2Val) && (!cells[i][x - 1].isBlocked())){
                                cells[i][x - 1].setValue(mergeTiles(t1Val, t2Val));
                                cells[i][x - 1].block(true);
                            }
                            else
                                cells[i][x].setValue(t1Val);   
                        }
                        else
                            cells[i][x].setValue(t1Val);
                        boardModified = true;
                    }
                }
            }
        }
        unblockTiles();
        redraw();
        return boardModified;
    }
    
    public boolean moveUp(){
        boolean boardModified = false;
        for (int i = 1; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (cells[i][j].isFilled()){
                    int t1Val = cells[i][j].getValue();
                    int previousPosition = i;
                    int y = i;
                    while ((y > 0) && (cells[y - 1][j].isAvailable()))
                        y--;
                    if (y == previousPosition)
                        if (t1Val == cells[y - 1][j].getValue() && (!cells[y - 1][j].isBlocked())){
                            cells[y][j].setValue(0);
                            cells[y - 1][j].setValue(mergeTiles(t1Val, cells[y - 1][j].getValue()));
                            cells[y - 1][j].block(true);
                            boardModified = true;
                        }
                    if (y != previousPosition){
                        cells[previousPosition][j].setValue(0);
                        if (y > 0){
                            int t2Val = cells[y - 1][j].getValue();
                            if ((t1Val == t2Val) && (!cells[y - 1][j].isBlocked())){
                                cells[y - 1][j].setValue(mergeTiles(t1Val, t2Val));
                                cells[y - 1][j].block(true);
                            }
                            else
                                cells[y][j].setValue(t1Val);    
                        }
                        else
                            cells[y][j].setValue(t1Val);
                        boardModified = true;
                    }                                             
                }
            }
        }
        unblockTiles();
        redraw();
        return boardModified;
    }
    
    public boolean moveRight(){
        boolean boardModified = false;
        for (int i = 0; i < 4; i++){
            for (int j = 2; j >= 0; j--){
                if (cells[i][j].isFilled()){
                    int t1Val = cells[i][j].getValue();
                    int previousPosition = j;
                    int x = j;
                    while ((x < 3) && (cells[i][x + 1].isAvailable()))
                        x++;
                    if (x == previousPosition)
                        if (t1Val == cells[i][x + 1].getValue() && (!cells[i][x + 1].isBlocked())){
                            cells[i][x].setValue(0);
                            cells[i][x + 1].setValue(mergeTiles(t1Val, cells[i][x + 1].getValue()));
                            cells[i][x + 1].block(true);
                            boardModified = true;
                        }
                    if (x != previousPosition){
                        cells[i][previousPosition].setValue(0);
                        if (x < 3){
                            int t2Val = cells[i][x + 1].getValue();
                            if ((t1Val == t2Val) && (!cells[i][x + 1].isBlocked())){
                                cells[i][x + 1].setValue(mergeTiles(t1Val, t2Val));
                                cells[i][x + 1].block(true);
                            }
                            else
                                cells[i][x].setValue(t1Val);     
                        }
                        else
                            cells[i][x].setValue(t1Val);
                        boardModified = true;
                    }
                }
            }
        }
        unblockTiles();
        redraw();
        return boardModified;
    }
    
    public boolean moveDown(){
        boolean boardModified = false;
        for (int i = 2; i >= 0; i--){
            for (int j = 0; j < 4; j++){
                if (cells[i][j].isFilled()){
                    int t1Val = cells[i][j].getValue();
                    int previousPosition = i;
                    int y = i;
                    while ((y < 3) && (cells[y + 1][j].isAvailable()))
                        y++;
                    if (y == previousPosition)
                        if (t1Val == cells[y + 1][j].getValue() && (!cells[y + 1][j].isBlocked())){
                            cells[y][j].setValue(0);
                            cells[y + 1][j].setValue(mergeTiles(t1Val, cells[y + 1][j].getValue()));
                            cells[y + 1][j].block(true);
                            boardModified = true;
                        }
                    if (y != previousPosition){
                        cells[previousPosition][j].setValue(0);
                        if (y < 3){
                            int t2Val = cells[y + 1][j].getValue();
                            if ((t1Val == t2Val) && (!cells[y + 1][j].isBlocked())){
                                cells[y + 1][j].setValue(mergeTiles(t1Val, t2Val));
                                cells[y + 1][j].block(true);
                            }
                            else
                                cells[y][j].setValue(t1Val);   
                        }
                        else
                            cells[y][j].setValue(t1Val);
                        boardModified = true;
                    }                                             
                }
            }
        }
        unblockTiles();
        redraw();
        return boardModified;
    }
           
    public int mergeTiles(int t1, int t2){
        long lastMoveScore = t1 + t2;
        _2048.updateScore(lastMoveScore);
        if (lastMoveScore == 2048)
            _2048.gameWon = true;
        return t1 + t2;
    }
    
    public void redraw(){
        revalidate();
        repaint();
    }
}
