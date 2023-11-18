package apps;

import java.sql.Connection;
//import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import ifmt.cba.util.FabricaConexao;

public class Incluir1 {
    public static void main(String args[]){
        Connection conexao = null;
        //Com um objeto do tipo Statement , por exemplo, você pode enviar uma SQL para o SGBD fazer o processamento, porém sua SQL já tem que estar "pronta", com os valores embutidos nela.
        Statement comando = null;
        String nome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto");
        float promocao  = Float.parseFloat(JOptionPane.showInputDialog("Forneca o porcetual de promocao do grupo de produto"));
        float margem  = Float.parseFloat(JOptionPane.showInputDialog("Forneca o porcetual da margem de lucro do grupo de produto"));
        String sql = "INSERT INTO grupoprodutos (nome, promocao, margemlucro) VALUES";
        sql += "('" + nome + "'," + promocao + "," + margem + ")";
        try{
            conexao = FabricaConexao.obterConexao();
            comando = conexao.createStatement();
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Inclusao realizada com sucesso");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao incluir grupo de produto " + ex.toString());
        }finally{
            try{
                comando.close();
                conexao.close();
                JOptionPane.showMessageDialog(null, "Desconectado com sucesso");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar" + ex.toString());
            }
        }

    }   
}
