/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recogerhamburguesasserveisprocesos;

/**
 *
 * @author PC
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

    public void setBaldosas(int[][] baldosas) {
        this.baldosas = baldosas;
    }
    //baldosas tamaño, que contiene(a traves de int o string)
    //contenido baldosas/ estado: espacio para caminar=0, espacio innaccesible=1, , fogon desocupado=3, 
    //fogon ocupado=4, mesa sin hamburguesas=5, hamburguesa=6(cliente i chef alomejor mas adelante), reservado hamburguesa=7, 
    //hamburguesa reservado comer=8
    //asiento desocupado=9, asiento ocupado=10;
    //en cada cliente i chef guardar posicion asiento i fogon asignado(tendran siempre el mismo).
    //recorrer mesa i ver espacios libres para colocar hamburguesas i espacios con hamburguesas para cogerlos.
    //Estas variables tendran que estar dentro de cada chef i cada cliente
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
    
    public void addHamburguer(int posY, int posX){
        this.baldosas[posY][posX]=6;
    }
    
    public void removeHamburguer(int posY, int posX){
        this.baldosas[posY][posX]=5;
    }
    
    public int getXPixelPosition(int baldosa){
        return baldosa*30;
    }
    
    public int getYPixelPosition(int baldosa){
        return baldosa*31;
    }
    
    public int getXBaldosaPosition(int pixel){
        return pixel/30;
    }
    
    public int getYBaldosaPosition(int pixel){
        return pixel/31;
    }
    
    public int getEatedHamburguers() {
        return eatedHamburguers;
    }

    public int getCookedHamburguers() {
        return cookedHamburguers;
    }

    public int getTotalTimeEating() {
        return totalTimeEating;
    }

    public int getTotalTimeCooking() {
        return totalTimeCooking;
    }
    
    public synchronized void sumTimeEating(int timeEating){
        this.totalTimeEating+=timeEating;
    }
    
    public synchronized void sumTimeCooking(int timeCooking){
        this.totalTimeCooking+=timeCooking;
    }
    
    public synchronized void sumEatedHamburguer(){
        this.eatedHamburguers++;
    }
    
    public synchronized void sumCookedHamburguer(){
        this.cookedHamburguers++;
    }
}
