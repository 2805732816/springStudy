package demo1.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PersonService {

    //切面
    @Before("pointCut()")
    public void method(){
        System.out.println("张开嘴巴");
    }


    //切入点
    @Pointcut("execution(void demo1.dto.Person.say())")
    private void pointCut(){

    }



}
