package com.linkedin.codesnippets.streams;

import java.util.IntSummaryStatistics;

public class SpecializedIntSummaryStatistics extends IntSummaryStatistics {

    private int median = 0;
    @Override
    public void accept(int value) {
        super.accept(value);
        median = 1;
    }
}
