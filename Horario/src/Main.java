public class Main {

    public static void main(String[] args){
        try {
            Horario h1 = new Horario((byte) 20, (byte) 33, (byte) 51);
            System.out.println(h1.getHora() + ":" + h1.getMinuto() + ":" + h1.getSegundo());
            h1.adiante((byte) 13);
            System.out.println(h1.getHora() + ":" + h1.getMinuto() + ":" + h1.getSegundo());

            System.out.print("Metodo toString: ");
            System.out.println(h1.toString());
        }catch (Exception erro){
            System.err.println(erro.getMessage());
        }

    }

}
