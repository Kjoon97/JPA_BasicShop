package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{

    @Id @GeneratedValue  // @GeneratedValue 기본 strategy값 : Auto
    @Column(name="MEMBER_ID")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    //필요시에만 이렇게 양방향 관계 설정해주면 됨. 양방향 관계가 필수는 아님.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    //가급적 생성자에서 세팅을 다하고 setter는 안 쓰는게 좋음.
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
