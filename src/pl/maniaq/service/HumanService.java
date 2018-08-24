package pl.maniaq.service;

import pl.maniaq.exception.HumanLastNameWrongFormat;
import pl.maniaq.exception.HumanNameWrongFormat;
import pl.maniaq.exception.HumanNotFoundException;
import pl.maniaq.model.Human;
import pl.maniaq.validator.HumanValidator;

import java.util.ArrayList;
import java.util.List;

public class HumanService {
    List<Human> humans;

    public HumanService() {
        humans = new ArrayList<>();
    }

    public void addHuman(String name, String lastName) throws HumanLastNameWrongFormat, HumanNameWrongFormat {
        if (HumanValidator.isHumanLastNameCorrect(lastName) && HumanValidator.isHumanNameCorrect(name)) {
            Human human = new Human(getNextHumanId(), name, lastName);
            humans.add(human);
        }
    }

    private int getNextHumanId() {
        return humans.size();
    }

    public Human getHumanById(Integer id) throws HumanNotFoundException {
        for (Human human : humans
             ) {
            boolean sameIds = human.getId().equals(id);
            if (sameIds) {
                return human;
            }
        }
        throw new HumanNotFoundException("Human with id: " + id + " not found.");
    }

    public Human getHumanByLastName(String lastName) throws HumanNotFoundException {
        for (Human human : humans
                ) {
            boolean sameIds = human.getLastName().equals(lastName);
            if (sameIds) {
                return human;
            }
        }
        throw new HumanNotFoundException("Human with lastname: " + lastName + " not found.");
    }
}
