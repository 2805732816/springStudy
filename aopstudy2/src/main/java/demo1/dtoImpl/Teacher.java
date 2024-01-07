package demo1.dtoImpl;

import demo1.dto.Person;
import org.springframework.stereotype.Component;


@Component
public class Teacher implements Person {
    @Override
    public void say() {
        System.out.println("老师发言了");
    }

    @Override
    public void eat() {
        System.out.println("老师吃饭喽");
    }
}
