package app.core.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import app.core.beans.Coupon;

@Component
public class CouponDao {

	private Map<Long, Coupon> map = new HashMap<>();

	public void addCoupon(Coupon coupon) {
		if (!this.map.containsKey(coupon.getId())) {
			this.map.put(coupon.getId(), coupon);
		}
	}

	public Optional<Coupon> getCoupon(long couponId) {
		Optional<Coupon> opt;
		if (this.map.containsKey(couponId)) {
			opt = Optional.of(map.get(couponId));
		} else {
			opt = Optional.empty();
		}
		return opt;
	}

	public List<Coupon> getAllCoupons() {
		return new ArrayList<>(this.map.values());
	}

	public boolean deleteCouon(long couponId) {
		Coupon coupon = this.map.remove(couponId);
		return coupon != null;
	}

}
