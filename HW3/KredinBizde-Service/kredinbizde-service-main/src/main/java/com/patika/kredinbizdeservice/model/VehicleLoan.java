package com.patika.kredinbizdeservice.model;

import com.patika.kredinbizdeservice.enums.LoanType;
import com.patika.kredinbizdeservice.enums.VehicleStatuType;

import java.math.BigDecimal;

public class VehicleLoan extends Loan {

    private LoanType loanType = LoanType.ARAC_KREDISI;
    private VehicleStatuType vehicleStatuType;
    private String vehicleInformation;




    public VehicleLoan(BigDecimal amount,long loanId, Integer installment, Double interestRate,String vehicleInformation, VehicleStatuType vehicleStatuType) {
        super(amount, loanId,installment, interestRate);
        this.vehicleInformation = vehicleInformation;
        this.vehicleStatuType = vehicleStatuType;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public String getVehicleInformation() {
        return vehicleInformation;
    }

    public void setVehicleInformation(String vehicleInformation) {
        this.vehicleInformation = vehicleInformation;
    }

    public VehicleStatuType getVechileStatuType() {
        return vehicleStatuType;
    }

    public void setVechileStatuType(VehicleStatuType vehicleStatuType) {
        this.vehicleStatuType = vehicleStatuType;
    }
}
