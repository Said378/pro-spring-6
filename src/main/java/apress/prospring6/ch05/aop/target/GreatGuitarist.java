package apress.prospring6.ch05.aop.target;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreatGuitarist implements Singer {

    Logger logger = LoggerFactory.getLogger(GreatGuitarist.class);

    @Override
    public void sign() {
        logger.info("You have got my soul in your hand");

    }
}
