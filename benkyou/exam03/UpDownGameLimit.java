package benkyou.exam03;

import java.util.Random;
import java.util.Scanner;

public class UpDownGameLimit {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int answer = random.nextInt(30) + 1;
		int maxTry = 5;
		int count = 0;
		
		int[] previousInputs = new int[maxTry];
		int index = 0;
		
		System.out.println("=== Up & Down　ゲームスタート ===");
		System.out.println("1～30の数字を当ててください"+ maxTry + "回まで入力可能です");
		
		while (count < maxTry) {
			System.out.println((count + 1) + "回目数字を入力: ");
			
			try {
				int input = Integer.parseInt(scanner.nextLine());
				
				//範囲チェック
				if (input < 1 || input > 30) {
					System.out.println("1～30の数字を入力してください");
					continue;
				}
				
				//重複チェック
				boolean isDuplicate = false;
				for(int i = 0; i < index; i++) {
					if (previousInputs[i] == input) {
						isDuplicate = true;
						break;
					}
				}
				
				if (isDuplicate) {
					System.out.println("その数字はすでに入力されています");
					continue;
				}
				
				previousInputs[index] = input;
				count++;
				index++;
				
				//正解判定
				if (input == answer) {
					System.out.println("正解です。" + count + "回でクリアしました");
					scanner.close();
					return;
				}
				
				//最後の入力でなければヒントを表示
				if (count < maxTry) {
					if (input < answer) {
						System.out.println("UP");
					} else {
						System.out.println("DOWN");
					} 
					
				}
				
			} catch(NumberFormatException e) {
				System.out.println("数字を入力してくだい");
				
			}
		
		}
		
		System.out.println("ゲームオーバー");
		System.out.println("正解は" + answer + "でした");
		
		scanner.close();

	}

}
