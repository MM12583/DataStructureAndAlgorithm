package dataStructureAndAlgorithm;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		
		HeroNode hero1 = new HeroNode(1, "宋江", "及時雨");
		HeroNode hero2 = new HeroNode(2, "盧俊義", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吳用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林沖", "豹子頭");
		
		SingleLinkedList sll = new SingleLinkedList();
		
		// 下有換加入順序
//		sll.add(hero1);
//		sll.add(hero4);
//		sll.add(hero2);
//		sll.add(hero3);
		sll.addByOrder(hero4);
		sll.addByOrder(hero1);
		sll.addByOrder(hero3);
		sll.addByOrder(hero2);
//		sll.addByOrder(hero2);
		// 遍歷
		sll.list();
		
		System.out.println("------------------------------");
		// 反轉
		sll.reverseList(sll.getHead());
		sll.list();
		
//		System.out.println("倒數第1個節點為 : " + sll.findLastIndexNode(1, sll.getHead()));
//		
//		System.out.println("------------------------------");
//		
//		// 測試修改節點
//		HeroNode newHeroNode = new HeroNode(2, "小盧", "冰淇淋");
//		sll.update(newHeroNode);
//		// 遍歷
//		sll.list();
//		System.out.println(sll.getLength(sll.getHead()));
//		
//		System.out.println("------------------------------");
//		// 測試刪除
//		sll.delete(1);
//		sll.list();
//		System.out.println("------------------------------");
//		sll.delete(4);
//		sll.list();
//		System.out.println("------------------------------");
//		sll.delete(3);
//		sll.delete(2);
//		sll.list();
	}

}

// 定義一個SingleLinkedList 管理英雄
class SingleLinkedList {
	
	// 先初始化頭節點, 頭節點不放任何數據, 功能:指向第一個數據
	private HeroNode head = new HeroNode(0, "", "");
	
	// 不管順序
	// 添加要先找到最後的節點，再以next域指向新節點添加
	public void add(HeroNode heroNode) {
		
		// 用臨時節點遍歷找到最後的節點
		HeroNode temp = head;
		
		while(true) {
			// 找到
			if (temp.next == null) {
				break;
			}
			// 未找到在找下一個
			temp = temp.next;
		}
		
		// 新節點
		temp.next = heroNode;
	}
	
	//按順序增加
	public void addByOrder(HeroNode heroNode) {
		
//		因頭節點不能動，使用輔助變量(指針)幫助找到添加的位置
//      temp = 添加位置的前一個節點
		HeroNode temp = head;
		
		boolean flag = false ; // 表示編號已存在,默認false
		
		// 找到插入點temp(後)
		while(true) {
			
			// 鏈表已到最後
			if (temp.next == null) { 
				break;
			}
			
			// ***插入點為 temp ~ temp.next 之間(有小到大排列情況)
			if (temp.next.no > heroNode.no) { 
				break;
			// 編號已存在
			} else if (temp.next.no == heroNode.no) {
				flag = true ; // 說明編號存在
				break;
			}
			// 後移
			temp = temp.next;
		}
		
		if (flag) {
			System.out.printf("編號%d英雄已存在,不能再添加\n", heroNode.no);
		}else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
		
	}
	
	// 刪除節點
	// 找待節點的前一個: temp.no = delteNode.no
	public void delete(int no) {
		HeroNode temp = head;
		boolean flag = false; //是否找到待刪除的前一個節點
		
		while(true) {
			// 已到最後未找到
			if (temp.next == null) {
				break;
			}
			// 找到
			if (temp.next.no == no) {
				flag = true;
				break;
			}
			
			temp = temp.next;
		}
		
		if (flag) {
			temp.next = temp.next.next;
		}else {
			System.out.printf("待刪除的節點編號 %d 不存在\n", no);
		}
	}
	
	// 修改節點訊息, 根據編號修改(編號不能修改)
	public void update(HeroNode newHeroNode) {
		
		if (head.next == null) {
			System.out.println("鏈表為空");
			return;
		}
		
		HeroNode temp = head.next;
		boolean flag = false; // 是否找到節點
		
		while(true) {
			// 鏈表以遍歷完畢
			if (temp == null) {
				break;
			}
			
			// 找到
			if (temp.no == newHeroNode.no) {
				flag = true ;
				break;
			}
			
			temp = temp.next;
		}
		
		// 根據flag 判斷是否找到修改節點
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickName = newHeroNode.nickName;
		}else {
			System.out.printf("尚未找到編號%d, 不能修改\n" + newHeroNode.no);
		}
	}
	
	// 注意鏈表帶頭節點不須統計頭
	/**
	 * 
	 * @param head 鏈表頭
	 * @return 有效節點個數
	 */
	public int getLength(HeroNode head) {
		// 空
		if (head.next == null) {
			return 0 ;
		}
		
		int length = 0 ;
		HeroNode cur = head.next;
		
		while(cur != null) {
			length ++;
			cur = cur.next;
		}
		
		return length;
	}
	
	// **找鏈表中倒數第 n 個值
	public HeroNode findLastIndexNode(int index, HeroNode head) {
		
		// 沒有數據
		if (head.next == null) {
			return null ;
		}
		
		// 鏈表長度
		int size = getLength(head);
		
		// 總長小於或找0、-1位置無效
		if (size < index || index <= 0) {
			return null;
		}
		
		HeroNode cur = head.next; //第一個有效數據
		for (int i = 0; i < size - index ; i++) { // **遍歷次數為總長 - 倒數第個數
			cur = cur.next;
		}
		
		return cur;
	}
	
//	反轉鏈表(頭插法)
	public void reverseList(HeroNode head) {
		// 鏈表為空或只有一個值不須反轉
		if (head.next == null || head.next.next == null) {
			return;
		}
		
		HeroNode cur = head.next; // 遍歷用
		HeroNode next = null; // 指向當前節點[cur]的下一個, **避免斷掉(引用已經在reverseHead上，非head)
		HeroNode reverseHead = new HeroNode(0, "", "");
		
		// 每遍歷一個節點，將其取出放置在新鏈表(reverseHead)的最前端
		while(cur != null) {
			// 暫時保存當前節點的下一個節點
			next = cur.next;
			// ***先給現在的cur賦值(將被取代reverseHead之首)
			cur.next = reverseHead.next;
			// 取代reverseHead
			reverseHead.next = cur ;
			// 遍歷後移
			cur = next;
			
		}
		
		head.next = reverseHead.next ;
		
		
	}
	
	public void list() {
		
		// 判斷鏈表是否為空
		if (head.next == null) {
			System.out.println("鏈表為空");
			return;
		}
		
		// 用臨時節點遍歷找到最後的節點
		HeroNode temp = head.next;
		while(true) {
			
//			System.out.println(temp);
//			
//			if (temp.next == null) {
//				break;
//			}
			
			// 判斷是否到底(***第一次無用，後續每次減少一次.next)
			if (temp == null) {
				break;
			}
			
			System.out.println(temp);
			
			temp = temp.next;
		}
		
		
	}
	
	// 取頭節點
	public HeroNode getHead() {
		return head;
	}

}

// 定義英雄節點Node(包含數據域、next域)

class HeroNode{
	
	//數據域
	public int no;
	
	public String name;
	
	public String nickName;
	
	//next域
	public HeroNode next;

	public HeroNode(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HeroNode [no=");
		builder.append(no);
		builder.append(", name=");
		builder.append(name);
		builder.append(", nickName=");
		builder.append(nickName);
		builder.append("]");
		return builder.toString();
	}
}








