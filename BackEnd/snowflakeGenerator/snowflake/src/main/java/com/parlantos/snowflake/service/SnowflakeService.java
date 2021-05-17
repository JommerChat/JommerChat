package com.parlantos.snowflake.service;

import org.springframework.stereotype.Service;

@Service
public class SnowflakeService {

    private static final Snowflake snowflake = new Snowflake();

    public Long generateSnowflake() {
        return snowflake.nextId();
    }
}
