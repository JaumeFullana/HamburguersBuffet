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

    public void setMaxHamburguers(int maxHamburguers) {
        this.maxHamburguers = maxHamburguers;
    }
    
    public void setMyTask(MyTask myTask) {
        this.myTask = myTask;
    }

    /**
     * Metodo sincronizado en el que entran los thread Chef. Mientras la mesa tenga
     * el numero maximo de hamburguesas, pondremos los thread a esperar. Una vez haya 
     * menos hamburugesas que el numero maximo permitido, sumaremos una hamburguesa y
     * notificaremos a todos lo threads en espera.
     * @param numeroHamburgesas numero de hamburguesas que añade el Chef
     * @param chef Chef que va a añadir las hamburguesas
     * @throws InterruptedException Puede lanzar una excepcion debido al metodo wait()
     */
    public synchronized void placeMeal(int numeroHamburgesas, Chef chef) throws InterruptedException{
        while (this.hamburguersNumber>=this.maxHamburguers){
            this.wait();
        }
        this.myTask.getRestaurant().addHamburguer(this.myTask.getRestaurant().getYBaldosaPosition(chef.getPosYHamburguesa()), 
                this.myTask.getRestaurant().getXBaldosaPosition(chef.getPosXHamburguesa()));
        this.hamburguersNumber+=numeroHamburgesas;
        this.notifyAll();
    }
    
    /**
     * Metodo sincronizado en el que entran los threads Cliente. Recorre la mesa en 
     * busca de una hamburguesa que no este reservada. Si la encuentra,
     * reserva esa hamburguesa para ir a cogerla, sino encuentra ninguna libre
     * espera a que algun chef traiga una.
     * @param client Cliente que busca una hamburguesa en la mesa
     * @throws InterruptedException Puede lanzar una excepcion debido al metodo wait()
     */
    public synchronized void searchHamburger(Client client) throws InterruptedException{
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
    
    /**
     * Metodo sincronizado en el que entran los threads chef. Recorre la mesa en 
     * busca de un sitio libre en el que añadir la hamburguesa. Si lo encuentra 
     * reserva ese sitio para ir a colocarla alli, sino encuentra ningun sitio libre
     * espera a que se vacie la mesa.
     * @param chef Chef que busca sitio en la mesa
     * @throws InterruptedException Puede lanzar una excepcion debido al metodo wait()
     */
    public synchronized void searchHamburgerSpace(Chef chef) throws InterruptedException{
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
    
    /**
     * Metodo sincronizado en el que entran los thread Client. Mientras la mesa no tenga 
     * hamburguesas pondremos los thread a esperar. Una vez haya, restaremos una hamburguesa y
     * notificaremos a todos lo threads en espera.
     * @param numeroHamburgesas numero de hamburguesas que coje el Cliente
     * @param client Cliente que va a coger las hamburguesas
     * @throws InterruptedException Puede lanzar una excepcion debido al metodo wait()
     */
    public synchronized void takeMeal(int numeroHamburgesas, Client client) throws InterruptedException{
        while (this.hamburguersNumber==0){
            client.setImage(client.getBackClientStatic());
            this.wait();
        }
        this.myTask.getRestaurant().removeHamburguer(this.myTask.getRestaurant().getYBaldosaPosition(client.getPosYHamburguesa()), 
            this.myTask.getRestaurant().getXBaldosaPosition(client.getPosXHamburguesa()));
        this.hamburguersNumber-=numeroHamburgesas;
        this.notifyAll();
    }
    
    /**
     * Notifica a todos los threads que esten esperando para que vuelvan a ejecutarse.
     * Se usa cuando se actualiza el numero maximo de hamburguesas.
     */
    public synchronized void notifyMaxHamburguerChange(){
        this.notifyAll();
    }
}
