import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bai24 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 2, 5 };
        List result = listNum(arr);
        System.out.println(result);
    }

    public static List<Integer> listNum(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int number : arr) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}