/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recogerhamburguesasserveisprocesos;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Viewer extends Canvas implements Runnable{
    
    private MyTask myTask;
    
    public Viewer() {
    }

    public MyTask getMyTask() {
        return myTask;
    }

    public void setMyTask(MyTask myTask) {
        this.myTask = myTask;
    }
    
    @Override
    public void run() {
        this.createBufferStrategy(3);
        while (!myTask.isStopped()){
            //while (!myTask.isPaused()){
                this.pintar(this.getMyTask().getChefList(), this.getMyTask().getClientList(), 
                    this.getMyTask().getTable().getHamburguersNumber());
            //}
            //necesari perque sino faig res, no funciona. Supos que es es garbage colector que sa carrega es thread.
            //Thread.onSpinWait();
        }
        this.repaint();
    }
    
    public void pintar(ArrayList <Chef> chefList, ArrayList <Client> clientList, int numHamburguers){
        BufferStrategy bs;
        bs=this.getBufferStrategy();
        Graphics g=bs.getDrawGraphics();
        g.drawImage(this.getMyTask().getAuxiliar().getFondoRestaurante(), 0, 0,this.getWidth(),this.getHeight(), null);
        for (int i=0;i<chefList.size();i++){
            if (chefList.get(i).isCooking()){
                if(i>5){
                    g.drawImage(this.myTask.getAuxiliar().getFogonEncendido(), chefList.get(i).getPosX()+2, chefList.get(i).getPosY()-8, null);
                } else {
                    g.drawImage(this.myTask.getAuxiliar().getFogonEncendido(), chefList.get(i).getPosX(), chefList.get(i).getPosY()-8, null);
                }
            }
            g.drawImage(chefList.get(i).getImage(), chefList.get(i).getPosX(), chefList.get(i).getPosY(), null);
        }
        for (int i=0;i<clientList.size();i++){
            g.drawImage(clientList.get(i).getImage(), clientList.get(i).getPosX(), clientList.get(i).getPosY(), null);
            if (clientList.get(i).isEating()){
                g.drawImage(clientList.get(i).getHamburguer(), clientList.get(i).getPosX()+5, clientList.get(i).getPosY()+62, null);
            }
        }
        for (int i=12;i<14;i++){
            for (int j=5; j<this.myTask.getRestaurant().getBaldosas()[i].length-5;j++){
                if(this.myTask.getRestaurant().getBaldosas()[i][j]==6 || this.myTask.getRestaurant().getBaldosas()[i][j]==8){
                    g.drawImage(this.getMyTask().getAuxiliar().getHamburguer(), 
                            this.getMyTask().getRestaurant().getXPixelPosition(j)+8, 
                            this.getMyTask().getRestaurant().getYPixelPosition(i)+3, null);
                }
            }
        }
        g.dispose();
        bs.show(); 
    }
}
