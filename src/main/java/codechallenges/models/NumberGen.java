package codechallenges.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGen {

    public static Integer[] generateArray(int upperLimit)
    {
        Random random = new Random();
        int entries = random.nextInt(upperLimit);

        List<Integer> items = new ArrayList<>();
        for(int i =0; i < entries; i++)
        {
            items.add(random.nextInt(1000));
        }

        return (Integer[])items.toArray(new Integer[items.size()]);
    }
}
