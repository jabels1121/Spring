public class MyApp {

    public static void main(String[] args) {
        // create the object
        Coach theCoach = new TrackCoach(() -> "Good luck man!");

        // use the object
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
    }

}
