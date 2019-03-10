
import java.awt.event.KeyAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class _2048 extends javax.swing.JFrame {
    
    public static long currentScore;
    private long bestScore;
    public static boolean gameWon;
    private boolean gameOver;
    private boolean formed2048;
    private KeyAdapter k = new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            formKeyPressed(evt);
        }
    };

    public _2048(){
        initComponents();
        addKeyListener(k);
        startGame();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainWindow = new javax.swing.JPanel();
        newGame = new javax.swing.JButton();
        gameTitle = new javax.swing.JLabel();
        objective = new javax.swing.JLabel();
        finishingObjective = new javax.swing.JLabel();
        currentScoreContainer = new javax.swing.JPanel();
        scoreText = new javax.swing.JLabel();
        currentScoreLabel = new javax.swing.JLabel();
        bestScoreContainer = new javax.swing.JPanel();
        bestText = new javax.swing.JLabel();
        bestScoreLabel = new javax.swing.JLabel();
        board = new Board();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("2048");
        setPreferredSize(new java.awt.Dimension(562, 782));

        mainWindow.setBackground(new java.awt.Color(250, 248, 219));
        mainWindow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newGame.setBackground(new java.awt.Color(143, 122, 102));
        newGame.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        newGame.setForeground(new java.awt.Color(249, 246, 242));
        newGame.setText("New Game");
        newGame.setFocusable(false);
        newGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newGameMouseClicked(evt);
            }
        });
        mainWindow.add(newGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 170, 100, 40));

        gameTitle.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        gameTitle.setForeground(new java.awt.Color(119, 110, 101));
        gameTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        gameTitle.setText("2048");
        mainWindow.add(gameTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 210, 120));

        objective.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        objective.setForeground(new java.awt.Color(119, 110, 101));
        objective.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        objective.setText("Join the numbers and get to the ");
        mainWindow.add(objective, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 181, 185, 14));

        finishingObjective.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        finishingObjective.setForeground(new java.awt.Color(119, 110, 101));
        finishingObjective.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        finishingObjective.setText("2048 tile!");
        mainWindow.add(finishingObjective, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 181, 185, 14));

        currentScoreContainer.setBackground(new java.awt.Color(187, 173, 160));
        currentScoreContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scoreText.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        scoreText.setForeground(new java.awt.Color(238, 228, 218));
        scoreText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreText.setText("SCORE");
        scoreText.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        currentScoreContainer.add(scoreText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 80, 14));

        currentScoreLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        currentScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        currentScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentScoreLabel.setText("" + currentScore);
        currentScoreContainer.add(currentScoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 100, 14));

        mainWindow.add(currentScoreContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 50, 100, 50));

        bestScoreContainer.setBackground(new java.awt.Color(187, 173, 160));
        bestScoreContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bestText.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bestText.setForeground(new java.awt.Color(238, 228, 218));
        bestText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bestText.setText("BEST");
        bestText.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bestScoreContainer.add(bestText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 80, 14));

        bestScoreLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bestScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        bestScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Scanner fileInput = null;
        File bestScoreFile = null;
        bestScoreFile = new File("best.txt");
        if (bestScoreFile.exists()){
            try{
                fileInput = new Scanner(bestScoreFile);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
            bestScore = fileInput.nextInt();
            fileInput.close();
        }
        else{
            try{
                bestScoreFile.createNewFile();
                FileWriter fw = new FileWriter(bestScoreFile);
                fw.write("" + 0);
                fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        bestScoreLabel.setText("" + bestScore);
        bestScoreContainer.add(bestScoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 46, 14));

        mainWindow.add(bestScoreContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 50, 100, 50));

        board.setBackground(new java.awt.Color(187, 173, 160));
        board.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        mainWindow.add(board, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 226, 464, 465));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWindow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWindow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newGameMouseClicked
        newGame();
        ((Board) board).redraw();
    }//GEN-LAST:event_newGameMouseClicked
 
    private void formKeyPressed(java.awt.event.KeyEvent evt) {                                
        boolean boardModified = false;
        switch (evt.getKeyCode()){
            case 37: boardModified = ((Board) board).moveLeft();
                break;
            case 38: boardModified = ((Board) board).moveUp();
                break;
            case 39: boardModified = ((Board) board).moveRight();
                break;
            case 40: boardModified = ((Board) board).moveDown();
                break;
        }
        if (boardModified){
            ((Board) board).generateNewTile();
            if (currentScore >= bestScore)
                updateBestScore(currentScore);
            if ((gameWon) && (!formed2048)){
                youWin();
                formed2048 = true;
            }
        }  
        else
            if ((((Board) board).isFilled()) && !(((Board) board).hasMergesAvailable())){
                if (!gameOver){
                    gameOver = true;
                    gameOver();
                }
            }
    }
    
    private void tryAgainMouseClicked(java.awt.event.MouseEvent evt){
        mainWindow.remove(0);
        addKeyListener(k);
        newGame();
        resetScore();
        ((Board) board).redraw();
    }
    
    private void keepGoingMouseClicked(java.awt.event.MouseEvent evt){
        mainWindow.remove(0);
        addKeyListener(k);
        ((Board) board).redraw();
    }
            
    private void startGame(){
        for (int i = 0 ; i < 2; i++)
            ((Board) board).generateNewTile();
    }
    
    private void newGame(){
        gameWon = formed2048 = gameOver = false;
        ((Board)(board)).clear();
        resetScore();
        startGame();
    }
    
    public void gameOver(){
        javax.swing.JPanel gameOverPanel = new javax.swing.JPanel();
        gameOverPanel.setBackground(new java.awt.Color(255, 255, 255, 64));
        gameOverPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        javax.swing.JButton tryAgain = new javax.swing.JButton("Try again");
        tryAgain.setBackground(new java.awt.Color(143, 122, 102));
        tryAgain.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tryAgain.setForeground(new java.awt.Color(249, 246, 242));
        tryAgain.setFocusable(false);
        tryAgain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tryAgainMouseClicked(evt);
            }
        });
        
        javax.swing.JLabel gameOverMessage = new javax.swing.JLabel("Game Over!");
        gameOverMessage.setFont(new java.awt.Font("Tahoma", 1, 40));
        gameOverMessage.setForeground(new java.awt.Color(119, 110, 101));
        gameOverMessage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        
        gameOverPanel.add(gameOverMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 60, 300, 300));
        gameOverPanel.add(tryAgain, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 235, 100, 40));
        
        mainWindow.add(gameOverPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 226, 464, 465), 0);
        
        removeKeyListener(k);
        
        ((Board) board).redraw();
    }
    
    public void youWin(){
        javax.swing.JPanel youWinPanel = new javax.swing.JPanel();
        youWinPanel.setBackground(new java.awt.Color(255, 255, 255, 64));
        youWinPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        javax.swing.JButton keepGoing = new javax.swing.JButton("Keep going");
        keepGoing.setBackground(new java.awt.Color(143, 122, 102));
        keepGoing.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        keepGoing.setForeground(new java.awt.Color(249, 246, 242));
        keepGoing.setFocusable(false);
        keepGoing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keepGoingMouseClicked(evt);
            }
        });
        
        javax.swing.JButton tryAgain = new javax.swing.JButton("Try again");
        tryAgain.setBackground(new java.awt.Color(143, 122, 102));
        tryAgain.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tryAgain.setForeground(new java.awt.Color(249, 246, 242));
        tryAgain.setFocusable(false);
        tryAgain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tryAgainMouseClicked(evt);
            }
        });
        
        javax.swing.JLabel youWinMessage = new javax.swing.JLabel("You win the game!");
        youWinMessage.setFont(new java.awt.Font("Tahoma", 1, 30));
        youWinMessage.setForeground(new java.awt.Color(119, 110, 101));
        youWinMessage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        
        youWinPanel.add(youWinMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 29, 300, 300));
        youWinPanel.add(keepGoing, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 207, 100, 40));
        youWinPanel.add(tryAgain, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 207, 100, 40));
        
        mainWindow.add(youWinPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 226, 464, 465), 0);
        
        removeKeyListener(k);
        
        ((Board) board).redraw();
    }
    
    public static void updateScore(long score){
        currentScore += score;
        currentScoreLabel.setText("" + currentScore);
    }
    
    private void resetScore(){
        currentScore = 0;
        currentScoreLabel.setText("" + 0);
    }
    
    private void updateBestScore(long score){
        bestScore = score;
        bestScoreLabel.setText("" + bestScore);
        File bestScoreFile;{
        bestScoreFile = new File("best.txt");}
        
        FileWriter fw = null;
        try {
            fw = new FileWriter(bestScoreFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.write("" + bestScore);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new _2048().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bestScoreContainer;
    private javax.swing.JLabel bestScoreLabel;
    private javax.swing.JLabel bestText;
    private javax.swing.JPanel board;
    private javax.swing.JPanel currentScoreContainer;
    private static javax.swing.JLabel currentScoreLabel;
    private javax.swing.JLabel finishingObjective;
    private javax.swing.JLabel gameTitle;
    private javax.swing.JPanel mainWindow;
    private javax.swing.JButton newGame;
    private javax.swing.JLabel objective;
    private javax.swing.JLabel scoreText;
    // End of variables declaration//GEN-END:variables
}
