public class Main
{
    public static void main (String[] args)
    {
        try
        {
            Data d1 = new Data ((byte)12,(byte)8,(short)2025);
            System.out.println(d1); // 12/8/2025

            System.out.print("Método get dia: ");
            System.out.println(d1.getDia()); // 12

            d1.avanceUmDia();
            System.out.print("Método avance um dia: ");
            System.out.println (d1); // 13/8/2025

            Data d2=d1.getDiaSeguinte();
            System.out.println();
            System.out.println (d2); // 14/8/2025
            System.out.println (d1); // 13/8/2025

            d1.retrocedaUmDia();
            System.out.println (d1); // 12/8/2025

            System.out.print("Metodo toString: ");
            System.out.println(d1);

            System.out.print("Metodo Hashcode: ");
            System.out.println(d1.hashCode());
        }
        catch (Exception erro)
        {
            System.err.println (erro.getMessage());
        }
    }
}