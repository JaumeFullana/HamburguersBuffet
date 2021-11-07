/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recogerhamburguesasserveisprocesos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    private Table table;
    private Viewer viewer;
    private ControlPanel cPanel;
    private AuxiliarImages auxiliar;
    protected static boolean terminar;

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
        this.table = table;
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        viewer.setParentFrame(this);
        this.viewer = viewer;
        //this.add(viewer);
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
        //GridBagConstraints c= new GridBagConstraints();
        //c.gridx=0;
        //this.add(cPanel,c);
        //c.gridx=1;
        //this.add(this.viewer);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=0;
        c.fill=GridBagConstraints.BOTH;
        c.weightx=0.1;
        c.weighty=1;
        this.add(this.cPanel,c);
        c.weightx=0.9;
        c.gridx=1;
        this.add(this.viewer,c);
    }
    /**
     * Metodo que da o actualiza los valores de hamburguesas maximas, numero de hamburguesas,
     * tiempo comiendo i tiempo cocinando. Es llamado al principio i puede ser llamado en cualquier momento
     * a traves de un boton. 
     */
    public void setValores(){
        this.getTable().setMaxHamburguers(Integer.parseInt(this.getcPanel().getMaxNumHamburgers().getText().trim()));
        this.getTable().setHamburguersNumber(Integer.parseInt(this.getcPanel().getNumHamburgers().getText().trim()));
        Client.setMinTimeEating(Integer.parseInt(this.getcPanel().getMinTimeEating().getText().trim()));
        Client.setMaxTimeEating(Integer.parseInt(this.getcPanel().getMaxTimeEating().getText().trim()));
        Chef.setMinTimeCooking(Integer.parseInt(this.getcPanel().getMinTimeCooking().getText().trim()));
        Chef.setMaxTimeCooking(Integer.parseInt(this.getcPanel().getMaxTimeCooking().getText().trim()));
    }
    
    public void reiniciar(){
        this.setViewer(new Viewer());
        this.addPanels();
        this.setClientList(new ArrayList <Client>());
        this.setChefList(new ArrayList <Chef>());
        this.setTable(new Table(0,0));
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
        MyTask.terminar=false;
        int numMayor=numClient;
        if (numChef>numClient){
            numMayor=numChef;
        }
        for (int i=0; i<numMayor;i++){
            if(i<numClient){
                this.getClientList().add(new Client(this.getTable(),this.getAuxiliar().getClient(),
                    getAuxiliar().getClientEating(), getAuxiliar().getClientWaiting()));
            }
            if (i<numChef){
                this.getChefList().add(new Chef(this.getTable(),getAuxiliar().getChef(),
                    getAuxiliar().getChefCooking(),getAuxiliar().getChefWaiting()));
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
