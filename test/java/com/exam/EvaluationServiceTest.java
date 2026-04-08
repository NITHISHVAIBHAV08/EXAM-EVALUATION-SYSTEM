package com.exam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

public class EvaluationServiceTest {

    @Test
    public void testCorrect() {
        EvaluationService s = new EvaluationService();
        assertEquals(2, s.evaluate(Map.of(1,"A",2,"B"), Map.of(1,"A",2,"B")));
    }

    @Test
    public void testWrong() {
        EvaluationService s = new EvaluationService();
        assertEquals(1, s.evaluate(Map.of(1,"A",2,"C"), Map.of(1,"A",2,"B")));
    }

    @Test
    public void testMissing() {
        EvaluationService s = new EvaluationService();
        assertEquals(1, s.evaluate(Map.of(1,"A"), Map.of(1,"A",2,"B")));
    }
}