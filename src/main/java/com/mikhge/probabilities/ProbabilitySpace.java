package com.mikhge.probabilities;

import java.util.*;
import java.util.stream.Collectors;


public class ProbabilitySpace {

    private final ArrayList<Outcome> experimentOutcomes = new ArrayList<>();
    private Set<Event> events = new HashSet<>();
    private Map<Event, ProbabilityFunction> functionMatching;

    public Event unionEvents(Event...events){
        Event newEvent = new Event();
        for (Event event : events) {
            newEvent.setOutcomes(event.getOutcomes());
        }
        return newEvent;
    }

    public Event intersectionEvents(Event...events){
        Set<Outcome> outcomes = new HashSet<>();
        for (Event event : events) {
            Set<Outcome> eventOutcomes = event.getOutcomes();
            for (Outcome eventOutcome : eventOutcomes) {
                if(!outcomes.contains(eventOutcome)){
                    outcomes.add(eventOutcome);
                }
            }
        }
        Map<Outcome, Long> statistic = new HashMap<>();
        for (Outcome outcome : outcomes) {
            for (Event event : events) {
                if(event.containsOutcome(outcome)){
                    if(statistic.containsKey(outcome)){
                        statistic.put(outcome, statistic.get(outcome) + 1);
                    }
                    else {
                        statistic.put(outcome, 1L);
                    }
                }
            }
        }
        Event newEvent = new Event();
        Set<Outcome> newEventOutcomes = statistic.entrySet().stream()
                .filter(outcomeLongEntry -> outcomeLongEntry.getValue()==events.length)
                .map(outcomeLongEntry->outcomeLongEntry.getKey())
                .collect(Collectors.toSet());
        newEvent.setOutcomes(newEventOutcomes);
        return newEvent;
    }
    
    public Event difference(Event minuend, Event reducer){
        Event newEvent = new Event();
        Set<Outcome> newEventOutcomes = new HashSet<>();
        for (Outcome outcome : minuend.getOutcomes()) {
         if(!reducer.containsOutcome(outcome)) {
             newEventOutcomes.add(outcome);
         }
        }
        newEvent.setOutcomes(newEventOutcomes);
        return newEvent;
    }

    public Outcome setExperimentOutcome(){
        Outcome outcome = new Outcome();
        experimentOutcomes.add(outcome);
        return outcome;
    }

    public Event setEvent(Set<Outcome> outcomes){
        Event newEvent = new Event();
        newEvent.setOutcomes(outcomes);
        events.add(newEvent);
        return newEvent;
    }

}
