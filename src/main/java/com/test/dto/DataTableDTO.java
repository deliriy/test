package com.test.dto;

import lombok.*;

import javax.persistence.*;

/**
 * Created by deliriy on 06.10.2016.
 */

@Data
public class DataTableDTO {

    Long id;
    String renderingEngine;
    String browser;
    String platform;
    Float EngineVersion;
    String cssGrade;

}
