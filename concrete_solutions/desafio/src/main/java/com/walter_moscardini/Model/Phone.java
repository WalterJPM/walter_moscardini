package com.walter_moscardini.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "{phone.number.NotNull}")
    @NotBlank(message = "{phone.number.NotBlank}")
    private String number;

    @NotNull(message = "{phone.ddd.NotNull}")
    @NotBlank(message = "{phone.ddd.NotBlank}")
    private String ddd;

    public Phone() {}

    public Phone(@NotNull @NotBlank String number, @NotNull @NotBlank String ddd) {
        this.number = number;
        this.ddd = ddd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
}
