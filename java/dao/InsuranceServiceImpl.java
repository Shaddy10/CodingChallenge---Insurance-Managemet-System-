package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import entity.Policy;
import util.DBConnection;
import util.PropertyUtil;

public class InsuranceServiceImpl implements IPolicyService {
	@Override
	public boolean createPolicy(Policy policy) {
		try (Connection conn = DBConnection.getConnection(PropertyUtil.getPropertyString("database.properties"));
	             PreparedStatement stmt = conn.prepareStatement("INSERT INTO policy (policyId, policyName) VALUES (?, ?)")) {

	            stmt.setInt(1, policy.getPolicyId());
	            stmt.setString(2, policy.getPolicyName());

	            int insertedRows = stmt.executeUpdate();
	            return insertedRows > 0;

	        } catch (SQLException | IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	}

	@Override
	public Policy getPolicy(int policyId) {
		try (Connection conn = DBConnection.getConnection(PropertyUtil.getPropertyString("database.properties"));
	             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM policy WHERE policyId = ?")) {

	            stmt.setInt(1, policyId);

	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    return new Policy(rs.getInt("policyId"), rs.getString("policyName"));
	                }
	            }

	        } catch (SQLException | IOException e) {
	            e.printStackTrace();
	        }
	        return null;
		
	}

	@Override
	public Collection<Policy> getAllPolicies() {
		Collection<Policy> policies = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection(PropertyUtil.getPropertyString("database.properties"));
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM policy");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                policies.add(new Policy(rs.getInt("policyId"), rs.getString("policyName")));
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return policies;
		
	}

	@Override
	public boolean updatePolicy(Policy policy) {
		try (Connection conn = DBConnection.getConnection(PropertyUtil.getPropertyString("database.properties"));
	             PreparedStatement stmt = conn.prepareStatement("UPDATE policy SET policyName = ? WHERE policyId = ?")) {

	            stmt.setString(1, policy.getPolicyName());
	            stmt.setInt(2, policy.getPolicyId());

	            int rowsUpdated = stmt.executeUpdate();
	            return rowsUpdated > 0;

	        } catch (SQLException | IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	}

	@Override
	public boolean deletePolicy(int policyId) {
		try (Connection conn = DBConnection.getConnection(PropertyUtil.getPropertyString("database.properties"));
	             PreparedStatement stmt = conn.prepareStatement("DELETE FROM policy WHERE policyId = ?")) {

	            stmt.setInt(1, policyId);

	            int rowsDeleted = stmt.executeUpdate();
	            return rowsDeleted > 0;

	        } catch (SQLException | IOException e) {
	            e.printStackTrace();
	            return false;
	        }
		
	}

}
