package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

    @Column(length = 10)   //몇자까지 적어야되는제 제약 넣기.
    private String city;

    @Column(length = 20)
    private String street;

    @Column(length = 5)
    private String zipcode;

    //값 타입이 좋은게 의미있는 비지니스 매소드를 만들 수 있다.
    private String fullAddress(){
        return getCity()+ " "+getStreet()+" "+getZipcode();
    }

    public boolean isValid(){
        //예를 들어 유효한 주소 확인하는 매소드도 추가할 수 있다.
        return true;
    }

    // setter는 private으로 선언

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

    public String getZipcode() {
        return zipcode;
    }

    private void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    //generate equals() and hashcode() - get 사용 체크하기 -> 그렇지않으면 필드에 직접 접근하는데 필드에 직접 접근하면 프록시일때는 계산이 안됨. - getter를 호출해야 프록시일때도 진짜 객체에 접근가능함.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
