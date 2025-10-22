package apress.prospring6.ch05.aop.target;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoodGuitarist implements Singer {

    private static final Logger logger = LoggerFactory.getLogger(GoodGuitarist.class);

    @Override
    public void sign() {
        logger.info("Head on your heart, arms around me");
    }
}
