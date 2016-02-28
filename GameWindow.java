import com.sun.java.swing.plaf.motif.MotifInternalFrameUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.GraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;





/**
 * Created by Admin on 2/27/2016.
 */
public class GameWindow extends Frame implements KeyListener,MouseListener,MouseMotionListener, Runnable{
    BufferedImage Background;
    BufferedImage PLANE1;
    BufferedImage PLANE2;
    int PlaneX, PlaneY;//khai bao bien toa do cua may bay
    int direction = 0;
    int move = 0;
    int PlaneX1, PlaneY1;

    public GameWindow(){
        this.setTitle("Game1945");
        this.setSize(400,640);
        this.setVisible(true);//de chay cua so window
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        try {
            Background = ImageIO.read(new File("Resouces/Background.png"));
            PLANE1 = ImageIO.read(new File("Resouces/PLANE1.png"));
            PLANE2 = ImageIO.read(new File("Resouces/PLANE2.png"));
        }
        catch(IOException e){

        }

        this.addKeyListener(this); //an phim de cac su kien hoat dong
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        repaint();//ve lai cua so
        PlaneX = 100;
        PlaneY = 200;
        PlaneX1 = 200;
        PlaneY1 = 200;

    }
    @Override
    public void paint(Graphics g){
        g.drawImage(Background,0,0,null);
//        g.drawLine(0,0,100,100);
        g.drawImage(PLANE1,PlaneX,PlaneY,null);
        g.drawImage(PLANE2,PlaneX1,PlaneY1,null);


    }

    //private void addMouseListener(GameWindow gameWindow) {
    //}
    @Override
    public void mouseMoved(MouseEvent me) {
        //PlaneX1=MouseInfo.getPointerInfo().getLocation().x;
        //PlaneY1=MouseInfo.getPointerInfo().getLocation().y;
    }

    public void mouseDragged(MouseEvent me) {
//        PlaneX1=MouseInfo.getPointerInfo().getLocation().x;
//        PlaneY1=MouseInfo.getPointerInfo().getLocation().y;
        PlaneX1 = me.getX();
        PlaneY1 = me.getY();
    }
    public void mouseClicked(MouseEvent m){

    }
    public void mousePressed(MouseEvent m){

    }
    public void mouseEntered(MouseEvent m){

    }
    public void mouseExited(MouseEvent m){

    }
    @Override
    public void mouseReleased(MouseEvent m){
        //System.out.println("(" + MouseInfo.getPointerInfo().getLocation().x +
          //      ", " +
            //    MouseInfo.getPointerInfo().getLocation().y + ")");
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Ban vua bam phim " +e.getKeyChar());//lay phim minh vua bam ra:e.getKeyChar()

    }

    @Override
    public void keyPressed(KeyEvent e) { //nhan xuong
        if(e.getKeyChar()=='w') {
            direction = 1;
//            PlaneY -= 10;
            repaint();
        }
        else if(e.getKeyChar()=='s') {
            direction = 2;
//            PlaneY -= 10;
            repaint();
        }
        else if(e.getKeyChar()=='d') {
            direction = 3;
//            PlaneY -= 10;
          repaint();
        }
        else if(e.getKeyChar()=='a') {
            direction = 4;
//            PlaneY -= 10;
            repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {//tha phim ra
        direction = 0;
    }


    @Override
    public void run() {


        while(true){

            if(direction == 0){

            }
            else if(direction==1){
                PlaneY -=2;
            }
            else if(direction==2){
                PlaneY +=2;
            }
            else if(direction==3){
                PlaneX +=5;

            }
            else if(direction==4){
                PlaneX -=5;
            }
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
