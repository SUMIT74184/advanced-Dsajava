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


    }


}
