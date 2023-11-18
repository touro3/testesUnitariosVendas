package org.junit.jupiter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class VendaTest {
     private Venda venda;

    @BeforeEach
    void setUp() {
        venda = new Venda("Cliente Teste");
    }

    @Test
    void testAdicionarItem() {
        ItemVenda item = new ItemVenda("Produto Teste", 10.00, 1);
        venda.adicionarItem(item);
        assertEquals(10.00, venda.getValorVenda(), "O valor da venda após adicionar item está incorreto.");
    }

    @Test
    void testRemoverItem() {
        ItemVenda item = new ItemVenda("Produto Teste", 10.00, 1);
        venda.adicionarItem(item);
        venda.removerItem(item);
        assertEquals(0, venda.getValorVenda(), "O valor da venda após remover item está incorreto.");
    }

    @Test
    void testAplicarDesconto() {
        ItemVenda item = new ItemVenda("Produto Teste", 50.00, 2);
        venda.adicionarItem(item);
        venda.setValorDesconto(10.00);
        assertEquals(90.00, venda.getValorVenda(), "O valor da venda após aplicar desconto está incorreto.");
    }
}
