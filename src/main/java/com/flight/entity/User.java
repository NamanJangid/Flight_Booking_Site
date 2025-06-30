package com.flight.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.flight.enumerate.Title;

/**
 * 
 * @author Naman
 * 
 *         This table stores data of the end user
 */

@Entity
@Table(name = "users")
public class User {

	@Null
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int id;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Title title;

	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@Email
	@Column(name = "email_id")
	private String email;

	@NotNull
	private String password;

	@NotNull
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@NotNull
	@Column(name = "contact_no")
	private long contact;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<BankAccount> bankaccounts;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Reservation> reservations;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public List<BankAccount> getBankaccounts() {
		return bankaccounts;
	}

	public void setBankaccounts(List<BankAccount> bankaccounts) {
		this.bankaccounts = bankaccounts;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}
