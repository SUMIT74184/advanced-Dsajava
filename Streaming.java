import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.StreamSupport.doubleStream;

public class Streaming {

    public static void main(String[] args) {
        //create the stream
        Stream<String>shoppingStream=Stream.of("apples","bananas","cherries","coffees");

        //Array
        String[] shoppingArray=new String[]{"grapes,watermelon,oranges"};
        Stream<String>shopArrayStream= Arrays.stream(shoppingArray);

        //lIST
        List<String>shoppinglist=List.of("lemons","peaches","tomato");
        Stream<String>shoppingListStream=shoppinglist.stream();

        shoppinglist.stream().forEach(System.out::println);
        shoppinglist.parallelStream().forEach(System.out::println);

        //Match
        boolean isOnList=shoppinglist.stream()
                .anyMatch(item->item.contains("peaches"));

        //filter
        Stream<String> itemInAisle=shoppinglist.stream()
                .filter(item->item.contains("o"));

        //Map
        List<Integer>numberLIst=List.of(2,3,4,5,6,7);
        Stream<Integer>doubleStreami=numberLIst.stream()
                .map(n->n*n);

        System.out.println("squares");
        doubleStreami.forEach(System.out::println);

        //collect
        List<Integer>doubleList=numberLIst.stream()
                .map(n->n*2)
                .collect(Collectors.toList());
        System.out.println("singles");
        System.out.println(doubleList);

        //switch statements
        int stage=3;
        String season=switch (stage){
            case 0->"Spring";
            case 1->"Summer";
            case 2->"Fall";
            case 3->"Winter";
            default -> "Invalid stage";
        };
        System.out.println(season);

    }
}
