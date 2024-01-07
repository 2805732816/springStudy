package demo1.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PersonService {


    @Before("pointCutEvery()")
    public void everyBefore(){
        System.out.println("everyMethodBefore: 干任何事之前都得干这个");
    }

    //切面
    @Before("pointCut()")
    public void sayBefore(){
        System.out.println("sayBefore:说话前得张开嘴巴");
    }

    @After("pointCut()")
    public void sayAfter(){
        System.out.println("sayAfter:说完话得闭上嘴巴啦啦");
    }



    @Before("pointCutEat()")
    public void eatBefore(){
        System.out.println("eatBefore:吃饭之前得洗手");
    }

    @After("pointCutEat()")
    public void eatAfter(){
        System.out.println("eatAfter:吃完饭记得擦嘴哦");
    }



    //切入点
    @Pointcut("execution(void demo1.dto.Person.say())")
    private void pointCut(){

    }

    @Pointcut("execution(void demo1.dto.Person.*(..))")
    private void pointCutEvery(){

    }

    @Pointcut("execution(void demo1.dto.Person.eat())")
    private void pointCutEat(){

    }



}
