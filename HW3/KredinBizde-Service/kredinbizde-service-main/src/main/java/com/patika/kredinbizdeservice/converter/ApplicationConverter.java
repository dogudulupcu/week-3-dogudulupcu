package com.patika.kredinbizdeservice.converter;

import com.patika.kredinbizdeservice.client.dto.response.ApplicationResponse;
import com.patika.kredinbizdeservice.dto.request.ApplicationRequest;
import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.model.User;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Builder
public class ApplicationConverter {

    public Application toApplication( User user, Loan loan) {
        Application application = new Application();
        application.setUser(user);
        application.setLoan(loan);
        application.setLocalDateTime(LocalDate.now());
        return application;
    }


}
