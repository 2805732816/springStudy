import demo1.confing.SpringConfig;
import demo1.dto.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Person person = annotationConfigApplicationContext.getBean(Person.class);
        person.say();

    }
}
