package com.oliverloenning.testapp2.interfaces;

import java.time.LocalDateTime;

public interface Movement {
    LocalDateTime getTime();
    long getAmount();
}
