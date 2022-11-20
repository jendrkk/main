public class FlugSimulator {
    public static void main(String[] args) {
        int numberofFlights = Integer.parseInt(args[0]);
        int numberofSeats = 75;
        double probabilityofArrival = 0.92;
        int numberofSoldTickets = 78;
        double totalPAX = 0;
        int numberofOverbookedFlights = 0;
        int numberofPAX = 0;
        double[] numberofPAXallFlights;
        numberofPAXallFlights = new double[numberofFlights];

        if(numberofFlights < 1){
            System.out.println("Nur Zahlen größer gleich 1.");                  // Check if the the input is greater or equal 1.
        } else {
            for(int i = 0; i < numberofFlights; i++){                              // Loop that repeats the simulation for every flight separatly
                numberofPAX = 0;
                for(int j = 0; j < numberofSoldTickets; j++){                      // Loop that simulates decision upon arrival of every passenger that has bought a ticket
                    if(Math.random() >= (1-probabilityofArrival)) {                // If random number is >= 0.08 [=1-0.92], then a passenger has managed to take a flight
                        numberofPAX++;                                             // Number of passengers is increased by 1, when passenger arrive
                }
            }
            numberofPAXallFlights[i] = (int) numberofPAX;                          // Simulated number of passengers on board is assignd to a corresponding (to a particular flight) record in array, which contains numbers of passengers of every simulated flight
            totalPAX = totalPAX + numberofPAXallFlights[i];                        // Sum of every value in array = Sum of all passengers who have been boarded to every simulated flight
        }
        for(int i = 0; i < numberofFlights; i++){
            if(numberofPAXallFlights[i] > numberofSeats){                          // If the correspondig record in array is greated than number of seats on the aircraft, then the flight is overbooked
                numberofOverbookedFlights++;                                       // Number of overbooked flights is increased by 1, when the condition ^ is true

            }
        }
        System.out.println("Überbuchungen: " + numberofOverbookedFlights + " (" + (double) Math.round((double) numberofOverbookedFlights/numberofFlights * 10000)/100 + "%)");          // Presentation of outcome of whole simulation
        System.out.println("Mittelwert: " + (double) Math.round(totalPAX/numberofFlights*10)/10);                                                                                       // Presentation of outcome of whole simulation
        }
    }
}
