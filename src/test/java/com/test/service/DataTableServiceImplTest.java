package com.test.service;

import com.test.repository.DataTableDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by deliriy on 10.10.2016.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DataTableServiceImplTest {

    @Autowired
    DataTableDao dataTableDao;
//    @Spy
//    ModelMapper modelMapper = new ModelMapper();
//    @Spy
//    DataParser dataParser = new DataParser();


    @Test
    public void reloadData() throws Exception {
//        Assert.assertNull(null);
    }

//    @Test
//    public void findAll() throws Exception {
//
//    }
//
//    @Test
//    public void find() throws Exception {
//
//    }
//
//    @Test
//    public void getCountByGroupRenderingEngine() throws Exception {
//
//    }
//
//    @Test
//    public void getDataByGroupRenderingEngine() throws Exception {
//
//    }
//
//    @Test
//    public void delete() throws Exception {
//
//    }
//
//    @Test
//    public void add() throws Exception {
//
//    }
//
//    @Test
//    public void update() throws Exception {
//
//    }
//
//    @Test
//    public void deleteAll() throws Exception {
//
//    }

}