package progmercato;
import java.io.*;

/*

    @author Marco

*/
public class ProgMercato 
{
    public static void main(String args[]) 
    {   
        String nome=null;
        float prezzo=0;
        float quantita=0;
        
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        //LEGGI I VALORI DI NOME/PREZZO/QUANTITA E LI METTI IN VARIABILI DI COMODO
        try
        {
           do{
           System.out.println("Scrivi il nome del prodotto.(max 30char)");
           nome=tastiera.readLine();
           }while(nome.length()>30);
        }
        catch(IOException e) {}       
        try
        {
           do{
           System.out.println("Scrivi il prezzo del prodotto.(unitario)(0<p<2000)");
           prezzo=(Float.valueOf(tastiera.readLine()));
           }while(prezzo>2000 || prezzo<0);
        }
        catch(IOException | NumberFormatException e) 
        {
          System.out.println("ERRORE: Inserisci un Numero reale.");
          System.exit(0);
        }
        
        try
        {
           do{
           System.out.println("Scrivi la quantità(0<q<100)");
           quantita=(Float.valueOf(tastiera.readLine()));
           }while(quantita>100 || quantita<0);
        }
        catch(IOException | NumberFormatException e) 
        {
            System.out.println("ERRORE: Inserisci un Numero reale.");
            System.exit(0);
        }
            
            //CREA LA CLASSE M1 CON IL COSTRUTTORE PERSONALIZZATO
            Mercato M1 = new Mercato(nome, prezzo, quantita);
        //LEGGI SOGLIA DI SCONTO    
        try
        {
            do{
            //System.out.println(M1.getPrezzo()*M1.getQuantita());
            System.out.println("Inserisci soglia di sconto(max 200.000)");
            M1.setSoglia(Float.valueOf(tastiera.readLine()));
            }while(M1.getSoglia()>200000 || M1.getSoglia()<0);
        }
        catch(IOException | NumberFormatException e)
        {
           System.out.println("ERRORE: Inserisci un Numero reale."); 
           System.exit(0);
        }
        
        //CALCOLA,SETTA PREZZO FINALE , SE SOGLIA<=PREZZOFINALE, LEGGI %SCONTO E CALCOLA PREZZO SCONTATO,SETTA TRUE LO SCONTOAPPLICATO
        try 
        {
           M1.setPrezzofinale(M1.getPrezzo()*M1.getQuantita());
           if(M1.getSoglia()<=M1.getPrezzofinale())
           {
               do{
               System.out.println("Inserisci lo sconto da applicare(0-100%)");
               M1.setPercsconto(Integer.valueOf(tastiera.readLine()));
               }while(M1.getPercsconto()>100 || M1.getPercsconto()<0);
               M1.setPrezzoscontato(M1.getPrezzofinale()*M1.getPercsconto()/100);
               M1.setScontoapplicato(true);
               }
           else
           {
              System.out.println("Sconto non applicato. Ti mancano: " + (M1.getPrezzofinale()-M1.getSoglia())+"€");
              M1.setScontoapplicato(false);
           }
        } catch (IOException | NumberFormatException e) 
        {
            System.out.println("ERRORE: Inserisci un Numero reale.");
            System.exit(0);
        }
        M1.stampa();
    }   
}
