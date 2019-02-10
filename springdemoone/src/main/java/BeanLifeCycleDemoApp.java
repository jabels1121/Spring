import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

    public static void main(String[] args) {

        // load the spring config file (etc. applicationContext where defined all beans(classes, injections)
        /*ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        // retrieve beans from container defined above
        Coach trackCoach = context.getBean("trackCoach", Coach.class);

        // close context
        context.close();*/

        try(ClassPathXmlApplicationContext context1 =
                new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml")) {
            Coach trackCoach1 = context1.getBean("trackCoach", Coach.class);
            trackCoach1.getDailyWorkout();
        }
    }
}
