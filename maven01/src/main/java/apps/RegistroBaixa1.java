package apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import ifmt.cba.util.FabricaConexao;

public class RegistroBaixa1 {
    private static Connection conexao = null;
    private static enum MotivoEnum{
        VENCIMENTO, DEFEITO
    };
    static{
        try{
            conexao = FabricaConexao.obterConexao();
        }catch(Exception ex){
            System.out.println("Erro ao conectar no banco de dados");
        }
    }
    public static void main(String args[]){
        PreparedStatement comandoRegistroBaixa;
        PreparedStatement comandoBaixaEstoque;
        PreparedStatement comandoSelecaoProduto;
        int estoqueAtualProduto = 0;
        Map<String, Integer> listaProdutos = obterProdutos();
        MotivoEnum motivo = (MotivoEnum) JOptionPane.showInputDialog(null, "Escolha o motivo da baixa de estoque", "Motivos de baixa", JOptionPane.QUESTION_MESSAGE, null, MotivoEnum.values(), MotivoEnum.values()[0]);
        java.sql.Date dataBaixa = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        int quantidadeBaixa = Integer.parseInt(JOptionPane.showInputDialog("Forneca a quantidade a ser retirado do estoque do produto"));
        String nomeProduto = (String) JOptionPane.showInputDialog(null, "Escolha o produto", "Produtos", JOptionPane.QUESTION_MESSAGE, null, listaProdutos.keySet().toArray(), listaProdutos.keySet().toArray()[0]);
        int codigoProduto = listaProdutos.get(nomeProduto);
        try{
            conexao.setAutoCommit(false);
            comandoRegistroBaixa = conexao.prepareStatement("INSERT INTO registrobaixa(motivo, data, quantidade, produtos)" +"VALUES (?, ?, ?, ?)");
            comandoRegistroBaixa.setInt(1, motivo.ordinal());
            comandoRegistroBaixa.setDate(2, dataBaixa);
            comandoRegistroBaixa.setFloat(3, quantidadeBaixa);
            comandoRegistroBaixa.setInt(4, codigoProduto);
            comandoRegistroBaixa.executeQuery();
            comandoSelecaoProduto = conexao.prepareStatement("SELECT estoque FROM produtos WHERE codigo=?");
            comandoSelecaoProduto.setInt(1, codigoProduto);
            ResultSet resultado = comandoSelecaoProduto.executeQuery();
            if(resultado.next()){
                estoqueAtualProduto = resultado.getInt("estoque");
            }
            comandoBaixaEstoque = conexao.prepareStatement("UPDATE produtos SET estoque =? WHERE codigo =?");
            comandoBaixaEstoque.setInt(1, estoqueAtualProduto -quantidadeBaixa);
            comandoBaixaEstoque.setInt(2, codigoProduto);
            comandoBaixaEstoque.executeUpdate();
            conexao.commit(); //efetiva as duas operacoes(inclusao e alteracao)
            System.out.println("Registro de baixa realizado com sucesso");
            comandoRegistroBaixa.close();
            comandoBaixaEstoque.close();
            comandoSelecaoProduto.close();
            conexao.close();
        }catch(SQLException sqle){
            System.out.println("Erro no registro de baixa de estoque " +sqle.toString());
            try{
                conexao.rollback();//cancela todas as operacoes dps de setAutoCommit(false)
                System.out.println("Rollback executado");
            }catch(SQLException ex1){
                System.out.println("Erro no rollback" +ex1.toString());
            }
        }
    }
    public static Map<String, Integer> obterProdutos(){
        Map<String, Integer> listaGrupos = new HashMap<>();
        PreparedStatement comando;
        try{
            comando = conexao.prepareStatement("SELECT * FROM produtos ORDER BY nome");
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                listaGrupos.put(resultado.getString("nome"), resultado.getInt("codigo"));
            }
            resultado.close();
            comando.close();
        }catch(SQLException sqle){
            System.out.println("Erro ao recuperar os produtos" +sqle.toString());
        }
        return listaGrupos;
    }
}
