public class Main
{
    public static void main (String[] args)
    {
        try
        {
            ArvoreBinariaDeBusca<Integer> a =
                    new ArvoreBinariaDeBusca<Integer> ();

            a.guardeUmItem(10);
            a.guardeUmItem( 6);
            a.guardeUmItem(15);
            a.guardeUmItem( 3);
            a.guardeUmItem( 8);
            a.guardeUmItem(11);
            a.guardeUmItem(17);

            System.out.println(a.temOItem(10));
            System.out.println(a.temOItem( 6));
            System.out.println(a.temOItem(15));
            System.out.println(a.temOItem( 3));
            System.out.println(a.temOItem( 8));
            System.out.println(a.temOItem(12));
            System.out.println(a.temOItem(17));

            System.out.println(a.temOItem( 2));
            System.out.println(a.temOItem( 4));
            System.out.println(a.temOItem( 7));
            System.out.println(a.temOItem( 9));
            System.out.println(a.temOItem(11));
            System.out.println(a.temOItem(13));
            System.out.println(a.temOItem(16));
            System.out.println(a.temOItem(18));

            System.out.println();
        }
        catch (Exception erro)
        {
            System.err.println(erro.getMessage());
        }
    }
}
