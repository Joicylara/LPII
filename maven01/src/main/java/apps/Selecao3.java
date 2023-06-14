package apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import javax.swing.JOptionPane;
import ifmt.cba.util.FabricaConexao;

public class Selecao3 {

    public static void main(String args[]){
        Connection conexao = null;
        PreparedStatement comando = null;
        String nome = JOptionPane.showInputDialog(null,"Forneca parte do nome a ser pesquisado");
        try{
            conexao = FabricaConexao.obterConexao();
            comando = conexao.prepareStatement("SELECT * FROM grupoprodutos WHERE upper(nome) LIKE ?");
            comando.setString(1, "'%" + nome.toUpperCase() + "%'");
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                do{
                    JOptionPane.showMessageDialog(null,"Codigo: "+ resultado.getInt("codigo")+"\nNome: " + resultado.getString("nome")+"\n%Promocao: "+ resultado.getFloat("promocao")+"\n%Margem lucro: "+ resultado.getFloat("margemlucro"));
                } while(resultado.next());
                }else {
                    JOptionPane.showMessageDialog(null, "Nao encontrado");
                }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao recuperar um grupo" +ex.toString());
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
