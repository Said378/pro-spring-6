package apress.prospring6.aop.ch05;

import apress.prospring6.aop.ch05.advice.SimpleAroundAdvice;
import apress.prospring6.aop.ch05.model.Guitar;
import apress.prospring6.aop.ch05.target.GrammyGuitarist;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class NamePointCutDemo {

    public static void main(String[] args) {

        GrammyGuitarist johnMayer = new GrammyGuitarist();


        /** this pointCut used when you want to match based on
         *  just the name of method, this ignoring method signature
         *  and return type and no consideration to the signature
         *  of the method i.e sign(), sign({key}) they both matched
         * **/
        NameMatchMethodPointcut pc = new NameMatchMethodPointcut();
        pc.addMethodName("sign");
//        pc.addMethodName("talk");

        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAroundAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(johnMayer);
        proxyFactory.addAdvisor(advisor);

        GrammyGuitarist proxy = (GrammyGuitarist) proxyFactory.getProxy();
        proxy.sign();
        proxy.sign(new Guitar());
//        proxy.talk();


    }
}
