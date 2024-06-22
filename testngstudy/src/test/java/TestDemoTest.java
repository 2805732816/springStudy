import org.testng.annotations.*;

import static org.testng.Assert.*;

public class TestDemoTest {
    @BeforeSuite
    public void test3(){
        System.out.println("优先级1-在所有的方法运行前执行：@BeforeSuite");
    }


    @BeforeTest
    public void test11(){
        System.out.println("优先级2-在类运行前运行：@BeforeTest");
    }
    @BeforeClass
    public void test1(){
        System.out.println("优先级3-在类运行前运行：@BeforeClass");
    }

    @BeforeMethod
    public void test4(){
        System.out.println("在每个@Test运行前运行：@BeforeMethod");
    }

    @Test
    public void test2(){
        System.out.println("@Test1");
    }


    @Test
    public void test5(){
        System.out.println("@Test2");
    }

    @Test(groups = "group1")
    public void test6(){
        System.out.println("在特定的group运行前执行：@Test(groups = \"group1\")");
    }

    @Test(groups = "group2")
    public void test7(){
        System.out.println("@Test(groups = \"group2\")");
    }


    @BeforeGroups(groups = "group2")
    public void test8(){
        System.out.println("@BeforeGroups(groups = \"group2\")");
    }

}