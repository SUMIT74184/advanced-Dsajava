import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

public class InterviewEssentialis {


    public static void main(String[] args) {
        Optional<String>empty=Optional.empty();
        Optional<String>name=Optional.of("nike");

        if(name.isPresent()){
            System.out.println("YES PRESENT " + name.get());
        }
        ArrayList<String>name1=new ArrayList<>();
        name1.add("sal");
        name1.add("call");
        name1.add("mino");
        name1.add("Lee");

        name1.forEach(s-> System.out.println(s));
        System.out.println(" ");
        //lamda functions--consumer

        Consumer<String>printItem=n-> System.out.println(n);
        name1.forEach(printItem);
        System.out.println(" ");

//        Function
        Function<Integer,Integer>doubly=n->n*n;
        System.out.println(doubly.apply(8));

        //Predicate
        IntPredicate isDivideByThree=n-> n % 5==0;
        System.out.println(isDivideByThree.test(6));

        //supplier
//        takes no input and prints the value
        Supplier<Double>randomNumber=()->Math.random()*200;
        System.out.println(randomNumber.get());


    }
}
