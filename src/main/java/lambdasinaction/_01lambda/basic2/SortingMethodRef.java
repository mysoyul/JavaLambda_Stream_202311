package lambdasinaction._01lambda.basic2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingMethodRef {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(10, 3, 5, 15, 1, 20, 2);

        //1. Anonymous Inner Class
        integerList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        //2. Lambda Expression
        integerList.sort((n1, n2) -> n1.compareTo(n2));

        //3. Method Reference
        integerList.sort(Integer::compareTo);

        integerList.forEach(System.out::println);

    }
}
