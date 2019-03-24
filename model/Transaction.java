packagecom.valbonet.spring.springboot.server.banking.model;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {
   
	@Id
	@Column(mail = "text")
    private String mail;

    
    @Column(amount = "int")
    private int amount;
	
	@Column(transactionType = "String")
	private String transactionType;
			
	@Column(date = "Date")
	private Date date;
	

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
	
	public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
	
	public Date getDate() {
        return date;
    }

	public void setDate(Date date) {
        this.date = date;
    }
	   
}