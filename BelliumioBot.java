package Programming;

import java.applet.Applet;
import java.util.Scanner;
public class BelliumioBot extends Applet{
    static final double DEVMPCOST = 1.15;

    static int bases = 0;
    static int squads = 0;
    static int soldiers = 0;
    static int tanks = 0;
    static int airfields = 0;

    static double  baseMpMadeTotal = 0;
    static double baseTotalCost = 0;
    static double  squadMpMadeTotal = 0;
    static double squadTotalCost= 0;
    static double  soldierMpMadeTotal;
    static double soldierTotalCost;
    static double  tankMpMadeTotal = 0;
    static double tankTotalCost = 0;
    static double  airfieldMpMadeTotal = 0;
    static double airfieldTotalCost = 0;
    static double soldierEfficiency = 0;
    static double squadEfficiency= 0;
    static double tankEfficiency = 0;
    static double baseEfficiency = 0;
    static double airfieldEfficiency = 0;
    static double troopNumberToStopAt = 0;
    static double timeLeftInGame = 0;



    //anything below is for the future!
    static int tilesAway;
    static int basePriceIncrease = tilesAway / 5 * 250000;
    static int landPriceIncrease = tilesAway / 5 * 25;
    static int landPrice = 50 + landPriceIncrease;
    static int basePrice = 500000 + basePriceIncrease;

    public String Soldiers(double troopNumberToStopAt,double timeLeftInGame) {
        for (; soldiers <= troopNumberToStopAt; soldiers++) {
            soldierMpMadeTotal = ((soldiers * /* no need to multiply by one*/ 60) * timeLeftInGame);
            soldierTotalCost = ((Math.pow(DEVMPCOST, soldiers) * 15));
            soldierEfficiency = (int)(((soldierMpMadeTotal)) / (soldierTotalCost));
            System.out.println((int)(((soldierMpMadeTotal)) / (soldierTotalCost)) + " %  " + soldiers +" soldiers " + timeLeftInGame + " min game left");
        }
        return "";
    }
    public String Squad(double troopNumberToStopAt,double timeLeftInGame) {
        for (; squads <= troopNumberToStopAt; squads++) {
            squadMpMadeTotal= ((squads*5*60) * timeLeftInGame);
            squadTotalCost = ((Math.pow(DEVMPCOST, squads) * 100));
            squadEfficiency = (int)(((squadMpMadeTotal)) / (squadTotalCost));
            System.out.println((int)(((squadMpMadeTotal)) / (squadTotalCost)) + " %  " + squads +" squads " + timeLeftInGame + " min game left");
        }
        return "";
    }
    public String Tank(double troopNumberToStopAt,double timeLeftInGame) {
        for (; tanks <= troopNumberToStopAt; tanks++) {
            tankMpMadeTotal= ((tanks*40*60) * timeLeftInGame);
            tankTotalCost = ((Math.pow(DEVMPCOST, tanks) * 500));
            tankEfficiency = (int)(((tankMpMadeTotal)) / (tankTotalCost));
            System.out.println((int)(((tankMpMadeTotal)) / (tankTotalCost)) + " %  " + tanks +" tanks " + timeLeftInGame + " min game left");
        }
        return "";
    }
    public String Base(double troopNumberToStopAt,double timeLeftInGame) {
        for (; bases <= troopNumberToStopAt; bases++) {
            baseMpMadeTotal= ((bases*100*60) * timeLeftInGame);
            baseTotalCost = ((Math.pow(DEVMPCOST, bases) * 3000));
            baseEfficiency = (int)(((baseMpMadeTotal)) / (baseTotalCost));
            System.out.println((int)(((baseMpMadeTotal)) / (baseTotalCost)) + " %  " + bases +" bases " + timeLeftInGame + " min game left");
        }
        return "";
    }
    public String AirField(double troopNumberToStopAt,double timeLeftInGame) {
        for (; airfields <= troopNumberToStopAt; airfields++) {
            airfieldMpMadeTotal= ((airfields*400*60) * timeLeftInGame);
            airfieldTotalCost = ((Math.pow(DEVMPCOST, airfields) * 10000));
            airfieldEfficiency = (int)(((airfieldMpMadeTotal)) / (airfieldTotalCost));
            System.out.println((int)(((airfieldMpMadeTotal)) / (airfieldTotalCost)) + " %  " + airfields +" airfields " + timeLeftInGame + " min game left");
        }
        return "";
    }

    public double totalingMpEfficiencyForAll() {
        System.out.print("How much time is left in game? ");
        Scanner sc = new Scanner(System.in);
        timeLeftInGame = sc.nextInt();
        System.out.print("How high of a troop do you want to calculate efficiency? ");
        int numberToStopAt= sc.nextInt();
        do {

            this.Soldiers(troopNumberToStopAt++,timeLeftInGame);
            troopNumberToStopAt--;
            this.Squad(troopNumberToStopAt++,timeLeftInGame);
            troopNumberToStopAt--;
            this.Tank(troopNumberToStopAt++,timeLeftInGame);
            troopNumberToStopAt--;
            this.Base(troopNumberToStopAt++,timeLeftInGame);
            troopNumberToStopAt--;
            this.AirField(troopNumberToStopAt++,timeLeftInGame);
            System.out.println("=====");

            double totalEfficiency = soldierEfficiency + squadEfficiency + tankEfficiency + baseEfficiency + airfieldEfficiency / timeLeftInGame;
            System.out.println("Efficency of doing "+ (int)troopNumberToStopAt + ","+(int)troopNumberToStopAt+","+(int)troopNumberToStopAt+","+(int)troopNumberToStopAt+","+(int)troopNumberToStopAt+"\n" +"Instead of doing "+(int)troopNumberToStopAt+","+0+","+0+","+0+","+0+"\n"+(int)totalEfficiency + " %" +" at "+(int)timeLeftInGame +" minutes");

            System.out.println("=====");



        } while (troopNumberToStopAt <= numberToStopAt);
        return 1;
    }
    public static void main(String[] args) {
        BelliumioBot BB = new BelliumioBot();
        Scanner sc = new Scanner(System.in);

        BB.totalingMpEfficiencyForAll();
    }

}
