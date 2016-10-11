package com.test.componet;

import com.test.dto.DataTableDTO;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.List;

/**
 * Created by deliriy on 10.10.2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class DataParserTest {
    String TEST_HTML =
            "<table id=\"example1\"> \n" +
                    "<tbody> \n" +
                    "<tr> \n" +
                    "<td>Trident</td><td>Internet Explorer 4.0 </td><td>Win 95+</td><td> 4</td><td>X</td> \n" +
                    "</tr> \n" +
                    "<tr> \n" +
                    "<td>Trident</td><td>Internet Explorer 5.0 </td><td>Win 95+</td><td>5</td><td>C</td> \n" +
                    "</tr> \n" +
                    "</tbody> \n" +
                    "</table> ";

    private final String SELECTOR = "table#example1";

    @Mock
    Connection connection;
    @Spy
    ModelMapper mapper = new ModelMapper();

    @InjectMocks
    DataParser dataParser = new DataParser();

    @BeforeClass
    public void setUp() throws Exception {
        dataParser.setTableSelector(SELECTOR);
    }

    @Test
    public void name() throws Exception {
        Mockito.when(connection.get()).thenReturn(Jsoup.parse(TEST_HTML));
        List<DataTableDTO> loadedData = dataParser.load();
        Assert.assertEquals(loadedData.size(), 2);
    }
}