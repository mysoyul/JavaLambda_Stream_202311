package lambdasinaction._02stream.basic2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


public class _05Reducing {

    public static void main(String... args) {

        //reduce - a + b 연산
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        //1. reduce() 메서드 구현 - 합계 구하기
        int sum = numbers.stream()
                //.reduce(0, (n1, n2) -> n1 + n2);
                .reduce(0, Integer::sum);
        System.out.println("sum = " + sum);

        //2. Stream의 mapToInt() 함수로 생성한 IntStream의 sum() 사용 - 합계 구하기
        sum = numbers.stream()
                //mapToInt(ToIntFunction)  ToIntFunction의 추상메서드 int applyAsInt(T value)
                //.mapToInt(value -> value.intValue())  //IntStream
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("mapToInt() IntStream sum = " + sum);

        //3. Stream의 flatMapToInt() 함수로 생성한 IntStream의 sum() 사용 - 합계 구하기
        //IntStream flatMapToInt(Function<? super T,? extends IntStream> mapper)
        sum = numbers.stream()
                //.flatMapToInt(value -> IntStream.of(value))
                .flatMapToInt(IntStream::of)
                .sum();
        System.out.println("flatMapToInt() IntStream sum = " + sum);
        
        //1. Stream의 reduce() 메서드 구현 - 최대값 구하기
        int max = numbers.stream()
                //.reduce(0, (n1,n2) -> Integer.max(n1,n2));
                .reduce(0, Integer::max);
        System.out.println("max = " + max);

        //reduce -  최소값



        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

        //Dish 의  총 칼로리 합계를 구하는 여러가지 방법




    }
}
