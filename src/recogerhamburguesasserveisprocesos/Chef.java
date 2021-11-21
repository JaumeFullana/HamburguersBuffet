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
    private Image frontChefStatic;
    private Image frontChefMoving1;
    private Image frontChefMoving2;
    private Image backChefStatic;
    private Image backChefMoving1;
    private Image backChefMoving2;
    private Image leftChefStatic;
    private Image leftChefMoving1;
    private Image leftChefMoving2;
    private Image rightChefStatic;
    private Image rightChefMoving1;
    private Image rightChefMoving2;
    private static int minTimeCooking;
    private static int maxTimeCooking;
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
        this.frontChefStatic=myTask.getAuxiliar().getFrontChefStatic();
        this.frontChefMoving1=myTask.getAuxiliar().getFrontChefMoving1();
        this.frontChefMoving2=myTask.getAuxiliar().getFrontChefMoving2();
        this.backChefStatic=myTask.getAuxiliar().getBackChefStatic();
        this.backChefMoving1=myTask.getAuxiliar().getBackChefMoving1();
        this.backChefMoving2=myTask.getAuxiliar().getBackChefMoving2();
        this.leftChefStatic=myTask.getAuxiliar().getLeftChefStatic();
        this.leftChefMoving1=myTask.getAuxiliar().getLeftChefMoving1();
        this.leftChefMoving2=myTask.getAuxiliar().getLeftChefMoving2();
        this.rightChefStatic=myTask.getAuxiliar().getRightChefStatic();
        this.rightChefMoving1=myTask.getAuxiliar().getRightChefMoving1();
        this.rightChefMoving2=myTask.getAuxiliar().getRightChefMoving2();
        this.cooking=false;
        this.addFogon();
    }
    
    public Image getImage() {
        return image;
    }
    
    public int getPosX() {
        return posX;
    }
    
    public int getPosXHamburguesa() {
        return posXHamburguesa;
    }
    
    public int getPosY() {
        return posY;
    }
    
    public int getPosYHamburguesa() {
        return posYHamburguesa;
    }
    
    public boolean isCooking() {
        return cooking;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }
    
    public static void setMaxTimeCooking(int maxTimeCooking) {
        Chef.maxTimeCooking = maxTimeCooking;
    } 
        
    public static void setMinTimeCooking(int minTimeCooking) {
        Chef.minTimeCooking = minTimeCooking;
    }
    
    public void setPosXHamburguesa(int posXHamburguesa) {
        this.posXHamburguesa = posXHamburguesa;
    }
    
    public void setPosYHamburguesa(int posYHamburguesa) {
        this.posYHamburguesa = posYHamburguesa;
    }
    
    /**
     * Recorre la matriz baldosas de la clase Restaurant para encontrar un fogon libre
     * y coger su posicion.
     */
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
    
    /**
     * Metodo que dependiendo de si el chef va hacia la mesa o no, y de la diferencia 
     * de posiciones entre el chef y la posicion de la mesa donde tiene que poner la hamburguesa
     * o el chef y su fogon llamara al metodo moveChef pasandole un parametro u otro.
     * @param haciaLaMesa booleano que dice si el chef va hacia la mesa o no
     * @throws InterruptedException puede lanzar una excepcion debido al metodo moveChef()
     */
    public void chooseMovement(boolean haciaLaMesa) throws InterruptedException{
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
    
    /**
     * Metodo que es todo la logica del chef. Mueve el chef, hace que deje 
     * hamburguesas en la mesa, lleva al chef hasta su fogon y hace que cocine la 
     * hamburguesa. Se va llamando al metodo waitIfPaused() para que se pare la ejeccucion
     * del metodo en el caso de que la aplicacion este pausada.
     * @param numberHamburguers int numero de hamburguesas que lleva el chef en un viaje
     */
    public void cook(int numberHamburguers){
        Random r=new Random();
        try {
            cooking=true;
            this.image=this.backChefStatic;
            int timeCooking=r.nextInt(Chef.maxTimeCooking-Chef.minTimeCooking)+Chef.minTimeCooking;
            myTask.waitIfPaused();
            Thread.sleep(timeCooking);
            myTask.getRestaurant().sumTimeCooking(timeCooking);
            myTask.getRestaurant().sumCookedHamburguer();
            myTask.waitIfPaused();
            cooking=false;
            this.image=this.frontChefStatic;
                this.myTask.getTable().searchHamburgerSpace(this);
            myTask.waitIfPaused();
            while(this.posXHamburguesa!=this.posX || this.posYHamburguesa-62!=this.posY ){
                this.chooseMovement(true);
            myTask.waitIfPaused();
            }
            this.image=this.frontChefStatic;
            Thread.sleep(100);
            this.myTask.getTable().placeMeal(numberHamburguers,this);
            myTask.waitIfPaused();
            while(this.posXFogon!=this.posX || this.posYFogon!=this.posY ){
                this.chooseMovement(false);
                myTask.waitIfPaused();
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Mueve el chef hacia la direccion que se le ha pasado por parametro asignando
     * valores nuevos a las variables posY y posX. Va asignando difernts imagenes a 
     * image para simular los pasos.
     * @param direccion int que representa la direccion en la que se mueve el chef
     * @throws InterruptedException puede lanzar una excepcion devido al metodo sleep()
     */
    public void moveChef(int direccion) throws InterruptedException{
        //arriba=1, izquierda=2, abajo=3, derecha=4
        if(direccion==1){
            this.image=this.backChefMoving1;
            posY-=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.backChefStatic;
            posY-=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.backChefMoving2;
            posY-=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.backChefStatic;
            posY-=7;
            Thread.sleep(myTask.getVelocity());
        } 
        else if (direccion==2){
            this.image=this.leftChefMoving1;
            posX-=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.leftChefStatic;
            posX-=7;
            Thread.sleep(myTask.getVelocity());
            this.image=this.leftChefMoving2;
            posX-=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.leftChefStatic;
            posX-=7;
            Thread.sleep(myTask.getVelocity());
        }
        else if(direccion==3){
            this.image=this.frontChefMoving1;
            posY+=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.frontChefStatic;
            posY+=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.frontChefMoving2;
            posY+=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.frontChefStatic;
            posY+=7;
            Thread.sleep(myTask.getVelocity());
        }
        else if(direccion==4){
            this.image=this.rightChefMoving1;
            posX+=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.rightChefStatic;
            posX+=7;
            Thread.sleep(myTask.getVelocity());
            this.image=this.rightChefMoving2;
            posX+=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.rightChefStatic;
            posX+=7;
            Thread.sleep(myTask.getVelocity());
        }
    }
    
    @Override
    /**
     * Metodo que va llamando en bucle al metodo cook. Implementado a traves de 
     * la interfaz runnable. Tambien va llamando al metodo sleep en cada iteracion del bucle.
     */
    public void run() {
        while (!myTask.isStopped()){
            if (!myTask.isPaused()){
                this.cook(1);
            }
            else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}

