/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recogerhamburguesasserveisprocesos;

import java.awt.Image;
import java.util.Random;


/**
 *
 * @author Jaume
 */
public class Chef extends Thread{
    
    private MyTask myTask;
    private Image image;
    private Image FrontChefStatic;
    private Image FrontChefMoving1;
    private Image FrontChefMoving2;
    private Image BackChefStatic;
    private Image BackChefMoving1;
    private Image BackChefMoving2;
    private Image LeftChefStatic;
    private Image LeftChefMoving1;
    private Image LeftChefMoving2;
    private Image RightChefStatic;
    private Image RightChefMoving1;
    private Image RightChefMoving2;
    private int counter;
    private static int minTimeCooking;
    private static int maxTimeCooking;
    //arriba=1, izquierda=2, abajo=3, derecha=4
    private int direction;
    private int movingPicture;
    private int posXFogon;
    private int posYFogon;
    private int posY;
    private int posX;
    private int posYHamburguesa;
    private int posXHamburguesa;
    private boolean cooking;
    
    public Chef(MyTask myTask) {
        this.myTask = myTask;
        this.image = myTask.getAuxiliar().getBackChefStatic();
        this.FrontChefStatic=myTask.getAuxiliar().getFrontChefStatic();
        this.FrontChefMoving1=myTask.getAuxiliar().getFrontChefMoving1();
        this.FrontChefMoving2=myTask.getAuxiliar().getFrontChefMoving2();
        this.BackChefStatic=myTask.getAuxiliar().getBackChefStatic();
        this.BackChefMoving1=myTask.getAuxiliar().getBackChefMoving1();
        this.BackChefMoving2=myTask.getAuxiliar().getBackChefMoving2();
        this.LeftChefStatic=myTask.getAuxiliar().getLeftChefStatic();
        this.LeftChefMoving1=myTask.getAuxiliar().getLeftChefMoving1();
        this.LeftChefMoving2=myTask.getAuxiliar().getLeftChefMoving2();
        this.RightChefStatic=myTask.getAuxiliar().getRightChefStatic();
        this.RightChefMoving1=myTask.getAuxiliar().getRightChefMoving1();
        this.RightChefMoving2=myTask.getAuxiliar().getRightChefMoving2();
        this.direction=1;
        this.movingPicture=0;
        this.cooking=false;
        this.addFogon();
    }

    public boolean isCooking() {
        return cooking;
    }

    public void setCooking(boolean cooking) {
        this.cooking = cooking;
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

    public int getPosXFogon() {
        return posXFogon;
    }

    public void setPosXFogon(int posXFogon) {
        this.posXFogon = posXFogon;
    }

    public int getPosYFogon() {
        return posYFogon;
    }

    public void setPosYFogon(int posYFogon) {
        this.posYFogon = posYFogon;
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

    public Image getFrontChefStatic() {
        return FrontChefStatic;
    }

    public void setFrontChefStatic(Image FrontChefStatic) {
        this.FrontChefStatic = FrontChefStatic;
    }

    public Image getFrontChefMoving1() {
        return FrontChefMoving1;
    }

    public void setFrontChefMoving1(Image FrontChefMoving1) {
        this.FrontChefMoving1 = FrontChefMoving1;
    }

    public Image getFrontChefMoving2() {
        return FrontChefMoving2;
    }

    public void setFrontChefMoving2(Image FrontChefMoving2) {
        this.FrontChefMoving2 = FrontChefMoving2;
    }

    public Image getBackChefStatic() {
        return BackChefStatic;
    }

    public void setBackChefStatic(Image BackChefStatic) {
        this.BackChefStatic = BackChefStatic;
    }

    public Image getBackChefMoving1() {
        return BackChefMoving1;
    }

    public void setBackChefMoving1(Image BackChefMoving1) {
        this.BackChefMoving1 = BackChefMoving1;
    }

    public Image getBackChefMoving2() {
        return BackChefMoving2;
    }

    public void setBackChefMoving2(Image BackChefMoving2) {
        this.BackChefMoving2 = BackChefMoving2;
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
    
    public void addFogon(){
        int i=2;
        boolean sinFogon=true;
        while (i<myTask.getRestaurant().getBaldosas()[1].length && sinFogon){
            if (myTask.getRestaurant().getBaldosas()[1][i]==3){
                myTask.getRestaurant().getBaldosas()[1][i]=4;
                this.posYFogon=myTask.getRestaurant().getYPixelPosition(1);
                this.posXFogon=myTask.getRestaurant().getXPixelPosition(i);
                this.posY=posYFogon;
                this.posX=posXFogon;
                sinFogon=false;
            }
            i++;
        }
    }
    
    public void moveChef(int direccion) throws InterruptedException{
        //arriba=1, izquierda=2, abajo=3, derecha=4
        if(direccion==1){
            this.setMovingPicture(1);
            this.image=this.BackChefMoving1;
            posY-=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(2);
            this.image=this.BackChefStatic;
            posY-=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(3);
            this.image=this.BackChefMoving2;
            posY-=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(0);
            this.image=this.BackChefStatic;
            posY-=7;
            Thread.sleep(myTask.getVelocity());
        } 
        else if (direccion==2){
            this.setMovingPicture(1);
            this.image=this.LeftChefMoving1;
            posX-=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(2);
            this.image=this.LeftChefStatic;
            posX-=7;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(3);
            this.image=this.LeftChefMoving2;
            posX-=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(0);
            this.image=this.LeftChefStatic;
            posX-=7;
            Thread.sleep(myTask.getVelocity());
        }
        else if(direccion==3){
            this.setMovingPicture(1);
            this.image=this.FrontChefMoving1;
            posY+=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(2);
            this.image=this.FrontChefStatic;
            posY+=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(3);
            this.image=this.FrontChefMoving2;
            posY+=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(0);
            this.image=this.FrontChefStatic;
            posY+=7;
            Thread.sleep(100);
        }
        else if(direccion==4){
            this.setMovingPicture(1);
            this.image=this.RightChefMoving1;
            posX+=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(2);
            this.image=this.RightChefStatic;
            posX+=7;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(3);
            this.image=this.RightChefMoving2;
            posX+=8;
            Thread.sleep(myTask.getVelocity());
            this.setMovingPicture(0);
            this.image=this.RightChefStatic;
            posX+=7;
            Thread.sleep(myTask.getVelocity());
        }
    }
    
    
    
    public void triarMoviment(boolean haciaLaMesa) throws InterruptedException{
        int diferenciaY=0;
        int diferenciaX=0;
        if (haciaLaMesa){
            diferenciaY=this.posY-(this.posYHamburguesa-62);
            if (diferenciaY<0){
                diferenciaY=-(diferenciaY);
            }

            diferenciaX=this.posX-this.posXHamburguesa;
            if (diferenciaX<0){
                diferenciaX=-(diferenciaX);
            }
            
            if (diferenciaY>diferenciaX){
                //arriba
                if (this.posY>this.posYHamburguesa-62){
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
            diferenciaY=this.posY-this.posYFogon;
            if (diferenciaY<0){
                diferenciaY=-(diferenciaY);
            }

            diferenciaX=this.posX-this.posXFogon;
            if (diferenciaX<0){
                diferenciaX=-(diferenciaX);
            }
            
            if (diferenciaY>diferenciaX){
                //arriba
                if (this.posY>this.posYFogon){
                    this.moveChef(1); 
                }//abajo
                else {
                    this.moveChef(3);
                }
            } 
            else {
                //izquiera
                if (this.posX>this.posXFogon){
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
        while (!myTask.isStopped()){
            while(!myTask.isPaused()){
                this.cook(1);
            }
            Thread.onSpinWait();
        }
    }
    
    public void cook(int numberHamburguers){
        Random r=new Random();
        try {
            cooking=true;
            this.image=this.BackChefStatic;
            int timeCooking=r.nextInt(Chef.maxTimeCooking-Chef.minTimeCooking)+Chef.minTimeCooking;
            myTask.waitIfPaused();
            Thread.sleep(timeCooking);
            myTask.getRestaurant().sumTimeCooking(timeCooking);
            myTask.getRestaurant().sumCookedHamburguer();
            myTask.waitIfPaused();
            cooking=false;
            this.image=this.FrontChefStatic;
                this.myTask.getTable().buscarEspacioHamburguesa(this);
            myTask.waitIfPaused();
            while(this.posXHamburguesa!=this.posX || this.posYHamburguesa-62!=this.posY ){
                this.triarMoviment(true);
            myTask.waitIfPaused();
            }
            this.image=this.FrontChefStatic;
            Thread.sleep(100);
            this.myTask.getTable().placeMeal(numberHamburguers,this);
            myTask.waitIfPaused();
            while(this.posXFogon!=this.posX || this.posYFogon!=this.posY ){
                this.triarMoviment(false);
                myTask.waitIfPaused();
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

