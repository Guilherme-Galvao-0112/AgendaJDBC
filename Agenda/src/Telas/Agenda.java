/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
  
// JFrame frame; // tela inicial. pode sfechar o programa, não pode ser modal
//Jdialog dialog; //Não fecha o sistema, pode ser modal

    

public class Agenda extends JFrame{
    private JLabel label = new JLabel("Olá Mundo") ;// novo label 
    private JLabel labe2 = new JLabel("Olá Mundo") ;// novo label 
    
    public Agenda(){
        
        setLayout(new FlowLayout());
        
        add(label);
        add(labe2);
        
        setTitle("Titulo");
        setSize(50,60);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        /*
        DISPOSE_ON_CLOSE
        DO_NOTHING_ON_CLOSE
        EXIT_ON_CLOSE
        */
    }
    public static void main(String args[]){
        new Agenda().setVisible(true); //torna a tabela visivel
        
    }

}


