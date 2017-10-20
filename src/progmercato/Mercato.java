package progmercato;

import java.io.*;

public class Mercato 
{
    private String nome;
    private float prezzo;
    private float quantita;
    private float soglia;
    private float prezzofinale;
    private int percsconto; //percentuale di sconto
    private boolean scontoapplicato;
    private float prezzoscontato;

    public Mercato(String nome, float prezzo, float quantita) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }
    public String getNome() {
        return nome;
    }
    public float getPrezzo() {
        return prezzo;
    }
    public float getQuantita() {
        return quantita;
    }
    public float getPrezzofinale() {
        return prezzofinale;
    }

    public void setPrezzofinale(float prezzofinale) {
        this.prezzofinale = prezzofinale;
    }

    public float getSoglia() {
        return soglia;
    }

    public void setSoglia(float soglia) {
        this.soglia = soglia;
    }

    public int getPercsconto() {
        return percsconto;
    }

    public void setPercsconto(int percsconto) {
        this.percsconto = percsconto;
    }

    public boolean isScontoapplicato() {
        return scontoapplicato;
    }

    public void setScontoapplicato(boolean scontoapplicato) {
        this.scontoapplicato = scontoapplicato;
    }

    public float getPrezzoscontato() {
        return prezzoscontato;
    }

    public void setPrezzoscontato(float prezzoscontato) {
        this.prezzoscontato = prezzoscontato;
    }
    
    void stampa()
    {
        System.out.println("---------");
        System.out.println("-RESOCONTO");
        System.out.println("-PRODOTTO: "+nome);
        System.out.println("-PREZZO: "+prezzo+"€");
        System.out.println("-QUANTITA: "+quantita);
        if(scontoapplicato==true)
        {
            System.out.println("-PREZZOFINALE(LORDO): "+prezzofinale+"€");
            System.out.println("-SOGLIA DI SCONTO: "+soglia+"€");
            System.out.println("-SCONTO: "+percsconto+"%");
            System.out.println("-PREZZO SCONTATO: "+prezzoscontato+"€" + " -RISPARMIO: "+(prezzofinale-prezzoscontato)+"€");
        }
    }
}
