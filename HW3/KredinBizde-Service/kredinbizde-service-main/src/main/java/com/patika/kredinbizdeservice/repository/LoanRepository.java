package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.enums.LoanType;
import com.patika.kredinbizdeservice.enums.VehicleStatuType;
import com.patika.kredinbizdeservice.model.HouseLoan;
import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.model.ConsumerLoan;
import com.patika.kredinbizdeservice.model.VehicleLoan;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class LoanRepository {

    private List<Loan> loanList = new ArrayList<>();




    public void save(Loan loan) {
        loanList.add(loan);
    }

    public List<Loan> getAll() {
        return loanList;
    }

    public Optional<List<Loan>> findByLoanType(String loanType) {
         return Optional.of(loanList.stream()
                 .filter(loan -> loan.getLoanType().equals(LoanType.valueOf(loanType)))
                 .collect(Collectors.toList()));

    }

    public Optional<Loan> findById(long id) {
        return loanList.stream()
                .filter(loan -> loan.getLoanId() == id)
                .findFirst();
    }

    public void delete(Loan loan) {
        loanList.remove(loan);
    }

   /* public void loadData() {
        BankRepository bankRepository = new BankRepository();
        // create 3 random consumer loans
        ConsumerLoan loan = new ConsumerLoan(new BigDecimal(1000), 12, 1.2);
        ConsumerLoan loan2 = new ConsumerLoan(new BigDecimal(2000), 24, 1.3);
        ConsumerLoan loan3 = new ConsumerLoan(new BigDecimal(3000), 36, 1.4);

        loan.setBank(bankRepository.findByBankName("Akbank").get());
        loan2.setBank(bankRepository.findByBankName("Garanti").get());
        loan3.setBank(bankRepository.findByBankName("Ziraat").get());

        //create 3 random vehicle loans
        VehicleLoan loan4 = new VehicleLoan(new BigDecimal(1000), 12, 1.2, "Audi",VehicleStatuType.NEW);
        VehicleLoan loan5 = new VehicleLoan(new BigDecimal(2000), 24, 1.3, "BMW",VehicleStatuType.NEW);
        VehicleLoan loan6 = new VehicleLoan(new BigDecimal(3000), 36, 1.4, "Mercedes", VehicleStatuType.USED);

        loan4.setBank(bankRepository.findByBankName("Akbank").get());
        loan5.setBank(bankRepository.findByBankName("Garanti").get());
        loan6.setBank(bankRepository.findByBankName("Ziraat").get());


        //create 3 random mortgage loans
        HouseLoan loan7 = new HouseLoan(new BigDecimal(1000), 12, 1.2, "Istanbul");
        HouseLoan loan8 = new HouseLoan(new BigDecimal(2000), 24, 1.3, "Ankara");
        HouseLoan loan9 = new HouseLoan(new BigDecimal(3000), 36, 1.4, "Izmir");

        loan7.setBank(bankRepository.findByBankName("Akbank").get());
        loan8.setBank(bankRepository.findByBankName("Garanti").get());
        loan9.setBank(bankRepository.findByBankName("Ziraat").get());

        loanList.addAll(List.of(loan, loan2, loan3, loan4, loan5, loan6, loan7, loan8, loan9));
    }*/

}
