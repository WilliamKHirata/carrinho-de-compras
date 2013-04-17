package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex01.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Remote
public interface EJBStatelessPagamentoCartao {

    public String realizaPagamento(Integer _cartaoCredito,String _senha,List<Produto> _listaProdutos);
}
