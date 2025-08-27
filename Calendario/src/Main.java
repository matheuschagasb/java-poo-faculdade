public class Main
{
    public static void main (String[] args)
    {
        try
        {
            Data d1 = new Data ((byte)12,(byte)8,(short)2025);
            System.out.println (d1.getDia()+"/"+d1.getMes()+"/"+d1.getAno()); // 12/8/2025
            
            d1.avanceUmDia();
            System.out.println (d1.getDia()+"/"+d1.getMes()+"/"+d1.getAno()); // 13/8/2025

            Data d2=d1.getDiaSeguinte();
            System.out.println (d2.getDia()+"/"+d2.getMes()+"/"+d2.getAno()); // 14/8/2025
            System.out.println (d1.getDia()+"/"+d1.getMes()+"/"+d1.getAno()); // 13/8/2025
        }
        catch (Exception erro)
        {
            System.err.println (erro.getMessage());
        }
    }
}