package recogerhamburguesasserveisprocesos;

/**
 *
 * @author Jaume
 */
public class Restaurant {
    

    //viewer 801x1022, cantidadBaldosas 26x34, tamaño baldosas 31x30
    private int [][] baldosas;
    private int eatedHamburguers;
    private int cookedHamburguers;
    private int totalTimeEating;
    private int totalTimeCooking;
    
    Restaurant(){
        this.initBaldosas();
        this.eatedHamburguers=0;
        this.cookedHamburguers=0;
        this.totalTimeEating=0;
        this.totalTimeCooking=0;
    }

    public int[][] getBaldosas() {
        return baldosas;
    }

    public int getCookedHamburguers() {
        return cookedHamburguers;
    }
    
    public int getEatedHamburguers() {
        return eatedHamburguers;
    }

    public int getTotalTimeCooking() {
        return totalTimeCooking;
    }
    
    public int getTotalTimeEating() {
        return totalTimeEating;
    }
    
    /**
     * Añade una hamburguesa (6) en una posicion de la matriz baldosas.
     * @param posY fila
     * @param posX columna
     */
    public void addHamburguer(int posY, int posX){
        this.baldosas[posY][posX]=6;
    }
    
    /**
     * Transfroma una posicion en pixeles en el axis x a la posicion de una baldosa
     * @param pixel numero de pixeles, que representa una posicion en el axis x
     * @return int posicion de la baldosa
     */
    public int getXBaldosaPosition(int pixel){
        return pixel/30;
    }
    
    /**
     * Transfroma la posicion de una baldosa en el axis x a la posicion en pixels
     * @param baldosa numero de la baldosa, que represnta su posicion en el axis x
     * @return int posicion en pixels
     */
    public int getXPixelPosition(int baldosa){
        return baldosa*30;
    }
    
    /**
     * Transfroma una posicion en pixeles en el axis y a la posicion de una baldosa
     * @param pixel numero de pixeles, que representa una posicion en el axis y
     * @return int posicion de la baldosa
     */
    public int getYBaldosaPosition(int pixel){
        return pixel/31;
    }
    
    /**
     * Transfroma la posicion de una baldosa en el axis y a la posicion en pixels
     * @param baldosa numero de la baldosa, que represnta su posicion en el axis y
     * @return int posicion en pixels
     */
    public int getYPixelPosition(int baldosa){
        return baldosa*31;
    }
    
    /**
     * Metodo que inizializa la matriz baldosas, una matriz de int en que cada posicion
     * representa una baldosa del canvas. Dentro de estas posiciones guardaremos numeros 
     * que representaran uno de los diferentes estados en los que se puede encontrar esa baldosa.
     * Espacio para caminar=0;
     * Espacio innaccesible=1;
     * Fogon desocupado=3;
     * Fogon ocupado=4;
     * Trozo de mesa sin hamburguesa=5;
     * Trozo de mesa con amburguesa=6;
     * Trozo de mesa reservado para colocar una hambuguesa=7;
     * Trozo de mesa con una hamburugesa reservada para ser cogida=8;
     * Asiento desocupado=9;
     * Asiento ocupado=10;
     */
    public void initBaldosas(){
        this.baldosas=new int[26][34];
        
        for(int i=0;i<2;i++){
            for (int j=0; j<this.baldosas[i].length-1;j++){
                if (i==1){
                    if (j==2 || j==3 || j==7 || j==8 || j==12 || j==13 || j==17 ||
                            j==18 || j==22 || j==23 || j==27 || j==28){
                        this.baldosas[i][j]=3;
                    } 
                    else {
                        this.baldosas[i][j]=1;
                    }
                } 
                else {
                    this.baldosas[i][j]=1;
                }
            }
        }
        
        for (int i=12;i<14;i++){
            for (int j=5; j<this.baldosas[i].length-5;j++){
                this.baldosas[i][j]=5;
            }
        }
        
        for(int i=this.baldosas.length-4;i<this.baldosas.length;i++){
            for (int j=0; j<this.baldosas[i].length;j++){
                if (i==this.baldosas.length-4){
                    if ((j>=0 && j<=9) || (j>=12 && j<=21) || (j>=24 && j<=33)){
                        this.baldosas[i][j]=9;
                    } 
                    else {
                        this.baldosas[i][j]=1;
                    }
                } 
                else {
                    this.baldosas[i][j]=1;
                }
            }
        }
    }
    
    /**
     * Quita una hamburguesa (5) en una posicion de la matriz baldosas.
     * @param posY fila
     * @param posX columna
     */
    public void removeHamburguer(int posY, int posX){
        this.baldosas[posY][posX]=5;
    }
    
    /**
     * Suma una hamburguesa a las hamburguesas totales cocinadas
     */
    public synchronized void sumCookedHamburguer(){
        this.cookedHamburguers++;
    }
    
    /**
     * Suma una hamburguesa a las hamburguesas totales comidas
     */
    public synchronized void sumEatedHamburguer(){
        this.eatedHamburguers++;
    }
    
    /**
     * Recibe por parametro el tiempo que ha tardado en cocinar un chef
     * y lo suma al tiempo total que se ha tardado en cocinar de los otros chefs
     * @param timeCooking int tiempo que ha tardado en cocinar un chef
     */
    public synchronized void sumTimeCooking(int timeCooking){
        this.totalTimeCooking+=timeCooking;
    }
    
    /**
     * Recibe por parametro el tiempo que ha tardado en comer un cliente
     * y lo suma al tiempo total que se ha tardado en comer de los otros clientes
     * @param timeEating int tiempo que ha tardado en comer un cliente
     */
    public synchronized void sumTimeEating(int timeEating){
        this.totalTimeEating+=timeEating;
    }
}
