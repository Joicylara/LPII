package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;

import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;



public class AppProduto {
    public static void main(String arg[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Produto produto = new Produto("Banana", 25.80f);
            em.persist(produto);

            produto = new Produto("Suco", 55.80f);
            em.persist(produto);

            produto = new Produto("Pao", 15.80f);
            em.persist(produto);

            produto = new Produto("Torta", 9.80f);
            em.persist(produto);

            produto = new Produto("Bolo", 150.60f);
            em.persist(produto);

           
            em.getTransaction().commit();

        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
