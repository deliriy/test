package com.test.service;

import com.test.domain.DataTable;
import com.test.dto.DataTableDTO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by deliriy on 06.10.2016.
 */
public interface DataTableService {
    List<DataTableDTO> reloadData() throws IOException;

    List<DataTableDTO> findAll();

    DataTableDTO find(Long id) throws IllegalArgumentException;

    DataTableDTO delete(long data) throws IllegalArgumentException;

    DataTableDTO add(DataTableDTO data);

    DataTableDTO update(DataTableDTO data) throws IllegalArgumentException;

    Map<String, Long> getCountByGroupRenderingEngine();

    Map<String, List<DataTable>> getDataByGroupRenderingEngine();

    void deleteAll();
}
