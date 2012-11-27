package org.pmg.cellar.util;

public class RandomUtil {
    public static long nextLong(){
        return (long) Math.floor(Math.random() * 900000L) + 100000L;
    }

}
