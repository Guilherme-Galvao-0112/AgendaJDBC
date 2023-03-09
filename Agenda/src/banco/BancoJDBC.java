package banco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import model.Pessoa;
public class BancoJDBC {
    
    private Connection conn; // Cria uma variavel para estabelecer conexão 
    PreparedStatement ps;
    
    public BancoJDBC() throws SQLException {
    String url="jdbc:postgresql://localhost:5432/postgres"; //Url do banco 
    String senha="1202"; //Senha do banco 
    String user="postgres"; //Nome de usuario do banco
    conn=DriverManager.getConnection(url, user, senha); //Estabelece conexão com o Banco de dados 
   //conn.setAutoCommit(false);// vem true por default
    }
    
        //Inserir Registro no banco 
    public Integer inserir(Pessoa pessoa) throws SQLException{
        try {
            ps=conn.prepareStatement("INSERT INTO public.pessoa VALUES(?); ");
            ps.setInt(0, pessoa.getId());
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
    
    public Integer inserir4(Pessoa pessoa) throws SQLException{   
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
