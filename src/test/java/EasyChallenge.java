import codechallenges.models.NumberGen;
import codechallenges.models.Student;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EasyChallenge {

    @Test
    public void studentTest()
    {
        List<Student> students = Student.getStudents(1000);
        //Create a List of Students over 15 years
        var studentsOver15 = students.stream().filter(s -> s.Age>15).collect(Collectors.toList());

        //Create a List of Students who are enrolled in Maths
        var studentsInMaths = students.stream().filter(s -> s.Course.equals("Maths")).collect(Collectors.toList());

        //Create a List of Student Names who are 18 and enrolled in History
        List<String> studentNames = new ArrayList<>();
        students.stream().filter(s-> s.Age == 18 && s.Course.equals("History")).forEach(t-> studentNames.add(t.Name));
    }

    @Test
    public void sumTest()
    {
      Integer[] numbers = NumberGen.generateArray(10);

      //Add the items in the array together
        var list = Arrays.asList(numbers);
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sdf");
    }

}
