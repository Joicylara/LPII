package ifmt.cba.apps;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
public class AppRelFornecedor {
    public static void main(String arg[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            //relacao com produto (N-> N)
            Query query =  em.createQuery("SELECT produto FROM Produto produto");
            List<Produto> listaProduto = query.getResultList();

            query = em.createQuery("SELECT fornecedor FROM Fornecedor fornecedor");
            List<Fornecedor> listaFornecedor = query.getResultList();

            Fornecedor fornecedor2 = listaFornecedor.get(0);
            System.out.println(listaProduto);
            fornecedor2.setListaProduto(listaProduto.subList(0, 1));
            em.persist(fornecedor2);
            

            fornecedor2 = listaFornecedor.get(1);
            fornecedor2.setListaProduto(listaProduto.subList(1, 2));
            em.persist(fornecedor2);

            fornecedor2 = listaFornecedor.get(2);
            fornecedor2.setListaProduto(listaProduto.subList(2, 3));
            em.persist(fornecedor2);


            em.getTransaction().commit();

        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
