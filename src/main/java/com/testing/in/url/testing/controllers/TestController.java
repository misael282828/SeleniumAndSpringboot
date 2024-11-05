package com.testing.in.url.testing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.testing.in.url.testing.services.TestService;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/run-tests")
    public String runTests(@RequestParam("suite") String suite) {
        return testService.runTest(suite);
    }
    
    @GetMapping
    public String test(){
      return "Probando en la url";
    }
}
