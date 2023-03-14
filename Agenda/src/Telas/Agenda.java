/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

import banco.BancoJDBC;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.SizeLimitExceededException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Pessoa;
  
// JFrame frame; // tela inicial. pode sfechar o programa, não pode ser modal
//Jdialog dialog; //Não fecha o sistema, pode ser modal

    

public class Agenda extends JFrame implements ActionListener{
    
    //Tabela
    private JTable tabela = new JTable();// (X,Y) X = linhas Y = Colunas
    private JScrollPane Scroll = new JScrollPane(tabela);//Painel para a Tabela
    //Componentes
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
  
    public Agenda(){
       
        setLayout(null);//Definindo Layout
        //Definindo posição dos Componentes
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
            atualizaDadosTabela();
            tabela.setModel(new DefaultTableModel(
            new Object [][]{
            },
            new String[]{
                "ID","Nome","Data de Nascimento","Altura","Peso"
            }
            ));
  
            
            Enviar.addActionListener(this);
        
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
    
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e){
            try {
                Pessoa pe = new Pessoa();
                pe.setNome(PNome.getText());
                pe.setAltura(Float.parseFloat(PAltura.getText()));
                pe.setPeso(Float.parseFloat(PPeso.getText()));
                BancoJDBC banco = new BancoJDBC();
                banco.inserir(pe);
                JOptionPane.showMessageDialog(rootPane,"salvar");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane,"Deu Ruim ao salvar");
            } catch (SizeLimitExceededException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
    
   private void atualizaDadosTabela(){
      try {
          String[] columnNames = new String[]{"Id","Nome","Data de Nascimento", "Altura", "Peso"};
          BancoJDBC banco = new BancoJDBC();
          List<Pessoa> dados = banco.listar();
          Object[][] data =
                  new Object[dados.size()][columnNames.length];
          
          for (int i = 0; i < dados.size(); i++) {
              data[i][0]=dados.get(i).getId();
              data[i][1]=dados.get(i).getNome();
          }
          DefaultTableModel modelo =
                  new DefaultTableModel(data, columnNames);
          tabela.setModel(modelo);
   
      } catch (SQLException ex) {
          Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SizeLimitExceededException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}

