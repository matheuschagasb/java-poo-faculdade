public class Main {

    public static void main(String[] args){
        try
        {
            Horario h1 = new Horario((byte) 20, (byte) 33, (byte) 5);
            System.out.println(h1.toString());
            h1.adiante(10);
            System.out.println(h1.toString());
            System.out.println(h1.getHorarioFuturo(60));
            System.out.println(h1.toString());
        }
        catch (Exception erro)
        {
            System.err.println(erro.getMessage());
        }
    }

}
