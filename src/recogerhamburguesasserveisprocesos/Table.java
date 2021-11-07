/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recogerhamburguesasserveisprocesos;

import javax.swing.ImageIcon;

/**
 *
 * @author Jaume
 */
public class Table{
    
    private int hamburguersNumber;
    private int maxHamburguers;

    public Table() {
    }

    public Table(int hamburguersNumber, int maxHamburguers) {
        this.hamburguersNumber = hamburguersNumber;
        this.maxHamburguers = maxHamburguers;
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
            chef.setImage(chef.getChefWaitingImage());
            //System.out.println(chef.getName()+" chef Esperando");
            this.wait();
        }
        //Thread.sleep(40);
        this.setHamburguersNumber(this.getHamburguersNumber()+numeroHamburgesas);
        //System.out.println("AVISO!!! Nuevas hamburguesas, chef "+chef.getName()+": "+this.getHamburguersNumber());
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
            client.setImage(client.getClientWaitingImage());
            //System.out.println(client.getName()+" cliente Esperando");
            this.wait();
        }
        //Thread.sleep(40);
        this.setHamburguersNumber(this.getHamburguersNumber()-numeroHamburgesas);
        //System.out.println(client.getName()+" Cliente coge, Hamburguesas restantes: "+this.getHamburguersNumber());
        this.notifyAll();
    }
    
}
