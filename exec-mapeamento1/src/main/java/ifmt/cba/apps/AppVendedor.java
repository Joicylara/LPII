package ifmt.cba.apps;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Venda;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
public class AppVendedor {
    public static void main(String arg[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            //relacao com venda (1 -> N)
            Query query = em.createQuery("SELECT venda FROM Venda venda");
            List <Venda> listaVenda = query.getResultList();

            Vendedor vendedor = new Vendedor("Paulo", 10);
            vendedor.setListaVenda(listaVenda.subList(0, 1));
            em.persist(vendedor);

            vendedor = new Vendedor("Ana Maria", 15);
            vendedor.setListaVenda(listaVenda.subList(1, 2));
            em.persist(vendedor);

            vendedor = new Vendedor("Ada Lovelace", 20);
            vendedor.setListaVenda(listaVenda.subList(2, 3));
            em.persist(vendedor);

            em.getTransaction().commit();
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
