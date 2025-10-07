import java.lang.reflect.*;

public class ArvoreBinariaDeBusca <X extends Comparable<X>>
{
    private class No
    {
        private No esq;
        private X  info;
        private No dir;

        public No (No e, X i, No d)
        {
            this.esq  = e;
            this.info = i;
            this.dir  = d;
        }

        public No (X i)
        {
            this.esq  = null;
            this.info = i;
            this.dir  = null;
        }

        public No getEsq ()
        {
            return this.esq;
        }

        public X getInfo ()
        {
            return this.info;
        }

        public No getDir ()
        {
            return this.dir;
        }

        public void setEsq (No e)
        {
            this.esq = e;
        }

        public void setInfo (X i)
        {
            this.info = i;
        }

        public void setDir (No d)
        {
            this.dir = d;
        }
    } //fim da classe No

    private No raiz;

    public void guardeUmItem (X i) throws Exception
    {
        if (i==null) throw new Exception ("Informacao ausente");

        if (this.raiz==null)
        {
            this.raiz = new No (i);
            return;
        }

        No atual=this.raiz;
        for(;;) // forever
        {
            int comparacao=i.compareTo(atual.getInfo());

            if (comparacao==0) throw new Exception ("Elemento repetido");

            if (comparacao<0)
            {
                if (atual.getEsq()==null)
                {
                    atual.setEsq (new No (i));
                    return;
                }
                else
                    atual=atual.getEsq();
            }
            else // comparacao>0
            {
                if (atual.getDir()==null)
                {
                    atual.setDir (new No (i));
                    return;
                }
                else
                    atual=atual.getDir();
            }
        }
    }

    public boolean temOItem (X i) throws Exception
    {
        if (i==null) throw new Exception ("Informacao ausente");

        if (this.raiz==null) return false;

        No atual=this.raiz;
        while (atual!=null)
        {
            int comparacao=i.compareTo(atual.getInfo());
            if (comparacao==0) return true;
            if (comparacao<0)
                atual=atual.getEsq();
            else // comparacao>0
                atual=atual.getDir();
        }
        return false;
    }

    private int getAltura (No r)
    {
        if (r==null) return 0;

        int alturaDaSubarvoreEsquerda = this.getAltura(r.getEsq()),
                alturaDaSubarvoreDireita  = this.getAltura(r.getDir());

        return alturaDaSubarvoreEsquerda>alturaDaSubarvoreDireita
                ?alturaDaSubarvoreEsquerda+1
                :alturaDaSubarvoreDireita +1;
    }

    public int getAltura ()
    {
        return this.getAltura(this.raiz);
    }

    private int getQuantidadeDeNos (No r)
    {
        if (r==null) return 0;

        int qtsNosHaNaSubarvoreEsquerda = this.getQuantidadeDeNos(r.getEsq()),
                qtsNosHaNaSubarvoreDireita  = this.getQuantidadeDeNos(r.getDir());

        return qtsNosHaNaSubarvoreEsquerda+1+qtsNosHaNaSubarvoreDireita;
    }

    public int getQuantidadeDeNos ()
    {
        return this.getQuantidadeDeNos(this.raiz);
    }

    private boolean isBalanceada(No r)
    {
        if (r==null) return true;

        int qtsNosHaNaSubarvoreEsquerda = this.getQuantidadeDeNos(r.getEsq());
        int qtsNosHaNaSubarvoreDireita  = this.getQuantidadeDeNos(r.getDir());
        int diferenca = qtsNosHaNaSubarvoreEsquerda - qtsNosHaNaSubarvoreDireita;

        if( diferenca < -1 || diferenca > 1) return false;

        return this.isBalanceada(r.getEsq()) && this.isBalanceada(r.getDir());
    }

    public boolean isBalanceada()
    {
        return this.isBalanceada(this.raiz);
    }

    /*
    public void balanceieSe()
    {

    }
    */
    // faça um metodo para balancear a arvore.
    // balanceadas sao as arvores CUJOS NÓS (todos eles) têm a diferença da
    // quantidade de nós de suas subárvores esquerda e direita entre -1 e 1.

} // fim da classe ArvoreBinariaDeBusca