package com.test.web;

import com.test.dto.DataTableDTO;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by deliriy on 10.10.2016.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DataTableRestControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    @Test
    public void load() throws Exception {
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("/api/data/reload", Object[].class);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void findAll() throws Exception {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("/api/data/", String.class);
        assertEquals(forEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void find() throws Exception {
        ResponseEntity<Object> forEntity = restTemplate.getForEntity("/api/data/{id}", Object.class, 1);
        assertEquals(forEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void add() throws Exception {
        DataTableDTO dataTableDTO = new DataTableDTO();
        dataTableDTO.setRenderingEngine("none");
        dataTableDTO.setBrowser("Mozilla");
        dataTableDTO.setPlatform("nix");
        dataTableDTO.setEngineVersion(2.5f);
        dataTableDTO.setCssGrade("a");
        DataTableDTO responseDto = restTemplate.postForObject("/api/data/", dataTableDTO, DataTableDTO.class);
        System.out.println(responseDto);
        Assert.assertNotNull(responseDto.getId());
    }

    @Test
    public void update() throws Exception {
        DataTableDTO dataTableDTO = new DataTableDTO();
        dataTableDTO.setId(1l);
        dataTableDTO.setRenderingEngine("none");
        dataTableDTO.setBrowser("Mozilla");
        dataTableDTO.setPlatform("nix");
        dataTableDTO.setEngineVersion(2.5f);
        dataTableDTO.setCssGrade("a");
        restTemplate.put("/api/data/", dataTableDTO);
        DataTableDTO response = restTemplate.getForObject("/api/data/{id}", DataTableDTO.class, 1);
        Assert.assertEquals(dataTableDTO, response);
    }

    @Test
    public void delete() throws Exception {
        ResponseEntity<DataTableDTO> response = restTemplate.getForEntity("/api/data/{id}", DataTableDTO.class, 2);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        restTemplate.delete("/api/data/{id}", 2);
        response = restTemplate.getForEntity("/api/data/{id}", DataTableDTO.class, 2);
        Assert.assertNotEquals(response.getStatusCode(), HttpStatus.OK);
    }


    @Test
    public void findCountByGroupRenderingEngine() throws Exception {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("/api/data/byCount", String.class);
        assertEquals(forEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void getDataByGroupRenderingEngine() throws Exception {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("/api/data/byGroup", String.class);
        assertEquals(forEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void deleteAll() throws Exception {
        restTemplate.delete("/api/data/");
        ResponseEntity<Object[]> response = restTemplate.getForEntity("/api/data", Object[].class);
        Assert.assertEquals(response.getBody().length, 0);
        load();
    }

}