package app.core.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import app.core.beans.Company;

@Component
public class CompanyDao {

	private Map<Long, Company> map = new HashMap<>();

	public void addCompany(Company company) {
		if (!this.map.containsKey(company.getId())) {
			this.map.put(company.getId(), company);
		}
	}

	public Optional<Company> getCompany(long companyId) {
		Optional<Company> opt;
		if (this.map.containsKey(companyId)) {
			opt = Optional.of(map.get(companyId));
		} else {
			opt = Optional.empty();
		}
		return opt;
	}

	public List<Company> getAllCompanies() {
		return new ArrayList<>(this.map.values());
	}

	public boolean deleteCompany(long companyId) {
		Company company = this.map.remove(companyId);
		return company != null;
	}

}
