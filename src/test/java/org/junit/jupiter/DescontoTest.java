package org.junit.jupiter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class DescontoTest {
    private Venda venda;

    @BeforeEach
    void setUp() {
        venda = new Venda("Cliente Teste");
        venda.adicionarItem(new ItemVenda("Produto 1", 100.00, 1));
        venda.adicionarItem(new ItemVenda("Produto 2", 200.00, 2));
    }

    @Test
    void testAtualizacaoValorVendaComDesconto() {
        venda.setValorDesconto(50.00);
        assertEquals(450.00, venda.getValorVenda(), "O valor da venda após aplicar desconto não está correto.");
    }

    @Test
    void testGetItens() {
        assertEquals(2, venda.getItens().size(), "A quantidade de itens na venda não está correta.");
    }

    @Test
    void testValorTotalSemItens() {
        Venda vendaVazia = new Venda("Cliente Vazio");
        assertEquals(0.00, vendaVazia.getValorVenda(), "O valor da venda sem itens deve ser zero.");
    }
}