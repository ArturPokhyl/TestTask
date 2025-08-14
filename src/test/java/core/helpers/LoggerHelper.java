package core.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerHelper {
    private static final ThreadLocal<LoggerHelper> TL = new ThreadLocal<>();

    private final Logger logger;

    private LoggerHelper(Class<?> clazz) {
        this.logger = LogManager.getLogger(clazz);
    }

    public static LoggerHelper log(Class<?> clazz) {
        LoggerHelper h = TL.get();
        if (h == null) {
            h = new LoggerHelper(clazz);
            TL.set(h);
        }
        return h;
    }

    public Logger getLogger() {
        return logger;
    }
}
