package fr.epita.assistant.mytinyepita;

import java.util.ArrayList;
import java.util.List;

public class School {
    protected List<ComputerRoom> computerRooms;

    public List<ComputerRoom> getComputerRooms() {
        return computerRooms;
    }

    public List<ComputerRoom> getAvailableRooms() {
        List<ComputerRoom> list = new ArrayList<>();
        for (ComputerRoom computerRoom : computerRooms) {
            if (computerRoom.getSize() < computerRoom.getCapacity()) {
                list.add(computerRoom);
            }
        }
        return list;
    }

    public School()
    {
        computerRooms = new ArrayList<>();
    }
}
