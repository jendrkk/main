import java.util.Arrays;

public class Vollmond {
    public static void main (String[] args) {
        int n = Integer.parseInt(args[0]);
        String[] month =  {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int[] dmonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] dmonthl = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count;
        int tag = 1;
        int monat = 1;
        int jahr = 2022;
        int vmanzahl = 0;
        double yd = 365;
        double ydl = 366;
        int[][] datum;
        datum = new int[n*24+1][3];
        datum[0][0] = tag;
        datum[0][1] = monat;
        datum[0][2] = jahr;


        double[] vec;
        vec = new double[n*24];
        double[] mod;
        mod = new double[n*24];

        int[] dmformat;
        dmformat = new int[n*24];
        for(int i = 0; i < 12; i++){
            if(n == 1){
                dmformat[i] = dmonth[i];
                dmformat[i+12] = dmonth[i];
            }
        }

        for (int i = 1; i < n*24+1; i++){ 
            datum[i][0] = datum[i-1][0] + 29;
        }

        for (int i = 1; i < n*24+1; i++){
            if(datum[i][0] > dmformat[i-1]){
                datum[i][1] = datum[i-1][1] + 1;                  /// changing number of months
                for (int j = i; j < n*24+1; j++){
                    datum[j][0] = datum[j][0] - dmformat[i-1];    /// substraction of days
                }
            } else {
                datum[i][1] = datum[i-1][1];
            }

        }
        
        for(int i = 1; i < n*24+1; i++){
            if(datum[i][1]>12){
                datum[i][2] = datum[i-1][2]+1;                      /// changing number of years
                for (int j = i; j < n*24+1; j++){
                    datum[j][1] = datum[j][1] - 12;    /// substraction of months
                }
            } else {
                datum[i][2] = datum[i-1][2];
            }
        }





        
        for (int i = 0; i < datum.length; i++) {
            for (int j = 0; j < datum[i].length; j++) {
                System.out.print(datum[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(dmformat));
    }
}
