@TestableClass
public class MyTest {
    //@BeforeTest
    public void BeforeTest(){
        System.out.println("BeforeTest");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest");
    }
    @Test
    public void Test1(){
        System.out.println("Test №-1");
    }
    @Test (priority = 5)
    public void Test2(){
        System.out.println("Test №-5");
    }
    @Test (priority = 3)
    public void Test3(){
        System.out.println("Test №-3");
    }
    public void Test4(){
        System.out.println("Test №-4");
    }
}
