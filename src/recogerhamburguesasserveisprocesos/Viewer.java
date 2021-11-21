package recogerhamburguesasserveisprocesos;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/**
 *
 * @author Jaume
 */
public class Viewer extends Canvas implements Runnable{
    
    private MyTask myTask;
    
    public Viewer() {
    }

    public void setMyTask(MyTask myTask) {
        this.myTask = myTask;
    }
    
    /**
     * Metodo encargado de pintar todos los elementos del programa. Recibe por 
     * parametro una ArrayList de chefs y otra de clientes para poder recorrerlas
     * y pintarlos en el canvas. El fondo siempre es el mismo. Los otros elementos
     * los situa dependiendo de la situacion de los chefs, de los clientes y de 
     * la matriz de Restaurant.
     * @param chefList ArrayList de la clase Chef con todos los chefs activos en el programa
     * @param clientList ArrayList de la clase Client con todos los clientes activos en el programa
     */
    public void pintar(ArrayList <Chef> chefList, ArrayList <Client> clientList){
        BufferStrategy bs;
        bs=this.getBufferStrategy();
        Graphics g=bs.getDrawGraphics();
        g.drawImage(myTask.getAuxiliar().getFondoRestaurante(), 0, 0,this.getWidth(),this.getHeight(), null);
        
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
        
        g.drawImage(this.myTask.getAuxiliar().getTable(), 131, 376, null);
        
        for (int i=12;i<14;i++){
            for (int j=5; j<this.myTask.getRestaurant().getBaldosas()[i].length-5;j++){
                if(this.myTask.getRestaurant().getBaldosas()[i][j]==6 || this.myTask.getRestaurant().getBaldosas()[i][j]==8){
                    if (i==12){
                        g.drawImage(myTask.getAuxiliar().getHamburguer(), 
                                myTask.getRestaurant().getXPixelPosition(j)+6, 
                                myTask.getRestaurant().getYPixelPosition(i)+5, null);
                    }
                    else {
                        g.drawImage(myTask.getAuxiliar().getHamburguer(), 
                                myTask.getRestaurant().getXPixelPosition(j)+6, 
                                myTask.getRestaurant().getYPixelPosition(i)-2, null);
                    }
                }
            }
        }
        
        for (int i=0;i<clientList.size();i++){
            g.drawImage(clientList.get(i).getImage(), clientList.get(i).getPosX(), clientList.get(i).getPosY(), null);
            if (clientList.get(i).isEating()){
                g.drawImage(clientList.get(i).getHamburguer(), clientList.get(i).getPosX()+5, clientList.get(i).getPosY()+62, null);
            }
        }
        
        g.dispose();
        bs.show(); 
    }
    
    @Override
    /**
     * Metodo que va llamando en bucle al metodo pintar. Implementado a traves de 
     * la interfaz runnable. Crea una buffered strategy i va llamando al metodo 
     * pintar mientras el boolean Stopped sea false i si el booleano paused es false.
     */
    public void run() {
        this.createBufferStrategy(3);
        while (!myTask.isStopped()){
            if (!myTask.isPaused()){
                this.pintar(myTask.getChefList(), myTask.getClientList());
            }
            else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        this.repaint();
    }
}
