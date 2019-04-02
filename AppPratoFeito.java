
package apppratofeito;


import javax.swing.JOptionPane;


public class AppPratoFeito {

        public static String menu() {
        String menu = "Menu Principal \n"
                + "\n"
                + "1 - Cadastrar mesa \n"
                + "2 - Imprimir mesas \n"
                + "3 - Efetuar pedidos \n"
                + "4 - Fechar conta \n"
                + "5 - Mesa com maior consumo\n"
                + "6 - Sair \n"
                + "\n";
        return menu;
    }

    public static void main(String[] args) {
        char operador = 0;
        Mesa aux;

        while (operador != '6') {
            operador = JOptionPane.showInputDialog(menu()).charAt(0);

            switch (operador) {
                case '1':
                    aux = new Mesa("");  
                    aux.setnMesa(JOptionPane.showInputDialog("Número da mesa:"));
                    if(GerenciarMesas.buscar(aux.getnMesa()) == null){
                        aux.setQtdPessoas(Integer.parseInt(JOptionPane.showInputDialog("Quantidade de pessoas:")));
                        GerenciarMesas.adicionar(aux);
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "Mesa digitada já existe.");
                    }   
                    break;

                case '2':
                    JOptionPane.showMessageDialog(null,GerenciarMesas.imprimir());
                    break;

                case '3':
                    String buscado = (JOptionPane.showInputDialog("Número da Mesa:"));
                    Mesa pedido = GerenciarMesas.buscar(buscado);

                    if (pedido != null){
                        
                        char operador2 = 's';
                        char operador3;

                        while (operador2 == 's') {
                           operador3 = JOptionPane.showInputDialog("1 - Refrigerante \n"
                                    + "2 - Cachorro-quente \n"
                                    + "3 - Batata-frita").charAt(0);
                           
                           switch (operador3) {
                               case '1':
                                  if(GerenciarMesas.regPedido(buscado,
                                           Integer.parseInt(JOptionPane.showInputDialog("Quantos refrigerantes?")),
                                           0, 0) == true){
                                   
                                   operador2 = JOptionPane.showInputDialog("Pedido feito com sucesso!"
                                            + "\n Deseja efetuar outro pedido?"
                                            + "\n 's' para sim e 'n' para não ").charAt(0);}
                                   break;
                                   
                               case '2':
                                   if(GerenciarMesas.regPedido(buscado,
                                           0,Integer.parseInt(JOptionPane.showInputDialog("Quantos cachorros-quentes?"))
                                           , 0) == true){
                                   
                                   operador2 = JOptionPane.showInputDialog("Pedido realizado com sucesso!"
                                            + "\n Deseja efetuar outro pedido?"
                                            + "\n 's' para sim e 'n' para não ").charAt(0);}
                                   
                                   break;
                                   
                               case '3':
                                    if(GerenciarMesas.regPedido(buscado,
                                           0,0,Integer.parseInt(JOptionPane.showInputDialog("Quantas batatas-fritas?"))
                                           ) == true){
                                   
                                   operador2 = JOptionPane.showInputDialog("Pedido realizado com sucesso!"
                                            + "\n Deseja efetuar outro coisa?"
                                            + "\n 's' para sim e 'n' para não ").charAt(0);}
                                   
                                   break;
                                }
                            }
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Mesa não encontrada.");
                    }
                    break;

                case '4':
                    char tipodePagamento;
                   
                    String fechar = (JOptionPane.showInputDialog("Número da Mesa:"));
                    Mesa fechamento = GerenciarMesas.buscar(fechar);

                    if (fechamento != null) {              
                        tipodePagamento = JOptionPane.showInputDialog("Selecione a forma de pagamento:"
                            + "\n 1. Dinheiro"
                            + "\n 2. Cheque"
                            + "\n 3. Cartão").charAt(0);
                  
                        switch (tipodePagamento){
                            case '1':
                                JOptionPane.showMessageDialog(null, "O valor total é: R$"+ fechamento.valorConta() *0.9 +
                                       "\n Total por pessoa: R$" +(fechamento.valorConta() *0.9)/fechamento.getQtdPessoas());
                                fechamento.setFechado(true);
                               break;

                           case '2':
                                JOptionPane.showMessageDialog(null, "O valor total é: R$"+ fechamento.valorConta() +
                                       "\n Total por pessoa: R$" + fechamento.valorConta()/fechamento.getQtdPessoas());
                                fechamento.setFechado(true);
                               break;

                           case '3':
                                JOptionPane.showMessageDialog(null, "O valor total é: R$"+ fechamento.valorConta() *0.95 +
                                       "\n Total por pessoa: R$" +(fechamento.valorConta() *0.95)/fechamento.getQtdPessoas());
                                fechamento.setFechado(true);
                               break;
                        }
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "Mesa não encontrada.");
                    }
                    break;

                case '5':
                    JOptionPane.showMessageDialog(null,GerenciarMesas.maiorConsumo());
                    break;
            }
        }
    }
}
