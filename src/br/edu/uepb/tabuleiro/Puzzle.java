package br.edu.uepb.tabuleiro;

/**
 * @author geovanniovinhas
 *
 * Jul 31, 2016
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.BorderFactory.*;

public class Puzzle extends JFrame{
    
    public static Placas panel1;
    public static Placas panel2;
    public static Placas panel3;
    
    public static Placas panel4;
    public static Placas panel5;
    public static Placas panel6;
    
    public static Placas panel7;
    public static Placas panel8;
    public static JPanel vazio;
    
    public static JLabel cronos;
    
    public static final int PRIM = 0;
    public static final int MEIO = 152;
    public static final int FIM = 304;
    
    
    public Puzzle()
    {
        super("Puzzle");
        Container c = getContentPane();
        setLayout(null);
        
        
        panel1 = new Placas(PRIM,PRIM,"G");        
        c.add(panel1);
        
        panel2 = new Placas(MEIO,PRIM,"C");            
        c.add(panel2);
        
        panel3 = new Placas(FIM,PRIM,"B");    
        c.add(panel3);
        
        panel4 = new Placas(PRIM,MEIO,"E");    
        c.add(panel4);
        
        panel5 = new Placas(MEIO,MEIO,"D");    
        c.add(panel5);
        
        panel6 = new Placas(FIM,MEIO,"A");    
        c.add(panel6);
        
        panel7 = new Placas(PRIM, FIM,"F");    
        c.add(panel7);
        
        panel8 = new Placas(MEIO,FIM,"H");    
        c.add(panel8);
        
        vazio = new JPanel();    
        c.add(vazio);
        vazio.setBounds(FIM,FIM,150,150);
        //vazio.setBorder(createEtchedBorder());    

             cronos = new JLabel("000 s");
             c.add(cronos);
             cronos.setBounds(MEIO,FIM,50,35);
        
        setSize(463,490);
        setResizable(false);
        setVisible(true);
        vazio.setToolTipText("Click em um botão para movimentá-lo ao espaço vazio!");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public static void main(String[] args){    
        Puzzle puzzle = new Puzzle();    
    }
    
    
    public boolean verificarVitoria(){
        if(       panel6.getPonto().equals("0, 0") 
            && panel3.getPonto().equals("152, 0")
            && panel2.getPonto().equals("304, 0")
            && panel5.getPonto().equals("0, 152")
            && panel4.getPonto().equals("152, 152")
            && panel7.getPonto().equals("304, 152")
            && panel1.getPonto().equals("0, 304")
            && panel8.getPonto().equals("152, 304")        )
            
                return true;
        else
                return false;
    }
    
    
public class Placas extends JButton{    
    int xx ,yy, deltaX, deltaY;
    
    public Placas(int x, int y,String text){
        
        setBounds(x,y,150,150);        
        
        
        
        addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ae){    
                    xx = getX();
                    yy = getY();
                    deltaX = Math.abs(xx - vazio.getX());
                    deltaY = Math.abs(yy - vazio.getY());
                    
                    if(deltaX <= 152 &&  deltaY <= 152    &&  deltaX != deltaY){
                        setBounds(vazio.getX(),vazio.getY(),150,150);                
                    
                        vazio.setBounds(xx,yy,150,150);        
                    }
                    
                    if(verificarVitoria() == true)
                        JOptionPane.showMessageDialog(null,"Parabéns, Você venceu!!!");                        
                    
                }    
            
            }
        );        
            
        setFont(new Font("Arial", 1, 45));        
        setText(text);                
        
        setForeground(new java.awt.Color(255, 255, 255));
        setBackground(new Color(65, 165,65));
        
    }    
    
    public   String getPonto(){
        String ponto = "";
        ponto = String.format("%d, %d",getX(),getY());    
        return ponto;
    }
    
    
}//fim da classe Placas

}//fim da classe Pluzze