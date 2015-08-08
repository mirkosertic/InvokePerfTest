package de.mirkosertic.invoke.perftest;

public class ExpensiveAction implements ProfilerAction {

    private static double callme(long aCounter) {
        return Math.random() * Math.PI * aCounter;
    }

    private double anotherdoit(long aCounter) {
        return callme(aCounter);
    }

    private double doit(long aCounter) {
        return anotherdoit(aCounter);
    }

    public void run(long aCounter) {
        doit(aCounter);
    }
}
