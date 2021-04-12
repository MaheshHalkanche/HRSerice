package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Payroll")
public class Payroll {
	@Id
	private int payrollId;
	private String payrollName;
	private Double salary;
	private String status;
	public int getPayrollId() {
		return payrollId;
	}
	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}
	public String getPayrollName() {
		return payrollName;
	}
	public void setPayrollName(String payrollName) {
		this.payrollName = payrollName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Payroll [payrollId=" + payrollId + ", PayrollName=" + payrollName + ", salary=" + salary + ", status="
				+ status + "]";
	}

}
