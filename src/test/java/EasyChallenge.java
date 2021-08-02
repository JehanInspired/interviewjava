import codechallenges.models.NumberGen;
import codechallenges.models.Student;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;

import java.util.List;

public class EasyChallenge {

    @Test
    public void studentTest()
    {
        List<Student> students = Student.getStudents(1000);

        //Create a List of Students over 15 years old

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
