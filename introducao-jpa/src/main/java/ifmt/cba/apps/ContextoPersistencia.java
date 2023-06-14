package ifmt.cba.apps;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
//o contexto presistencia, conjunto classes que estao associados a conjuto de tabelas. Ele faz as relaçoes das tabelas com as classes
public class ContextoPersistencia {
    public static void main(String args[]){
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try{
            emf = Persistence.createEntityManagerFactory("UnidadeProdutos");//fabrica que gera a persistencia da entidade
            em = emf.createEntityManager();// o que realiza a comunicacao com o banco de dados
            System.out.println("Contexto de persistencia criado com sucesso");
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Contexto de persistencia nao foi criado - " + ex.getMessage());
        }finally{
            if(em != null){
                em.close();
            }
            if(emf != null){
                emf.close();
            }
        }
    }
}
