package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Member extends BaseEntity {

	@Id @GeneratedValue // 오토로 해줌
	@Column(name = "MEMBER_ID")
	private Long id;
	private String name;

	@Embedded
	private Address address;

	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();
	// 특정회원의 주문을 보고싶다고 하면 사실 이렇게 양방향으로 매핑해서 접근하기 보다는 Order 의 FK 로 접근하는 경우가 통상적이다.

	// setter 는 다만들지말고 만들지 고려해야함 모두 변경가능하게 될 수 있기 때문이다.
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
