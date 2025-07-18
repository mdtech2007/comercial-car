package com.md.car.accounts.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.md.car.parameters.models.CommonObject;

import jakarta.persistence.Entity;
import lombok.Data;


@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class TransactionStatus extends CommonObject {
}
