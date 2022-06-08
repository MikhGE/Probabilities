package com.mikhge.probabilities;

public class Outcome {
    private static Long countOutcomes = 0L;
    private Long id;

    public Outcome() {
        this.id = countOutcomes++;
    }

    public Long getId() {
        return id;
    }
}
