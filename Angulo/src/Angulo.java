public class Angulo {

    private float valorEmGraus;

    public Angulo (float valorEmGraus) throws Exception
    {
        setValorEmGraus(valorEmGraus);
    }

    public void setValorEmGraus (float valorEmGraus) throws Exception
    {
        if (valorEmGraus < 0 || valorEmGraus > 360) throw new Exception("Valor inválido");

        this.valorEmGraus = valorEmGraus;
    }

    public void setValorEmGrados (float valorEmGrados)
    {
        this.valorEmGraus = valorEmGrados * (float)0.9;
    }

    public void setValorEmRadianos (float valorEmRadianos)
    {
        this.valorEmGraus = valorEmRadianos * (180 / (float)Math.PI);
    }

    public float getValorEmGraus()
    {
        return this.valorEmGraus;
    }

    public float getValorEmGrados()
    {
        return this.valorEmGraus * 10 / 9;
    }

    public float getValorEmRadianos()
    {
        return this.valorEmGraus * ((float)Math.PI / 180);
    }

    @Override
    public String toString()
    {
        return String.format("Valor em graus do angulo: %.2f°", this.valorEmGraus);
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj==this) return true;
        if (obj==null) return false;
        if (obj.getClass()!=this.getClass()) return false;
        Angulo a = (Angulo) obj;
        if (a.valorEmGraus!=this.valorEmGraus) return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        int result = 1;

        result = 31 * result + new Float(this.valorEmGraus).hashCode();

        if (result < 0) result =- result;
        return result;
    }

}
