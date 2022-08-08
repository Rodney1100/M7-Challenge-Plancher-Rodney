package com.company.musicstorecatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "label")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "label_id")
    private Long id;

    @NotNull
    @Length(max = 50)
    private String name;

    @NotNull
    @Length(max = 255)
    private String website;

    public Label(Long id, String name, String website) {
        this.id = id;
        this.name = name;
        this.website = website;
    }

    public Label(String name, String website) {
        this.name = name;
        this.website = website;
    }

    public Label() {
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Label{" + "id=" + id + ", name='" + name + '\'' + ", website='" + website + '\'' + '}';
    }
}
