package com.test.service;

import com.test.componet.DataParser;
import com.test.domain.DataTable;
import com.test.dto.DataTableDTO;
import com.test.repository.DataTableDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by deliriy on 06.10.2016.
 */
@Service
public class DataTableServiceImpl implements DataTableService {
    @Autowired
    DataTableDao dataTableDao;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    DataParser dataParser;

    @Override
    public List<DataTableDTO> reloadData() throws IOException {
        dataParser.load().forEach(dataTableDTO ->
                dataTableDao.save(modelMapper.map(dataTableDTO, DataTable.class)));
        return findAll();
    }

    @Override
    public List<DataTableDTO> findAll() {
        return dataTableDao.findAll().stream()
                .map((dataTable) -> modelMapper.map(dataTable, DataTableDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DataTableDTO find(Long id) throws IllegalArgumentException {
        DataTable entity = dataTableDao.findOne(id);
        if (entity != null) {
            return modelMapper.map(entity, DataTableDTO.class);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Map<String, Long> getCountByGroupRenderingEngine() {
        return dataTableDao.findAll().stream()
                .collect(Collectors.groupingBy((data) -> data.getRenderingEngine(), Collectors.counting()));
    }

    @Override
    public Map<String, List<DataTable>> getDataByGroupRenderingEngine() {
        return dataTableDao.findAll().stream()
                .collect(Collectors.groupingBy((data) -> data.getRenderingEngine(), Collectors.toList()));
    }

    @Override
    public DataTableDTO delete(long id) throws IllegalArgumentException {
        DataTable entity = dataTableDao.findOne(id);
        if (entity != null) {
            dataTableDao.delete(id);
            return modelMapper.map(entity, DataTableDTO.class);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public DataTableDTO add(DataTableDTO data) {
        DataTable entity = modelMapper.map(data, DataTable.class);
        entity = dataTableDao.save(entity);
        return modelMapper.map(entity, DataTableDTO.class);
    }

    @Override
    public DataTableDTO update(DataTableDTO data) throws IllegalArgumentException {
        DataTable entity = dataTableDao.findOne(data.getId());
        if (entity != null) {
            modelMapper.map(data, entity);
            entity = dataTableDao.save(entity);
            return modelMapper.map(entity, DataTableDTO.class);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void deleteAll() {
        List<DataTable> all = dataTableDao.findAll();
        dataTableDao.delete(all);
    }
}
