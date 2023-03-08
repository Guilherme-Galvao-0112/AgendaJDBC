package banco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import model.Pessoa;
public class BancoJDBC {
    private Connection conn;
    
    public BancoJDBC() throws SQLException {
    String url="jdbc:postgresql://localhost:5432/postgres";
    String senha="";
    String user="postgres";
    conn=DriverManager.getConnection(url, user, senha);    
   //conn.setAutoCommit(false);// vem true por default
    }
    PreparedStatement ps;
    public Integer inserir(Pessoa pessoa) throws SQLException{   
        ps=conn.prepareStatement("INSERT INTO public.pessoa(nome) VALUES(?);");
        ps.setString(0, pessoa.getNome());
        ps.executeLargeUpdate();   
        conn.close();//fecha conexão
        return 0;
    }
    public Integer inserir3(Pessoa pessoa) throws SQLException{
        conn.prepareStatement("INSERT INTO public.pessoa(nome) VALUES('aNDRE');");
        ps.executeUpdate();
        conn.commit();//valida execução banco
        conn.rollback();//volta estado do banco   
        return null;
    }
    public Integer inserir2(Pessoa pessoa) throws SQLException {
        try{
            ps=conn.prepareStatement("INSERT INTO public.pessoa(nome) VALUES(?);");
            ps.setString(0, pessoa.getNome());
            ps.executeLargeUpdate();
         }catch(SQLException ex){
             System.out.print("erro ao inserir");
         }finally{
            conn.close();//fecha conexão
         }
         return 0;
    }
    public Integer update(Pessoa pessoa) throws SQLException{
        try {
             ps=conn.prepareStatement("UPDATE public.pessoa SET nome=(?) WHERE coluna2 = (?) ");
             ps.setString(0, pessoa.getNome());
             ps.executeLargeUpdate(); 
        }catch(SQLException ex){
            System.out.println("erro ao fazer update");
        }finally {
            conn.close();
        
        }
        return 0;
    }
    public Integer list() throws SQLException{
        
        return 0;
    }
    public Integer delete(Pessoa pessoa) throws SQLException{
        try {
            ps=conn.prepareStatement("DELETE FROM public.pessoa WHERE id = (?)");
            ps.setString(0, pessoa.getNome());
            ps.executeLargeUpdate();
        } catch (SQLException ex) {
            System.out.println("erro ao fazer delete");
        } finally {
            conn.close();
        }
        return 0;
    }
    
}
