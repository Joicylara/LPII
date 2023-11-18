package ifmt.cba.apps;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;
import ifmt.cba.vo.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
public class AppCliente {
    public static void main(String arg[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            /*Query query = em.createQuery("SELECT venda FROM Venda venda");
            List <Venda> listaVenda = query.getResultList();

            Cliente cliente = new Cliente("Heloise");
            cliente.setListaVenda(listaVenda.subList(0, 2));
            em.persist(cliente);

            cliente = new Cliente("Mateus");
            cliente.setListaVenda(listaVenda.subList(2, 3));
            em.persist(cliente);

            cliente = new Cliente("Maria");
            cliente.setListaVenda(listaVenda.subList(4, 5));
            em.persist(cliente);*/

            //relacao com venda (1 -> N)
            Query query = em.createQuery("SELECT venda FROM Venda venda");
            List<Venda> listaVenda = query.getResultList();

            Cliente cliente = new Cliente("Benjamin");
            cliente.setListaVenda(listaVenda.subList(16, 17));
            em.persist(cliente);

            cliente = new Cliente("Bethouve");
            cliente.setListaVenda(listaVenda.subList(17, 18));
            em.persist(cliente);

            cliente = new Cliente("Jasmin");
            cliente.setListaVenda(listaVenda.subList(18, 19));
            em.persist(cliente);

            em.getTransaction().commit();
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
