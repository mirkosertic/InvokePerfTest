package de.mirkosertic.invoke.perftest;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

public class ReflectionMethodHandeExactCallTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {

        final ExpensiveAction theAction = new ExpensiveAction();
        Method theMethod = theAction.getClass().getMethod("run", long.class);

        MethodHandles.Lookup theLookup = MethodHandles.lookup();
        final MethodHandle theHandle = theLookup.unreflect(theMethod);

        ProfilerAction theReflectiveMethod = new ProfilerAction() {
            @Override
            public void run(long aCounter) {
                try {
                    theHandle.invokeExact(theAction, aCounter);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        };

        Profiler theProfiler = new Profiler("MethodHandle invokeExact", theReflectiveMethod);
        theProfiler.profile(1000, 500000000L);
    }
}
