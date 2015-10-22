package javaapplication1;

import javax.inject.Named;

/**
 *
 * @author sunfuji
 */
@Named
public class NewFnc {
    public static void staticDisplay(String s) {
        System.out.println("CDI fnc:" + s);
    }
}
