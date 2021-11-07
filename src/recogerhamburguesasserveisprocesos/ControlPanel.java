/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recogerhamburguesasserveisprocesos;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Jaume
 */
public class ControlPanel extends JPanel implements ActionListener{
    
    private MyTask myTask;
    
    private JLabel valoresNoActualizables;
    private JLabel valoresActualizables;
    private JLabel textNumHamburgers;
    private JLabel textNumMaxHamburgers;
    private JLabel textNumChefs;
    private JLabel textNumClients;
    private JLabel minTextTimeEating;
    private JLabel minTextTimeCooking;
    private JLabel maxTextTimeEating;
    private JLabel maxTextTimeCooking;
    
    private JTextField numHamburgers;
    private JTextField maxNumHamburgers;
    private JTextField numChefs;
    private JTextField numClients;
    private JTextField minTimeEating;
    private JTextField minTimeCooking;
    private JTextField maxTimeEating;
    private JTextField maxTimeCooking;
    
    private JButton empezar;
    private JButton actualizar;
    private JButton terminar;
    
    private JTable table;

    public ControlPanel() {
        this.initComponents();
    }
    
    /**
     * Instancia i añade los componentes al ControlPanel
     */
    public void initComponents(){
        this.setLayout(new GridBagLayout());
        
        this.valoresActualizables=new JLabel("VALORES ACTUALIZABLES");
        this.valoresActualizables.setFont(new Font("Tahoma",Font.BOLD,20));
        this.valoresNoActualizables=new JLabel("VALORES NO ACTUALIZABLES");
        this.valoresNoActualizables.setFont(new Font("Tahoma",Font.BOLD,20));
        
        this.textNumHamburgers = new JLabel("Numero Hamburguesas");
        this.textNumMaxHamburgers = new JLabel("Numero maximo Hamburguesas");
        this.textNumChefs = new JLabel("Numero de chefs");
        this.textNumClients = new JLabel("Numero de clientes");
        this.minTextTimeEating = new JLabel("Tiempo minimo que tardan los clientes en comer");
        this.minTextTimeCooking = new JLabel("Tiempo minimo que tardan los cocineros en cocinar");
        this.maxTextTimeEating = new JLabel("Tiempo maximo que tardan los clientes en comer");
        this.maxTextTimeCooking = new JLabel("Tiempo maximo que tardan los cocineros en cocinar");
        this.numHamburgers = new JTextField("          ");
        this.maxNumHamburgers = new JTextField("          ");
        this.numChefs = new JTextField("          ");
        this.numClients = new JTextField("          ");
        this.minTimeEating = new JTextField("          ");
        this.minTimeCooking = new JTextField("          ");
        this.maxTimeEating = new JTextField("          ");
        this.maxTimeCooking = new JTextField("          ");
        
        this.empezar=new JButton("EMPEZAR");
        this.actualizar=new JButton("ACTUALIZAR");
        this.terminar=new JButton("TERMINAR");
        
        
        String [][] info=new String[5][2];
        info[0][0]="Numero maximo Hamburguesas";
        info[0][1]="";
        info[1][0]="Tiempo minimo Comiendo";
        info[1][1]="";
        info[2][0]="Tiempo maximo Comiendo";
        info[2][1]="";
        info[3][0]="Tiempo minimo Cocinando";
        info[3][1]="";
        info[4][0]="Tiempo maximo Cocinando";
        info[4][1]="";

        String [] columnName={"CARACTERISTICA", "VALOR"};
        this.table=new JTable(info,columnName);
        
        this.empezar.addActionListener(this);
        this.actualizar.addActionListener(this);
        this.terminar.addActionListener(this);

        GridBagConstraints c=new GridBagConstraints();
        c.insets=new Insets(0,0,20,0);
        c.anchor=GridBagConstraints.NORTHWEST;
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=4;
        this.add(this.valoresNoActualizables,c);
        c.insets=new Insets(0,0,10,0);
        c.gridwidth=1;
        c.gridx=1;
        c.gridy=1;
        this.add(this.textNumChefs,c);
        c.gridx=2;
        c.gridy=1;
        this.add(this.numChefs,c);
        c.gridx=1;
        c.gridy=2;
        this.add(this.textNumClients,c);
        c.gridx=2;
        c.gridy=2;
        this.add(this.numClients,c);
        c.gridx=0;
        c.gridy=3;
        c.gridwidth=4;
        c.insets=new Insets(0,0,20,0);
        this.add(this.valoresActualizables,c);
        c.gridwidth=1;
        c.gridx=1;
        c.gridy=4;
        c.insets=new Insets(0,0,10,0);
        this.add(this.textNumHamburgers,c);
        c.gridx=2;
        c.gridy=4;
        this.add(this.numHamburgers,c);
        c.gridx=1;
        c.gridy=5;
        this.add(this.textNumMaxHamburgers,c);
        c.gridx=2;
        c.gridy=5;
        this.add(this.maxNumHamburgers,c);
        c.gridx=1;
        c.gridy=6;
        this.add(this.minTextTimeEating,c);
        c.gridx=2;
        c.gridy=6;
        this.add(this.minTimeEating,c);
        c.gridx=1;
        c.gridy=7;
        this.add(this.maxTextTimeEating,c);
        c.gridx=2;
        c.gridy=7;
        this.add(this.maxTimeEating,c);
        c.gridx=1;
        c.gridy=8;
        this.add(this.minTextTimeCooking,c);
        c.gridx=2;
        c.gridy=8;
        this.add(this.minTimeCooking,c);
        c.gridx=1;
        c.gridy=9;
        this.add(this.maxTextTimeCooking,c);
        c.gridx=2;
        c.gridy=9;
        this.add(this.maxTimeCooking,c);
        c.gridx=1;
        c.gridy=10;
        c.insets=new Insets(0,0,40,0);
        this.add(new JPanel(),c);
        c.gridx=0;
        c.gridy=11;
        c.anchor=GridBagConstraints.WEST;
        this.add(this.empezar,c);
        c.gridx=1;
        c.gridy=11;
        c.anchor=GridBagConstraints.CENTER;
        this.add(this.actualizar,c);
        c.gridx=2;
        c.gridy=11;
        c.anchor=GridBagConstraints.EAST;
        this.add(this.terminar,c);
        c.insets=new Insets(0,0,0,0);
        c.gridx=0;
        c.gridy=12;
        c.gridwidth=4;
        c.fill=GridBagConstraints.BOTH;
        c.anchor=GridBagConstraints.SOUTH;
        this.add(this.table.getTableHeader(),c);
        c.gridx=0;
        c.gridy=13;
        c.gridwidth=4;
        c.fill=GridBagConstraints.BOTH;
        c.anchor=GridBagConstraints.CENTER;
        this.add(this.table,c);
        
    }
    
    /**
     * LLama a al metodo setValores() y al metodo empezar si el boton apretado es 
     * el de empezar. Si ha sido el de empezar tambien desactiva los textfield
     * de numChefs i numClients i el boton de empezar.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("TERMINAR")){
            MyTask.terminar=true;
            this.numChefs.setEnabled(true);
            this.numClients.setEnabled(true);
            this.empezar.setEnabled(true);
        } else{
            if (MyTask.terminar && e.getActionCommand().equals("EMPEZAR")){
                    this.getMyTask().reiniciar();
                }
            this.getMyTask().setValores();
            this.setTableValues();
            this.resetValues();
            if (e.getActionCommand().equals("EMPEZAR")){
                this.getMyTask().empezar(Integer.parseInt(this.numChefs.getText().trim()), 
                    Integer.parseInt(this.numClients.getText().trim()));
                this.numChefs.setEnabled(false);
                this.numClients.setEnabled(false);
                this.empezar.setEnabled(false);
            }
        }
    }
    
    public void creteTable(){
        
    }

    public MyTask getMyTask() {
        return myTask;
    }

    public void setMyTask(MyTask myTask) {
        this.myTask = myTask;
    }

    public JTextField getNumHamburgers() {
        return numHamburgers;
    }

    public void setNumHamburgers(JTextField numHamburgers) {
        this.numHamburgers = numHamburgers;
    }

    public JTextField getMaxNumHamburgers() {
        return maxNumHamburgers;
    }

    public void setMaxNumHamburgers(JTextField maxNumHamburgers) {
        this.maxNumHamburgers = maxNumHamburgers;
    }

    public JTextField getNumChefs() {
        return numChefs;
    }

    public void setNumChefs(JTextField numChefs) {
        this.numChefs = numChefs;
    }

    public JTextField getNumClients() {
        return numClients;
    }

    public void setNumClients(JTextField numClients) {
        this.numClients = numClients;
    }

    public JTextField getMinTimeCooking() {
        return minTimeCooking;
    }

    public void setMinTimeCooking(JTextField minTimeCooking) {
        this.minTimeCooking = minTimeCooking;
    }

    public JTextField getMinTimeEating() {
        return minTimeEating;
    }

    public void setMinTimeEating(JTextField minTimeEating) {
        this.minTimeEating = minTimeEating;
    }

    public JTextField getMaxTimeEating() {
        return maxTimeEating;
    }

    public void setMaxTimeEating(JTextField maxTimeEating) {
        this.maxTimeEating = maxTimeEating;
    }

    public JTextField getMaxTimeCooking() {
        return maxTimeCooking;
    }

    public void setMaxTimeCooking(JTextField maxTimeCooking) {
        this.maxTimeCooking = maxTimeCooking;
    }
    
    public void setTableValues(){
        this.table.setValueAt(this.maxNumHamburgers.getText().trim(), 0, 1);
        this.table.setValueAt(this.minTimeEating.getText().trim(), 1, 1);
        this.table.setValueAt(this.maxTimeEating.getText().trim(), 2, 1);
        this.table.setValueAt(this.minTimeCooking.getText().trim(), 3, 1);
        this.table.setValueAt(this.maxTimeCooking.getText().trim(), 4, 1);
        /*
        String [][] info=new String[5][2];
        info[0][0]="Numero maximo Hamburguesas";
        info[0][1]="";
        info[1][0]="Tiempo minimo Comiendo";
        info[1][1]="";
        info[2][0]="Tiempo maximo Comiendo";
        info[2][1]="";
        info[3][0]="Tiempo minimo Cocinando";
        info[3][1]="";
        info[4][0]="Tiempo maximo Cocinando";
        info[4][1]="";
        */
    }
    
    public void resetValues(){
        this.numHamburgers.setText("");
        this.maxNumHamburgers.setText("");
        this.minTimeEating.setText("");
        this.maxTimeEating.setText("");
        this.minTimeCooking.setText("");
        this.maxTimeCooking.setText("");
    }
}
