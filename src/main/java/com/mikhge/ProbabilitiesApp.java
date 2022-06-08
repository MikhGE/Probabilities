package com.mikhge;

import com.mikhge.ProbabilitiesPackage.Event;
import com.mikhge.ProbabilitiesPackage.Outcome;
import com.mikhge.ProbabilitiesPackage.ProbabilitySpace;

import java.util.HashSet;
import java.util.Set;

public class ProbabilitiesApp {
    public static void main(String[] args) {
        ProbabilitySpace probabilitySpace = new ProbabilitySpace();
        Outcome outcome1 = probabilitySpace.setExperimentOutcome();
        Outcome outcome2 = probabilitySpace.setExperimentOutcome();
        Outcome outcome3 = probabilitySpace.setExperimentOutcome();
        Outcome outcome4 = probabilitySpace.setExperimentOutcome();
        Set<Outcome> outcomeSet1 = new HashSet<>();
        outcomeSet1.add(outcome1);
        outcomeSet1.add(outcome2);
        outcomeSet1.add(outcome3);
        Set<Outcome> outcomeSet2 = new HashSet<>();
        outcomeSet2.add(outcome2);
        outcomeSet2.add(outcome3);
        outcomeSet2.add(outcome4);
        Event event1 = probabilitySpace.setEvent(outcomeSet1);
        Event event2 = probabilitySpace.setEvent(outcomeSet2);
        Event newEvent1 = probabilitySpace.unionEvents(event1, event2);
        Event newEvent2 = probabilitySpace.intersectionEvents(event1, event2);

    }
}
