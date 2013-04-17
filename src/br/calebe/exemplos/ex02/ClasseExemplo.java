package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex01.Produto;
import br.calebe.exemplos.ex02.controller.EJBAcessoServicos;
import java.util.List;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class ClasseExemplo {

    private EJBAcessoServicos controller;
    private String answer;

    public ClasseExemplo() throws Exception {
        controller = new EJBAcessoServicos();
    }

    public void realizarPagamento(Integer _cartao,String _senha,List<Produto> _listaProdutos) {
        answer = controller.realizaPagamento(_cartao, _senha, _listaProdutos);
    }
    
    public String getAnswer() {
        return answer;
    }
}
