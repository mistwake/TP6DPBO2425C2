import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JPanel{
    int width = 360;
    int height = 640;

    private Logic logic;

    public View(Logic logic){
        this.logic = logic;
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.cyan);

        setFocusable(true);
        addKeyListener(logic);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        Player player = logic.getPlayer();
        if(player != null){
            g.drawImage(player.getImage(), player.getPosX(), player.getPosY(),
                    player.getWidth(), player.getHeight(), null);
        }

        ArrayList<Pipe> pipes = logic.getPipes();
        if(pipes != null){
            for (int i = 0; i < pipes.size(); i++){
                Pipe pipe = pipes.get(i);
                g.drawImage(pipe.getImage(), pipe.getPosX(), pipe.getPosY(),
                        pipe.getWidth(), pipe.getHeight(), null);
            }
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Score: " + logic.getScore(), 20, 40);

        if (logic.isGameOver()) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Font besar untuk teks utama
            Font gameOverFont = new Font("Arial Black", Font.BOLD, 40);
            g2.setFont(gameOverFont);
            FontMetrics fm = g2.getFontMetrics(gameOverFont);
            String gameOverText = "GAME OVER";
            int xGameOver = (width - fm.stringWidth(gameOverText)) / 2;
            int yGameOver = height / 2 - 30;

            // Bayangan hitam
            g2.setColor(new Color(0, 0, 0, 150));
            g2.drawString(gameOverText, xGameOver + 2, yGameOver + 2);

            // Warna utama merah
            g2.setColor(Color.RED);
            g2.drawString(gameOverText, xGameOver, yGameOver);

            // Font kecil untuk instruksi restart
            Font restartFont = new Font("Arial", Font.PLAIN, 20);
            g2.setFont(restartFont);
            fm = g2.getFontMetrics(restartFont);
            String restartText = "Tekan R untuk restart";
            int xRestart = (width - fm.stringWidth(restartText)) / 2;
            int yRestart = yGameOver + 40;

            g2.setColor(Color.WHITE);
            g2.drawString(restartText, xRestart, yRestart);
        }
    }
}
