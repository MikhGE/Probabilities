package com.mikhge.ProbabilitiesPackage;

public class Outcome {
    private static Long countOutcomes = 0L;
    private Long id;

    public Outcome() {
        this.id = countOutcomes++;
    }
}
