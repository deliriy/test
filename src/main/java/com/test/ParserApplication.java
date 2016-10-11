package com.test;

import com.test.service.DataTableService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.logging.Level;

@SpringBootApplication
@Log
public class ParserApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(ParserApplication.class, args);
        DataTableService tableService = context.getBean(DataTableService.class);
        tableService.reloadData();
        System.out.println("--------------------------------------");
        System.out.println("APPLICATION SUCCESSFUL STARTED");
        System.out.println("--------------------------------------");
    }

}
