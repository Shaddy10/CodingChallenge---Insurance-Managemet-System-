package entity;

import java.util.Date;

public class Claim {
	private int claimId;
	private int claimNumber;
	private Date dateFiled;
	private double claimAmount;
	private String Status;
	private Policy policy;
	private Client client;
	
	public Claim() {}

	public int getClaimId() {
		return claimId;
	}
	

	public Claim(int claimId, int claimNumber, Date dateFiled, double claimAmount, String status, Policy policy,
			Client client) {
		super();
		this.claimId = claimId;
		this.claimNumber = claimNumber;
		this.dateFiled = dateFiled;
		this.claimAmount = claimAmount;
		Status = status;
		this.policy = policy;
		this.client = client;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public int getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(int claimNumber) {
		this.claimNumber = claimNumber;
	}

	public Date getDateFiled() {
		return dateFiled;
	}

	public void setDateFiled(Date dateFiled) {
		this.dateFiled = dateFiled;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", claimNumber=" + claimNumber + ", dateFiled=" + dateFiled
				+ ", claimAmount=" + claimAmount + ", Status=" + Status + ", policy=" + policy + ", client=" + client
				+ "]";
	}
	
	
}
