package com.test.web;

import com.test.domain.DataTable;
import com.test.dto.DataTableDTO;
import com.test.service.DataTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by deliriy on 06.10.2016.
 */
@RestController
@RequestMapping(value = "/api/data", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataTableRestController {

    @Autowired
    DataTableService dataTableService;

    @RequestMapping(value = "/reload", method = RequestMethod.GET)
    public List<DataTableDTO> load() throws IOException {
        return dataTableService.reloadData();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<DataTableDTO> findAll() {
        return dataTableService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DataTableDTO find(@PathVariable("id") long id) {
        return dataTableService.find(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity add(@Valid @RequestBody DataTableDTO dataTable, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        DataTableDTO data = dataTableService.add(dataTable);
        return ResponseEntity.ok(data);

    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody DataTableDTO dataTable, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        DataTableDTO data = dataTableService.update(dataTable);
        return ResponseEntity.ok(data);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public DataTableDTO delete(@PathVariable("id") long id) {
        return dataTableService.delete(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllUsers() {
        dataTableService.deleteAll();
    }

    @RequestMapping(value = "/byCount", method = RequestMethod.GET)
    public Map<String, Long> findCountByGroupRenderingEngine() {
        return dataTableService.getCountByGroupRenderingEngine();
    }

    @RequestMapping(value = "/byGroup", method = RequestMethod.GET)
    public Map<String, List<DataTable>> getDataByGroupRenderingEngine() {
        return dataTableService.getDataByGroupRenderingEngine();
    }

}
