package com.test.componet;

/**
 * Created by deliriy on 06.10.2016.
 */

import com.test.dto.DataTableDTO;
import org.jsoup.Connection;
import org.jsoup.select.Elements;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataParser {

    Connection connection;
    ModelMapper mapper;
    String tableSelector;

    @Autowired
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Value("${table_selector}")
    public void setTableSelector( String tableSelector) {
        this.tableSelector = tableSelector;
    }

    public List<DataTableDTO> load() throws IOException {
        Elements rows = connection.get().select(tableSelector + " tbody tr");
        return rows.stream().map((row) -> mapper.map(row.select("td"), DataTableDTO.class))
                .collect(Collectors.toList());
    }

}
