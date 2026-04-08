package com.exam;

import java.util.Map;

public class EvaluationService {
    public int evaluate(Map<Integer, String> student, Map<Integer, String> correct) {
        int score = 0;

        for (Integer q : correct.keySet()) {
            if (!student.containsKey(q)) continue;

            if (student.get(q).equals(correct.get(q))) {
                score++;
            }
        }
        return score;
    }
}