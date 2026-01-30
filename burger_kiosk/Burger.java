
// VO (Value Object)

public class Burger { // 특정한 값들을 하나로 묶어서 => 하나의 값을 정의

	// 속성 : 이름, 가격
	// 접근제한자
	// public :
	// protected
	// dafault(생략) : 같은 패키지 내에서만 접근 가능
	// private : 현재 클래스 내에서만 사용 가능 (캡슐화) ~ getter/setter
	private String name;
	private int price;

	public Burger() { // 컴파일러가 만들어줌(생성자가 아무것도 정의가 되어있지 않을 경우에만)

	}

	public Burger(String name, int price) {
		this.name = name;
		this.price = price;
	}

	// 기능 : 메서드(getter, setter)

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
