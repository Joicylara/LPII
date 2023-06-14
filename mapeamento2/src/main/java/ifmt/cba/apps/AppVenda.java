package ifmt.cba.apps;

//import java.util.List;

import java.util.Calendar;

import ifmt.cba.util.EntityManagerUtil;
//import ifmt.cba.vo.Cliente;
//import ifmt.cba.vo.ItemVenda;
import ifmt.cba.vo.Venda;
//import ifmt.cba.vo.Vendedor;
//import ifmt.cba.vo.Venda;
import jakarta.persistence.EntityManager;
//import jakarta.persistence.Query;

//@SuppressWarnings("unchecked")
public class AppVenda {
    public static void main(String arg[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            //instancia de venda
            Venda venda = new Venda(Calendar.getInstance());
            em.persist(venda);

            venda = new Venda(Calendar.getInstance());
            em.persist(venda);

            venda = new Venda(Calendar.getInstance());
            em.persist(venda);

            venda = new Venda(Calendar.getInstance());
            em.persist(venda);

            venda = new Venda(Calendar.getInstance());
            em.persist(venda);

            //relacao com itemVenda (1 -> N)
           /* Query query = em.createQuery("SELECT itemVenda FROM ItemVenda itemVenda");
            List <ItemVenda> listaItemVendas = query.getResultList();

            Venda venda = new Venda(Calendar.getInstance());
            venda.setListaItemVenda(listaItemVendas.subList(0, 1));
            em.persist(venda);

            venda = new Venda(Calendar.getInstance());
            venda.setListaItemVenda(listaItemVendas.subList(1, 2));
            em.persist(venda);

            venda = new Venda(Calendar.getInstance());
            venda.setListaItemVenda(listaItemVendas.subList(2, 3));
            em.persist(venda);*/

            //relacao com cliente (N -> 1)
            /*Query query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome = 'Heloise'");
            Cliente cliente =(Cliente)query.getSingleResult();

            Venda venda = new Venda(Calendar.getInstance());
            venda.setCliente(cliente);
            em.persist(venda);

            query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome = 'Mateus'");
            cliente =(Cliente)query.getSingleResult();

            venda = new Venda(Calendar.getInstance());
            venda.setCliente(cliente);
            em.persist(venda);

            query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome = 'Maria'");
            cliente =(Cliente)query.getSingleResult();

            venda = new Venda(Calendar.getInstance());
            venda.setCliente(cliente);
            em.persist(venda);*/

            //relacao com vendedor (N -> 1)
           /* Query query = em.createQuery("SELECT vendedor FROM Vendedor vendedor WHERE vendedor.nome = 'Paulo'");
            Vendedor vendedor = (Vendedor)query.getSingleResult();

            Venda venda = new Venda(Calendar.getInstance());
            venda.setVendedor(vendedor);
            em.persist(venda);

            query = em.createQuery("SELECT vendedor FROM Vendedor vendedor WHERE vendedor.nome = 'Ana Maria'");
            vendedor = (Vendedor)query.getSingleResult();

            venda = new Venda(Calendar.getInstance());
            venda.setVendedor(vendedor);
            em.persist(venda);

            query = em.createQuery("SELECT vendedor FROM Vendedor vendedor WHERE vendedor.nome = 'Ada Lovelace'");
            vendedor = (Vendedor)query.getSingleResult();

            venda = new Venda(Calendar.getInstance());
            venda.setVendedor(vendedor);
            em.persist(venda); */



            em.getTransaction().commit();
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
