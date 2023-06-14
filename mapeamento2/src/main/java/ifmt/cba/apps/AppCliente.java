package ifmt.cba.apps;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;
import ifmt.cba.vo.Venda;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
public class AppCliente {
    public static void main(String arg[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
            
            Cliente cliente = new Cliente("Heloise", "2345-0", "39485-32", 34);
            em.persist(cliente);

            cliente = new Cliente("Bruna", "23344-9", "874530-98", 90);
            em.persist(cliente);

            cliente = new Cliente("Maria", "8755-0", "94855-082", 76);
            em.persist(cliente);

            cliente = new Cliente("Benjamin", "324567-9", "098765432-09", 3000.90f);
            em.persist(cliente);

            cliente = new Cliente("Bethouve",  "424589-9", "9988765432-09", 1600.90f);
            em.persist(cliente);

            cliente = new Cliente("Jasmin",  "114567-8", "112765345-10", 13000.90f);
            em.persist(cliente);

            
            //relacao com venda (1 -> N)
           /*Query query = em.createQuery("SELECT venda FROM Venda venda");
            List<Venda> listaVenda = query.getResultList();

           */

            em.getTransaction().commit();
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
