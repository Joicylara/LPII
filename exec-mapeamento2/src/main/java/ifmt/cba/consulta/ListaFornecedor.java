package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")

/*Listar todos os fornecedores cadastrados, ordenados por razão social (código e nome) e os 
produtos que ele fornece (código, nome do produto);*/
public class ListaFornecedor {
    public static void main(String ard[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
           
            Query query = em.createQuery("SELECT fornecedor FROM Fornecedor fornecedor ORDER BY fornecedor.razaoSocial");
            List <Fornecedor> listaFornecedor = query.getResultList();
            //nome do fornecedor e o produto que esta relacionado ao fonercedor
            for(Fornecedor fornecedor : listaFornecedor){
                System.out.println("Codigo: " +fornecedor.getCodigo());
                System.out.println("Razao Social: " +fornecedor.getRazaoSocial());
              
                for(Produto produto : fornecedor.getListaProduto()){
                    System.out.println("\nDados do produto fornecido");
                    System.out.println("Codigo: " +produto.getCodigo());
                    System.out.println("Nome: " +produto.getNome());
                }
            System.out.println("---------------------------------------------------------");
            }
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
