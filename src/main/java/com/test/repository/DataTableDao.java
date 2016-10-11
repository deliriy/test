package com.test.repository;

import com.test.domain.DataTable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by deliriy on 06.10.2016.
 */
@Transactional(readOnly = true)
public interface DataTableDao extends CrudRepository<DataTable, Long> {
    List<DataTable> findAll();

    DataTable findOne(Long id);

    @Transactional
    DataTable save(DataTable persisted);

    @Transactional
    void delete(DataTable deleted);

}
