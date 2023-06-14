package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.GrupoProduto;
import jakarta.persistence.EntityManager;

public class AppGrupoProduto {
    public static void main(String arg[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            //instancia de GrupoProduto
            GrupoProduto grupoProduto = new GrupoProduto("Frios");
            em.persist(grupoProduto);

            grupoProduto = new GrupoProduto("Padaria");
            em.persist(grupoProduto);

            grupoProduto = new GrupoProduto("Alimentos");
            em.persist(grupoProduto);

            em.getTransaction().commit();
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
