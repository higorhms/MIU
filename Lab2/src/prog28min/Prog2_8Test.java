package prog28min;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Prog2_8Test {

    @Test
    public void shouldReturnTheMinimun(){
        int[] input = {2, -21, 3, 45, 0, 12, 18, 6, 3, 1, 0, -22};

        int result = Prog2_8.min(input);

        assertEquals(result, -22);
    }


}
