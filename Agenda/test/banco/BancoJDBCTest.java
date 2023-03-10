package banco;

import java.sql.SQLException;
import java.util.Date;
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
            pessoa.setNome("Andre");
            pessoa.setDataNascimento(new Date(pessoa.getDataNascimento().getTime()));
            pessoa.setAltura(1.8f);
            pessoa.setPeso(70f);
        } catch (SizeLimitExceededException ex) {
            Logger.getLogger(BancoJDBCTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Test
    public void testeInserir() throws SQLException {
        BancoJDBC banco = new BancoJDBC();
        Integer inseriu = banco.inserir(this.pessoa);
        assertTrue(inseriu==0);
    }
    @Test
    public void testUpdate() throws SQLException{
        BancoJDBC banco = new BancoJDBC();
        Integer atualiza = banco.alterar(this.pessoa);
        assertTrue(atualiza==0);
    }
    @Test
    public void testDelete() throws SQLException{
        BancoJDBC banco = new BancoJDBC();
        Integer deletar = banco.remover(this.pessoa);
        assertTrue(deletar==0);
    }
    /*@Test
    public void testList() throws SQLException{
        BancoJDBC banco = new BancoJDBC();
        Integer listar = banco.list(this.pessoa);
        assertTrue(listar==0);
    }*/
}
