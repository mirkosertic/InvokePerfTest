package de.mirkosertic.invoke.perftest;

public class ExpensiveAction implements Runnable {

    private static double callme() {
        return Math.random() * Math.PI;
    }

    private double anotherdoit() {
        return callme();
    }

    private double doit() {
        return anotherdoit();
    }

    @Override
    public void run() {
        doit();
    }
}
