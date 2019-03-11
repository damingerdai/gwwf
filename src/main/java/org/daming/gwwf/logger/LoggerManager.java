package org.daming.gwwf.logger;

import com.google.common.collect.Maps;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class LoggerManager {

    private static Map<String, DamingLogger> cache = Maps.newHashMap();

    public static DamingLogger getLogger(String loggerName) {
        return cache.computeIfAbsent(loggerName, LoggerManager::buildLogger);
    }

    public static DamingLogger getLogger(Class<?> loggerClass) {
        return getLogger(loggerClass.getName());
    }

    private static  DamingLogger buildLogger(String loggerName) {
        return new DamingLogger(LoggerFactory.getLogger(loggerName));
    }
}
