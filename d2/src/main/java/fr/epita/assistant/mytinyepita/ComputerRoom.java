package fr.epita.assistant.mytinyepita;

import java.util.ArrayList;
import java.util.List;

public class ComputerRoom {
    protected String name;
    protected int capacity;
    protected int size;
    protected List<Student> students;
    protected List<Assistant> assistants;

    public List<Student> getStudents() {
        return students;
    }

    public List<Assistant> getAssistants() {
        return assistants;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public ComputerRoom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.students = new ArrayList<>();
        this.assistants = new ArrayList<>();
        this.size = 0;
    }

    public void addStudent(final Student student) throws InsertionException
    {
        if (getSize() >= getCapacity())
        {
            throw new InsertionException("Room is full.");
        }
        else if (students.contains(student))
        {
            throw new InsertionException("Student already inside the room.");
        }
        else if (!student.isAvailable())
        {
            throw new InsertionException("Student already inside another room.");
        }
        else
        {
            students.add(student);
            for ( Assistant assistant : assistants)
            {
                student.register(assistant);
            }
            student.setAvailable(false);
            this.size += 1;
        }
    }

    public void addStudents(final Student... students) throws InsertionException
    {
        for (Student student : students)
        {
            try
            {
                addStudent(student);
            }
            catch (InsertionException exception)
            {
                throw exception;
            }
        }
    }

    public void addAssistant(final Assistant assistant) throws InsertionException {
        if (assistants.contains(assistant))
        {
            throw new InsertionException("Assistant already inside the room.");
        }
        if (!assistant.isAvailable())
        {
            throw new InsertionException("Assistant already inside another room.");
        }

        assistants.add(assistant);
        for ( Student student : students)
        {
            student.register(assistant);
        }
        assistant.setAvailable(false);
    }

    public void addAssistants(final Assistant... assistants) throws InsertionException {
        for (Assistant assistant : assistants)
        {
            try
            {
                addAssistant(assistant);
            }
            catch (InsertionException exception)
            {
                throw exception;
            }
        }
    }

    public void removeStudent(final Student student)
    {
        if (!students.contains(student))
        {
            throw new IllegalArgumentException("Student is not inside the room.");
        }

        for (Assistant assistant : assistants)
        {
            student.unregister(assistant);
        }
        student.setAvailable(true);
        students.remove(student);
        this.size -= 1;
    }

    public void removeStudents(final Student... students)
    {
        for (Student student : students)
        {
            try
            {
                removeStudent(student);
            }
            catch (IllegalArgumentException exception)
            {
                throw exception;
            }
        }
    }

    public void removeAssistant(final Assistant assistant)
    {
        if (!assistants.contains(assistant))
        {
            throw new IllegalArgumentException("Assistant is not inside the room.");
        }
        for (Student student : students)
        {
            student.unregister(assistant);
        }
        assistant.setAvailable(true);
        assistants.remove(assistant);
    }

    public void removeAssistants(final Assistant... assistants)
    {
        for (Assistant assistant : assistants)
        {
            removeAssistant(assistant);
        }
    }
}
