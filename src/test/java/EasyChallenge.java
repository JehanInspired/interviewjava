import codechallenges.models.NumberGen;
import codechallenges.models.Student;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EasyChallenge {

    @Test
    public void studentTest()
    {
        List<Student> students = Student.getStudents(1000);
var t = "";
        //Create a List of Students over 15 years

        List<Student> studentAges =  new ArrayList<>();

        for(int i=0; i < students.size();i++)
        {
            var student = students.get(i);
            if(student.Age > 15)
            {
                System.out.println(student.Name+" "+student.Surname);
                studentAges.add(student);
            }
        }
        //Create a List of Students who are enrolled in Maths

        //Create a List of Student Names who are 18 and enrolled in History
    }

    @Test
    public void sumTest()
    {
      Integer[] numbers = NumberGen.generateArray(10);

      //Add the items in the array together
    }

}
