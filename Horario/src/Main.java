public class Main {

    public static void main(String[] args){
        Horario h1 = new Horario((byte) 20, (byte)33, (byte)51);
        System.out.println(h1.getHora()+ ":" + h1.getMinuto() + ":" + h1.getSegundo());
        h1.adiante((byte) 9);
        System.out.println(h1.getHora()+ ":" + h1.getMinuto() + ":" + h1.getSegundo());
    }



    }

}
