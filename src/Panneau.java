import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel {

    private int posX = -10;
    private int posY = -20;


    public void paintComponent(Graphics g){

        //Vous verrez cette phrase chaque fois que la méthode sera invoquée
        System.out.println("Je suis exécutée !");
        int largeur = this.getWidth() - 20;
        int longueur = 50;
        g.drawRoundRect(posX,posY,largeur, longueur,10,10);

    }
}