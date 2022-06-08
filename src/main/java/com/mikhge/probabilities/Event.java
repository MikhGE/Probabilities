package com.mikhge.probabilities;

import java.util.HashSet;
import java.util.Set;

public class Event {
    private static Long countEvents = 0L;
    private Long id;
    private Set<Outcome> outcomes = new HashSet<>();

    public Event() {
        this.id = countEvents++;
    }

    public Long getId() {
        return id;
    }

    public Set<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(Set<Outcome> outcomes) {
        for (Outcome outcome : outcomes) {
            if (!this.outcomes.contains(outcome)) {
                this.outcomes.add(outcome);
            }
        }
    }
    public boolean containsOutcome(Outcome outcome){
        return this.outcomes.contains(outcome);
    }
    public boolean eventIsImposible(){
        return outcomes.isEmpty();
    }
}
