package com.hamitmizrak.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hamitmizrak.data.entity.BaseEntityAudit;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Getter @Setter
public class DAOUser extends BaseEntityAudit {

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column(name = "system_auto_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date date;

}
