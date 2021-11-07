/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recogerhamburguesasserveisprocesos;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Jaume
 */
public class Client extends Thread{
    
    private Table table;
    private Image image;
    private Image clientImage;
    private Image clientEatingImage;
    private Image clientWaitingImage;
    private int counter;
    private static int minTimeEating;
    private static int maxTimeEating;
    
    public Client(Table table, Image clientImage, Image clientEatingImage, Image clientWaitingImage) {
        this.table = table;
        this.image = clientImage;
        this.clientImage = clientImage;
        this.clientEatingImage = clientEatingImage;
        this.clientWaitingImage = clientWaitingImage;
        this.counter = 0;
    }
    
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
    
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getClientImage() {
        return clientImage;
    }

    public void setClientImage(Image clientImage) {
        this.clientImage = clientImage;
    }

    public Image getClientEatingImage() {
        return clientEatingImage;
    }

    public void setClientEatingImage(Image clientEatingImage) {
        this.clientEatingImage = clientEatingImage;
    }

    public Image getClientWaitingImage() {
        return clientWaitingImage;
    }

    public void setClientWaitingImage(Image clientWaitingImage) {
        this.clientWaitingImage = clientWaitingImage;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public static int getMaxTimeEating() {
        return maxTimeEating;
    }

    public static void setMaxTimeEating(int maxTimeEating) {
        Client.maxTimeEating = maxTimeEating;
    }

    public static int getMinTimeEating() {
        return minTimeEating;
    }

    public static void setMinTimeEating(int minTimeEating) {
        Client.minTimeEating = minTimeEating;
    }
    
    
    
    @Override
    public void run() {
        this.eat(1);
    }
    
    public void eat(int numberHamburguers) {
        Random r=new Random();
        while(!MyTask.terminar){
            try {
                this.getTable().takeMeal(numberHamburguers,this);
                this.counter++;
                this.setImage(this.getClientEatingImage());
                Thread.sleep(r.nextInt(Client.maxTimeEating-Client.minTimeEating)+Client.minTimeEating);
                this.setImage(this.getClientImage());
                //Thread.sleep(300);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
