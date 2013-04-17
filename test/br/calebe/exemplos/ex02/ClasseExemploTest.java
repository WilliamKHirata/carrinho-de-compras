package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex01.Carrinho;
import br.calebe.exemplos.ex01.Produto;
import br.calebe.exemplos.ex02.controller.EJBAcessoServicos;
import junit.framework.Assert;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({AcessoServicos.class})
public class ClasseExemploTest {

    private Carrinho carrinho;

    @Before
    public void criandoCarrinho() {
        carrinho = new Carrinho();
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto deitel = new Produto("Java: como programar", 150.00);
        carrinho.add(deitel);
    }

    @Test
    public void testePagamento() throws Exception {
        EJBAcessoServicos controllerMock = PowerMock.createMock(EJBAcessoServicos.class);
        PowerMock.expectNew(EJBAcessoServicos.class).andReturn(controllerMock);
        EasyMock.expect(controllerMock.realizaPagamento(10, "pass", carrinho.listarItens())).andReturn("Pagamento Ok!");
        PowerMock.replay(controllerMock, EJBAcessoServicos.class);

        AcessoServicos tested = new AcessoServicos();
        tested.realizarPagamento(10, "pass", carrinho.listarItens());

        Assert.assertEquals("Pagamento Ok!", tested.getAnswer());
        PowerMock.verifyAll();
    }

    @Test
    public void testeStatusPedidoAguardandoPagamento() throws Exception {
        EJBAcessoServicos controllerMock = PowerMock.createMock(EJBAcessoServicos.class);
        PowerMock.expectNew(EJBAcessoServicos.class).andReturn(controllerMock);
        EasyMock.expect(controllerMock.statusPedido(1)).andReturn("Aguardando pagamento");
        PowerMock.replay(controllerMock, EJBAcessoServicos.class);

        AcessoServicos tested = new AcessoServicos();
        tested.veStatusPedido(1);

        Assert.assertEquals("Aguardando pagamento", tested.getAnswer());
        PowerMock.verifyAll();
    }

    @Test
    public void testeStatusPedidoEntregue() throws Exception {
        EJBAcessoServicos controllerMock = PowerMock.createMock(EJBAcessoServicos.class);
        PowerMock.expectNew(EJBAcessoServicos.class).andReturn(controllerMock);
        EasyMock.expect(controllerMock.statusPedido(1)).andReturn("Pedido entregue");
        PowerMock.replay(controllerMock, EJBAcessoServicos.class);

        AcessoServicos tested = new AcessoServicos();
        tested.veStatusPedido(1);

        Assert.assertEquals("Pedido entregue", tested.getAnswer());
        PowerMock.verifyAll();
    }
}
