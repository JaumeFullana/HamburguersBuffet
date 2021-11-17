/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recogerhamburguesasserveisprocesos;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Jaume
 */
public class AuxiliarImages {
    
    private Image FrontChefStatic;
    private Image FrontChefMoving1;
    private Image FrontChefMoving2;
    private Image BackChefStatic;
    private Image BackChefMoving1;
    private Image BackChefMoving2;
    private Image LeftChefStatic;
    private Image LeftChefMoving1;
    private Image LeftChefMoving2;
    private Image RightChefStatic;
    private Image RightChefMoving1;
    private Image RightChefMoving2;
    
    private Image FrontClientStatic;
    private Image FrontClientMoving1;
    private Image FrontClientMoving2;
    private Image BackClientStatic;
    private Image BackClientMoving1;
    private Image BackClientMoving2;
    private Image LeftClientStatic;
    private Image LeftClientMoving1;
    private Image LeftClientMoving2;
    private Image RightClientStatic;
    private Image RightClientMoving1;
    private Image RightClientMoving2;
    
    private Image hamburguer;
    private Image hamburguer1Bite;
    private Image hamburguer2Bite;
    private Image dish;
    private Image fogonEncendido;
    private Image fondoRestaurante;


    

    public AuxiliarImages() {
        
        this.fondoRestaurante=new ImageIcon(this.getClass().getResource("Images\\Fondo.png")).getImage();
        
        this.FrontChefStatic=new ImageIcon(this.getClass().getResource("Images\\FrontChefStatic.png")).getImage();
        this.FrontChefMoving1=new ImageIcon(this.getClass().getResource("Images\\FrontChefMoving1.png")).getImage();
        this.FrontChefMoving2=new ImageIcon(this.getClass().getResource("Images\\FrontChefMoving2.png")).getImage();
        this.BackChefStatic=new ImageIcon(this.getClass().getResource("Images\\BackChefStatic.png")).getImage();
        this.BackChefMoving1=new ImageIcon(this.getClass().getResource("Images\\BackChefMoving1.png")).getImage();
        this.BackChefMoving2=new ImageIcon(this.getClass().getResource("Images\\BackChefMoving2.png")).getImage();
        this.LeftChefStatic=new ImageIcon(this.getClass().getResource("Images\\LeftChefStatic.png")).getImage();
        this.LeftChefMoving1=new ImageIcon(this.getClass().getResource("Images\\LeftChefMoving1.png")).getImage();
        this.LeftChefMoving2=new ImageIcon(this.getClass().getResource("Images\\LeftChefMoving2.png")).getImage();
        this.RightChefStatic=new ImageIcon(this.getClass().getResource("Images\\RightChefStatic.png")).getImage();
        this.RightChefMoving1=new ImageIcon(this.getClass().getResource("Images\\RightChefMoving1.png")).getImage();
        this.RightChefMoving2=new ImageIcon(this.getClass().getResource("Images\\RightChefMoving2.png")).getImage();
        
        this.FrontClientStatic=new ImageIcon(this.getClass().getResource("Images\\FrontClientStatic.png")).getImage();
        this.FrontClientMoving1=new ImageIcon(this.getClass().getResource("Images\\FrontClientMoving1.png")).getImage();
        this.FrontClientMoving2=new ImageIcon(this.getClass().getResource("Images\\FrontClientMoving2.png")).getImage();
        this.BackClientStatic=new ImageIcon(this.getClass().getResource("Images\\BackClientStatic.png")).getImage();
        this.BackClientMoving1=new ImageIcon(this.getClass().getResource("Images\\BackClientMoving1.png")).getImage();
        this.BackClientMoving2=new ImageIcon(this.getClass().getResource("Images\\BackClientMoving2.png")).getImage();
        this.LeftClientStatic=new ImageIcon(this.getClass().getResource("Images\\LeftClientStatic.png")).getImage();
        this.LeftClientMoving1=new ImageIcon(this.getClass().getResource("Images\\LeftClientMoving1.png")).getImage();
        this.LeftClientMoving2=new ImageIcon(this.getClass().getResource("Images\\LeftClientMoving2.png")).getImage();
        this.RightClientStatic=new ImageIcon(this.getClass().getResource("Images\\RightClientStatic.png")).getImage();
        this.RightClientMoving1=new ImageIcon(this.getClass().getResource("Images\\RightClientMoving1.png")).getImage();
        this.RightClientMoving2=new ImageIcon(this.getClass().getResource("Images\\RightClientMoving2.png")).getImage();
        
        this.hamburguer=new ImageIcon(this.getClass().getResource("Images\\Hamburger.png")).getImage();
        this.hamburguer1Bite=new ImageIcon(this.getClass().getResource("Images\\Hamburger1Bite.png")).getImage();
        this.hamburguer2Bite=new ImageIcon(this.getClass().getResource("Images\\Hamburger2Bite.png")).getImage();
        this.dish=new ImageIcon(this.getClass().getResource("Images\\Dish.png")).getImage();
        this.fogonEncendido=new ImageIcon(this.getClass().getResource("Images\\FogonEncendido.png")).getImage();
    }

    public Image getHamburguer1Bite() {
        return hamburguer1Bite;
    }

    public void setHamburguer1Bite(Image hamburguer1Bite) {
        this.hamburguer1Bite = hamburguer1Bite;
    }

    public Image getHamburguer2Bite() {
        return hamburguer2Bite;
    }

    public void setHamburguer2Bite(Image hamburguer2Bite) {
        this.hamburguer2Bite = hamburguer2Bite;
    }

    public Image getDish() {
        return dish;
    }

    public void setDish(Image dish) {
        this.dish = dish;
    }
    
    
    
    public Image getLeftChefStatic() {
        return LeftChefStatic;
    }

    public void setLeftChefStatic(Image LeftChefStatic) {
        this.LeftChefStatic = LeftChefStatic;
    }

    public Image getLeftChefMoving1() {
        return LeftChefMoving1;
    }

    public void setLeftChefMoving1(Image LeftChefMoving1) {
        this.LeftChefMoving1 = LeftChefMoving1;
    }

    public Image getLeftChefMoving2() {
        return LeftChefMoving2;
    }

    public void setLeftChefMoving2(Image LeftChefMoving2) {
        this.LeftChefMoving2 = LeftChefMoving2;
    }

    public Image getRightChefStatic() {
        return RightChefStatic;
    }

    public void setRightChefStatic(Image RightChefStatic) {
        this.RightChefStatic = RightChefStatic;
    }

    public Image getRightChefMoving1() {
        return RightChefMoving1;
    }

    public void setRightChefMoving1(Image RightChefMoving1) {
        this.RightChefMoving1 = RightChefMoving1;
    }

    public Image getRightChefMoving2() {
        return RightChefMoving2;
    }

    public void setRightChefMoving2(Image RightChefMoving2) {
        this.RightChefMoving2 = RightChefMoving2;
    }

    public Image getLeftClientStatic() {
        return LeftClientStatic;
    }

    public void setLeftClientStatic(Image LeftClientStatic) {
        this.LeftClientStatic = LeftClientStatic;
    }

    public Image getLeftClientMoving1() {
        return LeftClientMoving1;
    }

    public void setLeftClientMoving1(Image LeftClientMoving1) {
        this.LeftClientMoving1 = LeftClientMoving1;
    }

    public Image getLeftClientMoving2() {
        return LeftClientMoving2;
    }

    public void setLeftClientMoving2(Image LeftClientMoving2) {
        this.LeftClientMoving2 = LeftClientMoving2;
    }

    public Image getRightClientStatic() {
        return RightClientStatic;
    }

    public void setRightClientStatic(Image RightClientStatic) {
        this.RightClientStatic = RightClientStatic;
    }

    public Image getRightClientMoving1() {
        return RightClientMoving1;
    }

    public void setRightClientMoving1(Image RightClientMoving1) {
        this.RightClientMoving1 = RightClientMoving1;
    }

    public Image getRightClientMoving2() {
        return RightClientMoving2;
    }

    public void setRightClientMoving2(Image RightClientMoving2) {
        this.RightClientMoving2 = RightClientMoving2;
    }

    public Image getFogonEncendido() {
        return fogonEncendido;
    }

    public void setFogonEncendido(Image fogonEncendido) {
        this.fogonEncendido = fogonEncendido;
    }

    public Image getFrontClientMoving2() {
        return FrontClientMoving2;
    }

    public void setFrontClientMoving2(Image FrontClientMoving2) {
        this.FrontClientMoving2 = FrontClientMoving2;
    }

    public Image getBackClientStatic() {
        return BackClientStatic;
    }

    public void setBackClientStatic(Image BackClientStatic) {
        this.BackClientStatic = BackClientStatic;
    }

    public Image getBackClientMoving1() {
        return BackClientMoving1;
    }

    public void setBackClientMoving1(Image BackClientMoving1) {
        this.BackClientMoving1 = BackClientMoving1;
    }

    public Image getBackClientMoving2() {
        return BackClientMoving2;
    }

    public void setBackClientMoving2(Image BackClientMoving2) {
        this.BackClientMoving2 = BackClientMoving2;
    }
    
    public Image getBackChefStatic() {
        return BackChefStatic;
    }

    public void setBackChefStatic(Image BackChefStatic) {
        this.BackChefStatic = BackChefStatic;
    }

    public Image getBackChefMoving1() {
        return BackChefMoving1;
    }

    public void setBackChefMoving1(Image BackChefMoving1) {
        this.BackChefMoving1 = BackChefMoving1;
    }

    public Image getBackChefMoving2() {
        return BackChefMoving2;
    }

    public void setBackChefMoving2(Image BackChefMoving2) {
        this.BackChefMoving2 = BackChefMoving2;
    }
    
    

    public Image getFondoRestaurante() {
        return fondoRestaurante;
    }

    public void setFondoRestaurante(Image fondoRestaurante) {
        this.fondoRestaurante = fondoRestaurante;
    }

    public Image getFrontChefMoving2() {
        return FrontChefMoving2;
    }

    public void setFrontChefMoving2(Image FrontChefMoving2) {
        this.FrontChefMoving2 = FrontChefMoving2;
    }
    
    public Image getFrontChefStatic() {
        return FrontChefStatic;
    }

    public void setFrontChefStatic(Image FrontChefStatic) {
        this.FrontChefStatic = FrontChefStatic;
    }

    public Image getFrontChefMoving1() {
        return FrontChefMoving1;
    }

    public void setFrontChefMoving1(Image FrontChefMoving1) {
        this.FrontChefMoving1 = FrontChefMoving1;
    }

    public Image getFrontClientStatic() {
        return FrontClientStatic;
    }

    public void setFrontClientStatic(Image FrontClientStatic) {
        this.FrontClientStatic = FrontClientStatic;
    }

    public Image getFrontClientMoving1() {
        return FrontClientMoving1;
    }

    public void setFrontClientMoving1(Image FrontClientMoving1) {
        this.FrontClientMoving1 = FrontClientMoving1;
    }

    public Image getHamburguer() {
        return hamburguer;
    }

    public void setHamburguer(Image hamburguer) {
        this.hamburguer = hamburguer;
    }
    
    
}
