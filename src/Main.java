import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Flatmap Method ---getCoachingStaff, combine All names");

        List<Club> clubs = Arrays.asList(
                (new Club("ManchesterUnited", 1878, Country.ENGLAND, Ligue.PremierLigue,
                        Arrays.asList("Ole Gunnar", "karla"))),
                new Club("RealMadrid", 1902, Country.SPAIN, Ligue.LaLiga,
                        Arrays.asList("Zidane", "karla")),
                new Club("Lion", 1950, Country.FRANCE, Ligue.Ligue1,
                        Arrays.asList("Rudi Garcia", "karla"))
        );

        List<String> getCoachingStaff = clubs.stream()
                .map(Club::getCoachingStaff)
                .peek(System.out::println)
                .skip(1)
                .limit(0)
                 .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(getCoachingStaff);

        System.out.println("Filter Method ---namesOfCoach, Find name 'O'");

        List<String> namesOfCoach = Arrays.asList("Ole Gunnar", "Zidane", "Rudi Garcia", "", null);

        namesOfCoach.stream()
                .filter(Objects::nonNull)
                .filter(name -> !name.isEmpty() && name.contains("O"))
                .forEach(System.out::println);


        System.out.println("Map Method ---ChampionsLigue, getClub playOff, quarterfinals, semiFinal");
        ChampionsLigue playOff = new ChampionsLigue("Manchester United 1/8", 9500000);
        ChampionsLigue quarterfinals = new ChampionsLigue("Real Madrid 1/4 ", 10500000);
        ChampionsLigue semiFinal = new ChampionsLigue("Lion 1/2", 12000000);

        List<ChampionsLigue> championsLigue = clubs.stream()
                .map(club -> {
                    if(club.getClub().equalsIgnoreCase("ManchesterUnited")){
                        return playOff;
                    }else if(club.getClub().equalsIgnoreCase("RealMadrid")){
                        return quarterfinals;
                    }else if(club.getClub().equalsIgnoreCase("Lion")){
                        return semiFinal;
                    }else{
                        return null;
                    }
                })
                .collect(Collectors.toList());
championsLigue.forEach(System.out::println);

        Stream<String> phoneStream = Stream.of("iPhone 6 S", "Lumia 950", "Samsung Galaxy S 6", "LG G 4", "Nexus 7");

        phoneStream.skip(1)
                .limit(2)
                .forEach(s->System.out.println(s));

        System.out.println("------------------------------------------");

        List<Club> clubs44 = Arrays.asList(
                (new Club("ManchesterUnited", 1878, Country.ENGLAND, Ligue.PremierLigue,
                        Arrays.asList("Ole Gunnar", "Ole Gunnar", "Ole Gunnar", "karla"))),
                new Club("RealMadrid", 1902, Country.SPAIN, Ligue.LaLiga,
                        Arrays.asList("Zidane", "Zidane", "Zidane", "karla")),
                new Club("Lion", 1950, Country.FRANCE, Ligue.Ligue1,
                        Arrays.asList("Rudi Garcia", "karla", "karla", "karla"))
        );
        //"A", "B", "C", "D", "A", "B", "C"

// Get collection without duplicate i.e. distinct only
        List<String > distinctElements = clubs44.stream()
                .map(Club::getCoachingStaff)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctElements);

        System.out.println("------------------------------------------");
//Let's verify distinct elements
        List<Club> clubs445 = Arrays.asList(
                (new Club("ManchesterUnited", 1878, Country.ENGLAND, Ligue.PremierLigue,
                        Arrays.asList("Ole Gunnar", "Ole Gunnar", "Ole Gunnar", "karla"))),
                new Club("RealMadrid", 1902, Country.SPAIN, Ligue.LaLiga,
                        Arrays.asList("Zidane", "Zidane", "Zidane", "karla")),
                new Club("Lion", 1950, Country.FRANCE, Ligue.Ligue1,
                        Arrays.asList("Rudi Garcia", "karla", "karla", "karla"))
        );

        List<String> newList = clubs445.stream()
                .map(Club::getCoachingStaff)
                .flatMap(Collection::stream)
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println(newList);

        System.out.println("------------------------------------------");

        List<Club> clubsNo = Arrays.asList(
                (new Club("ManchesterUnited", 1878, Country.ENGLAND, Ligue.PremierLigue,
                        Arrays.asList("Ole Gunnar", "Ole Gunnar", "Ole Gunnar", "karla"))),
                new Club("RealMadrid", 1902, Country.SPAIN, Ligue.LaLiga,
                        Arrays.asList("Zidane", "Zidane", "Zidane", "karla")),
                new Club("Lion", 1950, Country.FRANCE, Ligue.Ligue1,
                        Arrays.asList("Rudi Garcia", "karla", "karla", "karla"))
        );

        /*
        List<String> sortedList = list.stream()
            .sorted((o1,o2)-> o2.compareTo(o1))
            .collect(Collectors.toList());
        */

        List<String> sortedList = clubsNo.stream()
                .map(Club::getCoachingStaff)
                .flatMap(Collection::stream)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);

        System.out.println("------------------------------------");

        Predicate<ChampionsLigue> p1 = s -> s.getName().startsWith("S");
        Predicate<ChampionsLigue> p2 = s -> s.getPrice() == 28000000 && s.getName().startsWith("Z");
        List<ChampionsLigue> list = ChampionsLigue.getChampionsLigue();

        boolean b3 = list.stream().anyMatch(p1);
        System.out.println(b3);
        boolean b4 = list.stream().anyMatch(p2);
        System.out.println(b4);

        System.out.println("------------------------------------------------");

        long count = Stream.of("how","to","do","in","java")
                .count();
        System.out.printf("There are %d words in the stream %n", count);

        count = IntStream.of(1,2,3,4,5,6,7,8,9)
                .count();
        System.out.printf("There are %d integers in the stream %n", count);



        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        boolean match = numbers.stream()
                .anyMatch(number -> number % 2 == 0); // есть ли в Stream-e четное число

        System.out.println(match); //output true
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);

        boolean match2 = numbers3.stream()
                .allMatch(number -> number > 0); // все ли числа в Stream-e положительные

        System.out.println(match2); //output true
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);

        boolean match3 = numbers2.stream()
                .noneMatch(number -> number % 2 == 0); // все ли числа в Stream-e НЕ четные

        System.out.println(match3); //output false

        //findFirst return the first elements of the stream
        // but findAny is free to select any element in the stream.

        List<String> lst1 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");
        List<String> lst2 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");

        Optional<String> findFirst = lst1.parallelStream()
                .filter(s -> s.startsWith("D")).findFirst();
        Optional<String> fidnAny = lst2.parallelStream()
                .filter(s -> s.startsWith("J")).findAny();
        System.out.println(findFirst.get()); //Always print David
        System.out.println(fidnAny.get()); //Print Jack/Jill/Julia :behavior of this operation is explicitly nondeterminist


        //getting max number
        Integer maxNum = Stream.of(10, 13, 4, 9, 2, 100)
                .max(Comparator.comparing(Integer::valueOf))
                .get();

        //getting min number
        Integer minNum = Stream.of(10, 13, 4, 9, 2, 100)
                .min(Comparator.comparing(Integer::valueOf))
                .get();

        System.out.println("Max number is: " + maxNum);
        System.out.println("Min number is: " + minNum);

        Stream<Integer> numbersStream = Stream.of(1,2,3,4,5,6);
        Optional<Integer> result = numbersStream
                .reduce((x,y)->x*y);
        System.out.println(result.get());

        List<Integer> numbersO = Arrays.asList(1, 2, 3, 4, 5, 6);

        Set<Integer> oddNumbers = numbersO.parallelStream()
                .filter(x -> x % 2 != 0)
                .collect(Collectors.toSet());
        System.out.println(oddNumbers); // [1, 3, 5]

    }
}
