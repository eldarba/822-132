package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.core.aspects.StatisticsAspect;
import app.core.beans.Coupon;
import app.core.beans.login.LoginManager;
import app.core.dao.CouponDao;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopDrillSollutionEldarApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringAopDrillSollutionEldarApplication.class, args);

		try {
			LoginManager loginManager = ctx.getBean(LoginManager.class);
			System.out.println("is logged in: " + loginManager.isLoggedIn());
			loginManager.login("123");
			System.out.println("is logged in: " + loginManager.isLoggedIn());

			CouponDao couponDao = ctx.getBean(CouponDao.class);
			System.out.println(couponDao.getAllCoupons());
			couponDao.addCoupon(new Coupon(101, "FOODS"));
			couponDao.addCoupon(new Coupon(102, "SPORTS"));
			System.out.println(couponDao.getAllCoupons());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("======================");
		StatisticsAspect statisticsAspect = ctx.getBean(StatisticsAspect.class);
		System.out.println("number of \"get\" calls: " + statisticsAspect.getCountGetCalls());

	}

}
