package lab5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.testng.collections.Lists;

import java.lang.Math;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.Scanner;


public class ClassTest {

    private WebDriver driver;
    private int count=1;//количество строк в датапровайдере

//    @BeforeClass()
//    public void setUp() {
//      //  count=6;
//        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//        driver = new FirefoxDriver();
//        driver.get("https://passport.yandex.ru/registration/mail?from=mail&origin=home_desktop_ru&retpath=https%3A%2F%2Fmail.yandex.ru%2F");
//
//    }
//
//    @AfterClass()
//    public void downUp(){
//
//        driver.quit();
//    }

//    @Test()
//    public void WebTest() {
//        driver.findElement(By.id("firstname")).sendKeys( "Иван");
//        driver.findElement(By.id("lastname")).sendKeys( "Иванов");
//        driver.findElement(By.id("login")).sendKeys( "djgnks");
//        driver.findElement(By.id("password")).sendKeys( "dfghjnbvcx");
//        driver.findElement(By.id("password_confirm")).sendKeys( "dfghjnbvcx");
//        driver.findElement(By.id("password_confirm")).sendKeys( "dfghjnbvcx");
//        Assert.assertTrue(driver.getTitle().equals("Регистрация"));
//    }

    @DataProvider(name = "Test1_Data1")
    public Object[][] Data1()
    {
//        Object[][] obj=new Object[count][1];
//               for(int i=0; i<count;i++)
//               {
//                   obj[i][0]=(int)(Math.random() * Integer.MIN_VALUE );
//               }
        return  new Object[][]{{Integer.MIN_VALUE},{Integer.MAX_VALUE},{-1}};
    }

    @DataProvider(name = "Test2_Data1")
    public Object[][] Data2()
    {
        Object[][] obj=new Object[count][2];
        for(int i=0; i<count;i++)
        {
            obj[i][0]= (int)(Math.random() * Integer.MAX_VALUE - 1);
            obj[i][1]= (int)(Math.random() * Integer.MIN_VALUE + 1);
        }
        return  obj;
    }

    @DataProvider(name = "Test2_Data2")
    public Object[][] Data3()
    {
        List<Object[]> result = Lists.newArrayList();

        Object[][] obj1=new Object[count][1];
        for(int i=0; i<count;i++)
        {
            obj1[i][0]=(int)(Math.random() * Integer.MAX_VALUE);
        }
        Object[][] obj2=new Object[][]{{0},{1},{2}};

        result.addAll(Arrays.asList(obj1));
        result.addAll(Arrays.asList(obj2));

        return result.toArray(new Object[result.size()][]);
    }

    @DataProvider(name = "Test2_Data3")
    public Object[][] Data4()
    {

        Object[][] obj=new Object[count][1];
        for(int i=0; i<count;i++)
        {
            obj[i][0]=(int)(Math.random() * Integer.MIN_VALUE);
        }
        return  obj;
    }

    @DataProvider(name = "Test3_Data1")
    public Object[][] Data5()
    {

        Object[][] obj=new Object[count][2];
        for(int i=0; i<count;i++)
        {
            obj[i][0]=(int)(Math.random() * Integer.MAX_VALUE);
            obj[i][1]=(int)(Math.random() * Integer.MAX_VALUE);
        }
        return  obj;
    }


    @Test(dataProvider = "Test1_Data1")
    public void FirstModule(int n)
    {
        System.out.println("Тест 1. Позитивный тест Math.abs(n) (корректные значения) ");



        int res =Math.abs(n);
        try {

            System.out.println("n = " + n);
            System.out.println("Модуль n = " + res);
            Assert.assertEquals(res,  n=n < 0 ? -n : n);
            Assert.assertFalse(res==-2147483648, "Особая задукументированная ситуация");
        }
        catch (AssertionError e)
        {
            System.out.println("java.lang.AssertionError: Модуль посчитан неверно expected [false] but found [true]");
            System.out.println("Текущее исключение: " + e);
            Assert.assertEquals(e.toString(),"java.lang.AssertionError: Особая задукументированная ситуация expected [false] but found [true]");
        }
        System.out.println();
    }

    @Test(dataProvider = "Test2_Data1")
    public void SecondModule1(int n, int m)
    {
        System.out.println("Тест 2. Позитивный тест Math.addExact (корректные значения)");

        int sum = Math.addExact(n,m);
        Assert.assertEquals(sum,n + m);
        System.out.println("Значение с помощью addExact = " + sum);
        System.out.println("Проверочное значение = " + (n + m));
        System.out.println();
    }

    @Test(dataProvider = "Test2_Data2")
    public void SecondModule2(int m)
    {
        System.out.println("Тест 3. Негативный тест Math.addExact переполнение положительными числами");

        int n = Integer.MAX_VALUE;
        try {
            int sum = Math.addExact(n,m);
        }
        catch (RuntimeException e)
        {
            System.out.println("Ожидаемое исключение: java.lang.ArithmeticException: integer overflow");
            System.out.println("Текущее исключение: " + e);
            Assert.assertEquals(e.toString(),"java.lang.ArithmeticException: integer overflow");
        }
        System.out.println();
    }

    @Test(dataProvider = "Test2_Data3")
    public void SecondModule3(int m)
    {
        System.out.println("Тест 4. Негативный тест Math.addExact переполнение отрицательными числами");

        int n = Integer.MIN_VALUE;
        try {
            int sum = Math.addExact(n,m);
            }
        catch (RuntimeException e)
        {
            System.out.println("Ожидаемое исключение: java.lang.ArithmeticException: integer overflow");
            System.out.println("Текущее исключение: " + e);
            Assert.assertEquals(e.toString(),"java.lang.ArithmeticException: integer overflow");
        }
        System.out.println();
    }

    @Test(dataProvider = "Test3_Data1")
    public void ThirdModule1(int n, int m)
    {
        System.out.println("Тест 5. Позитивный тест Math.floorDiv (корректные значения)");
        int res =n/m;
        int result = Math.floorDiv(n, m);
        System.out.println("Первое число = " + n + "; Второе число = " + m);
        System.out.println("Результат floorDiv: " + result);
        System.out.println("Проверка: " + res);
        Assert.assertEquals(result, res);
        System.out.println();
    }

    @Test(dataProvider = "Test1_Data1")
    public void ThirdModule2(int n)
    {
        System.out.println("Тест 6. Негативный тест Math.floorDiv (делением на ноль)");

        int m = 0;
        try {
            Math.floorDiv(n,m);
        }
        catch (Throwable e)
        {
            System.out.println("Ожидаемое исключение: java.lang.ArithmeticException: / by zero");
            System.out.println("Текущее исключение: " + e);
            Assert.assertEquals(e.toString(),"java.lang.ArithmeticException: / by zero");
        }
        System.out.println();

    }
}
