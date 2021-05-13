import java.util.*;

public class StackSort {
    public static int[] StackSort(int[] A, int n){
        Stack<Integer> mainStack = new Stack<Integer>();
        Stack<Integer> shiftStack = new Stack<Integer>();

        mainStack.push(A[0]);
        for(int i = 1; i < n; i++){
            if(A[i] < mainStack.peek())
                mainStack.push(A[i]);
            else{
                while(mainStack.peek() < A[i]){
                    shiftStack.push(mainStack.pop());

                    if(mainStack.isEmpty())
                        break;
                }
                mainStack.push(A[i]);

                while(!shiftStack.isEmpty()){
                    mainStack.push(shiftStack.pop());
                }
            }
        }
        while(!mainStack.isEmpty()){
            for(int i = 0; i < n; i ++){
                A[i] = mainStack.pop();
            }

            if(mainStack.isEmpty())
                break;
        }

        return A;
    }

    public static void main(String[] args){
        int[] A = {3,4,1,5,2};
        System.out.println(Arrays.toString(StackSort(A, A.length)));

    }
}
