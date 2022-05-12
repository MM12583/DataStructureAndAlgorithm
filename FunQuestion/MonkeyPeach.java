
// 猴子吃桃問題 
// 每天吃一半再多一顆
// 第10天剩一顆,一開始有幾顆?
public class MonkeyPeach {

	public static void main(String[] args) {
		int day = 1 ;
		int peach = peach(day);
		System.out.println("第" + day + "天有" + peach + "顆桃");
	}
	
//	當天桃數 = (前一天桃數+1)*2
	public static int peach(int day) {
		if (day == 10) { //返回條件
			return 1 ;
		}else {
			return (peach(day + 1) + 1 ) * 2 ;
		}
	}

}
