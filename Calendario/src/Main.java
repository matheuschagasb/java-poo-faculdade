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
            System.out.print("Método getDiaSeguinte: ");
            System.out.println (d2); // 14/8/2025
            System.out.println (d1); // 13/8/2025

            d1.setAno((short)2026);
            System.out.print("Método setAno: ");
            System.out.println(d1);

            d1.retrocedaUmDia();
            System.out.print("Método retrocedaUmDia: ");
            System.out.println (d1); // 12/8/2025

            System.out.print("Metodo toString: ");
            System.out.println(d1.toString());

            System.out.print("Método equals: ");
            System.out.println(d1.equals(d2));

            System.out.print("Metodo Hashcode: ");
            System.out.println(d1.hashCode());

            System.out.print("Método compareTo: ");
            System.out.println(d1.compareTo(d2));

        }
        catch (Exception erro)
        {
            System.err.println (erro.getMessage());
        }
    }
}