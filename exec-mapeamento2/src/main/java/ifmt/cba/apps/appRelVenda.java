package ifmt.cba.apps;

import java.util.Calendar;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;
import ifmt.cba.vo.ItemVenda;
import ifmt.cba.vo.Produto;
import ifmt.cba.vo.Venda;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class appRelVenda {
    public static void main(String arg[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Venda venda = new Venda(Calendar.getInstance());


            Query query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Banana'");
            Produto produto = (Produto)query.getSingleResult();

            ItemVenda itemVenda = new ItemVenda(10,  15.80f, 15);
            itemVenda.setProduto(produto);
            venda.getListaItemVenda().add(itemVenda);

            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Suco'");
            produto = (Produto)query.getSingleResult();

            itemVenda = new ItemVenda(10,  25.80f, 15);
            itemVenda.setProduto(produto);
            venda.getListaItemVenda().add(itemVenda);

            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Pao'");
            produto = (Produto)query.getSingleResult();

            itemVenda = new ItemVenda(10,  55.60f, 15);
            itemVenda.setProduto(produto);
            venda.getListaItemVenda().add(itemVenda);

            query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome = 'Heloise'");
            Cliente cliente =(Cliente)query.getSingleResult();
            venda.setCliente(cliente);

            query = em.createQuery("SELECT vendedor FROM Vendedor vendedor WHERE vendedor.nome = 'Ana Maria'");
            Vendedor vendedor = (Vendedor)query.getSingleResult();
            venda.setVendedor(vendedor);

            //persistencia 1
            em.persist(venda);

            venda = new Venda(Calendar.getInstance());

            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Torta'");
            produto = (Produto)query.getSingleResult();

            itemVenda = new ItemVenda(10,  15.80f, 15);
            itemVenda.setProduto(produto);
            venda.getListaItemVenda().add(itemVenda);


            query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome = 'Benjamin'");
            cliente =(Cliente)query.getSingleResult();
            venda.setCliente(cliente);

            query = em.createQuery("SELECT vendedor FROM Vendedor vendedor WHERE vendedor.nome = 'Ada Lovelace'");
            vendedor = (Vendedor)query.getSingleResult();
            venda.setVendedor(vendedor);

            //persistencia 2
            em.persist(venda);

            venda = new Venda(Calendar.getInstance());


            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Bolo'");
            produto = (Produto)query.getSingleResult();

            itemVenda = new ItemVenda(10,  15.80f, 15);
            itemVenda.setProduto(produto);
            venda.getListaItemVenda().add(itemVenda);

            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Suco'");
            produto = (Produto)query.getSingleResult();

            itemVenda = new ItemVenda(10,  25.80f, 15);
            itemVenda.setProduto(produto);
            venda.getListaItemVenda().add(itemVenda);

            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Pao'");
            produto = (Produto)query.getSingleResult();

            itemVenda = new ItemVenda(10,  55.60f, 15);
            itemVenda.setProduto(produto);
            venda.getListaItemVenda().add(itemVenda);

            query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome = 'Maria'");
            cliente =(Cliente)query.getSingleResult();
            venda.setCliente(cliente);

            query = em.createQuery("SELECT vendedor FROM Vendedor vendedor WHERE vendedor.nome = 'Lua'");
            vendedor = (Vendedor)query.getSingleResult();
            venda.setVendedor(vendedor);

            //persistencia 3
            em.persist(venda);

            venda = new Venda(Calendar.getInstance());


            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Banana'");
            produto = (Produto)query.getSingleResult();

            itemVenda = new ItemVenda(10,  15.80f, 15);
            itemVenda.setProduto(produto);
            venda.getListaItemVenda().add(itemVenda);

            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Suco'");
            produto = (Produto)query.getSingleResult();

            itemVenda = new ItemVenda(10,  25.80f, 15);
            itemVenda.setProduto(produto);
            venda.getListaItemVenda().add(itemVenda);

            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Torta'");
            produto = (Produto)query.getSingleResult();

            itemVenda = new ItemVenda(10,  55.60f, 15);
            itemVenda.setProduto(produto);
            venda.getListaItemVenda().add(itemVenda);

            query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome = 'Bruna'");
            cliente =(Cliente)query.getSingleResult();
            venda.setCliente(cliente);

            query = em.createQuery("SELECT vendedor FROM Vendedor vendedor WHERE vendedor.nome = 'Ana Claudia'");
            vendedor = (Vendedor)query.getSingleResult();
            venda.setVendedor(vendedor);

            //persistencia 4
            em.persist(venda);

            venda = new Venda(Calendar.getInstance());


            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Pao'");
            produto = (Produto)query.getSingleResult();

            itemVenda = new ItemVenda(10,  15.80f, 15);
            itemVenda.setProduto(produto);
            venda.getListaItemVenda().add(itemVenda);

            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Suco'");
            produto = (Produto)query.getSingleResult();

            itemVenda = new ItemVenda(10,  25.80f, 15);
            itemVenda.setProduto(produto);
            venda.getListaItemVenda().add(itemVenda);

            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Bolo'");
            produto = (Produto)query.getSingleResult();

            itemVenda = new ItemVenda(10,  55.60f, 15);
            itemVenda.setProduto(produto);
            venda.getListaItemVenda().add(itemVenda);

            query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome = 'Bethouve'");
            cliente =(Cliente)query.getSingleResult();
            venda.setCliente(cliente);

            query = em.createQuery("SELECT vendedor FROM Vendedor vendedor WHERE vendedor.nome = 'Ada Lovelace'");
            vendedor = (Vendedor)query.getSingleResult();
            venda.setVendedor(vendedor);

            //persistencia 5
            em.persist(venda);


            em.getTransaction().commit();


        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
        
}
