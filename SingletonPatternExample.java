
class EagerLogger {
    private static final EagerLogger instance = new EagerLogger();

    private EagerLogger() {
        System.out.println("EagerLogger instance created.");
    }

    public static EagerLogger getInstance() {
        return instance;
    }

    public void log(String message) {
        System.out.println("[EAGER LOG] " + message);
    }
}


class UnsafeLazyLogger {
    private static UnsafeLazyLogger instance;

    private UnsafeLazyLogger() {
        System.out.println("UnsafeLazyLogger instance created.");
    }

    public static UnsafeLazyLogger getInstance() {
        if (instance == null) {           // <-- race condition: two threads can both pass this check
            instance = new UnsafeLazyLogger(); // <-- before either finishes this line
        }
        return instance;
    }
}


class SynchronizedLogger {
    private static SynchronizedLogger instance;

    private SynchronizedLogger() {
        System.out.println("SynchronizedLogger instance created.");
    }

    public static synchronized SynchronizedLogger getInstance() {
        if (instance == null) {
            instance = new SynchronizedLogger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[SYNC LOG] " + message);
    }
}


class Logger {
    
    private static volatile Logger instance;

    private Logger() {
        System.out.println("Logger instance created.");
    }

    public static Logger getInstance() {
        if (instance == null) {                   
            synchronized (Logger.class) {
                if (instance == null) {            
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}


public class SingletonPatternExample {
    public static void main(String[] args) {
        System.out.println("--- Testing Logger Singleton ---");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First message");
        logger2.log("Second message");

        System.out.println("\nlogger1 == logger2 ? " + (logger1 == logger2));
        System.out.println("logger1 hashCode: " + logger1.hashCode());
        System.out.println("logger2 hashCode: " + logger2.hashCode());

        System.out.println("\n--- Testing across multiple threads ---");
        Runnable task = () -> {
            Logger l = Logger.getInstance();
            l.log("Logged from " + Thread.currentThread().getName());
        };
        Thread t1 = new Thread(task, "Thread-A");
        Thread t2 = new Thread(task, "Thread-B");
        t1.start();
        t2.start();
    }
}
