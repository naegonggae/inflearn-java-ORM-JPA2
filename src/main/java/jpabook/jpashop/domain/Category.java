package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category extends BaseEntity {

	@Id @GeneratedValue
	private Long id;

	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private Category parent;

	@OneToMany(mappedBy = "parent")
	private List<Category> child = new ArrayList<>();

	//  @JoinColumn 의 name 속성 값은 대상 엔티티와 “매핑할 외래 키(자기 필드명)” 이름을 지정해주는 값이고,
	//  “조인할 컬럼명(외래 키가 참조하는 대상 테이블의 컬럼명)”을 지정해주는 속성 값은 referencedColumnName 이었던 것이다
	@ManyToMany // 다대다 얘가 주인임
	@JoinTable(name = "CATEGORY_ITEM",
			joinColumns = @JoinColumn(name = "CATEGORY_ID"), // 내가 조인하는애 , _ID 안 붙이니까 DB에 CATEGORY 로 저장됨
			inverseJoinColumns = @JoinColumn(name = "ITEM_ID") // 반대쪽이 조인하는애
	)
	private List<Item> items = new ArrayList<>();

}
