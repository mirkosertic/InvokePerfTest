package de.mirkosertic.invoke.perftest;

public class DirectCallTest {

    public static void main(String[] args) {
        Profiler theProfiler = new Profiler("DirectCall", new ExpensiveAction());
        theProfiler.profile(1000, 500000000L);
    }
}
