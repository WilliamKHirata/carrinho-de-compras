package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex01.Produto;
import br.calebe.exemplos.ex02.controller.EJBAcessoServicos;
import java.util.List;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class AcessoServicos {

    private EJBAcessoServicos controller;
    private String answer;

    public AcessoServicos() throws Exception {
        controller = new EJBAcessoServicos();
    }

    public void realizarPagamento(Integer _cartao,String _senha,List<Produto> _listaProdutos) {
        answer = controller.realizaPagamento(_cartao, _senha, _listaProdutos);
    }
    
    public void veStatusPedido(Integer _idPedido)
    {
        answer = controller.statusPedido(_idPedido);
    }
    
    public String getAnswer() {
        return answer;
    }
}
