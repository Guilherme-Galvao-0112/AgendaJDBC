/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
  
// JFrame frame; // tela inicial. pode sfechar o programa, não pode ser modal
//Jdialog dialog; //Não fecha o sistema, pode ser modal

    

public class Agenda extends JFrame{
    
    //Tabela
    private JTable tabela = new JTable();// (X,Y) X = linhas Y = Colunas
    private JScrollPane Scroll = new JScrollPane(tabela);//Painel para a Tabela
    //Componentes
        //ID
    private JLabel ID = new JLabel("ID") ; 
    private JTextField PID = new JTextField();
        //Nome
    private JLabel Nome = new JLabel("Nome") ;
    private JTextField PNome = new JTextField();
        //Data de Nascimento
    private JLabel DNS = new JLabel("Data de Nascimento") ;
    private JTextField PDNS = new JTextField();
        //Altura
    private JLabel Altura = new JLabel("Altura");
    private JTextField PAltura = new JTextField();
        //Peso
    private JLabel Peso = new JLabel("Peso") ;// novo label 
    private JTextField PPeso = new JTextField();
    //Botao
    private JButton Enviar = new JButton("Enviar");
        //Adiciona Função ao Botao enviar
    public void EnviarAction(java.awt.event.ActionEvent evt){
        String GID = PID.getText();
        String GNome = PNome.getText();
        String GDNS = PDNS.getText();
        String GAltura = PAltura.getText();
        String GPeso = PPeso.getText(); 
        
        DefaultTableModel Retorno = (DefaultTableModel)tabela.getModel();
        
        Object[] Infos = new Object[]{
            GID,GNome,GDNS,GAltura,GPeso
        };
        
        Retorno.addRow(Infos);
        
        PID.setText("");
        PNome.setText("");
        PDNS.setText("");
        PAltura.setText("");
        PPeso.setText("");
    }
    
    
    public Agenda(){
       
        setLayout(null);//Definindo Layout
        //Definindo posição dos Componentes
            //ID    (X,Y,Largura,Altura) X=Horizontal Y=Vertical
            
            ID.setBounds(5,0,115,15);
            PID.setBounds(120,0,100,15);
            add(ID);
            add(PID);
            //Nome
            Nome.setBounds(5,20,115,15);
            PNome.setBounds(120,20,100,15);
            add(Nome);
            add(PNome);
            //Data de Nascimento
            DNS.setBounds(5,40,115,15);
            PDNS.setBounds(120,40,100,15);
            add(DNS);
            add(PDNS);
            //Altura
            Altura.setBounds(5,60,115,15);
            PAltura.setBounds(120,60,100,15);
            add(Altura);
            add(PAltura);
            //Peso
            Peso.setBounds(5,80,115,15);
            PPeso.setBounds(120,80,100,15);
            add(Peso);
            add(PPeso);
            //Tabela
            Scroll.setBounds(5,100,1100,800);
            add(Scroll);
            //Botao
            Enviar.setBounds(400,80,100,15);
            add(Enviar);
            Enviar.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt){
                    EnviarAction(evt);
                }
            });
            
            
            //tabela 
            tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]{
            },
            new String[]{
                "ID","Nome","Data de Nascimento","Altura","Peso"
            }
            ));
            
            //JFrame
            setTitle("Agenda"); //Adiciona um titulo ao Frame
            setSize(1200,900); // Define o tamanho do Frame
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


