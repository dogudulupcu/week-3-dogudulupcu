package com.patika.kredinbizdeservice.model;


import com.patika.kredinbizdeservice.enums.LoanType;

import java.math.BigDecimal;
import java.util.List;

public class ConsumerLoan extends Loan {

    private final LoanType loanType = LoanType.IHTIYAC_KREDISI;
    private List<Integer> installmentOptions;

    public ConsumerLoan() {

    }

    public ConsumerLoan(BigDecimal amount, Long loanId,Integer installment, Double interestRate) {
        super(amount,loanId, installment, interestRate);
    }

    public LoanType getLoanType() {
        return loanType;
    }


    void calculate(BigDecimal amount, int installment) {
        //tc bul, maaşı bul
    }


}
