package org.daming.gwwf.logger;

import org.slf4j.Logger;

import java.util.function.Supplier;

public class DamingLogger {

    private final Logger logger;

    public void trace(String message) {
        if (logger.isTraceEnabled()) {
            logger.trace(message);
        }
    }

    public void trace(String format, Object...params) {
        if (logger.isTraceEnabled()) {
            logger.trace(format, params);
        }
    }


    public void trace(String message, Throwable cause) {
        if (logger.isTraceEnabled()) {
            logger.trace(message, cause);
        }
    }

    public void trace(Supplier<String> messageSupplier) {
        if (logger.isTraceEnabled()) {
            logger.trace(nullSafeGet(messageSupplier));
        }
    }

    public void trace(Supplier<String> messageSupplier, Throwable cause) {
        if (logger.isTraceEnabled()) {
            logger.trace(nullSafeGet(messageSupplier), cause);
        }
    }

    public void trace(Supplier<String> messageSupplier, Supplier<Throwable> causeSupplier) {
        if (logger.isTraceEnabled()) {
            logger.trace(nullSafeGet(messageSupplier), nullSafeGet(causeSupplier));
        }
    }


    public void debug(String message) {
        if (logger.isDebugEnabled()) {
            logger.debug(message);
        }
    }

    public void debug(String format, Object...params) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, params);
        }
    }


    public void debug(String message, Throwable cause) {
        if (logger.isDebugEnabled()) {
            logger.debug(message, cause);
        }
    }

    public void debug(Supplier<String> messageSupplier) {
        if (logger.isDebugEnabled()) {
            logger.debug(nullSafeGet(messageSupplier));
        }
    }

    public void debug(Supplier<String> messageSupplier, Throwable cause) {
        if (logger.isDebugEnabled()) {
            logger.debug(nullSafeGet(messageSupplier), cause);
        }
    }

    public void debug(Supplier<String> messageSupplier, Supplier<Throwable> causeSupplier) {
        if (logger.isDebugEnabled()) {
            logger.debug(nullSafeGet(messageSupplier), nullSafeGet(causeSupplier));
        }
    }

    public void info(String message) {
        if (logger.isInfoEnabled()) {
            logger.info(message);
        }
    }

    public void info(String format, Object...params) {
        if (logger.isInfoEnabled()) {
            logger.info(format, params);
        }
    }


    public void info(String message, Throwable cause) {
        if (logger.isInfoEnabled()) {
            logger.info(message, cause);
        }
    }

    public void info(Supplier<String> messageSupplier) {
        if (logger.isInfoEnabled()) {
            logger.info(nullSafeGet(messageSupplier));
        }
    }

    public void info(Supplier<String> messageSupplier, Throwable cause) {
        if (logger.isInfoEnabled()) {
            logger.info(nullSafeGet(messageSupplier), cause);
        }
    }

    public void info(Supplier<String> messageSupplier, Supplier<Throwable> causeSupplier) {
        if (logger.isInfoEnabled()) {
            logger.info(nullSafeGet(messageSupplier), nullSafeGet(causeSupplier));
        }
    }

    public void warn(String message) {
        if (logger.isWarnEnabled()) {
            logger.warn(message);
        }
    }

    public void warn(String format, Object...params) {
        if (logger.isWarnEnabled()) {
            logger.warn(format, params);
        }
    }



    public void warn(String message, Throwable cause) {
        if (logger.isWarnEnabled()) {
            logger.warn(message, cause);
        }
    }

    public void warn(Supplier<String> messageSupplier) {
        if (logger.isWarnEnabled()) {
            logger.warn(nullSafeGet(messageSupplier));
        }
    }

    public void warn(Supplier<String> messageSupplier, Throwable cause) {
        if (logger.isWarnEnabled()) {
            logger.warn(nullSafeGet(messageSupplier), cause);
        }
    }

    public void warn(Supplier<String> messageSupplier, Supplier<Throwable> causeSupplier) {
        if (logger.isWarnEnabled()) {
            logger.warn(nullSafeGet(messageSupplier), nullSafeGet(causeSupplier));
        }
    }

    public void error(String message) {
        if (logger.isWarnEnabled()) {
            logger.error(message);
        }
    }

    public void error(String format, Object...params) {
        if (logger.isWarnEnabled()) {
            logger.error(format, params);
        }
    }


    public void error(String message, Throwable cause) {
        if (logger.isWarnEnabled()) {
            logger.error(message, cause);
        }
    }

    public void error(Supplier<String> messageSupplier) {
        if (logger.isWarnEnabled()) {
            logger.error(nullSafeGet(messageSupplier));
        }
    }

    public void error(Supplier<String> messageSupplier, Throwable cause) {
        if (logger.isWarnEnabled()) {
            logger.error(nullSafeGet(messageSupplier), cause);
        }
    }

    public void error(Supplier<String> messageSupplier, Supplier<Throwable> causeSupplier) {
        if (logger.isWarnEnabled()) {
            logger.error(nullSafeGet(messageSupplier), nullSafeGet(causeSupplier));
        }
    }

    private <T> T nullSafeGet(Supplier<T> supplier) {
        return supplier != null ? supplier.get() : null;
    }


    DamingLogger(Logger logger) {
        super();
        this.logger = logger;
    }
}
