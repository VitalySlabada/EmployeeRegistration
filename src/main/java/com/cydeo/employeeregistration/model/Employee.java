package com.cydeo.employeeregistration.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {

    //  validation annotation
//    @NotNull    // Anything except null
//    @NotEmpty   // Anything except null and ""
//    @NotBlank   // Anything except " ", "", null
//    @NotBlank(message =) --prints custom message in console

    @NotBlank
    @Size(max=12, min=2)
    public String firstName;

    @NotBlank
    public String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate birthday;

    public String email;

    public String password;

    public String address;

    public String address2;

    public String city;

    public String state;

    public String zipCode;

}
