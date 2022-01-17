package recogerhamburguesasserveisprocesos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author Jaume
 */
public class ControlPanel extends JPanel implements ActionListener, ChangeListener, Runnable{
    
    private MyTask myTask;
    
    private JLabel valoresNoActualizables;
    private JLabel valoresActualizables;
    private JLabel textNumMaxHamburgers;
    private JLabel textNumChefs;
    private JLabel textNumClients;
    private JLabel minTextTimeEating;
    private JLabel minTextTimeCooking;
    private JLabel maxTextTimeEating;
    private JLabel maxTextTimeCooking;
    private JLabel labelTimeEating;
    private JLabel labelTimeCooking;
    private JLabel labelVelocity;
    
    private JSlider sliderNumChefs;
    private JSlider sliderNumClients;
    private JSlider sliderMaxNumHamburgers;
    private JSlider sliderVelocity;
    
    private JSpinner minTimeEating;
    private JSpinner minTimeCooking;
    private JSpinner maxTimeEating;
    private JSpinner maxTimeCooking;
    
    private JButton empezar;
    private JButton pausar;
    private JButton terminar;
    
    private JTable table;

    public ControlPanel() {
        this.initComponents();
    }

    public void setMyTask(MyTask myTask) {
        this.myTask = myTask;
    }
    
    @Override
    /**
     * Metodo que es llamado cuando se aprieta uno de los botones de la aplicacion.
     * Puede hacer empezar, pausar o terminar la ejecucion del programa.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("TERMINAR")){
            myTask.terminar();
            this.textNumChefs.setEnabled(true);
            this.textNumClients.setEnabled(true);
            this.sliderNumChefs.setEnabled(true);
            this.sliderNumClients.setEnabled(true);
            this.terminar.setEnabled(true);
            this.pausar.setEnabled(true);
            this.empezar.setEnabled(true);
        } 
        else if (e.getActionCommand().equals("         PAUSAR         ")){
            myTask.pausar();
            this.terminar.setEnabled(true);
            this.pausar.setEnabled(false);
            this.empezar.setEnabled(true);
        }
        else if (e.getActionCommand().equals("EMPEZAR")){
            if (!myTask.isStopped() && myTask.isPaused()){
                this.myTask.reiniciar();
            } else {
                this.setInitialValues();
                this.myTask.empezar((int)this.sliderNumChefs.getValue(),(int)this.sliderNumClients.getValue());
                this.setTableValues();
                this.textNumChefs.setEnabled(false);
                this.textNumClients.setEnabled(false);
                this.sliderNumChefs.setEnabled(false);
                this.sliderNumClients.setEnabled(false);
                Thread t=new Thread(this);
                t.start();
            }
            this.terminar.setEnabled(true);
            this.pausar.setEnabled(true);
            this.empezar.setEnabled(false);
        }
    }
    
    /**
     * Instancia y añade los componentes al ControlPanel
     */
    public void initComponents(){
        this.setLayout(new GridBagLayout());
        
        this.valoresActualizables=new JLabel("VALORES ACTUALIZABLES");
        this.valoresActualizables.setFont(new Font("Tahoma",Font.BOLD,20));
        this.valoresNoActualizables=new JLabel("VALORES NO ACTUALIZABLES");
        this.valoresNoActualizables.setFont(new Font("Tahoma",Font.BOLD,20));
        
        this.textNumMaxHamburgers = new JLabel("MAXIMO HAMBURGUESAS:");
        this.labelVelocity = new JLabel("VELOCIDAD PERSONAS:");
        this.textNumChefs = new JLabel("CHEFS:");
        this.textNumClients = new JLabel("CLIENTES:");
        
        this.labelTimeCooking=new JLabel("TIEMPO COCINANDO");
        this.labelTimeCooking.setFont(new Font("Tahoma",Font.BOLD,16));
        this.labelTimeEating=new JLabel("TIEMPO COMIENDO");
        this.labelTimeEating.setFont(new Font("Tahoma",Font.BOLD,16));
        
        this.minTextTimeEating = new JLabel("MINIMO:");
        this.minTextTimeCooking = new JLabel("MINIMO:");
        this.maxTextTimeEating = new JLabel("MAXIMO:");
        this.maxTextTimeCooking = new JLabel("MAXIMO:");
        
        
        this.sliderNumChefs = new JSlider(0,12,6);
        this.sliderNumChefs.setMinorTickSpacing(1);
        this.sliderNumChefs.setMajorTickSpacing(2);
        this.sliderNumChefs.setPaintTicks(true);
        this.sliderNumChefs.setPaintLabels(true);
        this.sliderNumChefs.addChangeListener(this);
        
        this.sliderNumClients = new JSlider(0,30,15);
        this.sliderNumClients.setMinorTickSpacing(1);
        this.sliderNumClients.setMajorTickSpacing(5);
        this.sliderNumClients.setPaintTicks(true);
        this.sliderNumClients.setPaintLabels(true);
        this.sliderNumClients.addChangeListener(this);
        
        this.sliderMaxNumHamburgers = new JSlider(0,48,24);
        this.sliderMaxNumHamburgers.setMinorTickSpacing(1);
        this.sliderMaxNumHamburgers.setMajorTickSpacing(4);
        this.sliderMaxNumHamburgers.setPaintTicks(true);
        this.sliderMaxNumHamburgers.setPaintLabels(true);
        this.sliderMaxNumHamburgers.addChangeListener(this);
        
        this.sliderVelocity = new JSlider(10,200,100);
        this.sliderVelocity.setMinorTickSpacing(10);
        this.sliderVelocity.setMajorTickSpacing(20);
        this.sliderVelocity.setPaintTicks(true);
        this.sliderVelocity.setPaintLabels(true);
        this.sliderVelocity.addChangeListener(this);

        SpinnerModel modelMinTimeEating=new SpinnerNumberModel(6000,500,6000,500);
        SpinnerModel modelMaxTimeEating=new SpinnerNumberModel(15000,7000,30000,500);
        
        this.minTimeEating = new JSpinner(modelMinTimeEating);
        this.maxTimeEating = new JSpinner(modelMaxTimeEating);
        
        SpinnerModel modelMinTimeCooking=new SpinnerNumberModel(3000,500,6000,500);
        SpinnerModel modelMaxTimeCooking=new SpinnerNumberModel(8000,7000,30000,500);
        
        this.minTimeCooking = new JSpinner(modelMinTimeCooking);
        this.maxTimeCooking = new JSpinner(modelMaxTimeCooking);
        
        this.minTimeEating.addChangeListener(this);
        this.maxTimeEating.addChangeListener(this);
        this.minTimeCooking.addChangeListener(this);
        this.maxTimeCooking.addChangeListener(this);
        
        this.empezar=new JButton("EMPEZAR");
        this.pausar=new JButton("         PAUSAR         ");
        this.terminar=new JButton("TERMINAR");
        
        
        String [][] info=new String[4][2];
        info[0][0]="HAMBURGUESAS COCINADAS";
        info[0][1]="";
        info[1][0]="HAMBURGUESAS COMIDAS";
        info[1][1]="";
        info[2][0]="TIEMPO MEDIO COMIENDO";
        info[2][1]="";
        info[3][0]="TIEMPO MEDIO COCINANDO";
        info[3][1]="";

        String [] columnName={"CARACTERISTICA", "VALOR"};
        this.table=new JTable(info,columnName);
        
        this.empezar.addActionListener(this);
        this.pausar.addActionListener(this);
        this.terminar.addActionListener(this);

        GridBagConstraints c=new GridBagConstraints();
        c.weighty=0.2;
        c.insets=new Insets(30,0,10,0);
        c.anchor=GridBagConstraints.NORTHWEST;
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=3;
        this.add(this.valoresNoActualizables,c);
        c.insets=new Insets(0,10,10,0);
        c.gridwidth=1;
        c.gridx=0;
        c.gridy=1;
        c.fill=GridBagConstraints.BOTH;
        this.add(this.textNumChefs,c);
        c.gridx=1;
        c.gridy=1;
        c.gridwidth=3;
        this.add(this.sliderNumChefs,c);
        c.gridx=0;
        c.gridy=2;
        c.gridwidth=1;
        this.add(this.textNumClients,c);
        c.gridx=1;
        c.gridy=2;
        c.gridwidth=3;
        this.add(this.sliderNumClients,c);
        c.gridx=0;
        c.gridy=3;
        c.gridwidth=3;
        c.insets=new Insets(0,0,20,0);
        this.add(this.valoresActualizables,c);
        c.gridwidth=1;
        c.gridx=0;
        c.gridy=4;
        c.insets=new Insets(0,10,20,0);
        this.add(this.textNumMaxHamburgers,c);
        c.gridx=1;
        c.gridy=4;
        c.gridwidth=3;
        c.insets=new Insets(0,0,20,0);
        this.add(this.sliderMaxNumHamburgers,c);
        c.gridwidth=1;
        c.gridx=0;
        c.gridy=5;
        c.insets=new Insets(0,10,20,0);
        this.add(this.labelVelocity,c);
        c.gridx=1;
        c.gridy=5;
        c.gridwidth=3;
        c.insets=new Insets(0,0,20,0);
        this.add(this.sliderVelocity,c);
        c.gridx=0;
        c.gridy=6;
        c.gridwidth=3;
        this.add(this.labelTimeEating,c);
        c.gridwidth=1;
        c.gridx=0;
        c.gridy=7;
        c.fill=GridBagConstraints.NONE;
        c.anchor=GridBagConstraints.EAST;
        c.insets=new Insets(0,0,20,10);
        this.add(this.minTextTimeEating,c);
        c.gridx=1;
        c.gridy=7;
        c.anchor=GridBagConstraints.WEST;
        c.insets=new Insets(0,0,20,0);
        this.add(this.minTimeEating,c);
        c.gridx=2;
        c.gridy=7;
        c.anchor=GridBagConstraints.EAST;
        c.insets=new Insets(0,0,20,10);
        this.add(this.maxTextTimeEating,c);
        c.gridx=3;
        c.gridy=7;
        c.anchor=GridBagConstraints.WEST;
        c.insets=new Insets(0,0,20,0);
        this.add(this.maxTimeEating,c);
        c.gridx=0;
        c.gridy=8;
        c.gridwidth=3;
        this.add(this.labelTimeCooking,c);
        c.gridx=0;
        c.gridy=9;
        c.gridwidth=1;
        c.anchor=c.anchor=GridBagConstraints.EAST;
        c.insets=new Insets(0,0,20,10);
        this.add(this.minTextTimeCooking,c);
        c.gridx=1;
        c.gridy=9;
        c.anchor=c.anchor=GridBagConstraints.WEST;
        c.insets=new Insets(0,0,20,0);
        this.add(this.minTimeCooking,c);
        c.gridx=2;
        c.gridy=9;
        c.anchor=c.anchor=GridBagConstraints.EAST;
        c.insets=new Insets(0,0,20,10);
        this.add(this.maxTextTimeCooking,c);
        c.gridx=3;
        c.gridy=9;
        c.anchor=c.anchor=GridBagConstraints.WEST;
        c.insets=new Insets(0,0,20,0);
        this.add(this.maxTimeCooking,c);
        c.insets=new Insets(0,0,20,0);
        c.weighty=0.6;
        c.gridx=0;
        c.gridy=10;
        c.fill=GridBagConstraints.BOTH;
        c.anchor=GridBagConstraints.WEST;
        this.add(this.empezar,c);
        c.gridx=1;
        c.gridy=10;
        c.anchor=GridBagConstraints.CENTER;
        this.add(this.pausar,c);
        c.gridwidth=2;
        c.gridx=2;
        c.gridy=10;
        c.anchor=GridBagConstraints.EAST;
        this.add(this.terminar,c);
        c.weighty=0;
        c.insets=new Insets(10,0,0,0);
        c.gridx=0;
        c.gridy=11;
        c.gridwidth=4;
        c.fill=GridBagConstraints.BOTH;
        c.anchor=GridBagConstraints.SOUTH;
        this.add(this.table.getTableHeader(),c);
        c.insets=new Insets(0,0,30,0);
        c.gridx=0;
        c.gridy=12;
        c.gridwidth=4;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.anchor=GridBagConstraints.CENTER;
        this.add(this.table,c); 
    }
    
    @Override
    /**
     * Metodo que va llamando en bucle al metodo setTableValues. Implementado a traves de 
     * la interfaz runnable. Tiene una pequeña pausa en cada iteracion del bucle.
     */
    public void run() {
        while (true){
            try {
                Thread.sleep(330);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            this.setTableValues();
        }
    }
    
    /**
     * Coge todos los valores de los componenetes del control panel para asignarlos
     * a sus respectivas variables. 
     */
    public void setInitialValues(){
        this.myTask.setVelocity(210-(int)this.sliderVelocity.getValue());
        this.myTask.getTable().setMaxHamburguers((int)this.sliderMaxNumHamburgers.getValue());
        Client.setMinTimeEating((int)this.minTimeEating.getValue());
        Client.setMaxTimeEating((int)this.maxTimeEating.getValue());
        Chef.setMinTimeCooking((int)this.minTimeCooking.getValue());
        Chef.setMaxTimeCooking((int)this.maxTimeCooking.getValue());
    }
    
    /**
     * Añade sus respectivos valores a la tabla de estadisticas.
     */
    public void setTableValues(){
        String timeEating="0";
        String timeCooking="0";
        if(myTask.getRestaurant().getEatedHamburguers()!=0){
            timeEating=Integer.toString(myTask.getRestaurant().getTotalTimeEating()/myTask.getRestaurant().getEatedHamburguers());
        }
        if (myTask.getRestaurant().getCookedHamburguers()!=0){    
            timeCooking=Integer.toString(myTask.getRestaurant().getTotalTimeCooking()/myTask.getRestaurant().getCookedHamburguers());
        }
        this.table.setValueAt(Integer.toString(myTask.getRestaurant().getCookedHamburguers()), 0, 1);
        this.table.setValueAt(Integer.toString(myTask.getRestaurant().getEatedHamburguers()), 1, 1);
        this.table.setValueAt(timeEating, 2, 1);
        this.table.setValueAt(timeCooking, 3, 1);
    }

    @Override
    /**
     * Metodo que asigna los valores de unos sliders o de unos spinners a una variables
     * concretas.
     */
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() instanceof JSlider){
            JSlider slider=(JSlider)e.getSource();
            if(slider==this.sliderMaxNumHamburgers){
                if (!slider.getValueIsAdjusting()){
                    this.myTask.getTable().setMaxHamburguers((int)slider.getValue());
                    this.myTask.getTable().notifyMaxHamburguerChange();
                }
            } else if(slider==this.sliderVelocity){
                this.myTask.setVelocity(210-(int)slider.getValue());
            }
        } 
        else if (e.getSource() instanceof JSpinner){
            JSpinner spinner=(JSpinner)e.getSource();
            if (spinner==this.minTimeCooking){
                Chef.setMinTimeCooking((int)spinner.getValue());
            }
            else if (spinner==this.maxTimeCooking){
                Chef.setMaxTimeCooking((int)spinner.getValue());
            }
            else if (spinner==this.minTimeEating){
                Client.setMinTimeEating((int)spinner.getValue());
            }
            else if (spinner==this.maxTimeEating){
                Client.setMaxTimeEating((int)spinner.getValue());
            }
        }
    }
}
