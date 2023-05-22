import java.util.Stack;

public class HanoiT {

    private Stack<String> TorreI;
    private Stack<String> TorreP;
    private Stack<String> TorreD;
    private int nDiscos;
    private int IntentosM;
    private int Intentos;


    public HanoiT(){
        Intentos = 0;
        nDiscos = 0;
        TorreI = new Stack<>();
        TorreP = new Stack<>();
        TorreD = new Stack<>();
    }
    public int getIntentosM() {
        return IntentosM;
    }

   public void setIntentosM(){
        this.IntentosM = ((int)Math.pow(2, nDiscos))-1;
   }

    public int getIntentos() {
        return Intentos;
    }

    public void setIntentos(int intentos) {
        this.Intentos = intentos;
    }

    public Stack<String> getTorreI() {
        return TorreI;
    }

    public Stack<String> getTorreP() {
        return TorreP;
    }

    public Stack<String> getTorreD() {
        return TorreD;
    }

    public void setnDiscos(int nDiscos) {
        this.nDiscos = nDiscos;
    }

    public int getnDiscos() {
        return nDiscos;
    }

}
