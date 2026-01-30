package Ex01배열;

import java.util.Random;

public class Ex03큰수찾기중복제거 {

	public static void main(String[] args) {

		// 1. 랜덤 도구 꺼내오기
		Random rd = new Random();

		// 2. 정수형 데이터 5개를 저장할 수 있는 배열 array 선언
		int[] array = new int[5];

		// 3. 배열 안에 들어있는 모든 데이터를 랜덤 수로 저장
		// 랜덤 수의 범위 : 1~10
		for (int i = 0; i < array.length; i++) {
			array[i] = rd.nextInt(10) + 1; // 일단 수를 하나 뽑는다.

			// 방금 뽑은 array[i]가 배열 내의 다른 것들과 겹치는지 확인하기
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) { // 만약 중복을 발견하면
					i--; // 배열의 이전 칸으로 되돌려 버려서, 다시 뽑게 유도하기
					break; // 더 이상 중복 검사할 필요 없으므로 반복문 탈출
				}
			}
		}

		// 4. 가장 큰 수를 구하기
		// 큰 수를 구하는 알고리즘
		// 예시) 배열 안에 저장된 숫자 : 1, 5, 6, 3, 8
		// 가장 큰 수를 저장할 변수 1개 필요! -> max
		// -> 크기 비교 후, 큰 값을 max에 저장
		// -> 비교 -> 저장 -> 비교 -> 저장
		// (1) 1과 5 크기 비교 -> 5 저장
		// (2) 5와 6 크기 비교 -> 6 저장
		// (3) 6과 3 크기 비교 -> 6 저장
		// (4) 6과 8 크기 비교 -> 8 저장

		// 4-1. 배열의 크기만큼 반복을 돌리면서
		// 4-2. 배열의 0번 인덱스가 max보다 큰지 조건 판단
		// 4-3. max보다 크다면 그 큰 수를 max에 다시 저장(재할당)

		int max = array[0];

		for (int i = 0; i < array.length - 1; i++) {

			if (max < array[i + 1]) {
				max = array[i + 1];
			}
		}

		// 5. 배열 안의 모든 데이터 출력
		// 5-1. 가장 큰 값 출력
		System.out.print("배열 안에 들어있는 값 : [");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.println(array[i] + "]");
			} else {
				System.out.print(array[i] + ", ");
			}
		}
		System.out.println("가장 큰 값은 " + max + "입니다.");

	}

}
