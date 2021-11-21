package recogerhamburguesasserveisprocesos;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Jaume
 */
public class AuxiliarImages {
    
    private Image frontChefStatic;
    private Image frontChefMoving1;
    private Image frontChefMoving2;
    private Image backChefStatic;
    private Image backChefMoving1;
    private Image backChefMoving2;
    private Image leftChefStatic;
    private Image leftChefMoving1;
    private Image leftChefMoving2;
    private Image rightChefStatic;
    private Image rightChefMoving1;
    private Image rightChefMoving2;
    
    private Image frontClientStatic;
    private Image frontClientMoving1;
    private Image frontClientMoving2;
    private Image backClientStatic;
    private Image backClientMoving1;
    private Image backClientMoving2;
    private Image leftClientStatic;
    private Image leftClientMoving1;
    private Image leftClientMoving2;
    private Image rightClientStatic;
    private Image rightClientMoving1;
    private Image rightClientMoving2;
    
    private Image hamburguer;
    private Image hamburguer1Bite;
    private Image hamburguer2Bite;
    private Image dish;
    private Image fogonEncendido;
    private Image fondoRestaurante;
    private Image table;

    public AuxiliarImages() {
        
        this.fondoRestaurante=new ImageIcon(this.getClass().getResource("Images\\Fondo.png")).getImage();
        
        this.frontChefStatic=new ImageIcon(this.getClass().getResource("Images\\FrontChefStatic.png")).getImage();
        this.frontChefMoving1=new ImageIcon(this.getClass().getResource("Images\\FrontChefMoving1.png")).getImage();
        this.frontChefMoving2=new ImageIcon(this.getClass().getResource("Images\\FrontChefMoving2.png")).getImage();
        this.backChefStatic=new ImageIcon(this.getClass().getResource("Images\\BackChefStatic.png")).getImage();
        this.backChefMoving1=new ImageIcon(this.getClass().getResource("Images\\BackChefMoving1.png")).getImage();
        this.backChefMoving2=new ImageIcon(this.getClass().getResource("Images\\BackChefMoving2.png")).getImage();
        this.leftChefStatic=new ImageIcon(this.getClass().getResource("Images\\LeftChefStatic.png")).getImage();
        this.leftChefMoving1=new ImageIcon(this.getClass().getResource("Images\\LeftChefMoving1.png")).getImage();
        this.leftChefMoving2=new ImageIcon(this.getClass().getResource("Images\\LeftChefMoving2.png")).getImage();
        this.rightChefStatic=new ImageIcon(this.getClass().getResource("Images\\RightChefStatic.png")).getImage();
        this.rightChefMoving1=new ImageIcon(this.getClass().getResource("Images\\RightChefMoving1.png")).getImage();
        this.rightChefMoving2=new ImageIcon(this.getClass().getResource("Images\\RightChefMoving2.png")).getImage();
        
        this.frontClientStatic=new ImageIcon(this.getClass().getResource("Images\\FrontClientStatic.png")).getImage();
        this.frontClientMoving1=new ImageIcon(this.getClass().getResource("Images\\FrontClientMoving1.png")).getImage();
        this.frontClientMoving2=new ImageIcon(this.getClass().getResource("Images\\FrontClientMoving2.png")).getImage();
        this.backClientStatic=new ImageIcon(this.getClass().getResource("Images\\BackClientStatic.png")).getImage();
        this.backClientMoving1=new ImageIcon(this.getClass().getResource("Images\\BackClientMoving1.png")).getImage();
        this.backClientMoving2=new ImageIcon(this.getClass().getResource("Images\\BackClientMoving2.png")).getImage();
        this.leftClientStatic=new ImageIcon(this.getClass().getResource("Images\\LeftClientStatic.png")).getImage();
        this.leftClientMoving1=new ImageIcon(this.getClass().getResource("Images\\LeftClientMoving1.png")).getImage();
        this.leftClientMoving2=new ImageIcon(this.getClass().getResource("Images\\LeftClientMoving2.png")).getImage();
        this.rightClientStatic=new ImageIcon(this.getClass().getResource("Images\\RightClientStatic.png")).getImage();
        this.rightClientMoving1=new ImageIcon(this.getClass().getResource("Images\\RightClientMoving1.png")).getImage();
        this.rightClientMoving2=new ImageIcon(this.getClass().getResource("Images\\RightClientMoving2.png")).getImage();
        
        this.hamburguer=new ImageIcon(this.getClass().getResource("Images\\Hamburger.png")).getImage();
        this.hamburguer1Bite=new ImageIcon(this.getClass().getResource("Images\\Hamburger1Bite.png")).getImage();
        this.hamburguer2Bite=new ImageIcon(this.getClass().getResource("Images\\Hamburger2Bite.png")).getImage();
        this.dish=new ImageIcon(this.getClass().getResource("Images\\Dish.png")).getImage();
        this.fogonEncendido=new ImageIcon(this.getClass().getResource("Images\\FogonEncendido.png")).getImage();
        this.table=new ImageIcon(this.getClass().getResource("Images\\Table.png")).getImage();
    }
    
    public Image getBackChefMoving1() {
        return backChefMoving1;
    }

    public Image getBackChefMoving2() {
        return backChefMoving2;
    }
    
    public Image getBackChefStatic() {
        return backChefStatic;
    }
    
    public Image getBackClientMoving1() {
        return backClientMoving1;
    }

    public Image getBackClientMoving2() {
        return backClientMoving2;
    }
    
    public Image getBackClientStatic() {
        return backClientStatic;
    }
    
    public Image getDish() {
        return dish;
    }
    
    public Image getFogonEncendido() {
        return fogonEncendido;
    }

    public Image getFondoRestaurante() {
        return fondoRestaurante;
    }

    public Image getFrontChefMoving1() {
        return frontChefMoving1;
    }

    public Image getFrontChefMoving2() {
        return frontChefMoving2;
    }
    
    public Image getFrontChefStatic() {
        return frontChefStatic;
    }
    
    public Image getFrontClientMoving1() {
        return frontClientMoving1;
    }

    public Image getFrontClientMoving2() {
        return frontClientMoving2;
    }
    
    public Image getFrontClientStatic() {
        return frontClientStatic;
    }
    
    public Image getHamburguer() {
        return hamburguer;
    }

    public Image getHamburguer1Bite() {
        return hamburguer1Bite;
    }

    public Image getHamburguer2Bite() {
        return hamburguer2Bite;
    }
    
    public Image getLeftChefMoving1() {
        return leftChefMoving1;
    }

    public Image getLeftChefMoving2() {
        return leftChefMoving2;
    }
    
    public Image getLeftChefStatic() {
        return leftChefStatic;
    }
    
    public Image getLeftClientMoving1() {
        return leftClientMoving1;
    }

    public Image getLeftClientMoving2() {
        return leftClientMoving2;
    }
    
    public Image getLeftClientStatic() {
        return leftClientStatic;
    }
    
    public Image getRightChefMoving1() {
        return rightChefMoving1;
    }

    public Image getRightChefMoving2() {
        return rightChefMoving2;
    }
    
    public Image getRightChefStatic() {
        return rightChefStatic;
    }
    
    public Image getRightClientMoving1() {
        return rightClientMoving1;
    }

    public Image getRightClientMoving2() {
        return rightClientMoving2;
    }
    
    public Image getRightClientStatic() {
        return rightClientStatic;
    }

    public Image getTable() {
        return table;
    }    
}
