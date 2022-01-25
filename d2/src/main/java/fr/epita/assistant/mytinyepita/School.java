package fr.epita.assistant.mytinyepita;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void addComputerRooms(final ComputerRoom... computerRooms) throws InsertionException
    {
        for (ComputerRoom computerRoom : computerRooms)
        {
            for (ComputerRoom computerRoom1 : this.computerRooms)
            {
                if (computerRoom.getName().equals(computerRoom1.getName()))
                {
                    throw new InsertionException("Another room with the sane name already exists.");
                }
            }
            this.computerRooms.add(computerRoom);
        }
    }

    public Optional<ComputerRoom> findStudent(final String login)
    {
        for (ComputerRoom computerRoom : this.computerRooms)
        {
            for (Student student : computerRoom.students)
            {
                if (student.getLogin().equals(login))
                {
                    return Optional.of(computerRoom);
                }
            }
        }
        return Optional.empty();
    }

    public int numberOfStudents() {
        return computerRooms.stream().map(ComputerRoom::getSize).reduce(0, Integer::sum);
    }

    public void printState()
    {
        int i = 0;
        for (ComputerRoom computerRoom : this.computerRooms)
        {
            if (i != 0)
            {
                System.out.println("---");
                i++;
            }
            System.out.println(computerRoom.getName() + " (" + computerRoom.getSize() + "/" + computerRoom.getCapacity() + ")");
            System.out.println("Assistants:");
            for (Assistant assistant : computerRoom.getAssistants())
            {
                System.out.println(assistant.getLogin());
            }
            System.out.println("Students:");
            for (Student student : computerRoom.getStudents())
            {
                System.out.println(student.getLogin());
            }

        }
    }
}
