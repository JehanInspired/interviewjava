package codechallenges.models;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student {

    public static String[] Courses = new String[]{"Biology","History","Maths"};

    public String Name;
    public String Surname;
    public int Age;
    public String Course;

    public static List<Student> getStudents(int numberOfStudents)
    {
        Faker faker = new Faker();
        int min = 13;
        int max = 19;

        List<Student> students = new ArrayList<>();

        for(int i =0; i < numberOfStudents; i++)
        {
            Random random = new Random();
            Student student = new Student();
            student.Name = faker.name().firstName();
            student.Surname = faker.name().lastName();
            student.Age = random.nextInt(max-min)+min;
            student.Course = Courses[random.nextInt(Courses.length)];

            students.add(student);
        }

        return students;

    }

}
