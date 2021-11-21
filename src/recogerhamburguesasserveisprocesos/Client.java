package recogerhamburguesasserveisprocesos;

import java.awt.Image;
import java.util.Random;

/**
 *
 * @author Jaume
 */
public class Client extends Thread{
    
    private MyTask myTask;
    private Image image;
    private Image frontClientStatic;
    private Image frontClientMoving1;
    private Image frontClientMoving2;
    private Image backClientStatic;
    private Image backClientMoving1;
    private Image backClientMoving2;
    private Image leftClientStatic;
    private Image leftClientMoving1;
    private Image leftClientMoving2;
    private Image rightClientStatic;
    private Image rightClientMoving1;
    private Image rightClientMoving2;
    private Image hamburguer;
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
        this.frontClientStatic = myTask.getAuxiliar().getFrontClientStatic();
        this.frontClientMoving1 = myTask.getAuxiliar().getFrontClientMoving1();
        this.frontClientMoving2 = myTask.getAuxiliar().getFrontClientMoving2();
        this.backClientStatic = myTask.getAuxiliar().getBackClientStatic();
        this.backClientMoving1 = myTask.getAuxiliar().getBackClientMoving1();
        this.backClientMoving2 = myTask.getAuxiliar().getBackClientMoving2();
        this.leftClientStatic = myTask.getAuxiliar().getLeftClientStatic();
        this.leftClientMoving1 = myTask.getAuxiliar().getLeftClientMoving1();
        this.leftClientMoving2 = myTask.getAuxiliar().getLeftClientMoving2();
        this.rightClientStatic = myTask.getAuxiliar().getRightClientStatic();
        this.rightClientMoving1 = myTask.getAuxiliar().getRightClientMoving1();
        this.rightClientMoving2 = myTask.getAuxiliar().getRightClientMoving2();
        this.hamburguer=myTask.getAuxiliar().getHamburguer();
        this.eating=false;
        this.addAsiento();
    }
    
    public Image getBackClientStatic() {
        return backClientStatic;
    }
    
    public Image getHamburguer() {
        return hamburguer;
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
    
    public boolean isEating() {
        return eating;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }
    
    public static void setMaxTimeEating(int maxTimeEating) {
        Client.maxTimeEating = maxTimeEating;
    }

    public static void setMinTimeEating(int minTimeEating) {
        Client.minTimeEating = minTimeEating;
    }

    public void setPosXHamburguesa(int posXHamburguesa) {
        this.posXHamburguesa = posXHamburguesa;
    }
    
    public void setPosYHamburguesa(int posYHamburguesa) {
        this.posYHamburguesa = posYHamburguesa;
    }
    
    /**
     * Recorre la matriz baldosas de la clase Restaurant para encontrar un asiento libre
     * y coger su posicion.
     */
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
            }
            i++;
        }
    }
    
    /**
     * Metodo que dependiendo de si el cliente va hacia la mesa o no, y de la diferencia 
     * de posiciones entre el cliente y la hamburguesa o el cliente y su asiento llamara al
     * metodo moveClient pasandole un parametro u otro.
     * @param haciaLaMesa booleano que dice si el cliente va hacia la mesa o no
     * @throws InterruptedException puede lanzar una excepcion debido al metodo moveClient()
     */
    public void chooseMovement(boolean haciaLaMesa) throws InterruptedException{
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
                    this.moveClient(1); 
                }//abajo
                else {
                    this.moveClient(3);
                }
            } 
            else {
                //izquiera
                if (this.posX>this.posXHamburguesa){
                    this.moveClient(2); 
                }//derecha
                else {
                    this.moveClient(4);
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
                    this.moveClient(1); 
                }//abajo
                else {
                    this.moveClient(3);
                }
            } 
            else {
                //izquiera
                if (this.posX>this.posXAsiento){
                    this.moveClient(2); 
                }//derecha
                else {
                    this.moveClient(4);
                }
            }
        }

    }
    
    /**
     * Metodo que es todo la logica del cliente. Mueve el cliente, hace que coja 
     * hamburguesas, lleva al cliente hasta su asiento y hace que se coma la 
     * hamburguesa. Se va llamando al metodo waitIfPaused() para que se pare la ejeccucion
     * del metodo en el caso de que la aplicacion este pausada.
     * @param numberHamburguers int numero de hamburguesas que coje el cliente en un viaje
     */
    public void eat(int numberHamburguers) {
        Random r=new Random();
        try {
            this.myTask.getTable().searchHamburger(this);
            myTask.waitIfPaused();
            while(this.posXHamburguesa!=this.posX || this.posYHamburguesa+31!=this.posY ){
                this.chooseMovement(true);
                myTask.waitIfPaused();
            }
            this.image=this.backClientStatic;
            Thread.sleep(100);
            this.myTask.getTable().takeMeal(numberHamburguers,this);
            myTask.waitIfPaused();
            while(this.posXAsiento!=this.posX || this.posYAsiento!=this.posY ){
                this.chooseMovement(false);
                myTask.waitIfPaused();
            }
            this.eating=true;
            this.image=this.frontClientStatic;
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
            this.image=this.backClientStatic;
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Mueve el cliente hacia la direccion que se le ha pasado por parametro asignando
     * valores nuevos a las variables posY y posX. Va asignando difernts imagenes a 
     * image para simular los pasos.
     * @param direccion int que representa la direccion en la que se mueve el cliente
     * @throws InterruptedException puede lanzar una excepcion devido al metodo sleep()
     */
    public void moveClient(int direccion) throws InterruptedException{
        //arriba=1, izquierda=2, abajo=3, derecha=4
        if(direccion==1){
            this.image=this.backClientMoving1;
            posY-=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.backClientStatic;
            posY-=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.backClientMoving2;
            posY-=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.backClientStatic;
            posY-=7;
            Thread.sleep(myTask.getVelocity());
        } 
        else if (direccion==2){
            this.image=this.leftClientMoving1;
            posX-=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.leftClientStatic;
            posX-=7;
            Thread.sleep(myTask.getVelocity());
            this.image=this.leftClientMoving2;
            posX-=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.leftClientStatic;
            posX-=7;
            Thread.sleep(myTask.getVelocity());
        }
        else if(direccion==3){
            this.image=this.frontClientMoving1;
            posY+=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.frontClientStatic;
            posY+=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.frontClientMoving2;
            posY+=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.frontClientStatic;
            posY+=7;
            Thread.sleep(myTask.getVelocity());
        }
        else if(direccion==4){
            this.image=this.rightClientMoving1;
            posX+=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.rightClientStatic;
            posX+=7;
            Thread.sleep(myTask.getVelocity());
            this.image=this.rightClientMoving2;
            posX+=8;
            Thread.sleep(myTask.getVelocity());
            this.image=this.rightClientStatic;
            posX+=7;
            Thread.sleep(myTask.getVelocity());
        }
    }
    
    @Override
    /**
     * Metodo que va llamando en bucle al metodo eat. Implementado a traves de 
     * la interfaz runnable. Tambioen va llamando al metodo sleep en cada iteracion del bucle.
     */
    public void run() {
        while(!myTask.isStopped()){
            if (!myTask.isPaused()){
                this.eat(1);
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
