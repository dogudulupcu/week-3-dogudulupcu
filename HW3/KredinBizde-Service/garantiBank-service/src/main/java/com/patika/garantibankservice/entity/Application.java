package com.patika.garantibankservice.entity;

import com.patika.garantibankservice.enums.ApplicationStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Application {

    private long userId;
    private long loanId;
    private LocalDate createDate;
    private ApplicationStatus applicationStatus;


}
