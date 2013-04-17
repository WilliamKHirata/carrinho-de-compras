package br.calebe.exemplos.ex02.controller;

import br.calebe.exemplos.ex01.Produto;
import br.calebe.exemplos.ex02.EJBStatelessPagamentoCartao;
import br.calebe.exemplos.ex02.EJBStatelessStatusPedido;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class EJBAcessoServicos {

    private EJBStatelessPagamentoCartao ejbPagamento;
    private EJBStatelessStatusPedido ejbStatus;

    public EJBAcessoServicos() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        ejbPagamento = (EJBStatelessPagamentoCartao) ctx.lookup("ejb/EJBStatelessPagamento");
        ejbStatus = (EJBStatelessStatusPedido) ctx.lookup("ejb/EJBStatelessStatus");
    }
    
    public String realizaPagamento(Integer _cartao,String _senha,List<Produto> _listaProdutos)
    {
        return ejbPagamento.realizaPagamento(_cartao,_senha,_listaProdutos);
    }
    
    public String statusPedido(Integer _idPedido)
    {
        return ejbStatus.statusPedido(_idPedido);
    }

//    @Override
//    public String metodo(int i) {
//        return ejb.metodo(i);
//    }
}
