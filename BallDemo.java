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
     * @param numBolas = numero total de bolas que se desea tener
     */
    public void bounce(int numBolas)
    {
        int ground = 400;   // position of the ground line
        myCanvas.setVisible(true);
        //inicializamos array de bolas.
        bolas = new ArrayList<BouncingBall>();
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        //creamos objeto Random para obtener numeros aleatorios
        Random aleatorio = new Random();
        //hacemos un bucle creando tantas bolas como se ha pedido en el parametro.
        for (int cont = 0; cont < numBolas; cont ++){
            //numero aleatorio para el diametro de la bola
            int diametroBola = aleatorio.nextInt(30) + 5;
            //numeros aleatorios para la posicion en x e y;
            int posX = aleatorio.nextInt(300);
            int posY= aleatorio.nextInt(50);
            //numeros aleatorios para el color de las bolas
            int red =  aleatorio.nextInt(256);
            int green =  aleatorio.nextInt(256);
            int blue =  aleatorio.nextInt(256);
            Color color = new Color(red,green,blue);
            //cremamos las bolas y las pintamos.
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
