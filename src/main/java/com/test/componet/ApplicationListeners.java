package com.test.componet;

import com.test.service.DataTableService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

/**
 * Created by deliriy on 07.10.2016.
 */
@Component
@Log
public class ApplicationListeners {

    @Autowired
    DataTableService tableService;

    @EventListener({ContextRefreshedEvent.class})
    void contextRefreshedEvent() {
//        try {
////            tableService.reloadData();
//            log.info("Data success loaded");
//        } catch (Exception e) {
//            log.log(Level.SEVERE, "Data not loaded: ", e);
//        }
    }
}
