package dao;

import java.util.Collection;

import entity.Policy;

public interface IPolicyService {

	public boolean createPolicy(Policy policy);
	public Policy getPolicy(int policyId);
	Collection<Policy> getAllPolicies();
	public boolean updatePolicy(Policy policy);
	public boolean deletePolicy(int policyId);
}
