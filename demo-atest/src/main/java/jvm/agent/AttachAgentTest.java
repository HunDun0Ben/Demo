package jvm.agent;

import java.lang.instrument.Instrumentation;

/**
 * JVM 启动后，通过 attach 添加 agent
 */
public class AttachAgentTest {

    String MD5;

    public static void agentmain(String agentArgs, Instrumentation inst){
        
    }

    public static void agentmain(String agentArgs){

    }

    public static void main(String[] args) {
        System.out.println(AttachAgentTest.class.getCanonicalName());
        System.out.println(AttachAgentTest.class.getTypeName());
        System.out.println(AttachAgentTest.class.getName());
    }
}