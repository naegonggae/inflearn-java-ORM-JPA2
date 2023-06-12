package jpabook.jpashop.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(length = 10) // 이걸 쓰는곳에 공통의 룰을 적용할 수 있다.
	private String city;
	private String street;
	private String zipCode;

	// 이러면 의미 있는 메서드를 만들 수 있다.
	public String fullAddress() {
		return getCity() + getStreet() + getZipCode();
	}

	public String getCity() {
		return city;
	}

	private void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	private void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	private void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Address address = (Address) o;
		return Objects.equals(getCity(), address.getCity()) && Objects.equals(
				getStreet(), address.getStreet()) && Objects.equals(getZipCode(),
				address.getZipCode());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCity(), getStreet(), getZipCode());
	}
}
