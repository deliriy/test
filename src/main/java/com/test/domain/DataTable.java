package com.test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by deliriy on 06.10.2016.
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DataTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "engine", length = 15)
    String renderingEngine;
    @Column(name = "browser", length = 25)
    String browser;
    @Column(name = "platform", length = 25)
    String platform;
    @Column(name = "engine_version")
    Float EngineVersion;
    @Column(name = "css_grade", length = 5)
    String cssGrade;
    @Version
    Date updated;

}
