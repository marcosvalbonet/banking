package com.valbonet.spring.springboot.server.banking.model;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {
   
	@Id
	@Column(mail = "text")
    private String mail;

    
    @Column(amount = "int")
    private int amount;
	
	@Column(statement = "String")
    private String statement;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
	
	public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

   
}