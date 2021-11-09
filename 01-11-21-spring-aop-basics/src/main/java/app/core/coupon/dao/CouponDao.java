package app.core.coupon.dao;

import org.springframework.stereotype.Component;

@Component
public class CouponDao {

	public void addCoupon() {
		System.out.println("coupon added");
	}

	public void doWork(int x) {
		System.out.println("doing some work at CouponDao");
	}

}
