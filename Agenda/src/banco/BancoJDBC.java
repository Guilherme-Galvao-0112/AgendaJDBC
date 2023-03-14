package banco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import javax.naming.SizeLimitExceededException;
import model.Pessoa;
public class BancoJDBC {
    
    private Connection conn; // Cria uma variavel para estabelecer conexão 
    private PreparedStatement ps;
    
    public BancoJDBC() throws SQLException {
    String url="jdbc:postgresql://localhost:5432/postgres"; //Url do banco 
    String senha="unigran"; //Senha do banco 
    String user="postgres"; //Nome de usuario do banco
    conn=DriverManager.getConnection(url, user, senha); //Estabelece conexão com o Banco de dados 
   //conn.setAutoCommit(false);// vem true por default
    }
    
        //Inserir Registro no banco 
    public Integer inserir(Pessoa pessoa) throws SQLException{
        try {
            ps=conn.prepareStatement("INSERT INTO public.pessoa VALUES(?); ");
            ps.setString(1, pessoa.getNome());
            ps.setDate(2, (Date) pessoa.getDataNascimento());
            ps.setFloat(3, pessoa.getAltura());
            ps.setFloat(4, pessoa.getPeso());
            ps.executeLargeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir");
        }finally{
            conn.close();
        }
        return 0;
    }
    
    public Integer alterar(Pessoa pessoa) throws SQLException{
     ps=conn.prepareStatement("UPDATE public.pessoa SET nome=? WHERE id=?;");
        ps.setString(1, pessoa.getNome());
        ps.setDate(2, (Date) pessoa.getDataNascimento());
        ps.setFloat(3, pessoa.getAltura());
        ps.setFloat(4, pessoa.getPeso());
        ps.executeUpdate();   
        conn.close();//fecha conexão
        ps.close();
        return 0;
    }
     public Integer remover(Pessoa pessoa) throws SQLException{
     ps=conn.prepareStatement("DELETE FROM public.pessoa WHERE id=?;");
        ps.setInt(1, pessoa.getId());
        ps.executeUpdate();   
        conn.close();//fecha conexão
        ps.close();
        return 0;
    }
     public List listar() throws SQLException, SizeLimitExceededException{
     List pessoas= new LinkedList();
        ps=conn.prepareStatement("select * from public.pessoa;");
        ResultSet res = ps.executeQuery();   
       while(res.next()){
           Pessoa p = new Pessoa();
           p.setId(res.getInt("id"));
           p.setNome(res.getString("nome"));
           p.setDataNascimento(res.getDate("dns"));
           p.setAltura(res.getFloat("altura"));
           p.setPeso(res.getFloat("peso"));
           pessoas.add(p);
       }
        conn.close();//fecha conexão
        ps.close();
        return pessoas;
    }
}