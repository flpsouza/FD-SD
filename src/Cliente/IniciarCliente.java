package Cliente;


import Servidor.InterfaceProduto;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

public class IniciarCliente {
   
    public static void main(String[] args) {
        try{
            InterfaceProduto produtoRemoto = (InterfaceProduto) Naming.lookup("rmi://127.0.0.1:1099/Produto");
            
            String valor_descrição = JOptionPane.showInputDialog(null, "Qual Produto quer cadastrar?", "Entrada de dados", JOptionPane.QUESTION_MESSAGE);
            String valor_preco = JOptionPane.showInputDialog(null, "Qual o preço desse Produto?", "Entrada de dados", JOptionPane.QUESTION_MESSAGE);
            String valor_dquantidade = JOptionPane.showInputDialog(null, "Qual a quantidade?", "Entrada de dados", JOptionPane.QUESTION_MESSAGE);
            
            String descricao = valor_descrição;
            double preco = Double.parseDouble(valor_preco);
            int quantidade = Integer.parseInt(valor_dquantidade);
            
            produtoRemoto.setDescricao(valor_descrição);
            produtoRemoto.setPreco(preco);
            produtoRemoto.setQuntidade(quantidade);
            
            String texto_retorno = "\n Descrição: "+produtoRemoto.getDescricao()
                    +"\n Preço: "+produtoRemoto.getPreco()
                    +"\n Quantidade: " +produtoRemoto.getQuntidade();
            
            produtoRemoto.getDescricao();
            produtoRemoto.getPreco();
            produtoRemoto.getQuntidade();
            
            JOptionPane.showMessageDialog(null, texto_retorno, "Dados do Produto", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(RemoteException re){
            JOptionPane.showMessageDialog(null,"Erro remoto: " +re.toString(), "Erro Remoto", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro Local: " +e.toString(), "Erro Local", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
