package de.mirkosertic.invoke.perftest;

public class Profiler {

    private final String name;
    private final ProfilerAction action;

    public Profiler(String aName, ProfilerAction aAction) {
        name = aName;
        action = aAction;
    }

    public void profile(long aNumberOfWarmups, long aNumberOfRuns) {
        System.out.println("========================================");
        System.out.println("= Starting Profiling of " + name);
        System.out.println("=");
        System.out.println("= Warmups = " + aNumberOfWarmups);
        System.out.println("= Real runs = " + aNumberOfRuns);
        long theWarmupstart = System.currentTimeMillis();
        for (long i=0;i<aNumberOfWarmups;i++) {
            action.run(i);
        }
        long theWarmupDuration = System.currentTimeMillis() - theWarmupstart;
        System.out.println("= Warmup took " +theWarmupDuration + "ms");
        long theRealStart = System.currentTimeMillis();
        for (long i=0;i<aNumberOfRuns;i++) {
            action.run(i);
        }
        long theRealDuration = System.currentTimeMillis() - theRealStart;
        System.out.println("= Real run took " +theRealDuration + "ms");
    }
}
