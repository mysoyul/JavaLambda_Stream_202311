package lambdasinaction._02stream.basic2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lambdasinaction._02stream.basic1.Dish;

import static java.util.stream.Collectors.toList;

public class _02Filtering {

    public static void main(String... args) {

        // 1. Filtering with predicate ( isVegeterian() )
        List<Dish> vegeList =
                Dish.menu //List<Dish>
                        .stream() //Stream<Dish>
                        //.filter(dish -> dish.isVegetarian())
                        .filter(Dish::isVegetarian) //Stream<Dish>
                        //.collect(toList())
                        .toList();

        vegeList.forEach(System.out::println);

        // 2. Filtering unique elements
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("==> limit");
        //3. Truncating 3 stream ( d.getCalories() > 300 )
        List<Dish> dishesLimit3 =
                Dish.menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .limit(3)
                        .toList();
        dishesLimit3.forEach(System.out::println);

        System.out.println("==> skip");
        //4. Skipping elements
        List<Dish> dishesSkip2 =
                Dish.menu.stream()
                        .skip(2)
                        .toList();
        dishesSkip2.forEach(System.out::println);


    }
}
