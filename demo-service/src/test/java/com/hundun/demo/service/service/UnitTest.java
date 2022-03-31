package com.hundun.demo.service.service;

import com.hundun.demo.service.util.MockStaticUtil;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate()
@PrepareForTest(MockStaticUtil.class)
public class UnitTest {

    public UnitTest() {
        System.out.println("Construct！ 每个测试用例都会重新调用构造函数。");
    }

//    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("[@BeforeClass2] beforeClassInit");
        PowerMockito.mockStatic(MockStaticUtil.class);
        PowerMockito.when(MockStaticUtil.getStaticMethodName())
                .thenCallRealMethod();
    }

    @BeforeClass
    public static void beforeClassInit() {
        PowerMockito.mockStatic(MockStaticUtil.class);
        PowerMockito.when(MockStaticUtil.getStaticMethodName())
                .thenReturn("change to change");
        // 1)对方法 getChanges(String str) 进行 Mock, 参数为`null`时
        PowerMockito.when(MockStaticUtil.getChanges(Mockito.isNull())).thenReturn("Null");
        // 2)对方法 getChanges(String str) 进行 Mock, 参数不为`null`时
        PowerMockito.when(MockStaticUtil.getChanges(Mockito.anyString()))
                .thenAnswer((invocation)->{
                    Arrays.stream(invocation.getArguments()).forEach(v->{
                        System.out.println("[GetChanges[:invocation]]" + v.toString());
                    });
                    return "MOCK_ANY_" + invocation.getArgument(0);
                });
        // 3)不会完全覆盖上方的 Mock, 新增特定的 ‘123’ 的 mock 数据
        PowerMockito.when(MockStaticUtil.getChanges("123")).thenCallRealMethod();
        // 4)不会完全覆盖上方的 Mock, 新增特定的 ‘456’ 的 mock 数据
        PowerMockito.when(MockStaticUtil.getChanges("456")).thenCallRealMethod();
        // 2) 与 3、4) 对调时，会导致 3、4 被覆盖
    }

    @AfterClass
    public static void afterClassInit() {
        System.out.println("[@AfterClass] afterClassInit");
    }

    @Before
    public void beforeEveryMethod() {
        System.out.println("[@Before] beforeEveryMethod");
    }

    @After
    public void afterEveryMethod() {
        System.out.println("[@After] afterEveryMethod");
    }
    @Test
    public void test1(){
        System.out.println("test1");
        Assert.assertSame("123","123");
    }

    @Test
    public void test2(){
        System.out.println("test2");
        Assert.assertSame("123",new String("123"));
    }

    @Test
    public void mockTest() throws Exception {
        String str = null;
        str = MockStaticUtil.getChanges(null);
        System.out.println("[GetChanges[:Null]] " + str);
        str = MockStaticUtil.getChanges("11223");
        System.out.println("[GetChanges[:One]] " + str);
        str = MockStaticUtil.getChanges("123");
        System.out.println("[GetChanges[:Two]] " + str);
        str = MockStaticUtil.getChanges("456");
        System.out.println("[GetChanges[:Three]] " + str);
    }
}
