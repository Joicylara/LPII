package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;

public class AppVendedor {
    public static void main(String arg[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            //instancia e persistencia de vendedor
            Vendedor vendedor = new Vendedor("Ana Claudia", "11167-0", "0954253-11", 50);
            em.persist(vendedor);

            vendedor = new Vendedor("Ana Maria", "335065-8", "556123789-80", 70);
            em.persist(vendedor);

            vendedor = new Vendedor("Ada Lovelace", "109065-9", "987123789-45", 20);
            em.persist(vendedor);

            vendedor = new Vendedor("Lua", "203065-9", "987123789-24", 80);
            em.persist(vendedor);

            em.getTransaction().commit();
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
