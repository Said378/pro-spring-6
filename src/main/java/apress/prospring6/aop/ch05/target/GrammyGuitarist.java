package apress.prospring6.aop.ch05.target;

import apress.prospring6.aop.ch05.model.Guitar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrammyGuitarist implements Singer {

    private static Logger logger = LoggerFactory.getLogger(Singer.class);

    @Override
    public void sign() {

        logger.info("sign: gravity is working against me\n" +
                "And gravity want to bring me down");
    }

    public void sign(Guitar guitar){
        logger.info("play: " + guitar.play());
    }

    public void talk(){
        logger.info("talk");
    }


}
