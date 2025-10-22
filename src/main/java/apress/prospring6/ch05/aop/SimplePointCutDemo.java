package apress.prospring6.ch05.aop;

import apress.prospring6.ch05.aop.advice.SimpleAroundAdvice;
import apress.prospring6.ch05.aop.pointcut.SimpleDynamicPointCut;
import apress.prospring6.ch05.aop.pointcut.SimpleStaticPointCut;
import apress.prospring6.ch05.aop.target.GoodGuitarist;
import apress.prospring6.ch05.aop.target.GreatGuitarist;
import apress.prospring6.ch05.aop.target.Singer;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;


public class SimplePointCutDemo {

    public static void main(String[] args) {

      //  staticPointCut();
        dynamicPointCut();
    }


    public static void staticPointCut(){
        GoodGuitarist johnMayer = new GoodGuitarist();
        GreatGuitarist ericClapton = new GreatGuitarist();

        Singer proxyOne;
        Singer proxyTwo;

        Pointcut pointcut = new SimpleStaticPointCut();
        Advice advice = new SimpleAroundAdvice();

        /** Advisor is Spring's representation of an aspect which is coupling of advice and pointcut
         *   DefaultPointcutAdvisor is a simple PointcutAdvisor for associating a single pointcut with single advice
         **/
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(johnMayer);
        proxyOne = (Singer)  proxyFactory.getProxy();

        proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(ericClapton);
        proxyTwo = (Singer)  proxyFactory.getProxy();

        proxyOne.sign();
        proxyTwo.sign();
    }

    public static void dynamicPointCut(){
        GoodGuitarist target = new GoodGuitarist();
        Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointCut(), new SimpleAroundAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(target);

        Singer proxy = (Singer)  proxyFactory.getProxy();

        proxy.sign("C");
        proxy.sign("c");
        proxy.sign("E");

        proxy.sign();
    }
}
