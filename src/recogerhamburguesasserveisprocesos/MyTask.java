/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recogerhamburguesasserveisprocesos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Jaume
 */
public class MyTask extends JFrame{
    
    public static void main(String[] args)  throws InterruptedException {
        
        MyTask myTask=new MyTask(new ArrayList <Client>(),new ArrayList <Chef>(),new Table(0,0),new Viewer(),new ControlPanel());
        myTask.setAuxiliar(new AuxiliarImages());
    }
    
    
    private ArrayList <Client> clientList;
    private ArrayList <Chef> chefList;
    private Restaurant restaurant;
    private Table table;
    private Viewer viewer;
    private ControlPanel cPanel;
    private AuxiliarImages auxiliar;
    private boolean stopped;
    private boolean paused;
    private int velocity;

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
    
    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }


    public MyTask( ArrayList<Client> clientList, ArrayList <Chef> chefList, Table table, Viewer view, ControlPanel cPanel) {
        this.setViewer(view);
        this.setcPanel(cPanel);
        this.addPanels();
        this.setClientList(clientList);
        this.setChefList(chefList);
        this.setTable(table);
        this.setSize(800,800);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    
    public AuxiliarImages getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(AuxiliarImages auxiliar) {
        this.auxiliar = auxiliar;
    }
    
    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public void setClientList(ArrayList<Client> clientList) {
        this.clientList = clientList;
    }

    public ArrayList<Chef> getChefList() {
        return chefList;
    }

    public void setChefList(ArrayList<Chef> chefList) {
        this.chefList = chefList;
    }
    
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        table.setMyTask(this);
        this.table = table;
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        viewer.setMyTask(this);
        this.viewer = viewer;
    }

    public ControlPanel getcPanel() {
        return cPanel;
    }

    public void setcPanel(ControlPanel cPanel) {
        cPanel.setMyTask(this);
        this.cPanel = cPanel;
    }
    
    /**
     * Metodo que pone al frame un GridBagLayout i añade el ControlPanel i el 
     * canvas Viewer.
     */
    public void addPanels(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=0;
        c.fill=GridBagConstraints.BOTH;
        c.weightx=0.084;
        c.weighty=1;
        c.insets=new Insets(0,0,0,0);
        this.add(this.cPanel,c);
        c.weightx=0.91;
        c.gridx=1;
        c.insets=new Insets(0,0,0,0);
        this.add(this.viewer,c);
    }
    
    public void reiniciar(){
        this.stopped=false;
        this.paused=false;
    }
    
    public void pausar(){
        this.paused=true;
    }
    
    public void terminar(){
        this.stopped=true;
        this.paused=true;
        for (int i=0;i<this.clientList.size();i++){
            this.clientList.get(i).interrupt();
        }       
        for (int i=0;i<this.chefList.size();i++){
            this.chefList.get(i).interrupt();
        }
    }
    
    public void waitIfPaused(){
        while(this.isPaused()){
            Thread.onSpinWait();
        }
    }
    
    /**
     * Metodo que es para empezar la ejecucion de la app. Se le pasa el numero de chefs 
     * y el numero de clientes que queremos en la app, son instanciados i añadidos a sus
     * ArrayLists para luego empezar la ejecucion del thread de Viewer i luego empezar
     * la ejecucion de los thread de los chefs y los clientes.
     * @param numChef int cantidad de chefs
     * @param numClient int cantidad de clientes
     */
    public void empezar(int numChef, int numClient){
        this.stopped=false;
        this.paused=false;
        this.clientList=new ArrayList <Client>();
        this.chefList=new ArrayList <Chef>();
        this.restaurant=new Restaurant();
        int numMayor=numClient;
        if (numChef>numClient){
            numMayor=numChef;
        }
        for (int i=0; i<numMayor;i++){
            if(i<numClient){
                this.getClientList().add(new Client(this));
            }
            if (i<numChef){
                this.getChefList().add(new Chef(this));
            }
        }
        
        Thread t=new Thread(this.getViewer());
        t.start();
     
        for (int i=0; i<numMayor;i++){
            if (i<numClient){
                this.getClientList().get(i).start();
            }
            if (i<numChef){
                this.getChefList().get(i).start();
            }
        }
    }
    
}
