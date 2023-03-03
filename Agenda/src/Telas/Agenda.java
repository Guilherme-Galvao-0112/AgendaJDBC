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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
  
// JFrame frame; // tela inicial. pode sfechar o programa, não pode ser modal
//Jdialog dialog; //Não fecha o sistema, pode ser modal

    

public class Agenda extends JFrame{
    private JTable tabela = new JTable(5,3);
    
    private JLabel id = new JLabel("ID") ;// novo label 
    private JLabel nome = new JLabel("Nome") ;// novo label 
    private JLabel DNC = new JLabel("Data de Nascimento") ;// novo label 
    private JLabel altura = new JLabel("Altura") ;// novo label 
    private JLabel peso = new JLabel("Peso") ;// novo label 
    private JScrollPane scroll = new JScrollPane(tabela);
    private JTextField gnome = new JTextField();
    private JTextField gid = new JTextField();
    private JTextField gDNC = new JTextField();
    private JTextField galtura = new JTextField();
    private JTextField gpeso = new JTextField();
    public Agenda(){
        
        setLayout(null);
        id.setBounds(0,0,100,15);
        gid.setBounds(150, 0, 100, 15);
        add(id);
        add(gid);
        nome.setBounds(0,20, 100, 15);
        gnome.setBounds(150, 20, 100, 15);
        add(nome);
        add(gnome);
        DNC.setBounds(0, 30, 200, 15);
        add(DNC);
        add(gDNC);
        altura.setBounds(0, 40, 100, 15);
        add(altura);
        add(galtura);
        peso.setBounds(0, 50, 100, 15);
        add(peso);
        add(gpeso);
        setTitle("Titulo");
        setSize(900,600);
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


