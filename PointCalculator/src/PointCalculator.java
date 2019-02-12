import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class PointCalculator {
	public static void main(String[] args) throws Exception{
		try {
			PointCalculator point = new PointCalculator();
			int totalExpence = 0;
			int totalPoint = 0;
			Map<String, String> mapper = new HashMap<>();
			Scanner sc = new Scanner(System.in);
			final int TOTAL_RECIPT = Integer.parseInt(sc.nextLine());
			// レシート数判定
			if(1 > TOTAL_RECIPT || TOTAL_RECIPT  >= 100){
				System.exit(1);
			}
			for(int i = 0; i < TOTAL_RECIPT; i++) {
				String shop = sc.nextLine();
				String[] str = shop.split(" ");
				if(1 > Integer.parseInt(str[0]) || 31 < Integer.parseInt(str[0])){
					System.exit(1);
				}
				if(1 > Integer.parseInt(str[1]) || 10000 < Integer.parseInt(str[1])){
					System.exit(1);
				}
				mapper.put(str[0],str[1]);
			}
			sc.close();
			for(Iterator<Map.Entry<String, String>> iterator = mapper.entrySet().iterator() ; iterator.hasNext() ;){
			    Map.Entry<String, String> entry = iterator.next();
			    totalPoint += point.calcPoint(Integer.parseInt(entry.getKey()), Integer.parseInt(entry.getValue()));
			    totalExpence += Integer.parseInt(entry.getValue());
			}
			System.out.println(totalExpence + "円");
			System.out.println(totalPoint + "ポイント");
		}catch (Exception e) {
			System.out.println("error " + e);
		}
	}

	/*
	 * 日々のポイント計算用メソッド
	 * param	day		購入日付
	 * param	expence	day日の支出
	 * return	point	その日に溜まったポイント
	 */
	public int calcPoint(int day, int expence) {
		int point = 0;
		switch(day%10){
		case 3:
			point = (int) Math.floor((expence * 0.03));
			break;
		case 5:
			point = (int) Math.floor((expence * 0.05));
			break;
		default:
			point = (int) Math.floor((expence * 0.01));
			break;

		}
		return point;
	}
}
