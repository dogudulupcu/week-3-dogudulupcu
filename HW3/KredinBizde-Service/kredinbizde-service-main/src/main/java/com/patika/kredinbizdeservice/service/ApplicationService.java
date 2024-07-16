package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.client.GarantiBankServiceClient;
import com.patika.kredinbizdeservice.client.dto.request.GarantiBankApplicationRequest;
import com.patika.kredinbizdeservice.client.dto.response.ApplicationResponse;
import com.patika.kredinbizdeservice.converter.ApplicationConverter;
import com.patika.kredinbizdeservice.dto.request.ApplicationRequest;
import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationService {

    private final ApplicationRepository applicationRepository = new ApplicationRepository();
    private final ApplicationConverter applicationConverter;
    private final UserService userService;
    private final LoanService loanService;
    private final GarantiBankServiceClient garantiBankServiceClient;
    private static long applicationId = 1;

    public Application save(Application application) {
        applicationRepository.save(application);
        return application;
    }

    public List<Application> getAll() {
        return applicationRepository.getAll();
    }

    public List<Application> findByUserEmail(String email) {
        Optional<List<Application>> foundApplicationList = applicationRepository.findByUserEmail(email);
        List<Application> applicationList = null;
        if (foundApplicationList.isPresent()) {
            applicationList = foundApplicationList.get();
        }
        return applicationList;
    }

    public Application findById(long id) {
        Optional<Application> foundApplication = applicationRepository.findById(id);
        Application application = null;

        if (foundApplication.isPresent()) {
            application = foundApplication.get();
        }
        return application;
    }

    public Application update(long applicationId, Application application) {
        Optional<Application> foundApplication = applicationRepository.findById(applicationId);
        if (foundApplication.isPresent()) {
            foundApplication.get().setApplicationStatus(application.getApplicationStatus());
            foundApplication.get().setApplicationId(application.getApplicationId());
            foundApplication.get().setAmount(application.getAmount());
            applicationRepository.delete(application);
            applicationRepository.save(foundApplication.get());
            return foundApplication.get();
        }
        return null;


    }

    public Application createApplication(ApplicationRequest request) {

        User user = userService.getById(request.getUserId());
        log.info("User bulundu {}",user.getEmail());

        Loan loan = loanService.findById(request.getLoanId());
        log.info("Loan bulundu {} {}",loan.getLoanId(),loan.getLoanType());

        Application application= applicationConverter.toApplication(user,loan);
        application.setApplicationId(applicationId++);

        Application savedApplication = applicationRepository.save(application);

        ApplicationResponse applicationResponse = garantiBankServiceClient.createApplication(prepareGarantiBankApplicationRequest(user,loan));

        return savedApplication;

    }

    public List<Application> getAllGarantiBankApplications(){
        List<ApplicationResponse> responseList = garantiBankServiceClient.getAll();
        log.info("applications: {}", responseList);
        return applicationRepository.getAll();
    }

    public List<Application> getGarantiBankApplicationsByUserId(long userId) {
      List<ApplicationResponse> responseList =garantiBankServiceClient.getAllByUserId(userId);
        if(applicationRepository.getAllApplicationsByUserId(responseList).isPresent()){
            return applicationRepository.getAllApplicationsByUserId(responseList).get();
        }
        return null;


    }



    private GarantiBankApplicationRequest prepareGarantiBankApplicationRequest(User user, Loan loan) {
        GarantiBankApplicationRequest applicationRequest = new GarantiBankApplicationRequest();
        applicationRequest.setUserId(user.getUserId());
        applicationRequest.setLoanId(loan.getLoanId());
        return applicationRequest;
    }


}
