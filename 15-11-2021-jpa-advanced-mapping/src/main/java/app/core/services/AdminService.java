package app.core.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.entities.Review;
import app.core.repositories.CompanyRepo;
import app.core.repositories.CouponRepo;

@Service
@Transactional
public class AdminService {

	@Autowired
	private CompanyRepo companyRepo;
	@Autowired
	private CouponRepo couponRepo;

	public int addCompany(Company company) {
		company = companyRepo.save(company);
		return company.getId();
	}

	public Company getCompanyById(int companyId) {
		Optional<Company> opt = this.companyRepo.findById(companyId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new RuntimeException("company with id " + companyId + " not found");
		}
	}

	public Coupon getCoupon(int couponId) {
		Optional<Coupon> opt = this.couponRepo.findById(couponId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new RuntimeException("coupon with id " + couponId + " not found");
		}

	}

	public List<Review> getCouponReviews(int couponId) {
		Optional<Coupon> opt = this.couponRepo.findById(couponId);
		if (opt.isPresent()) {
			List<Review> reviews = opt.get().getReviews();
			System.out.println(reviews);
			return reviews;
		} else {
			throw new RuntimeException("coupon with id " + couponId + " not found");
		}

	}

}
