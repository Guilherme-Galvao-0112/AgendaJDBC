package model;

import javax.naming.SizeLimitExceededException;
import org.junit.Test;
import static org.junit.Assert.*;

public class PessoaTest {
    
    public PessoaTest() {
    }

    @Test
    public void pesoNegativo() throws SizeLimitExceededException {
        Pessoa p = new Pessoa();
        p.setPeso(-12f);
        assertTrue(p.getPeso()>=0);
    }
    @Test(expected = SizeLimitExceededException.class)
    public void pesoMaximo() throws SizeLimitExceededException{
         Pessoa p = new Pessoa();
            p.setPeso(201f);
        
    }
    
}
