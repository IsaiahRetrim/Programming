package Programming.Bellum.io;

/**
 * Created by Nick on 11/16/2016.
 */
public class TerrainCalculator {

    public static void main(String[] args) {
        chanceCalculator cc = new chanceCalculator();
        double x = cc.Bases500k();
        System.out.println("You have: " + (int)x +"  bases that cost 500k around you");
    }

}
class Calculate {
        public  boolean basesWithin500K() {
            return true;

        }
        public boolean basesWithin750K() {
            return true;

        }
        public boolean basesWithin1000k() {
            return true;

        }
        public boolean basesMoreThan1000K() {
            return true;
        }
    }
class chanceCalculator {
    public int PERCENT = 100;
    double basesBeforeRunOut;
    public double  Bases500k() {
        int chance500k = (int)(Math.random() * 10 + 9);

        for(double i = 0;i < PERCENT;++i) {
            this.basesBeforeRunOut = ((chance500k / i) * 100);
        }
        return basesBeforeRunOut ;
    }
    public float Bases750k() {
        
        return 0;
    }
    public float Baese1000k() {
        return 0;
    }
}
