package com.netcompany.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    @NotBlank(message = "Cannot be Null")
    private String name;
    private String authorFirstName;
    private String authorLastName;
    private int authorAge;
    private String genre;



}
