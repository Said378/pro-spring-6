package apress.prospring6.aop.ch05;

import apress.prospring6.aop.ch05.advice.SimpleAroundAdvice;
import apress.prospring6.aop.ch05.pointcut.SimpleStaticPointCut;
import apress.prospring6.aop.ch05.target.GoodGuitarist;
import apress.prospring6.aop.ch05.target.GreatGuitarist;
import apress.prospring6.aop.ch05.target.Singer;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointCutDemo {

    public static void main(String[] args) {

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
}
