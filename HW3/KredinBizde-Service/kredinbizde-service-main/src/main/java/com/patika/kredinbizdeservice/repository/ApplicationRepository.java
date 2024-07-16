package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.client.dto.response.ApplicationResponse;
import com.patika.kredinbizdeservice.enums.LoanType;
import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.model.User;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ApplicationRepository {

    private List<Application> applicationList = new ArrayList<>();



    public Application save(Application application){
        applicationList.add(application);
        return application;
    }

    public List<Application> getAll(){
        return applicationList;
    }


    public void delete(Application application){
        applicationList.remove(application);
    }

    public Optional<List<Application>> findByUserEmail(String email){
        return Optional.of(applicationList.stream()
                .filter(application -> application.getUser().getEmail().equals(email))
                .collect(Collectors.toList()));
    }

    public Optional<Application> findById(long id){
        return applicationList.stream()
                .filter(application -> application.getApplicationId() == id)
                .findFirst();
    }

   public Optional<List<Application>> findByUserId(long id){
        return Optional.of(applicationList.stream()
                .filter(application -> application.getUser().getUserId() == id)
                .collect(Collectors.toList()));
   }

   public Optional<List<Application>> getAllApplicationsByUserId(List<ApplicationResponse> responseList){
        return Optional.of(applicationList.stream()
                .filter(application -> responseList.stream().anyMatch(response -> response.getUserId() == application.getUser().getUserId()))
                .collect(Collectors.toList()));

   }


   /* public void loadData() {
        UserRepository userRepository = new UserRepository();
        LoanRepository loanRepository = new LoanRepository();
        CreditCardRepository creditCardRepository = new CreditCardRepository();

        // create 3 random applications
        User user= userRepository.findByEmail("aliveli@gmail.com").get();
        User user2= userRepository.findByEmail("cemdrman@gmail.com").get();
        User user3= userRepository.findByEmail("aysekaya@gmail.com").get();
        User user4= userRepository.findByEmail("mehmetozturk@gmail.com").get();

        CreditCard creditCard = creditCardRepository.findByName("Visa").get();
        CreditCard creditCard2 = creditCardRepository.findByName("MasterCard").get();
        CreditCard creditCard3 = creditCardRepository.findByName("American Express").get();

        Loan loan = loanRepository.findByLoanType("IHTIYAC_KREDISI").get().get(0);
        Loan loan2 = loanRepository.findByLoanType("IHTIYAC_KREDISI").get().get(1);
        Loan loan3 = loanRepository.findByLoanType("IHTIYAC_KREDISI").get().get(2);

        Loan loan4= loanRepository.findByLoanType("ARAC_KREDISI").get().get(0);
        Loan loan5= loanRepository.findByLoanType("ARAC_KREDISI").get().get(1);
        Loan loan6= loanRepository.findByLoanType("ARAC_KREDISI").get().get(2);

        Loan loan7= loanRepository.findByLoanType("KONUT_KREDISI").get().get(0);
        Loan loan8= loanRepository.findByLoanType("KONUT_KREDISI").get().get(1);
        Loan loan9= loanRepository.findByLoanType("KONUT_KREDISI").get().get(2);

        //create credit card applications
        Application application1 = new Application(1,creditCard, user, new BigDecimal(1000), LocalDate.of(2024, 3, 22));
        Application application2 = new Application(2,creditCard2, user2, new BigDecimal(2000), LocalDate.of(2024, 3, 23));
        Application application3 = new Application(3,creditCard3, user3, new BigDecimal(3000), LocalDate.of(2024, 3, 24));
        Application application4 = new Application(4,creditCard, user4, new BigDecimal(4000), LocalDate.of(2024, 3, 25));
        Application application5 = new Application(5,creditCard2, user, new BigDecimal(5000), LocalDate.of(2024, 3, 26));
        Application application6 = new Application(6,creditCard3, user2, new BigDecimal(6000), LocalDate.of(2024, 3, 27));

        //create loan applications
        Application application7 = new Application(7,loan, user, new BigDecimal(1000), LocalDate.of(2024, 3, 22));
        Application application8 = new Application(8,loan2, user2, new BigDecimal(2000), LocalDate.of(2024, 3, 23));
        Application application9 = new Application(9,loan3, user3, new BigDecimal(3000), LocalDate.of(2024, 3, 24));
        Application application10 = new Application(10,loan4, user4, new BigDecimal(4000), LocalDate.of(2024, 3, 25));
        Application application11 = new Application(11,loan5, user, new BigDecimal(5000), LocalDate.of(2024, 3, 26));
        Application application12 = new Application(12,loan6, user2, new BigDecimal(6000), LocalDate.of(2024, 3, 27));
        Application application13 = new Application(13,loan7, user4, new BigDecimal(6000), LocalDate.of(2024, 2, 24));
        Application application14 = new Application(14,loan8, user, new BigDecimal(6000), LocalDate.of(2024, 2, 25));
        Application application15 = new Application(15,loan9, user2, new BigDecimal(6000), LocalDate.of(2024, 2, 26));

       user.addApplication(application2);

        applicationList.addAll(List.of(application1, application2, application3, application4, application5, application6, application7, application8, application9, application10, application11, application12, application13, application14, application15));


    }*/


}
