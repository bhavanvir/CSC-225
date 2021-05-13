import java.io.File;
import java.util.*;

public class Lab7 {

    public static boolean PairSum(int[] A, int n){
        int sum = 225;
        HashMap<Integer, Integer> pairs = new HashMap<Integer, Integer>();

        for(int i = 0; i < n; i++){
            if(pairs.containsKey(A[i])){
                System.out.println("True");
                return true;
            }
            else
                pairs.put(sum - A[i], A[i]);
        }
        System.out.println("False");
        return false;
    }

    public static void main(String[] args){
        Scanner s;
        if (args.length > 0){
            try{
                s = new Scanner(new File(args[0]));
            } catch(java.io.FileNotFoundException e){
                System.out.printf("Unable to open %s\n",args[0]);
                return;
            }
            System.out.printf("Reading input values from %s.\n",args[0]);
        }else{
            s = new Scanner(System.in);
            System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
        }
        Vector<Integer> inputVector = new Vector<Integer>();

        int v;
        while(s.hasNextInt() && (v = s.nextInt()) >= 0)
            inputVector.add(v);

        int[] array = new int[inputVector.size()];

        for (int i = 0; i < array.length; i++)
            array[i] = inputVector.get(i);

        System.out.printf("Read %d values.\n",array.length);
        PairSum(array, array.length);
    }
}
