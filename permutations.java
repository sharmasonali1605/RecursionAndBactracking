import java.util.ArrayList;

public class permutations {

    public static void main(String[] args) {
          int a[] = {1,2,3};
          generate(a,new ArrayList<>(), a.length);
    }

    private static void generate(int[] a, ArrayList<Integer> temp, int length) {
            if(temp.size()==length){
                System.out.println(temp);
                return;
            }
            for(int i=0;i<length;i++){
                if(!temp.contains(a[i])) {
                    temp.add(a[i]);
                    generate(a, temp, length);
                    temp.remove(temp.size() - 1);
                }
            }
    }
}
