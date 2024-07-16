package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.enums.LoanType;
import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    LoanRepository LoanRepository = new LoanRepository();

    public void save(Loan loan) {
        LoanRepository.save(loan);
    }

    public List<Loan> getAll() {
        return LoanRepository.getAll();
    }

    public List<Loan> findByLoanType(String loanType) {
        Optional<List<Loan>> loanFound = LoanRepository.findByLoanType(loanType);

        List<Loan> loanList = null;

        if(loanFound.isPresent()){
            loanList = loanFound.get();
        }

        return loanList;
    }

    public Loan findById(long id) {
        Optional<Loan> loanFound = LoanRepository.findById(id);

        Loan loan = null;

        if(loanFound.isPresent()){
            loan = loanFound.get();
        }

        return loan;
    }

    public void delete(Loan loan) {
        LoanRepository.delete(loan);
    }

}
