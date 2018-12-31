package somoonShop.function.util;
import java.io.IOException;

import somoonShop.function.util.ClothesSize;
import somoonShop.function.util.Input;
import somoonShop.function.util.urlSite;

public class BMIMain {
	
		public int bmi(int a, int b) {
			return ( a / ( b * b ) * 10000);
		}
//		//선언
//		ClothesSize si = new ClothesSize();
//	    urlSite te = new urlSite();
//	    Input i = new Input();
//	    while (true) {
//			double myWeight = i.weInput();
//	    	if(myWeight == 0) {
//	    		System.out.println("시스템을 종료합니다.");
//	    		break;
//	    	}
//	    	else {
//	    		double myHeight= i.heInput();
//		    	if(myHeight == 0){
//		    		System.out.println("시스템을 종료합니다.");
//		    		break;
//		    	}
//		    	else {
//		    		double bmiResult = (myWeight / (myHeight * myHeight) * 10000); 
//		    		if (bmiResult >= 30) {
//		    			System.out.println("당신의 BMI 수치는 " + bmiResult + " 입니다. 비만상태이므로 운동이 필요합니다.");			
//		    		}
//		    		else if (bmiResult >= 25 && bmiResult < 30) {
//		    			System.out.println("당신의 BMI 수치는 " + bmiResult + " 입니다. 과체중이므로 주의하세요!");
//		    		}
//		    		else if (bmiResult >= 18.5 && bmiResult < 25) {
//		    			System.out.println("당신의 BMI 수치는 " + bmiResult + " 입니다. 이대로 유지하세요.");
//		    		}
//		    		else if (bmiResult < 18.5){
//		    			System.out.println("당신의 BMI 수치는 " + bmiResult + " 입니다. 저체중입니다. 운동과 식사를 균형있게 실시하세요.");
//		    		}
//		    			int size = si.Size(myWeight, myHeight);
//		    			String YesorNo = i.seeYou(size);
//		    			
//		    			if(YesorNo.equals("y")) {
//		    				te.bodySize(size);
//		    				System.out.println("고생하셨습니다.");
//		    				break;
//		            	}else if(YesorNo.equals("n")) {
//		            		System.out.println("고생하셨습니다.");
//		            		break;
//		            	}else {
//		            		System.out.println("잘못된 입력입니다. 시스템을 종료합니다.");
//		            		break;
//		            	}
//		    	}
//	    	}
//	    }	
}
