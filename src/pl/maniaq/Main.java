package pl.maniaq;

import pl.maniaq.exception.HumanLastNameWrongFormat;
import pl.maniaq.exception.HumanNameWrongFormat;
import pl.maniaq.exception.HumanNotFoundException;
import pl.maniaq.model.Human;
import pl.maniaq.service.HumanService;

public class Main {



    public static void main(String[] args) {

        //zadanie 1
        int [] numbers = {1, 5, 4, 2, 9, 10, 24, 23};

        try {
            for (int i=0; i<numbers.length+1; i++) {
                System.out.println(i + ": " + numbers[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // Łapanie wyjątka unchecked - czyli możemy, ale nie musimy!
            System.out.println("Wyszedłeś poza rozmiar tablicy.");
        }


        HumanService humanService = new HumanService();

        //zadanie 2

        try {
            Human human = humanService.getHumanById(1);
        } catch (HumanNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // zmienne tworzone w bloku try-catch są dostępne tylko w tym bloku
        // dlatego możemy mieć dwie zmienne o nazwie human w jednej metodzie

        try {
            Human human = humanService.getHumanByLastName("pablo");
        } catch (HumanNotFoundException e) {
            System.out.println(e.getMessage());
        }


        //zadanie 3
        try {
            humanService.addHuman("Pablo", "Escabo");
        } catch (HumanLastNameWrongFormat lastNameE) {
            System.out.println(lastNameE.getMessage());
        } catch (HumanNameWrongFormat nameE) {
            System.out.println(nameE.getMessage());
        }

        try {
            humanService.addHuman("AS", "Karosa");
        } catch (HumanLastNameWrongFormat lastNameE) {
            System.out.println(lastNameE.getMessage());
        } catch (HumanNameWrongFormat nameE) {
            System.out.println(nameE.getMessage());
        }


        // od Javy 7 (my używamy 8) - można w jednym bloku catch łapac wiele wyjątków łącząc je przy użyciu operator |
        try {
            humanService.addHuman("adminadmin", "abc");
        } catch (HumanLastNameWrongFormat | HumanNameWrongFormat e) {
            System.out.println(e.getMessage());
        }
    }
}
