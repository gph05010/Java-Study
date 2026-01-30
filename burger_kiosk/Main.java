import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Burger> menu = new ArrayList<>();
		menu.add(new Burger("치즈버거", 5000));
		menu.add(new Burger("불고기버거", 6000));

		ArrayList<Burger> orderList = new ArrayList<>();

		while (true) {
			System.out.print("1.메뉴보기 2.주문하기 3.주문목록 4.총금액 5.계산 0.종료 ");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("~~~집게리아 메뉴~~~");
//				for (int i = 0; i < menu.size(); i++) {
//					System.out.println(
//							"[" + (i + 1) + ". " + menu.get(i).getName() + "(" + menu.get(i).getPrice() + "원)]");
//				} for 문을 사용하고, println을 썼더니 매우 복잡한 코드...
				int num = 1; // for-each 문은 인덱스 값을 가져올 수 없으므로, 카운트를 위한 변수 선언
				for (Burger b : menu) {
					// %d : 정수 / %s : 문자열 / %f : 실수
					System.out.printf("[%d. %s (%d원)]\n", num++, b.getName(), b.getPrice());
					// 개행 필요 시, \n
				}
			} else if (choice == 2) {
				// 메뉴 번호 선택(1개만 선택)
				System.out.print("주문할 메뉴 번호를 입력하세요 >> ");
				int orderMenu = sc.nextInt();
				// 선택한 메뉴를 주문 리스트에 추가
				// 0 이하 입력 불가, 리스트의 사이즈보다 큰 값은 입력 불가
				if (orderMenu <= 0 || orderMenu > menu.size()) {
					System.out.println("번호를 다시 선택하세요");
				} else {
					orderList.add(menu.get(orderMenu - 1));
					System.out.println("주문 완료");
				}
			} else if (choice == 3) {
//				int num = 1;
//				for (Burger b : orderList) {
//					System.out.printf("[%d. %s]\n", num++, b.getName());
//				}
				// 리스트의 내용을 확인, 개수 카운트 변수 선언, 같은 걸 찾으면 그 변수를 증가시키기
				// 메뉴 이름을 가져와, 중복 없이 저장하는 리스트 만들기
//				ArrayList<Burger> orderList2 = new ArrayList<>();
//
//				for (int i = 0; i < orderList.size(); i++) {
//					boolean isFind = false;
//					for (int j = 0; j < orderList2.size(); j++) {
//
//						if (orderList.get(i).getName().equals(orderList2.get(j).getName()))
//						// 주문 목록에 있는 메뉴 이름이 메뉴 이름 저장 리스트에 저장된 것과 같으면
//						{
//							isFind = true;
//							break;
//						}
//
//					}
//					if (!isFind) {
//						orderList2.add(orderList.get(i));
//					}
//
//				}
//				int num = 1;
//				for (int i = 0; i < orderList2.size(); i++) {
//					int count = 0;
//					for (int j = 0; j < orderList.size(); j++) {
//						if (orderList.get(j).getName().equals(orderList2.get(i).getName())) {
//							count++;
//						}
//					}
//					System.out.printf("[%d. %s %d개]\n", num++, orderList2.get(i).getName(), count);
//				}

				// HashMap
				// Key는 중복될 수 없음!
				// put("a", 10);
				// put("a", 20);
				// => get("a") => 20 // 더해지지 않고 덮어씌워짐
				HashMap<String, Integer> countOrder = new HashMap<>();

				for (Burger b : orderList) {
					// put(key, value)

					// getOrDefault(a, b)
					// 만약에 map에 a 키가 있으면 기존의 value 값을 가져온다
					// 없으면 b값을 value로 넣는다
					countOrder.put(b.getName(), countOrder.getOrDefault(b.getName(), 0) + 1);
				}

				// HashMap 데이터 출력
				int num = 1;
				for (String key : countOrder.keySet()) {
					System.out.printf("%d. %s (%d개)\n", num++, key, countOrder.get(key));
				}
			} else if (choice == 4) {
				int sum = 0;
				for (Burger b : orderList) {
					sum += b.getPrice();
				}
				System.out.printf("총 금액 : %d원\n", sum);
			} else if (choice == 5) {
				System.out.print("1. 간편결제 2. 카드결제 >> ");
				sc.nextInt();
				orderList.clear();
				System.out.println("결제 완료");
			} else if (choice == 0) {
				System.out.println("키오스크 전원 off");
				break;
			}
		}
	}

}
