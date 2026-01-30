package Ex01배열;

import java.util.Random;

public class Ex02홀수찾기정렬 {

	public static void main(String[] args) {

		// 랜덤 도구 꺼내오기
		Random rd = new Random();

		// 1. 정수형 데이터 5개를 저장할 수 있는 배열 array 선언
		int[] array = new int[5];

		// 2. 배열 안에 있는 모든 데이터를 랜덤한 수로 저장
		// (랜덤 수의 범위 : 1~100까지)

		for (int i = 0; i < array.length; i++) {
			// rd.nextInt(100); -> 0~99
			// rd.nextInt(100)+1; -> 1~100
			array[i] = rd.nextInt(100) + 1;
		}

		// 배열 안에 있는 데이터를 정렬해 보기
		for (int k = 0; k < array.length - 1; k++) { // 가장 큰 수를 맨 뒤로 보내는 과정을, 배열 길이 -1번만큼 반복하면, 모든 수가 오름차순 정렬
			for (int i = 0; i < array.length - 1; i++) { // 이 과정은 가장 큰 수를 맨 뒤로 보내는 과정이 됨
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}
		// 홀수의 개수를 저장할 변수
		int count = 0;

		// 3. 그 중에서도 홀수, 홀수 개수 찾기
		System.out.print("array에 들어있는 홀수는 ");
		// 인덱스에 들어있는 데이터가 홀수인지 아닌지 조건 판단 -> 조건문
		// 배열의 크기만큼 반복을 하면서 그 중에서 홀수 찾기

		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) { // 인덱스에 들어있는 값이 홀수면
				System.out.print(array[i] + " ");
				count++;
			}
		}
		System.out.println("이며,");
		System.out.println("총 " + count + "개 입니다.");

	}

}
