public class Main {

    public static void main(String[] args) {
        try{
            Angulo a1 = new Angulo((float)25);

            System.out.println(a1);
            a1.setValorEmRadianos(2);
            System.out.println(a1);
            System.out.printf("Valor em radianos: %.2frad\n", a1.getValorEmRadianos());
            System.out.printf("Valor em grados: %.2fgon", a1.getValorEmGrados());
            a1.setValorEmGrados(200);
            System.out.println();
            System.out.println(a1);
            System.out.printf("%.2f°", a1.getValorEmGraus());
        }catch (Exception error){
            System.err.println(error.getMessage());
        }

    }

}
