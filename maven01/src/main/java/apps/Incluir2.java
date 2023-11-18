package apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.SQLException;
import javax.swing.JOptionPane;

import ifmt.cba.util.FabricaConexao;

public class Incluir2 {
    public static void main(String args[]){
        Connection conexao =null;
        //PreparedStatement é uma interface mais especializada de Statement , logo, lhe permite maior flexibilidade ao interagir com o SGBD, pois já vem pré pronta
        PreparedStatement comando = null;
        //  JOptionPane.showMessageDialog: mostra interface grafica com a entrada de dados
        String nome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto");
        float promocao = Float.parseFloat(JOptionPane.showInputDialog("Forneca o porcentual de promocao do grupo de produto"));
        float margem = Float.parseFloat(JOptionPane.showInputDialog("Forneca o porcentual da margem de lucro do grupo de produto"));
        try{
            conexao = FabricaConexao.obterConexao();
            comando = conexao.prepareStatement("INSERT INTO grupoprodutos (nome, promocao, margemlucro)VALUES (?, ?, ?)");
            comando.setString(1, nome);
            comando.setFloat(2, promocao);
            comando.setFloat(3, margem);
            comando.executeUpdate();
            //  JOptionPane.showMessageDialog: mostra interface grafica sem a entrada de dados
            JOptionPane.showMessageDialog(null,"Inclusao realizada com sucesso");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao incluir grupo de produto " + ex.toString());
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
