public class Data implements Cloneable
{
    private byte  dia, mes;
    private short ano;

    public static boolean isBissexto (short ano)
    {
        // Calendario Juliano
        if (ano<1582)
            if (ano%4==0)
                return true;
            else
                return false;

        // Calendario Gregoriano
        if (ano%400==0) return true;
        if (ano%  4==0 && ano%100!=0) return true;
        return false;
    }

    public static boolean isValida (byte dia, byte mes, short ano)
    {
        if (ano<-45) return false; // antes do Calendario Juliano
        if (ano== 0) return false; // nao existiu ano 0; do ano 1ac foi direto para o ano 1dc
        if (ano==1582 && mes==10 && dia>=5 && dia<=14) return false; // dias cortados dos calendario pelo Papa Gregorio

        if (dia<1 || dia>31 || mes<1 || mes>12) return false;

        if (dia>30 && (mes==4 || mes==6 || mes==9 || mes==11)) return false;
        if (dia>29 && mes==2) return false;
        if (dia>28 && mes==2 && !Data.isBissexto(ano)) return false;

        return true;
    }

    public /*void*/ Data (byte dia, byte mes, short ano) throws Exception
    {
        if (!Data.isValida(dia,mes,ano))
            throw new Exception ("Data invalida");

        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
    }

    public void setDia (byte dia) throws Exception
    {
        if (!Data.isValida(dia,this.mes,this.ano))
            throw new Exception ("Dia invalido");

        this.dia=dia;
    }

    public byte getDia ()
    {
        return this.dia;
    }
    
    public void setMes (byte mes) throws Exception
    {
        if (!Data.isValida(this.dia,mes,this.ano))
            throw new Exception ("Mes invalido");

        this.mes=mes;
    }

    public byte getMes ()
    {
        return this.mes;
    }
    
    public void setAno (short ano) throws Exception
    {
        if (!Data.isValida(this.dia,this.mes,ano))
            throw new Exception ("Ano invalido");

        this.ano=ano;
    }

    public short getAno ()
    {
        return this.ano;
    }
    
    public void avanceUmDia () throws Exception // altera o this
    {
        /*
        byte  dia, mes;
        short ano;
        dia = this.dia;
        mes = this.mes;
        ano = this.ano;*/

        if (!Data.isValida(dia, mes, ano))
            throw new Exception ("data invalida");

        if (dia == 31 && mes == 12){
            this.ano++;
            this.mes = (byte)1;
            this.dia = (byte)1;
        }
        else if (dia == 30 && (mes==4 || mes==6 || mes==9 || mes==11)){
            this.dia = (byte)1;
            this.mes++;
        }else if (dia == 31 && (mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes == 10 || mes==12)) {
            this.dia = (byte)1;
            this.mes++;
        }else{
            this.dia++;
        }
    }

    /*
    public Data getDiaSeguinte () // não altera o this
    {
        byte  dia, mes;
        short ano;
        dia = this.dia;
        mes = this.mes;
        ano = this.ano;

        if (!Data.isValida(dia, mes, ano)) return null;

        if (dia == 31 && mes == 12){
            ano++;
            mes = (byte)1;
            dia = (byte)1;
        }
        else if (dia == 30 && (mes==4 || mes==6 || mes==9 || mes==11)){
            dia = (byte)1;
            mes++;
        }else if (dia == 31 && (mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes == 10 || mes==12)) {
            dia = (byte)1;
            mes++;
        }else {
            dia++;
        }

        Data retorno = null;
        try{
            retorno = new Data(dia, mes, ano);
        }catch (Exception erro){}
        return retorno;
    }
     */

    public void avanceVariosDias(int qtd) throws Exception //altera o this
    {
        if(qtd <=0) throw new Exception("Quantidade inválida");
        for(int i=0;i<qtd; i++)
        {
            this.avanceUmDia();
        }
    }

    /*
    public Data getVariosDiasAdiante(int qtd) throws Exception //não altera this
    {

    }
     */

    public Data getDiaSeguinte() throws Exception
    {
        Data retorno=null;
        try
        {
            retorno = new Data(this.dia, this.mes, this.ano);
        }catch (Exception erro)
        {}
        retorno.avanceUmDia();
        return retorno;
    }

    public void retrocedaUmDia() throws Exception
    {
        if (Data.isValida((byte)(this.dia-1), this.mes, this.ano))
        {
            this.dia--;
        }
        else if (Data.isValida((byte)31, (byte)(this.mes-1), this.ano))
        {
            this.dia=(byte)31;
            this.mes--;
        }
        else if (Data.isValida((byte)30, (byte)(this.mes-1), this.ano))
        {
            this.dia=(byte)30;
            this.mes--;
        }
    }

    public void retrocedaVariosDias(int qtd) throws Exception
    {
        if(qtd<=0) throw new Exception("Quantidade inválida");

        for (int i=0; i<qtd; i++)
        {
            this.retrocedaUmDia();
        }
    }

    @Override
    public String toString()
    {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj==this) return true;
        if (obj==null) return false;
        if (obj.getClass()!=this.getClass()) return false;
        Data d = (Data)obj;
        if (d.dia!=this.dia || d.mes!=this.mes || d.ano!=this.ano) return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        int result = 1; //qlqr numero natural > 0

        result = 31 * result + new Byte(this.dia).hashCode();
        result = 31 * result + new Byte(this.mes).hashCode();
        result = 31 * result + new Short(this.ano).hashCode();

        if (result < 0) result =- result;

        return result;
    }

    public /*void*/ Data (Data modelo) throws Exception
    {
        if (modelo==null) throw new Exception("Modelo ausente");

        this.dia=modelo.dia;
        this.mes=modelo.mes;
        this.ano=modelo.ano;
    }

    @Override
    public Object clone ()
    {
        Data retorno=null;
        try
        {
            retorno = new Data (this);
        }
        catch (Exception erro)
        {} // so da erro se receber null e this nunca é null

        return retorno;
    }

}
