package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="ORDERS")   //디비마다 다른데 디비에는 ORDER BY 라고 예약어가 걸려있음.
public class Order {

    @Id @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

    @Column(name="MEMBER_ID")
    private Long memberId;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)   // Ordinal은 쓰지말자!!!(숫자로 들어가면 나중에 Enum 수정 시 꼬일 수 있음)
    private OrderStatus orderStatus;
}
