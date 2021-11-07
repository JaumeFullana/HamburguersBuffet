/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recogerhamburguesasserveisprocesos;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author PC
 */
public class AuxiliarImages {
    
    private Image chef;
    private Image chefCooking;
    private Image chefWaiting;
    private Image client;
    private Image clientEating;
    private Image clientWaiting;
    private Image hamburguer;

    public AuxiliarImages(Image chef, Image chefCooking, Image chefWaiting, Image client, Image clientCooking, Image clientWaiting) {
        this.chef = chef;
        this.chefCooking = chefCooking;
        this.chefWaiting = chefWaiting;
        this.client = client;
        this.clientEating = clientCooking;
        this.clientWaiting = clientWaiting;
    }
    
    

    public AuxiliarImages() {
        this.chef = new ImageIcon(this.getClass().getResource("Images\\chef.jpg")).getImage();
        this.chefCooking = new ImageIcon(this.getClass().getResource("Images\\chefCocinando.jpg")).getImage();
        this.chefWaiting = new ImageIcon(this.getClass().getResource("Images\\chefEsperando.jpg")).getImage();
        this.client = new ImageIcon(this.getClass().getResource("Images\\client.jpg")).getImage();
        this.clientEating = new ImageIcon(this.getClass().getResource("Images\\clientComiendo.jpg")).getImage();
        this.clientWaiting = new ImageIcon(this.getClass().getResource("Images\\clientEsperando.jpg")).getImage();
        this.hamburguer=new ImageIcon(this.getClass().getResource("Images\\hamburguers.png")).getImage();
    }

    public Image getChef() {
        return chef;
    }

    public void setChef(Image chef) {
        this.chef = chef;
    }

    public Image getChefCooking() {
        return chefCooking;
    }

    public void setChefCooking(Image chefCooking) {
        this.chefCooking = chefCooking;
    }

    public Image getChefWaiting() {
        return chefWaiting;
    }

    public void setChefWaiting(Image chefWaiting) {
        this.chefWaiting = chefWaiting;
    }

    public Image getClient() {
        return client;
    }

    public void setClient(Image client) {
        this.client = client;
    }

    public Image getClientEating() {
        return clientEating;
    }

    public void setClientEating(Image clientEating) {
        this.clientEating = clientEating;
    }

    public Image getClientWaiting() {
        return clientWaiting;
    }

    public void setClientWaiting(Image clientWaiting) {
        this.clientWaiting = clientWaiting;
    }

    public Image getHamburguer() {
        return hamburguer;
    }

    public void setHamburguer(Image hamburguer) {
        this.hamburguer = hamburguer;
    }
    
    
}
