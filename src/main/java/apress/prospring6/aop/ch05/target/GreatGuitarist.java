package apress.prospring6.aop.ch05.target;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreatGuitarist implements Singer {

    Logger logger = LoggerFactory.getLogger(GreatGuitarist.class);

    @Override
    public void sign() {
        logger.info("You have got my soul in your hand");

    }
}
