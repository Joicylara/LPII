package ifmt.cba.apps;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.GrupoProduto;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
public class appRelProduto {

    public static void main(String arg[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            //relacao com GrupoProduto (N -> 1)
            Query query = em.createQuery("SELECT grupoproduto FROM GrupoProduto grupoproduto WHERE grupoproduto.nome = 'Frios'");
            GrupoProduto grupoProduto = (GrupoProduto)query.getSingleResult();

            Produto produto = new Produto("Frango", 25.80f);
            produto.setGrupoProduto(grupoProduto);
            em.persist(produto);

            produto = new Produto("Carne", 55.80f);
            produto.setGrupoProduto(grupoProduto);
            em.persist(produto);

            produto = new Produto("Sorvete", 15.80f);
            produto.setGrupoProduto(grupoProduto);
            em.persist(produto);

            produto = new Produto("Queijo", 9.80f);
            produto.setGrupoProduto(grupoProduto);
            em.persist(produto);

            produto = new Produto("Peixe", 150.60f);
            produto.setGrupoProduto(grupoProduto);
            em.persist(produto);

            query = em.createQuery("SELECT grupoproduto FROM GrupoProduto grupoproduto WHERE grupoproduto.nome = 'Padaria'");
            grupoProduto = (GrupoProduto)query.getSingleResult();

            produto = new Produto("Massa de pizza", 15.80f);
            produto.setGrupoProduto(grupoProduto);
            em.persist(produto);

            produto = new Produto("Pao de queijo", 9.80f);
            produto.setGrupoProduto(grupoProduto);
            em.persist(produto);

            produto = new Produto("Pao doce", 5.60f);
            produto.setGrupoProduto(grupoProduto);
            em.persist(produto);

            query = em.createQuery("SELECT grupoproduto FROM GrupoProduto grupoproduto WHERE grupoproduto.nome = 'Alimentos'");
            grupoProduto = (GrupoProduto)query.getSingleResult();

            produto = new Produto("Massa de tomate", 1.80f);
            produto.setGrupoProduto(grupoProduto);
            em.persist(produto);

            produto = new Produto("Macarrao", 9.80f);
            produto.setGrupoProduto(grupoProduto);
            em.persist(produto);

            produto = new Produto("oleo", 5.60f);
            produto.setGrupoProduto(grupoProduto);
            em.persist(produto);

            //relacao com fornecedor (N-> N)
            Query query2 = em.createQuery("SELECT fornecedor FROM Fornecedor fornecedor");
            List<Fornecedor> listaFornecedor = query2.getResultList();
 
            query2 =  em.createQuery("SELECT produto FROM Produto produto");
            List<Produto> listaProduto = query2.getResultList();
 
            Produto produto2 = listaProduto.get(0);
            produto2.setListaFornecedor(listaFornecedor.subList(0, 2));
            em.persist(produto2);
 
            produto2 = listaProduto.get(1);
            produto2.setListaFornecedor(listaFornecedor.subList(2, 3));
            em.persist(produto2);
            
            produto2 = listaProduto.get(2);
            produto2.setListaFornecedor(listaFornecedor.subList(1, 2));
            em.persist(produto2);


            em.getTransaction().commit();

        }catch(Exception ex){
            System.out.println(ex.toString());
        }    
    }        
}
