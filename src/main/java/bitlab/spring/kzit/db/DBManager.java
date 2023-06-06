package bitlab.spring.kzit.db;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBManager {
    private static final  ArrayList<Student> students = new ArrayList<>();

    private static Long id = 3L;

    static {
        students.add(new Student(1L, "Yernur", "Assilov", 86, "B+"));
        students.add(new Student(2L, "Nurbol","Agzamkhan", 74, "C+"));
    }
    public static ArrayList<Student>getStudents(){
        return students;
    }
    public static void addStudent(Student student){
        student.setId(id);
        id++;
        students.add(student);

    }
}
