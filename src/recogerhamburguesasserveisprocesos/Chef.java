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
public class Chef extends Thread{
    
    private Table table;
    private Image image;
    private Image chefImage;
    private Image chefCookingImage;
    private Image chefWaitingImage;
    private int counter;
    private static int minTimeCooking;
    private static int maxTimeCooking;
    
    public Chef(Table table, Image chefImage, Image chefCookingImage, Image chefWaitingImage) {
        this.table = table;
        this.image = chefImage;
        this.chefImage = chefImage;
        this.chefCookingImage = chefCookingImage;
        this.chefWaitingImage = chefWaitingImage;
        this.counter=0;
    }
    
    
    public Chef(Table table) {
        this.setTable(table);
        this.setImage(new ImageIcon(this.getClass().getResource("Images\\chef.jpg")).getImage());
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

    public Image getChefImage() {
        return chefImage;
    }

    public void setChefImage(Image chefImage) {
        this.chefImage = chefImage;
    }

    public Image getChefCookingImage() {
        return chefCookingImage;
    }

    public void setChefCookingImage(Image chefCookingImage) {
        this.chefCookingImage = chefCookingImage;
    }

    public Image getChefWaitingImage() {
        return chefWaitingImage;
    }

    public void setChefWaitingImage(Image chefWaitingImage) {
        this.chefWaitingImage = chefWaitingImage;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public static int getMinTimeCooking() {
        return minTimeCooking;
    }

    public static void setMinTimeCooking(int minTimeCooking) {
        Chef.minTimeCooking = minTimeCooking;
    }

    public static int getMaxTimeCooking() {
        return maxTimeCooking;
    }

    public static void setMaxTimeCooking(int maxTimeCooking) {
        Chef.maxTimeCooking = maxTimeCooking;
    }
    
    
    
    @Override
    public void run() {
        this.cook(1);
    }
    
    public void cook(int numberHamburguers){
        Random r=new Random();
        while (!MyTask.terminar){
            try {
                this.setImage(this.getChefCookingImage());
                Thread.sleep(r.nextInt(Chef.maxTimeCooking-Chef.minTimeCooking)+Chef.minTimeCooking);
                this.setImage(this.getChefImage());
                //Thread.sleep(100);
                this.getTable().placeMeal(numberHamburguers,this);
                this.counter++;
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    
}

