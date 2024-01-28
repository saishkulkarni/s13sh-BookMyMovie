package com.s13sh.bookmymovie.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Component
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 3, max = 10, message = "* Enter between 3~10 characters")
    private String name;
    @NotEmpty(message = "* this is required field")
    @Email(message = "* Enter proper email address")
    private String email;
    @Size(min = 3, max = 10, message = "* Enter between 3~10 characters")
    private String password;
    @NotEmpty(message = "* this is required field")
    private String gender;
    @NotNull(message = "* this is required field")
    @DecimalMax(value = "9999999999", message = "* Enter proper mobile number")
    @DecimalMin(value = "6000000000", message = "* Enter proper mobile number")
    private long mobile;
    @NotNull(message = "* this is required field")
    @Past(message = "* Enter valid Date")
    private LocalDate dob;
    private String role;
}
