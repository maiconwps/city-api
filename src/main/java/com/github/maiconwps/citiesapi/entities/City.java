package com.github.maiconwps.citiesapi.entities;

import com.github.maiconwps.citiesapi.utils.PointType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cidade")
@TypeDef(name = "point", typeClass = PointType.class)
public class City {

    @Id
    private Long id;

    @Column(name="nome")
    private String name;

    private String uf;

    private Integer ibge;

    @Type(type = "point")
    @Column(name = "lat_lon")
    private Point geolocation;

    private Double latitude;

    private Double longitude;

    @Column(name = "cod_tom")
    private Short codTom;

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public Point getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Point geolocation) {
        this.geolocation = geolocation;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Short getCodTom() {
        return codTom;
    }

    public void setCodTom(Short codTom) {
        this.codTom = codTom;
    }
}
