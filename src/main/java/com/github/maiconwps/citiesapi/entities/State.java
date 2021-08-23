package com.github.maiconwps.citiesapi.entities;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="estado")
@TypeDef(
        name="json",
        typeClass = JsonType.class
)
public class State {
    @Id
    private Long id;

    @Column(name="nome")
    private String name;

    private String uf;

    private Integer ibge;

    @Type(type="json")
    @Column(columnDefinition = "json")
    private List<Integer> ddd;

    @ManyToOne()
    @JoinColumn(name = "pais")
    private Country country;


    public State() {
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

    public List<Integer> getDdd() {
        return ddd;
    }

    public void setDdd(List<Integer> ddd) {
        this.ddd = ddd;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
