package com.walter_moscardini.Model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "{user.name.NotNull}")
    @NotBlank(message = "{user.name.NotBlank}")
    private String name;

    @NotNull(message = "{user.email.NotNull}")
    @NotBlank(message = "{user.email.NotBlank}")
    @Email(message = "{user.email.invalid}")
    @Column(unique = true)
    private String email;

    @NotNull(message = "{user.password.NotNull}")
    @NotBlank(message = "{user.password.NotBlank}")
    private String password;

    @NotNull(message = "{user.phones.NotNull}")
    @NotEmpty(message = "{user.phones.NotEmpty}")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phones;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date created;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    public User() {}

    public User(@NotNull @NotBlank String name, @NotNull @NotBlank String email, @NotNull @NotBlank String password, @NotNull @NotEmpty List<Phone> phones) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Phone> getPhones() {
        if (Objects.isNull(phones)){
            return new ArrayList<>();
        }
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

}
