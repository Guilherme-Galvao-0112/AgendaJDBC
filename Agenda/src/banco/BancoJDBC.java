package banco;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class BancoJDBC {
    //Cria conexao com o banco de dados
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendaPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction etx = em.getTransaction();
    
    public void inserir(Object o){
         etx.begin();
         em.persist(o);
         etx.commit();
         em.close();
    }
    public void update(Object o){
        etx.begin();
        em.merge(o);
        etx.commit();
        em.close();
    }
    public void remove(Object o){
        etx.begin();
        em.remove(o);
        etx.commit();
        em.close();
    }
    public List listar(Object o){
        Query query = em.createQuery("SELECT o FROM "+o.getClass().getSimpleName()+" o");
         return query.getResultList();
    }
    
  
  /*
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
     public List listar() throws SQLException{
     List pessoas= new LinkedList();
        ps=conn.prepareStatement("select * from public.pessoa;");
        ResultSet res = ps.executeQuery();   
       while(res.next()){
           Pessoa p = new Pessoa();
           p.setId(res.getInt("id"));
           p.setNome(res.getString("nome"));
           p.setDataNascimento(res.getDate("dns"));
           p.setAltura(res.getFloat("altura"));
           try {
                    p.setPeso(res.getFloat("peso"));   
                } catch (SizeLimitExceededException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
           pessoas.add(p);
       }
        conn.close();//fecha conexão
        ps.close();
        return pessoas;
    }
*/
}