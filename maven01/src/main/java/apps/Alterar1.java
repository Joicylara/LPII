package apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import ifmt.cba.util.FabricaConexao;

public class Alterar1 {
    public static void main(String args[]){
        Connection conexao = null;
        PreparedStatement comando = null;

        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Forneca o codigo do grupo de produtos a ser alterado"));
        float promocao = Integer.parseInt(JOptionPane.showInputDialog(null, "Forneca o valor da promocao"));
        float margem = Integer.parseInt(JOptionPane.showInputDialog(null, "Forneca o valor da margem de lucro"));
    
        try{
            conexao = FabricaConexao.obterConexao();
            comando = conexao.prepareStatement("UPDATE grupoprodutos SET promocao=?, margemlucro=? WHERE codigo=?");
            comando.setFloat(1, promocao);
            comando.setFloat(2, margem);
            comando.setInt(3, codigo);
            int contRec = comando.executeUpdate();
            JOptionPane.showMessageDialog(null,"Alteracao realizada com sucesso");
            JOptionPane.showMessageDialog(null, "Numero de registros alterados: " + contRec);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao alterar o grupo" + ex.toString());
        }finally{
            try{
                comando.close();
                conexao.close();
                JOptionPane.showMessageDialog(null, "Desconectado com sucesso");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Erro ao desconectar" + ex.toString());
            }
        }
    }
}
