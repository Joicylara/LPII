package ifmt.cba.apps;

import java.util.List;

import javax.swing.JOptionPane;

import ifmt.cba.vo.GrupoProdutoVO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
// diferente da JDBC as alteracoes sao feitos com a chave primaria, a JPA recupera(para isso tem q buscar) o objeto do banco, altera o que em q ser alterado depois faz um merge
public class Alterar1 {
    public static void main(String args[]){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        GrupoProdutoVO grupoVO = null;
        try{
            emf = Persistence.createEntityManagerFactory("UnidadeProdutos");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            String pNome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto a ser localizado");
            // Query objeto de consulta da JPA
            Query consulta = em.createQuery("SELECT gp FROM GrupoProdutoVO gp WHERE UPPER(gp.nome) = :pNome ");//faz referencia a classe referente a os objetos da tabela, parametro JPA,
            consulta.setParameter("pNome", pNome.toUpperCase());
            List<GrupoProdutoVO> lista = consulta.getResultList();// o getResultList faz tudo o que foi trabalhoso fazer no ResultSet
            if(lista.size() > 0){
                grupoVO = lista.get(0);
                String nome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto", grupoVO.getNome());
                float margem = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual da marge de lucro do grupo de produto", grupoVO.getMargemLucro()));
                float promocao = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual de promocao do grupo de produto", grupoVO.getPromocao()));
                //popular o objeto grupoVO
                grupoVO.setNome(nome);
                grupoVO.setMargemLucro(margem);
                grupoVO.setPromocao(promocao);
                em.merge(grupoVO);// faz um update
                em.getTransaction().commit();//confirmar a atualizacao
                System.out.println("Alteracao realizada com sucesso");
            }else{
                System.out.println("Grupo de produto nao localizado");
            }
        }catch(Exception ex){
            System.out.println("Alteracao nao realizada - " + ex.getMessage());
        }finally{
            //destruindo o contexto de persistencia
            if(em != null){
                 em.close();
            }
            if(emf != null){
                emf.close();
            }
         }
    }    
}
