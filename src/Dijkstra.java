class Dijkstra {
    
    int ue = 999999; //unendlich

    int[][] kanten = 
        /* 0   1   2   3   4   5   6   7   8*/
        {{ 0,  4, ue, ue, ue, ue, ue,  8, ue}, //0
         { 4,  0,  8, ue, ue, ue, ue, 11, ue}, //1
         {ue,  8,  0,  7, ue,  4, ue, ue,  2}, //2
         {ue, ue,  7,  0,  9, 14, ue, ue, ue}, //3
         {ue, ue, ue,  9,  0, 10, ue, ue, ue}, //4
         {ue, ue,  4, 14, 10,  0,  2, ue, ue}, //5
         {ue, ue, ue, ue, ue,  2,  0,  1,  6}, //6
         { 8, 11, ue, ue, ue, ue,  1,  0,  7}, //7
         {ue, ue,  2, ue, ue, ue,  6,  7,  0} };


    int startknoten = 0;
    int[] alleKnoten = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    boolean[] erledigteKnoten = new boolean[9];
    int[] kosten = new int[9];
    int[] vorgaenger = new int[9];

    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        d.initialisieren();
        d.dijkstra();
        d.print();
    }
    
         
    void initialisieren() {
        for (int i = 0; i < alleKnoten.length; i++) {
            kosten[i] = ue;
            vorgaenger[i] = i;
            erledigteKnoten[i] = false;
        }
        kosten[startknoten] = 0;
    }
         
    void dijkstra() {           
            while(!allKontenBearbeitet()) {
                int aktuellerKnoten = -1;
                int akutelleKosten = ue;
                for (int i = 0; i < alleKnoten.length; i++) {
                    if ((kosten[i] < akutelleKosten ) && (!erledigteKnoten[i])){
                        aktuellerKnoten = i;
                        akutelleKosten = kosten[i];
                    }
                }
                
                 for (int i = 0; i < alleKnoten.length; i++) {
                     if (aktuellerKnoten != i || erledigteKnoten[i]) {
                         if (kanten[aktuellerKnoten][i] + kosten[aktuellerKnoten] < kosten[i]) {
                             kosten[i] = kanten[aktuellerKnoten][i] + kosten[aktuellerKnoten];
                             vorgaenger[i] = aktuellerKnoten;
                         }
                     }
                 }
                 erledigteKnoten[aktuellerKnoten] = true;
            }
         
        }

        boolean allKontenBearbeitet() {
            boolean fertig = true;
            for (int i = 0; i < erledigteKnoten.length; i++) {
                if (!erledigteKnoten[i]) {
                     fertig = false;
                     break;
                }
             }
             return fertig;
        }

        void print() {
            for (int i = 0; i < alleKnoten.length; i++) {
                
                    System.out.print("Knoten " + i + " Kosten: " + kosten[i] + " Weg: ");
                    int vorg = vorgaenger[i];
                    String weg = i + "";
                    while(vorg != startknoten) {
                        weg = vorg + " -> " + weg;
                        vorg = vorgaenger[vorg];
                    }
                    weg = startknoten + " -> " + weg;
                    System.out.println(weg);
                
            }
        }
}