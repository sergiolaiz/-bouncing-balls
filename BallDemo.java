import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall> bolas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        bolas = new ArrayList<BouncingBall>();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        bolas = new ArrayList<BouncingBall>();
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        Random aleatorio = new Random();

        for (int cont = 0; cont < numBolas; cont ++){
            int diametroBola = aleatorio.nextInt(30) + 5;
            
            int posX = aleatorio.nextInt(300);
            int posY= aleatorio.nextInt(50);
            
            int red =  aleatorio.nextInt(256);
            int green =  aleatorio.nextInt(256);
            int blue =  aleatorio.nextInt(256);
            Color color = new Color(red,green,blue);

            BouncingBall ball = new BouncingBall(posX, posY, diametroBola, color, ground, myCanvas);
            ball.draw();
            bolas.add(ball);
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            //Recoremos el array de bolas con un bucle para ir moviendo cada bola.
            for(BouncingBall bolaTem : bolas){
                bolaTem.move();
                // stop once ball has travelled a certain distance on x axis
                if(bolaTem.getXPosition() >= 550 ) {
                    finished = true;
                }
            }
        }
    }
}
