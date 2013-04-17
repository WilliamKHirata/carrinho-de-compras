package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Carrinho {

    private List<Produto> produtos;

    public Carrinho() {
        produtos = new ArrayList<>();
    }

    public void add(Produto produto) {
        produtos.add(produto);
    }

    public Produto menorProduto() throws CarrinhoVazioExpected {
        if (produtos.isEmpty()) {
            throw new CarrinhoVazioExpected();
        }
        Produto menor = produtos.get(0);
        for (Produto produto : produtos) {
            if (produto.getPreco() < menor.getPreco()) {
                menor = produto;
            }
        }
        return menor;
    }

    public boolean remover(Produto produto) {

        try {
            produtos.remove(produto);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Double valorAtual() {

        Double total = new Double(0);

        for (Produto prod : produtos) {
            total += prod.getPreco();
        }

        return total;
    }

    public Integer qtdeItens() {
        return produtos.size();
    }

    public List<Produto> listarItens() {
        return produtos;
    }
}
