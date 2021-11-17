/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recogerhamburguesasserveisprocesos;

/**
 *
 * @author Jaume
 */
public class Table{
    
    private MyTask myTask;
    private int hamburguersNumber;
    private int maxHamburguers;

    public Table() {
    }

    public Table(int hamburguersNumber, int maxHamburguers) {
        this.hamburguersNumber = hamburguersNumber;
        this.maxHamburguers = maxHamburguers;
    }

    public MyTask getMyTask() {
        return myTask;
    }

    public void setMyTask(MyTask myTask) {
        this.myTask = myTask;
    }
    
    public int getHamburguersNumber() {
        return hamburguersNumber;
    }

    public void setHamburguersNumber(int hamburguersNumber) {
        this.hamburguersNumber = hamburguersNumber;
    }

    public int getMaxHamburguers() {
        return maxHamburguers;
    }

    public void setMaxHamburguers(int maxHamburguers) {
        this.maxHamburguers = maxHamburguers;
    }

    /**
     * Metodo sincronizado en el que entran los thread Chef. Mientras la mesa tenga
     * el numero maximo de hamburguesas, pondremos los thread a esperar. Una vez haya 
     * menos hamburugesas que el numero maximo permitido, sumaremos una hamburguesa y
     * notificaremos a todos lo threads en espera.
     * @param numeroHamburgesas
     * @param chef
     * @throws InterruptedException 
     */
    public synchronized void placeMeal(int numeroHamburgesas, Chef chef) throws InterruptedException{
        while (this.getHamburguersNumber()>=this.getMaxHamburguers()){
            this.wait();
        }
        this.myTask.getRestaurant().addHamburguer(this.myTask.getRestaurant().getYBaldosaPosition(chef.getPosYHamburguesa()), 
                this.myTask.getRestaurant().getXBaldosaPosition(chef.getPosXHamburguesa()));
        this.hamburguersNumber+=numeroHamburgesas;
        this.notifyAll();
    }
    /**
     * Metodo sincronizado en el que entran los thread Client. Mientras la mesa no tenga 
     * hamburguesas pondremos los thread a esperar. Una vez haya, restaremos una hamburguesa y
     * notificaremos a todos lo threads en espera.
     * @param numeroHamburgesas
     * @param client
     * @throws InterruptedException 
     */
    public synchronized void takeMeal(int numeroHamburgesas, Client client) throws InterruptedException{
        while (this.getHamburguersNumber()==0){
            client.setImage(client.getBackClientStatic());
            this.wait();
        }
        this.myTask.getRestaurant().removeHamburguer(this.myTask.getRestaurant().getYBaldosaPosition(client.getPosYHamburguesa()), 
            this.myTask.getRestaurant().getXBaldosaPosition(client.getPosXHamburguesa()));
        this.hamburguersNumber-=numeroHamburgesas;
        this.notifyAll();
    }
    

    public synchronized void buscarEspacioHamburguesa(Chef chef) throws InterruptedException{
        int i=12;
        boolean sinEspacio=true;
        while (sinEspacio){
            int j=5;
            while (j<this.myTask.getRestaurant().getBaldosas()[i].length-5 && sinEspacio){
                if (this.myTask.getRestaurant().getBaldosas()[i][j]==5){
                    chef.setPosYHamburguesa(myTask.getRestaurant().getYPixelPosition(i));
                    chef.setPosXHamburguesa(myTask.getRestaurant().getXPixelPosition(j));
                    this.myTask.getRestaurant().getBaldosas()[i][j]=7;
                    sinEspacio=false;
                }
                j++;
            }
            i++;
            if (i>14){
                i=12;
                this.wait();
            }
        }
        this.notifyAll();
    }
    
    public synchronized void buscarHamburguesa(Client client) throws InterruptedException{
        int i=12;
        boolean sinHamburugesa=true;
        while (sinHamburugesa){
            int j=5;
            while (j<this.myTask.getRestaurant().getBaldosas()[i].length-5 && sinHamburugesa){
                if (this.myTask.getRestaurant().getBaldosas()[i][j]==6){
                    client.setPosYHamburguesa(myTask.getRestaurant().getYPixelPosition(i));
                    client.setPosXHamburguesa(myTask.getRestaurant().getXPixelPosition(j));
                    this.myTask.getRestaurant().getBaldosas()[i][j]=8;
                    sinHamburugesa=false;
                }
                j++;
            }
            i++;
            if (i>14){
                i=12;
                this.wait();
            }
        }
        this.notifyAll();
    }
}
