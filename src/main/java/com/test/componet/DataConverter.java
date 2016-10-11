package com.test.componet;

import com.test.dto.DataTableDTO;
import org.jsoup.select.Elements;
import org.modelmapper.AbstractConverter;

/**
 * Created by deliriy on 06.10.2016.
 */

public class DataConverter extends AbstractConverter<Elements, DataTableDTO> {
    @Override
    protected DataTableDTO convert(Elements elements) {
        DataTableDTO dataTableDTO = new DataTableDTO();
        dataTableDTO.setRenderingEngine(elements.get(0).text());
        dataTableDTO.setBrowser(elements.get(1).text());
        dataTableDTO.setPlatform(elements.get(2).text());

        String engineVersion = elements.get(3).text();
        if (!engineVersion.equals("-"))
            dataTableDTO.setEngineVersion(Float.valueOf(engineVersion));

        dataTableDTO.setCssGrade(elements.get(4).text());
        return dataTableDTO;
    }
}
