package Programming;

public class GetValueInArray {
    public static void main(String[] args) {
        double total = 0;
        double smallArray[] = {1,999};
        for(int i = 0;i<smallArray.length;i++){
            total += smallArray[i];
        }

        System.out.println(total);
    }
}
