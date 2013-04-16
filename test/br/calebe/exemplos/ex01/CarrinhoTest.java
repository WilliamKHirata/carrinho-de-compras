package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

	private Carrinho carrinho;

	@Before
	public void criandoCarrinho() {
		carrinho = new Carrinho();
	}

	@Test(expected = CarrinhoVazioExpected.class)
	public void colocandoZeroProduto() throws CarrinhoVazioExpected {
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { null }, new Object[] { menor });
	}

	@Test
	public void colocandoUmProduto() throws CarrinhoVazioExpected {
		Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { livro }, new Object[] { menor });
	}

	@Test
	public void colocandoMaisProdutos() throws CarrinhoVazioExpected {
		Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Produto deitel = new Produto("Java: como programar", 150.00);
		carrinho.add(deitel);
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { livro }, new Object[] { menor });
	}

	@Test
	public void identidadeDeProdutos() throws CarrinhoVazioExpected {
		Produto original = new Produto("Java em 24 horas", 50.00);
		carrinho.add(original);
		Produto copia = new Produto("Java em 24 horas", 50.00);
		original = carrinho.menorProduto();
		assertArrayEquals(new Object[] { original }, new Object[] { copia });
	}
        
        @Test
        public void removerProdutoDoCarrinho(){
            Produto original = new Produto("Java em 24 horas", 50.00);
            carrinho.add(original);
            assertTrue(carrinho.remover(original));
        }
        
        @Test
        public void somarValoresDosProdutos(){
            Produto original = new Produto("Java em 24 horas", 50.00);
            carrinho.add(original);
            Produto copia = new Produto("Java em 24 horas", 50.00);
            carrinho.add(copia);
            
            assertEquals(new Double(100.00), carrinho.valorAtual());
	
        }
        
        @Test
        public void qtdeDeItensDoCarrinho(){
            
            Produto original = new Produto("Java em 24 horas", 50.00);
            carrinho.add(original);
            Produto copia = new Produto("Java em 24 horas", 50.00);
            carrinho.add(copia);

            assertEquals(new Integer(2), carrinho.qtdeItens());
            
        }

        @Test
        public void listarItensDoCarrinho(){
            
            Produto original = new Produto("Java em 24 horas", 50.00);
            carrinho.add(original);
            Produto copia = new Produto("Java em 24 horas", 50.00);
            carrinho.add(copia);
            
            List<Produto> listaItens = new ArrayList<>();
            listaItens.add(copia);
            listaItens.add(original);
            assertEquals(listaItens, carrinho.listarItens()); 
            
        }
        
}
