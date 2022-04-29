package util;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

@Slf4j
public class TimerUtil {

    private final static ThreadLocal<Map<String, Long>> timer = ThreadLocal.withInitial(new Supplier<Map<String, Long>>() {
        @Override
        public Map<String, Long> get() {
            return new ConcurrentHashMap<>();
        }
    });

    public static void startTimer() {
        startTimer("default");
    }
    public static void startTimer(String flag) {
        timer.get().put(flag, System.currentTimeMillis());
    }

    public static long getTimer() {
        return getTimer("default");
    }

    public static long getTimer(String flag) {
        return System.currentTimeMillis() - timer.get().get(flag);
    }

    public static long stopTimer() {
        long time = getTimer();
        long stop = System.currentTimeMillis();
        log.info("Stop timer.");
        timer.get().forEach((k,v)-> {
            log.info("flag = {}, spend time {}ms.", k, stop - v);
        });
        return time;
    }
}
