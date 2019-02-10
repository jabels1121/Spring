import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {
        // load the spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("trackCoach", Coach.class);
        Coach alphaCoach = context.getBean("trackCoach", Coach.class);

        // check if they are the same objects
        boolean result = theCoach == alphaCoach;
        // print out the result
        System.out.println("\nPointing to the same object: " + result);
        System.out.println("\nMemory location for the theCoach: " + theCoach);
        System.out.println("\nMemory location for the alphaCoach: " + alphaCoach + "\n");

        // close the context
        context.close();
    }

}
