package recogerhamburguesasserveisprocesos;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Jaume
 */
public class MyTask extends JFrame{
    
    public static void main(String[] args)  throws InterruptedException { 
        MyTask myTask=new MyTask(new ArrayList <Client>(),new ArrayList <Chef>(),new Table(0,0),new Viewer(),new ControlPanel(),new AuxiliarImages());
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

    public MyTask( ArrayList<Client> clientList, ArrayList <Chef> chefList, Table table, Viewer viewer, ControlPanel cPanel, AuxiliarImages auxiliar) {
        this.setViewer(viewer);
        this.setcPanel(cPanel);
        this.addPanels();
        this.clientList=clientList;
        this.chefList=chefList;
        this.setTable(table);
        this.auxiliar=auxiliar;
        this.setSize(800,800);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public AuxiliarImages getAuxiliar() {
        return auxiliar;
    }
    
    public ArrayList<Chef> getChefList() {
        return chefList;
    }
    
    public ArrayList<Client> getClientList() {
        return clientList;
    }
    
    public Restaurant getRestaurant() {
        return restaurant;
    }
    
    public Table getTable() {
        return table;
    }
    
    public int getVelocity() {
        return velocity;
    }
    
    public boolean isPaused() {
        return paused;
    }
    
    public boolean isStopped() {
        return stopped;
    }
    
    public void setcPanel(ControlPanel cPanel) {
        cPanel.setMyTask(this);
        this.cPanel = cPanel;
    }
    
    public void setTable(Table table) {
        table.setMyTask(this);
        this.table = table;
    }
    
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void setViewer(Viewer viewer) {
        viewer.setMyTask(this);
        this.viewer = viewer;
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
    
    /**
     * Metodo que es para empezar la ejecucion de la app. Se le pasa el numero de chefs 
     * y el numero de clientes que queremos en la app, son instanciados i añadidos a sus
     * ArrayLists para luego empezar la ejecucion del thread de Viewer i luego empezar
     * la ejecucion de los thread de los chefs y los clientes. Tambien se instancia 
     * el restaurante dentro de este metodo.
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
        
        Thread t=new Thread(this.viewer);
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
    
    /**
     * Metodo que es llamado cuando se pausa el programa.
     */
    public void pausar(){
        this.paused=true;
    }
    
    /**
     * Metodo que es llamado cuanda se reanuda la ejecucion del programa despues
     * de una pausa.
     */
    public void reiniciar(){
        this.stopped=false;
        this.paused=false;
    }
    
    /**
     * Metodo que es llamado cuando se quiere terminar la ejecucion del programa.
     * No cierra el frame.
     */
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
    
    /**
     * metodo para pausar la ejecucion de otro metodo mientras el programa este en
     * pausa.
     */
    public void waitIfPaused(){
        while(this.isPaused()){
            Thread.onSpinWait();
        }
    }
}
