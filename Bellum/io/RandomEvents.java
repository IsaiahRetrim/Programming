package Programming.Bellum.io;

/**
 * Created by Nick on 11/16/2016.
 */
public  class RandomEvents {


    public int orgin;
    public static void main(String[] args) {
        EventAtRandomTimes eART = new EventAtRandomTimes();
        boolean RandomChance = eART.calculateChanceOf500kBase();
        System.out.println(RandomChance);
    }
}
class EventAtRandomTimes {
    public boolean calculateChanceOf500kBase() {
        float x =  (float) (Math.random() * 10.000);
        System.out.println(x);
        if (x < 5) {
            return false;
        } else {

            return true;
        }
    }
}
