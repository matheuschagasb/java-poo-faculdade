public class TestePilha
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("=== TESTE 1: Construtor padrão ===");
            Pilha<Integer> p1 = new Pilha<>();
            System.out.println("Pilha criada: " + p1);
            System.out.println("Tamanho: " + p1.getTamanho());
            System.out.println();

            System.out.println("=== TESTE 2: Construtor com capacidade ===");
            Pilha<String> p2 = new Pilha<>(5);
            System.out.println("Pilha criada: " + p2);
            System.out.println("Tamanho: " + p2.getTamanho());
            System.out.println();

            System.out.println("=== TESTE 3: Inserção (guardeUmItem) ===");
            p1.guardeUmItem(10);
            p1.guardeUmItem(20);
            p1.guardeUmItem(30);
            System.out.println("Após inserir 10,20,30: " + p1);
            System.out.println("Topo: " + p1.getUmItem());
            System.out.println("Tamanho: " + p1.getTamanho());
            System.out.println();

            System.out.println("=== TESTE 4: Remoção (removaUmItem) ===");
            System.out.println("Item removido: " + p1.removaUmItem());
            System.out.println("Pilha agora: " + p1);
            System.out.println("Topo agora: " + p1.getUmItem());
            System.out.println("Tamanho agora: " + p1.getTamanho());
            System.out.println();

            System.out.println("=== TESTE 5: Teste de exceção – get de pilha vazia ===");
            Pilha<Integer> p3 = new Pilha<>();
            try {
                p3.getUmItem();
            } catch (Exception e) {
                System.out.println("Exceção capturada corretamente: " + e.getMessage());
            }
            System.out.println();

            System.out.println("=== TESTE 6: Teste de exceção – remover de pilha vazia ===");
            try {
                p3.removaUmItem();
            } catch (Exception e) {
                System.out.println("Exceção capturada corretamente: " + e.getMessage());
            }
            System.out.println();

            System.out.println("=== TESTE 7: Teste de exceção – inserir item nulo ===");
            try {
                p1.guardeUmItem(null);
            } catch (Exception e) {
                System.out.println("Exceção capturada corretamente: " + e.getMessage());
            }
            System.out.println();

            System.out.println("=== TESTE 8: Teste de pilha cheia ===");
            Pilha<Integer> p4 = new Pilha<>(2);
            p4.guardeUmItem(1);
            p4.guardeUmItem(2);
            try {
                p4.guardeUmItem(3);
            } catch (Exception e) {
                System.out.println("Exceção capturada corretamente: " + e.getMessage());
            }
            System.out.println();

            System.out.println("=== TESTE 9: Clone ===");
            Pilha<Integer> p5 = new Pilha<>();
            p5.guardeUmItem(100);
            p5.guardeUmItem(200);
            Pilha<Integer> clone = (Pilha<Integer>) p5.clone();
            System.out.println("Original: " + p5);
            System.out.println("Clone:    " + clone);
            System.out.println("Equals? " + p5.equals(clone));
            System.out.println();

            System.out.println("=== TESTE 10: Alteração no clone não altera o original ===");
            clone.removaUmItem();
            clone.guardeUmItem(999);
            System.out.println("Original: " + p5);
            System.out.println("Clone:    " + clone);
            System.out.println("Equals? " + p5.equals(clone));
            System.out.println();

            System.out.println("=== FIM DOS TESTES ===");
        }
        catch (Exception e)
        {
            System.out.println("ERRO INESPERADO: " + e.getMessage());
        }
    }
}
