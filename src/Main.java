import java.util.*;

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

    }
}
