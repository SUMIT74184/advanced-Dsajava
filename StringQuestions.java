import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringQuestions {

    public static void main(String[] args) {
        //concatenate
        String name1="times";
        String name2="comes";

        String concatName=(name1.concat(" ").concat(name2));
        System.out.println(concatName);


        String panda= "  panda  ";
        String fish="  fish  ";
        String horse="  Horse  ";
        String cat= "   kitty  ";
        String nothing="    ";

        List<String>animals= List.of(panda,cat,horse,fish,nothing);
        animals.stream().forEach(s-> System.out.println(s.trim()));//removing the spaces



        List<String>trimmed=animals.stream()
                .map(String::trim)
                .toList();
        System.out.println("animals are ");
        trimmed.forEach(System.out::println);

        System.out.println("different");
        List<String>realAnimals=trimmed.stream()
                .filter(s->!s.isEmpty())
                .toList();

        List<String>NormalizedAnimalsName=realAnimals.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println("Normalised Animal Names" + NormalizedAnimalsName);


        //indexing in the string
        String apples="Apples";
        char firsCharacter=apples.charAt(0);
        System.out.println(firsCharacter);


        System.out.println(apples.indexOf('e'));


        String sub=apples.substring(2,5);
        System.out.println(sub);


        System.out.println(apples.contains("pp"));

        char[] applesArray=apples.toCharArray();
        System.out.println(applesArray[4]);


        String text="Welcome to Java programming."+
                "Ebola vaccine protects against Zaire ebolavirus."+
                "PM25 in Britain is below 10 µg/m³ in some areas."+
                "Melanin levels vary across ethnicities.";

        String [] sentences=text.split("\\.");
        System.out.println("The text has " + sentences.length+ " sentences.");

        String[] words=text.split("\\W+");
        System.out.println("The text has " + words.length +" words");

        System.out.println(Arrays.asList(words));


//
    String objA=new String("abc");
    String objB=new String("abc");

            String literalA="abc";
            String literalB="abc";

        System.out.println("  string equality");
        System.out.println(literalA.equals(literalB));





                ;



    }


}
