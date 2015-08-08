package de.mirkosertic.invoke.perftest;

import java.lang.reflect.Method;

public class ReflectionDisabledSecCallTest {

    public static void main(String[] args) throws NoSuchMethodException {

        final ExpensiveAction theAction = new ExpensiveAction();
        final Method theMethod = theAction.getClass().getMethod("run", new Class[] {long.class});
        theMethod.setAccessible(true);

        ProfilerAction theReflectiveMethod = new ProfilerAction() {
            @Override
            public void run(long aCounter) {
                try {
                    theMethod.invoke(theAction, aCounter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Profiler theProfiler = new Profiler("Reflection with disabled security", theReflectiveMethod);
        theProfiler.profile(1000, 500000000L);
    }
}
