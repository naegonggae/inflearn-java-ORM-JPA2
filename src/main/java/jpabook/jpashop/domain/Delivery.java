package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery extends BaseEntity {

	@Id @GeneratedValue
	private Long id;

	private String city;
	private String street;
	private String zipCode;
	private DeliveryStatus deliveryStatus;

	@OneToOne(mappedBy = "delivery") // 일대일 양방향
	private Order order;


}
