package somoonShop.function.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

	public double weInput() throws IOException {
		double value2 = 0;
		// 입력 데이터를 읽어들이기 위한 객체 생성
		BufferedReader thisWeight = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("오신걸 환영합니다.");
			// 입력부분
			System.out.println("당신의 체중을 입력해주세요. (단위는 kg입니다. 숫자만 기입하세요.)");
			// 입력된 내용을 변수에 대입
			String value = thisWeight.readLine();
			value2 = Double.parseDouble(value);
		} catch (IllegalArgumentException e) {
			System.out.println("에러가 발생했습니다   : " + e);
			return 0;
		}
		return value2;
	}

	public double heInput() throws IOException {
		double value2 = 0;
		// 입력 데이터를 읽어들이기 위한 객체 생성
		BufferedReader thisHeight = new BufferedReader(new InputStreamReader(System.in));
		try {
			// 입력부분
			System.out.println("당신의 신장을 입력해주세요. (단위는 cm입니다. 숫자만 기입하세요.)");
			// 입력된 내용을 변수에 대입
			String value = thisHeight.readLine();
			value2 = Double.parseDouble(value);
		} catch (IllegalArgumentException e) {
			System.out.println("에러가 발생했습니다   : " + e);
		}
		return value2;
	}

	public String seeYou(int size) throws IOException {
		String value = "";
		// 입력 데이터를 읽어들이기 위한 객체 생성
		BufferedReader Answer = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("당신에게 적합한 사이즈는 " + size + "입니다. 티셔츠를 보여드릴까요? [y/n]");
			// 입력된 내용을 변수에 대입
			value = Answer.readLine();
		} catch (IllegalArgumentException e) {
			System.out.println("에러가 발생했습니다   : " + e);
		}
		return value;
	}
}