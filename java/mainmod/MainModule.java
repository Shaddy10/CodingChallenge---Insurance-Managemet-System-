package mainmod;
import dao.InsuranceServiceImpl;
import entity.Policy;

import java.util.Collection;
import java.util.Scanner;

public class MainModule {

	    private static final InsuranceServiceImpl insuranceService = new InsuranceServiceImpl();
	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        boolean exit = false;

	        while (!exit) {
	            System.out.println("1.Create Policy");
	            System.out.println("2.Get Policy");
	            System.out.println("3.Get All Policies");
	            System.out.println("4.Update Policy");
	            System.out.println("5.Delete Policy");
	            System.out.println("6.Exit");

	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    createPolicy();
	                    break;
	                case 2:
	                    getPolicy();
	                    break;
	                case 3:
	                    getAllPolicies();
	                    break;
	                case 4:
	                    updatePolicy();
	                    break;
	                case 5:
	                    deletePolicy();
	                    break;
	                case 6:
	                    exit = true;
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again!");
	            }
	        }
	    }

	    private static void createPolicy() {
	        System.out.print("Enter policy ID: ");
	        int policyId = scanner.nextInt();
	        System.out.print("Enter policy name: ");
	        String policyName = scanner.next();

	        Policy policy = new Policy(policyId, policyName);
	        boolean created = insuranceService.createPolicy(policy);
	        if (created) {
	            System.out.println("Policy created successfully.");
	        } else {
	            System.out.println("Failed to create policy.");
	        }
	    }

	    private static void getPolicy() {
	        System.out.print("Enter policy ID to retrieve: ");
	        int policyId = scanner.nextInt();

	        Policy policy = insuranceService.getPolicy(policyId);
	        if (policy != null) {
	            System.out.println("Policy: " + policy);
	        } else {
	            System.out.println("Policy not found.");
	        }
	    }

	    private static void getAllPolicies() {
	        Collection<Policy> policies = insuranceService.getAllPolicies();
	        if (!policies.isEmpty()) {
	            System.out.println("All Policies:");
	            for (Policy policy : policies) {
	                System.out.println(policy);
	            }
	        } else {
	            System.out.println("No policies found.");
	        }
	    }

	    private static void updatePolicy() {
	        System.out.print("Enter policy ID to update: ");
	        int policyId = scanner.nextInt();
	        System.out.print("Enter new policy name: ");
	        String newPolicyName = scanner.next();

	        Policy policy = new Policy(policyId, newPolicyName);
	        boolean updated = insuranceService.updatePolicy(policy);
	        if (updated) {
	            System.out.println("Policy updated successfully.");
	        } else {
	            System.out.println("Failed to update policy.");
	        }
	    }

	    private static void deletePolicy() {
	        System.out.print("Enter policy ID to delete: ");
	        int policyId = scanner.nextInt();

	        boolean deleted = insuranceService.deletePolicy(policyId);
	        if (deleted) {
	            System.out.println("Policy deleted successfully.");
	        } else {
	            System.out.println("Failed to delete policy.");
	        }
	    }
	}
