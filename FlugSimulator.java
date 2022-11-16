public class FlugSimulator {
    public static void main(String[] args) {
        int anzahlFluege = Integer.parseInt(args[0]);
        int pax = 75;
        double wkeit = 0.92;
        int verkauft = 78;
        double sum = 0;
        int count = 0;
        int sumsim = 0;
        double[] sim;
        sim = new double[anzahlFluege];

        if(anzahlFluege < 1){
            System.out.println("Nur Zahlen größer gleich 1.");
        } else {
        for(int i = 0; i < anzahlFluege; i++){
            sumsim = 0;
            for(int j = 0; j < verkauft; j++){
                if(Math.random() >= (1-wkeit)) {
                    sumsim++;
                }
            }
            sim[i] = (int) sumsim;
            sum = sum + sim[i];
        }
        for(int i = 0; i < anzahlFluege; i++){
            if(sim[i] > pax){
                count++;
            }
        }
        System.out.println("Überbuchungen: " + count + " (" + (double) Math.round((double) count/anzahlFluege*10000)/100 + "%)");
        System.out.println("Mittelwert: " + (double) Math.round(sum/anzahlFluege*10)/10);
        }
    }
}
