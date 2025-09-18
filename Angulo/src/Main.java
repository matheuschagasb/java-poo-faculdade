public class Main
{

    public static void main(String[] args)
    {
        Angulo a1 = null;

        //criando o angulo
        try
        {
            a1 = new Angulo((float)25);
        }
        catch (Exception erro)
        {
            System.err.println ("Erro ao criar o angulo: " + erro.getMessage());
        }

        //settando valor em radianos
        try
        {
            if (a1 != null)
            {
                a1.setValorEmRadianos(2);
                System.out.println(a1); //114,59°
                System.out.printf("Valor em radianos: %.2frad\n", a1.getValorEmRadianos()); //2rad
            }
        }
        catch (Exception erro)
        {
            System.err.println("Erro ao settar valor em radianos: " + erro.getMessage());
        }

        //settando valor em grados
        try
        {
            if (a1 != null)
            {
                a1.setValorEmGrados(200);
                System.out.println(a1); //180,00°
                System.out.printf("Valor em grados: %.2f gon\n", a1.getValorEmGrados()); //200gon
                System.out.printf("Valor em graus: %.2f°\n", a1.getValorEmGraus()); //180,00°
            }
        }
        catch (Exception erro)
        {
            System.err.println("Erro ao settar valor em grados: " + erro.getMessage());
        }
    }
}
