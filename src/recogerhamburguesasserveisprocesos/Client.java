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
    
    private MyTask myTask;
    private Image image;
    private Image FrontClientStatic;
    private Image FrontClientMoving1;
    private Image FrontClientMoving2;
    private Image BackClientStatic;
    private Image BackClientMoving1;
    private Image BackClientMoving2;
    private Image LeftClientStatic;
    private Image LeftClientMoving1;
    private Image LeftClientMoving2;
    private Image RightClientStatic;
    private Image RightClientMoving1;
    private Image RightClientMoving2;
    private Image hamburguer;
    //arriba=1, izquierda=2, abajo=3, derecha=4
    private int direction;
    private int movingPicture;
    private int posXAsiento;
    private int posYAsiento;
    private int posY;
    private int posX;
    private int posYHamburguesa;
    private int posXHamburguesa;    
    private boolean eating;
    
    private static int minTimeEating;
    private static int maxTimeEating;
    
    public Client(MyTask myTask) {
        this.myTask = myTask;
        this.image = myTask.getAuxiliar().getFrontClientStatic();
        this.FrontClientStatic = myTask.getAuxiliar().getFrontClientStatic();
        this.FrontClientMoving1 = myTask.getAuxiliar().getFrontClientMoving1();
        this.FrontClientMoving2 = myTask.getAuxiliar().getFrontClientMoving2();
        this.BackClientStatic = myTask.getAuxiliar().getBackClientStatic();
        this.BackClientMoving1 = myTask.getAuxiliar().getBackClientMoving1();
        this.BackClientMoving2 = myTask.getAuxiliar().getBackClientMoving2();
        this.LeftClientStatic = myTask.getAuxiliar().getLeftClientStatic();
        this.LeftClientMoving1 = myTask.getAuxiliar().getLeftClientMoving1();
        this.LeftClientMoving2 = myTask.getAuxiliar().getLeftClientMoving2();
        this.RightClientStatic = myTask.getAuxiliar().getRightClientStatic();
        this.RightClientMoving1 = myTask.getAuxiliar().getRightClientMoving1();
        this.RightClientMoving2 = myTask.getAuxiliar().getRightClientMoving2();
        this.hamburguer=myTask.getAuxiliar().getHamburguer();
        this.direction=3;
        this.movingPicture=0;
        this.eating=false;
        this.addAsiento();
    }

    public Image getHamburguer() {
        return hamburguer;
    }

    public boolean isEating() {
        return eating;
    }

    public void setEating(boolean eating) {
        this.eating = eating;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getMovingPicture() {
        return movingPicture;
    }

    public void setMovingPicture(int movingPicture) {
        this.movingPicture = movingPicture;
    }

    public int getPosXAsiento() {
        return posXAsiento;
    }

    public void setPosXAsiento(int posXAsiento) {
        this.posXAsiento = posXAsiento;
    }

    public int getPosYAsiento() {
        return posYAsiento;
    }

    public void setPosYAsiento(int posYAsiento) {
        this.posYAsiento = posYAsiento;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosYHamburguesa() {
        return posYHamburguesa;
    }

    public void setPosYHamburguesa(int posYHamburguesa) {
        this.posYHamburguesa = posYHamburguesa;
    }

    public int getPosXHamburguesa() {
        return posXHamburguesa;
    }

    public void setPosXHamburguesa(int posXHamburguesa) {
        this.posXHamburguesa = posXHamburguesa;
    }
    
    public MyTask getMyTask() {
        return myTask;
    }

    public void setMyTask(MyTask myTask) {
        this.myTask = myTask;
    }
    
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getFrontClientStatic() {
        return FrontClientStatic;
    }

    public void setFrontClientStatic(Image FrontClientStatic) {
        this.FrontClientStatic = FrontClientStatic;
    }

    public Image getFrontClientMoving1() {
        return FrontClientMoving1;
    }

    public void setFrontClientMoving1(Image FrontClientMoving1) {
        this.FrontClientMoving1 = FrontClientMoving1;
    }

    public Image getFrontClientMoving2() {
        return FrontClientMoving2;
    }

    public void setFrontClientMoving2(Image FrontClientMoving2) {
        this.FrontClientMoving2 = FrontClientMoving2;
    }

    public Image getBackClientStatic() {
        return BackClientStatic;
    }

    public void setBackClientStatic(Image BackClientStatic) {
        this.BackClientStatic = BackClientStatic;
    }

    public Image getBackClientMoving1() {
        return BackClientMoving1;
    }

    public void setBackClientMoving1(Image BackClientMoving1) {
        this.BackClientMoving1 = BackClientMoving1;
    }

    public Image getBackClientMoving2() {
        return BackClientMoving2;
    }

    public void setBackClientMoving2(Image BackClientMoving2) {
        this.BackClientMoving2 = BackClientMoving2;
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
    
    
    public void addAsiento(){
        int i=0;
        boolean sinAsiento=true;
        while (i<myTask.getRestaurant().getBaldosas()[myTask.getRestaurant().getBaldosas().length-4].length && sinAsiento){
            if (myTask.getRestaurant().getBaldosas()[myTask.getRestaurant().getBaldosas().length-4][i]==9){
                myTask.getRestaurant().getBaldosas()[myTask.getRestaurant().getBaldosas().length-4][i]=10;
                this.posYAsiento=myTask.getRestaurant().getYPixelPosition(myTask.getRestaurant().getBaldosas().length-4);
                this.posXAsiento=myTask.getRestaurant().getXPixelPosition(i);
                this.posY=posYAsiento;
                this.posX=posXAsiento;
                sinAsiento=false;
                //System.out.println("Cliente pos asiento y:"+posYAsiento+", x:"+posXAsiento);
            }
            i++;
        }
    }
    
    public void moveChef(int direccion) throws InterruptedException{
        //arriba=1, izquierda=2, abajo=3, derecha=4
        if(direccion==1){
            this.setMovingPicture(1);
            this.image=this.BackClientMoving1;
            posY-=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(2);
            this.image=this.BackClientStatic;
            posY-=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(3);
            this.image=this.BackClientMoving2;
            posY-=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(0);
            this.image=this.BackClientStatic;
            posY-=7;
            Thread.sleep(myTask.getVelocity());
        } 
        else if (direccion==2){
            this.setMovingPicture(1);
            this.image=this.LeftClientMoving1;
            posX-=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(2);
            this.image=this.LeftClientStatic;
            posX-=7;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(3);
            this.image=this.LeftClientMoving2;
            posX-=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(0);
            this.image=this.LeftClientStatic;
            posX-=7;
            Thread.sleep(myTask.getVelocity());
        }
        else if(direccion==3){
            this.setMovingPicture(1);
            this.image=this.FrontClientMoving1;
            posY+=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(2);
            this.image=this.FrontClientStatic;
            posY+=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(3);
            this.image=this.FrontClientMoving2;
            posY+=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(0);
            this.image=this.FrontClientStatic;
            posY+=7;
            Thread.sleep(myTask.getVelocity());
        }
        else if(direccion==4){
            this.setMovingPicture(1);
            this.image=this.RightClientMoving1;
            posX+=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(2);
            this.image=this.RightClientStatic;
            posX+=7;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(3);
            this.image=this.RightClientMoving2;
            posX+=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(0);
            this.image=this.RightClientStatic;
            posX+=7;
            Thread.sleep(myTask.getVelocity());
        }
    }
    
    public void triarMoviment(boolean haciaLaMesa) throws InterruptedException{
        int diferenciaY=0;
        int diferenciaX=0;
        if (haciaLaMesa){
            diferenciaY=this.posY-(this.posYHamburguesa+31);
            if (diferenciaY<0){
                diferenciaY=-(diferenciaY);
            }

            diferenciaX=this.posX-this.posXHamburguesa;
            if (diferenciaX<0){
                diferenciaX=-(diferenciaX);
            }
            
            if (diferenciaY>diferenciaX){
                //arriba
                if (this.posY>this.posYHamburguesa+31){
                    this.moveChef(1); 
                }//abajo
                else {
                    this.moveChef(3);
                }
            } 
            else {
                //izquiera
                if (this.posX>this.posXHamburguesa){
                    this.moveChef(2); 
                }//derecha
                else {
                    this.moveChef(4);
                }
            }
        }
        else{
            diferenciaY=this.posY-this.posYAsiento;
            if (diferenciaY<0){
                diferenciaY=-(diferenciaY);
            }

            diferenciaX=this.posX-this.posXAsiento;
            if (diferenciaX<0){
                diferenciaX=-(diferenciaX);
            }
            
            if (diferenciaY>diferenciaX){
                //arriba
                if (this.posY>this.posYAsiento){
                    this.moveChef(1); 
                }//abajo
                else {
                    this.moveChef(3);
                }
            } 
            else {
                //izquiera
                if (this.posX>this.posXAsiento){
                    this.moveChef(2); 
                }//derecha
                else {
                    this.moveChef(4);
                }
            }
        }

    }
    
    @Override
    public void run() {
        while(!myTask.isStopped()){
            while(!myTask.isPaused()){
                this.eat(1);
            }
            Thread.onSpinWait();
        }
    }
    
    public void eat(int numberHamburguers) {
        Random r=new Random();
        try {
            this.myTask.getTable().buscarHamburguesa(this);
            myTask.waitIfPaused();
            while(this.posXHamburguesa!=this.posX || this.posYHamburguesa+31!=this.posY ){
                this.triarMoviment(true);
                myTask.waitIfPaused();
            }
            this.image=this.BackClientStatic;
            Thread.sleep(100);
            this.myTask.getTable().takeMeal(numberHamburguers,this);
            myTask.waitIfPaused();
            while(this.posXAsiento!=this.posX || this.posYAsiento!=this.posY ){
                this.triarMoviment(false);
                myTask.waitIfPaused();
            }
            this.eating=true;
            this.image=this.FrontClientStatic;
            int timeEating=r.nextInt(Client.maxTimeEating-Client.minTimeEating)+Client.minTimeEating;
            int tiempoEntreMordisco=(timeEating)/4;
            this.hamburguer=myTask.getAuxiliar().getHamburguer();
            myTask.waitIfPaused();
            Thread.sleep(tiempoEntreMordisco);
            this.hamburguer=myTask.getAuxiliar().getHamburguer1Bite();
            myTask.waitIfPaused();
            Thread.sleep(tiempoEntreMordisco);
            this.hamburguer=myTask.getAuxiliar().getHamburguer2Bite();
            myTask.waitIfPaused();
            Thread.sleep(tiempoEntreMordisco);
            this.hamburguer=myTask.getAuxiliar().getDish();
            myTask.waitIfPaused();
            Thread.sleep(tiempoEntreMordisco);
            myTask.getRestaurant().sumTimeEating(timeEating);
            myTask.getRestaurant().sumEatedHamburguer();
            myTask.waitIfPaused();
            this.eating=false;
            this.image=this.BackClientStatic;
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
