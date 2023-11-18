package ifmt.cba.apps;


import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import jakarta.persistence.EntityManager;


public class AppFornecedor {
    public static void main(String arg[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            //instancia e persistencia de fornecedor
            Fornecedor fornecedor = new Fornecedor("Paola","Sadia", "839439379-98");
            em.persist(fornecedor);

            fornecedor = new Fornecedor("Antonio","Perdigao", "6373829023-97");
            em.persist(fornecedor);

            fornecedor = new Fornecedor("Maria","Copacol", "21425374849-93");
            em.persist(fornecedor);

            em.getTransaction().commit();

        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
