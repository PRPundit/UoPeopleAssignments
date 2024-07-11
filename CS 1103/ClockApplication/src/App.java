import java.text.SimpleDateFormat;
import java.util.Date;

public class App  {

    // Clock class
    public static class Clock {
        private volatile String currentTime;

        public Clock() {
            updateCurrentTime();
        }

        public void updateCurrentTime() {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
            currentTime = formatter.format(new Date());
        }

        public String getCurrentTime() {
            return currentTime;
        }
    }

    // Thread class to update the clock time
    public static class ClockUpdater extends Thread {
        private final Clock clock;

        public ClockUpdater(Clock clock) {
            this.clock = clock;
        }

        @Override
        public void run() {
            while (true) {
                clock.updateCurrentTime();
                try {
                    Thread.sleep(1000);  // Update every second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Thread class to display the clock time
    public static class ClockDisplay extends Thread {
        private final Clock clock;

        public ClockDisplay(Clock clock) {
            this.clock = clock;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(clock.getCurrentTime());
                try {
                    Thread.sleep(1000);  // Display every second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Clock clock = new Clock();

        ClockUpdater clockUpdater = new ClockUpdater(clock);
        ClockDisplay clockDisplay = new ClockDisplay(clock);

        // Set thread priorities
        clockUpdater.setPriority(Thread.MIN_PRIORITY);
        clockDisplay.setPriority(Thread.MAX_PRIORITY);

        // Start the threads
        clockUpdater.start();
        clockDisplay.start();
    }
}
