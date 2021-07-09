package com.parlantos.snowflake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.parlantos.snowflake.service.SnowflakeService;

@Controller
public class SnowflakeController {

    @Autowired
    private SnowflakeService snowflakeService;

    @GetMapping("snowflake")
    public ResponseEntity<Long> getSnowflakeId() {
        return new ResponseEntity<>(snowflakeService.generateSnowflake(), HttpStatus.OK);
    }

}
