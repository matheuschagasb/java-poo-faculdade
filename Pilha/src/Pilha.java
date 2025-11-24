import java.util.Arrays;

public class Pilha <X> implements Cloneable
{
    private X[] elemento;
    private int ultimo;     // (-1 quando vazio)

    public Pilha()
    {
        this.elemento = (X[]) new Object[10]; // capacidade padrão = 10
        this.ultimo   = -1;
    }

    public Pilha(int capacidade) throws Exception
    {
        if (capacidade <= 0) throw new Exception("Capacidade invalida");

        this.elemento = (X[]) new Object[capacidade];
        this.ultimo   = -1;
    }

    public void guardeUmItem(X num) throws Exception
    {
        if (num == null) throw new Exception("Informacao ausente");

        if (this.ultimo == this.elemento.length - 1) throw new Exception("Pilha cheia");

        this.ultimo++;
        this.elemento[this.ultimo] = num;
    }

    public X getUmItem() throws Exception
    {
        if (this.ultimo == -1) throw new Exception("Pilha vazia");

        return this.elemento[this.ultimo];
    }

    public X removaUmItem() throws Exception
    {
        if (this.ultimo == -1) throw new Exception("Pilha vazia");

        X retorno = this.elemento[this.ultimo];
        this.elemento[this.ultimo] = null;
        this.ultimo--;

        return retorno;
    }

    public int getTamanho()
    {
        return this.ultimo + 1;
    }

    @Override
    public String toString() {
        return (ultimo == -1)
                ? "Pilha vazia"
                : Arrays.toString(Arrays.copyOf(elemento, ultimo + 1));
    }


    @Override
    public boolean equals (Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Pilha<?> p = (Pilha<?>) obj;

        if (p.ultimo != this.ultimo) return false;

        for (int i = 0; i <= this.ultimo; i++)
        {
            if (!this.elemento[i].equals(p.elemento[i]))
                return false;
        }

        return true;
    }


    @Override
    public int hashCode()
    {
        int result = 1;
        result = 31 * result + this.ultimo;

        for (int i = 0; i <= this.ultimo; i++)
        {
            if (this.elemento != null) result = 31 * result + this.elemento[i].hashCode();
        }
        if (result < 0) result = -result;
        return result;
    }

    public Pilha(Pilha<X> modelo) throws Exception
    {
        if (modelo == null) throw new Exception("Modelo ausente");

        X[] novo = (X[]) new Object[modelo.elemento.length];

        for (int i = 0; i <= modelo.ultimo; i++)
        {
            novo[i] = modelo.elemento[i];
        }

        this.elemento = novo;
        this.ultimo   = modelo.ultimo;
    }

    @Override
    public Object clone()
    {
        Pilha<X> retorno = null;

        try
        {
            retorno = new Pilha<X>(this);
        }
        catch (Exception erro)
        {}

        return retorno;
    }
}
