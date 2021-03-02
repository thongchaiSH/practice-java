package com.example.cassandra;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
import org.apache.tinkerpop.shaded.kryo.NotNull;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@Table
public class Customer {
    @PrimaryKey
    private UUID id;

    public  Customer(){
        this.id= Uuids.timeBased();
    }

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Integer age;
    @NotNull
    private String email;

}
