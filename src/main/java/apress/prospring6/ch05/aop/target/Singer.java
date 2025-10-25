package apress.prospring6.ch05.aop.target;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Singer {

    Logger logger = LoggerFactory.getLogger(Singer.class);

    void sign();

    default void sign(String key) {
        logger.info("Signing in the key of {} ", key);
    }
}
