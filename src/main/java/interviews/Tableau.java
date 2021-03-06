package interviews;


import java.util.ArrayList;
import java.util.List;

public class Tableau {

    /*
     * Complete the 'mergeArrays' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
     
     // a = [1,2]
     // b = [2,3]
	
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		b.add(2);
		b.add(3);
		List<Integer> c = mergeArrays(a,b);
		System.out.println(c);
		
	}

    public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
    // Write your code here
//    a.addAll(b);
    
    for (int i = 1; i < b.size(); i++){
        int ele = b.get(i);
        int j = a.size();
        while(j >= 0 && a.get(j) > ele){
            a.add(j+1, a.get(j));
            j--;
        }
        if(a.get(j) == b.get(i)){
            a.add(j+1, b.get(i));
        }
        a.add(j+1, ele);
    }
    
    return a;

    }

}

//class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int aCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//            .map(String::trim)
//            .map(Integer::parseInt)
//            .collect(toList());
//
//        int bCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> b = IntStream.range(0, bCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//            .map(String::trim)
//            .map(Integer::parseInt)
//            .collect(toList());
//
//        List<Integer> result = Result.mergeArrays(a, b);
//
//        bufferedWriter.write(
//            result.stream()
//                .map(Object::toString)
//                .collect(joining("\n"))
//            + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//    
//   
//}

