package apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import javax.swing.JOptionPane;
import ifmt.cba.util.FabricaConexao;

public class Selecao1 {
    public static void main(String args[]){
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = FabricaConexao.obterConexao();
            comando = conexao.prepareStatement("SELECT * FROM grupoprodutos ORDER BY nome");
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                JOptionPane.showMessageDialog(null,"Codigo: "+ resultado.getInt("codigo")+"\nNome: " + resultado.getString("nome")+"\n%Promocao: "+ resultado.getFloat("promocao")+"\n%Margem lucro: "+ resultado.getFloat("margemlucro"));
            }
            resultado.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao recuperar os grupos de produtos" +ex.toString());
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
