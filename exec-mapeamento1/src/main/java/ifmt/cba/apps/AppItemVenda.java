package ifmt.cba.apps;


import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.ItemVenda;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AppItemVenda {
    public static void main(String arg[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            //relacao com produto (N-> 1)
            Query query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Sorvete'");
            Produto produto = (Produto)query.getSingleResult();

            ItemVenda itemVenda = new ItemVenda(10,  15.80f, 15);
            itemVenda.setProduto(produto);
            em.persist(itemVenda);

            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Frango'");
            produto = (Produto)query.getSingleResult();

            itemVenda = new ItemVenda(10,  25.80f, 15);
            itemVenda.setProduto(produto);
            em.persist(itemVenda);

            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'Carne'");
            produto = (Produto)query.getSingleResult();

            itemVenda = new ItemVenda(10,  55.60f, 15);
            itemVenda.setProduto(produto);
            em.persist(itemVenda);

            em.getTransaction().commit();
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
