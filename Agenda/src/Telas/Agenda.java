/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

import banco.BancoJDBC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
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
    private JLabel Nome = new JLabel("Nome");
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
    private JButton Apagar = new JButton("Deletar");
    private JButton Atualizar = new JButton("Atualizar");
        //Adiciona Função ao Botao enviar
  
    public Agenda(){
       
        setLayout(null);//Definindo Layout
        //Definindo posição dos Componentes
            //Nome
            Nome.setBounds(10,10,115,15);
            PNome.setBounds(135,10,100,15);
            add(Nome);
            add(PNome);
            //Data de Nascimento
            DNS.setBounds(10,30,115,15);
            PDNS.setBounds(135,30,100,15);
            add(DNS);
            add(PDNS);
            //Altura
            Altura.setBounds(10,50,115,15);
            PAltura.setBounds(135,50,100,15);
            add(Altura);
            add(PAltura);
            //Peso
            Peso.setBounds(10,70,115,15);
            PPeso.setBounds(135,70,100,15);
            add(Peso);
            add(PPeso);
            //Scroll
            Scroll.setBounds(10,100,500,300);
            add(Scroll);
            //Botao
            Enviar.setBounds(400,40,100,15);
            add(Enviar);
            Apagar.setBounds(400,60,100,15);
            add(Apagar);
            Atualizar.setBounds(400,80,100,15);
            add(Atualizar);
            Enviar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent enviar){
                    EnviarAction(enviar);
                }
            });

            
            //Tabela
            
            atualizaDadosTabela();
            setTitle("Agenda JDBC");
            setSize(545,355);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public static void main(String args[]){
        new Agenda().setVisible(true); //torna a tabela visivel
    }
    /**
     *
     * @param enviar
     */
    public void EnviarAction(ActionEvent enviar){
        if(enviar.getSource().equals(Enviar)){
            Pessoa p = new Pessoa();
            p.setNome(PNome.getText());
            p.setDataNascimento(new Date(PDNS.getText()));
            p.setAltura(Float.valueOf(PAltura.getText()));
            try {
                p.setPeso(Float.valueOf(PPeso.getText()));
            } catch (SizeLimitExceededException ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Ação de inserir no Banco de Dados
            BancoJDBC banco = new BancoJDBC();
            banco.inserir(p);
            atualizaDadosTabela();
                
            JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso");
        }
    }
   
    
   private void atualizaDadosTabela(){
       
           String[] ColumNames = new String[]{"Id","Nome","Data Nascimento","Altura","Peso"};
           BancoJDBC banco = new BancoJDBC();
           Pessoa p = new Pessoa();
           List<Pessoa> dados = banco.listar(p);
           
           
           
           Object[][] data = new Object[dados.size()][ColumNames.length];
           
           for(int i = 0; i <dados.size(); i++){
               data[i][0]=dados.get(i).getId();
               data[i][1]=dados.get(i).getNome();
               data[i][2]=dados.get(i).getDataNascimento();
               data[i][3]=dados.get(i).getAltura();
               data[i][4]=dados.get(i).getPeso();
           }
           
           DefaultTableModel modelo = new DefaultTableModel(data, ColumNames);
           tabela.setModel(modelo);
           
}
  

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}