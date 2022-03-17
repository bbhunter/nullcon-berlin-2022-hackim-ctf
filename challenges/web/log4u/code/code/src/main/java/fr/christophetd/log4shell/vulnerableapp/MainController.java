package fr.christophetd.log4shell.vulnerableapp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class MainController {

    private static final Logger logger = LogManager.getLogger("HelloWorld");

    @GetMapping("/")
    public String index(@RequestHeader(value = "X-Api-Version", defaultValue="default") String apiVersion) {
        logger.info("Received a request for API version " + apiVersion);
        return "Value of X-Api-Version: " + apiVersion + "\nYou'll find the flag here: /FLAG";
    }

}