package banco;

import java.sql.SQLException;
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
        pessoa = new Pessoa();
        pessoa.setNome("André");
    }
    @Test
    public void testeInserir2() throws SQLException {
        BancoJDBC banco = new BancoJDBC();
        Integer inseriu = banco.inserir2(this.pessoa);
        assertTrue(inseriu==0);
    }
    @Test
    public void testUpdate() throws SQLException{
        BancoJDBC banco = new BancoJDBC();
        Integer atualiza = banco.update(this.pessoa);
        assertTrue(atualiza==0);
    }
    @Test
    public void testDelete() throws SQLException{
        BancoJDBC banco = new BancoJDBC();
        Integer deletar = banco.delete(this.pessoa);
        assertTrue(deletar==0);
    }
    @Test
    public void testList() throws SQLException{
        BancoJDBC banco = new BancoJDBC();
        Integer listar = banco.list(this.pessoa);
        assertTrue(listar==0);
    }
}
