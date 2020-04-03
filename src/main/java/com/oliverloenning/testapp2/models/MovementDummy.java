package com.oliverloenning.testapp2.models;

import com.oliverloenning.testapp2.interfaces.Movement;

import java.time.LocalDateTime;

public class MovementDummy implements Movement {
    private LocalDateTime time;
    private long amount;

    public MovementDummy(LocalDateTime time, long amount) {
        this.time = time;
        this.amount = amount;
    }

    @Override
    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public long getAmount() {
        return amount;
    }
}
