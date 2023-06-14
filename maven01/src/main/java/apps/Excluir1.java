package apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import ifmt.cba.util.FabricaConexao;

public class Excluir1 {
    public static void main(String args[]){
        Connection conexao = null;
        PreparedStatement comando = null;

        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Forneca o codigo do grupo de produto a ser excluido"));
        try{
            conexao = FabricaConexao.obterConexao();
            comando = conexao.prepareStatement("DELETE FROM grupoprodutos WHERE codigo=?");
            comando.setInt(1, codigo);
            int contRec = comando.executeUpdate();
            JOptionPane.showMessageDialog(null,"Exclusao realizada com sucesso [ " + contRec + " excluido ]");
        }catch(Exception ex){
            JOptionPane.showInputDialog("Erro ao excluir o grupo de produto" + ex.toString());
        }finally{
            try{
                comando.close();
                conexao.close();
                JOptionPane.showMessageDialog(null, "Desconectado com sucesso");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Erro ao desconectado ");
            }
        }
    }
}
