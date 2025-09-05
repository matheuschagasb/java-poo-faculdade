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
        if (hora < 0 || hora > 25)
        {
            throw new Exception("Hora inválida");
        }
        this.hora=hora;
    }

    public void setMinuto (byte minuto) throws Exception
    {
        if (minuto < 0 || minuto > 59)
        {
            throw new Exception("Minuto inválido");
        }
        this.minuto=minuto;
    }

    public void setSegundo (byte segundo) throws Exception
    {
        if (segundo < 0 || segundo > 59)
        {
            throw new Exception("Segundo inválido");
        }
        this.segundo=segundo;
    }

    public String getHora()
    {
        return (this.hora<10?"0":"")+this.hora;
    }

    public String getMinuto()
    {
        return (this.minuto<10?"0":"")+this.minuto;
    }

    public String getSegundo()
    {
        return (this.segundo<10?"0":"")+this.segundo;
    }


    public void adiante(int qtdSegundos) throws Exception
    {
        if (qtdSegundos <=0) throw new Exception("Quantidade inválida");
        int horarioSegundos = this.hora*3600+
                      this.minuto*60+
                      this.segundo;

        horarioSegundos += qtdSegundos;

        this.hora = (byte) (horarioSegundos /3600);
        horarioSegundos = horarioSegundos %3600;
        this.minuto = (byte) (horarioSegundos /60);
        this.segundo = (byte) (horarioSegundos %60);
    }

    public void retroceda (int qtdSegundos) throws Exception
    {
        if (qtdSegundos <=0) throw new Exception("Quantidade inválida");
        int horarioSegundos = this.hora*3600+
                this.minuto*60+
                this.segundo;

        horarioSegundos -= qtdSegundos;

        this.hora = (byte) (horarioSegundos /3600);
        horarioSegundos = horarioSegundos %3600;
        this.minuto = (byte) (horarioSegundos /60);
        this.segundo = (byte) (horarioSegundos %60);
    }

    public Horario getHorarioFuturo (int qtdSegundos) throws Exception // nao altera o this
    {
       Horario retorno = null;
       try{
           retorno = new Horario(this.hora, this.minuto, this.segundo);
       }
       catch (Exception erro)
       {}
       retorno.adiante(qtdSegundos);
       return retorno;
    }

    public Horario getHorarioPassado (int qtdSegundos) throws Exception // nao altera o this
    {
       Horario retorno = null;
       try{
           retorno = new Horario(this.hora, this.minuto, this.segundo);
       }
       catch (Exception erro)
       {}
       retorno.retroceda(qtdSegundos);
       return retorno;
    }

    @Override
    public String toString()
    {

        return (this.hora<10?"0":"")+this.hora+":"+
                (this.minuto<10?"0":"")+this.minuto+":"+
                (this.segundo<10?"0":"")+this.segundo;
    }

    @Override
    public boolean equals (Object obj)
    {
        if(obj==this) return true;
        if(obj==null) return false;
        if(obj.getClass()!=this.getClass()) return false;
        Horario h = (Horario) obj;
        if (h.hora != this.hora ||
            h.minuto != this.minuto ||
            h.segundo != this.segundo) return false;
        return true;
    }

}
