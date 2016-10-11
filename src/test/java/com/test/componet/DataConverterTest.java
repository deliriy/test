package com.test.componet;

import com.test.dto.DataTableDTO;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


/**
 * Created by deliriy on 10.10.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class DataConverterTest {

    @Mock
    Elements elements;
    Tag DIV = Tag.valueOf("div");
    DataConverter dataConverter = new DataConverter();

    @Before
    public void setUp() throws Exception {
        Mockito.when(elements.get(0)).thenReturn(new Element(DIV, "").appendText("v_0"));
        Mockito.when(elements.get(1)).thenReturn(new Element(DIV, "").appendText("v_1"));
        Mockito.when(elements.get(2)).thenReturn(new Element(DIV, "").appendText("v_2"));
        Mockito.when(elements.get(3)).thenReturn(new Element(DIV, "").appendText("3.3"));
        Mockito.when(elements.get(4)).thenReturn(new Element(DIV, "").appendText("v_4"));
    }

    @Test
    public void convertTest() throws Exception {
        DataTableDTO dataTableDTO = dataConverter.convert(elements);

        Assert.assertEquals(dataTableDTO.getRenderingEngine(), elements.get(0).text());
        Assert.assertEquals(dataTableDTO.getBrowser(), elements.get(1).text());
        Assert.assertEquals(dataTableDTO.getPlatform(), elements.get(2).text());
        Assert.assertEquals(dataTableDTO.getEngineVersion(), Float.valueOf(elements.get(3).text()));
        Assert.assertEquals(dataTableDTO.getCssGrade(), elements.get(4).text());
    }

    @Test
    public void testEngineVersionIsNull() {
        Mockito.when(elements.get(3)).thenReturn(new Element(DIV, "").appendText("-"));
        DataTableDTO dataTableDTO = dataConverter.convert(elements);
        Assert.assertNull(dataTableDTO.getEngineVersion());
    }


}