public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k.";
    }

    @Override
    public String getDailyFortune() {
        return "Just DO it: " + fortuneService.getFortune();
    }

    // add an init method
    public void doMyStartupStuffMethod() {
        System.out.println("TrackCoach: inside method doMyStartupMethod");
    }

    // add a destroy method
    public void doMyCleanupStuffMethod() {
        System.out.println("TrackCoach: inside method doMyCleanupStuffMethod");
    }
}
