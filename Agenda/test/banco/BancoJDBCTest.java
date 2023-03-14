package banco;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.SizeLimitExceededException;
import model.Pessoa;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author andre
 */
public class BancoJDBCTest {
    Pessoa pessoa=null;
    public BancoJDBCTest() {
    }
    @Before
    public void criaPessoa(){
        try {         
            pessoa = new Pessoa();
            pessoa.setId(Integer.SIZE);
            pessoa.setNome("Guilherme");
            pessoa.setDataNascimento(new Date(pessoa.getDataNascimento().getTime()));        
            pessoa.setAltura(1.8f);
            pessoa.setPeso(70f);
        } catch (SizeLimitExceededException ex) {
            Logger.getLogger(BancoJDBCTest.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NullPointerException e){
            
        }
        
    } 
    @Test
    public void testeInserir() throws SQLException {
        BancoJDBC banco = new BancoJDBC();
        Integer inseriu = banco.inserir(this.pessoa);
        assertTrue(inseriu==0);
    }
    @Test
    public void testeAlterar() throws SQLException{
        try {
            BancoJDBC banco = new BancoJDBC();
            this.pessoa.setId(1);
            this.pessoa.setNome("Novo");
            this.pessoa.setDataNascimento(new Date(pessoa.getDataNascimento().getTime()));
            this.pessoa.setAltura(Float.NaN);
            this.pessoa.setPeso(Float.NaN);
            Integer atualiza = banco.alterar(this.pessoa);
            assertTrue(atualiza==0);
        } catch (SizeLimitExceededException ex) {
            Logger.getLogger(BancoJDBCTest.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NullPointerException e){
            
        }
    }
    @Test
    public void testDelete() throws SQLException{
        BancoJDBC banco = new BancoJDBC();
        Integer deletar = banco.remover(this.pessoa);
        assertTrue(deletar==0);
    }
    @Test
    public void testList() throws SQLException, SizeLimitExceededException{
        BancoJDBC banco = new BancoJDBC();
        List listar = banco.listar();
        assertTrue(!listar.isEmpty());
    }
}
