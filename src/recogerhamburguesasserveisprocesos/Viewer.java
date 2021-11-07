/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recogerhamburguesasserveisprocesos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author PC
 */
public class Viewer extends Canvas implements Runnable{
    
    private MyTask parentFrame;
    
    public Viewer() {
        
    }

    public MyTask getParentFrame() {
        return parentFrame;
    }

    public void setParentFrame(MyTask parentFrame) {
        this.parentFrame = parentFrame;
    }
    
    @Override
    public void run() {
        while (true){
            this.pintar(this.getParentFrame().getChefList(), this.getParentFrame().getClientList(), 
                this.getParentFrame().getTable().getHamburguersNumber());
        }
    }
    
    public void pintar(ArrayList <Chef> chefList, ArrayList <Client> clientList, int numHamburguers){
        int anchura=this.getWidth();
        int altura=this.getHeight();
        int xChef=1;
        int yChef=1;
        int xClient=1;
        int yClient=altura-(altura/20)-1;
        int i=0;
        int counter=0;
        //this.repaint();
        Graphics g=this.getGraphics();
        g.setColor(Color.black);
        //Image imatgeClient=new ImageIcon(this.getClass().getResource("Images\\client.jpg")).getImage();
        //Image imatgeChef=new ImageIcon(this.getClass().getResource("Images\\chef.jpg")).getImage();
        Image imatgeHamburgueses=this.getParentFrame().getAuxiliar().getHamburguer();
        Font fPetita=new Font("Calibri",Font.BOLD,(int)((anchura+altura)/2)/30);
        while (counter<chefList.size()){
            while(i<20 && counter<chefList.size()){
                g.drawImage(chefList.get(counter).getImage(), xChef, yChef, (anchura/20)-2, (altura/20)-2, null);
                g.setFont(fPetita);
                g.drawString(""+chefList.get(counter).getCounter(), xChef, yChef+(altura/20));
                xChef=xChef+(anchura/20);
                i++;
                counter++;
            }
            i=0;
            xChef=1;
            yChef=yChef+(altura/20); 
        }
        counter=0;
        //g.clearRect((anchura/2)-20, (altura/2)+10, 40, 40);
        g.drawImage(imatgeHamburgueses, (anchura/2)-anchura/6, (altura/2)-altura/6, anchura/3, altura/3, null);
        //g.setColor(Color.white);
        //g.fillRect((anchura/2)-12, (altura/2)-13, 40, 20);
        //g.setColor(Color.black);
        Font f=new Font("Calibri",Font.BOLD,(int)((anchura+altura)/2)/20);
        g.setFont(f);
        g.drawString(""+numHamburguers, (anchura/2)-(int)anchura/40, (altura/2)+(int)anchura/80);
        while (counter<clientList.size()){
            while(i<20 && counter<clientList.size()){
                g.drawImage(clientList.get(counter).getImage(), xClient, yClient, (anchura/20)-2, (altura/20)-2, null);
                g.setFont(fPetita);
                g.drawString(""+clientList.get(counter).getCounter(), xClient, yClient+(altura/20));
                xClient=xClient+(anchura/20);
                i++;
                counter++;
            }
            i=0;
            xClient=1;
            yClient=yClient-(altura/20);
        }
        g.dispose();
    }
    
}
