public class Horario {

    private byte hora, minuto, segundo;

    public Horario (byte hora, byte minuto, byte segundo)throws Exception
    {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    public void setHora (byte hora) throws Exception
    {
        if (hora < 0 || hora > 25){
            throw new Exception("Hora inválida");
        }
        this.hora=hora;
    }

    public void setMinuto (byte minuto) throws Exception
    {
        if (minuto < 0 || minuto > 59) {
            throw new Exception("Minuto inválido");
        }
        this.minuto=minuto;
    }

    public void setSegundo (byte segundo) throws Exception
    {
        if (segundo < 0 || segundo > 59){
            throw new Exception("Segundo inválido");
        }
        this.segundo=segundo;
    }

    public byte getHora()
    {
        return this.hora;
    }

    public byte getMinuto()
    {
        return this.minuto;
    }

    public byte getSegundo()
    {
        return this.segundo;
    }


    public void adiante(byte qtdSegundos) throws Exception
    {
        byte novosSegundos = (byte) (this.segundo+qtdSegundos);
        if (novosSegundos > 59){
            this.minuto++;
            novosSegundos=(byte)0;
        }
        this.segundo = novosSegundos;
    }

    /*
    public void retroceda (byte qtdSegundos) throws Exception
    {
        segundo
    }
     */



}
