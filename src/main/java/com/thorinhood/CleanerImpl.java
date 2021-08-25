package com.thorinhood;

import com.thorinhood.annotations.InjectRandomInt;

/**
 * @author Evgeny Borisov
 */
public class CleanerImpl implements Cleaner {

    @InjectRandomInt(min = 1, max = 5)
    private int repeat;

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVVvvvvvvvvvvvvvvvvv");
        }
    }
}
