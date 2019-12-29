import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainFebruaryTest {

    @Test
    void test() {

        final ArrayList a = new ArrayList<Integer>();

        for(int i = 0; i < 10000; ++i){
            a.add(1);
            System.out.println(a.size());
        }
    }
}