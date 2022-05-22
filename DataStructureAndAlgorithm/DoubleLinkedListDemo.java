package dataStructureAndAlgorithm;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		HeroNode2 hero1 = new HeroNode2(1, "宋江", "及時雨");
		HeroNode2 hero2 = new HeroNode2(2, "盧俊義", "玉麒麟");
		HeroNode2 hero3 = new HeroNode2(3, "吳用", "智多星");
		HeroNode2 hero4 = new HeroNode2(4, "林沖", "豹子頭");
		
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//		doubleLinkedList.add(hero1);
//		doubleLinkedList.add(hero2);
//		doubleLinkedList.add(hero3);
//		doubleLinkedList.add(hero4);
		doubleLinkedList.addByOrder(hero4);
		doubleLinkedList.addByOrder(hero2);
		doubleLinkedList.addByOrder(hero3);
		doubleLinkedList.addByOrder(hero1);
		doubleLinkedList.addByOrder(hero3);
		doubleLinkedList.list();

		// 修改
		System.out.println("----修改----");
		HeroNode2 newhero2 = new HeroNode2(2, "公孫勝", "入雲龍");
		doubleLinkedList.update(newhero2);
		doubleLinkedList.list();

		// 刪除
		System.out.println("----刪除----");
		doubleLinkedList.delete(3);
		doubleLinkedList.list();
	}

}

class DoubleLinkedList {
	// 先初始化頭節點, 頭節點不放任何數據, 功能:指向第一個數據
	private HeroNode2 head = new HeroNode2(0, "", "");

	// 取頭節點
	public HeroNode2 getHead() {
		return head;
	}

	// 添加新節點
	public void add(HeroNode2 heroNode) {

		// 用臨時節點遍歷找到最後的節點
		HeroNode2 temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}

		// 形成雙向鏈表
		temp.next = heroNode;
		heroNode.pre = temp;
	}

	// 按順序增加
	public void addByOrder(HeroNode2 heroNode) {

		HeroNode2 temp = head;
		boolean flag = false; // 是否有重複編號

		// 找到插入點temp(後)
		while (true) {

			// 鏈表已到最後
			if (temp.next == null) {
				break;
			}

			// ***插入點為 temp ~ temp.next 之間(有小到大排列情況)
			if (temp.next.no > heroNode.no) {
				break;
				// 編號已存在
			} else if (temp.next.no == heroNode.no) {
				flag = true; // 說明編號存在
				break;
			}
			// 後移
			temp = temp.next;
		}

		if (flag) {
			System.out.printf("編號%d英雄已存在,不能再添加\n", heroNode.no);
		} else {
			heroNode.next = temp.next;
			temp.next = heroNode;
			heroNode.pre = temp;
			// 空鏈表添加時 heroNode.next = null
			if (heroNode.next != null) {
				heroNode.next.pre = heroNode;
			}
		}

	}

	// 刪除節點
	// 雙向鏈表不須找到刪除節點的前一個
	// 找到後可自我刪除
	public void delete(int no) {

		if (head.next == null) {
			System.out.println("鏈表為空無法刪除");
			return;
		}

		HeroNode2 temp = head.next;
		boolean flag = false; // 是否找到待刪除的節點

		while (true) {
			// 已到最後未找到
			if (temp == null) {
				break;
			}
			// 找到
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}

		// 刪除
		if (flag) {
			temp.pre.next = temp.next;
			// 如果節點為最後一個 temp.next => NullPointerException
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.printf("待刪除的節點編號 %d 不存在\n", no);
		}
	}

	// 修改節點訊息(與單向鏈表相同)
	public void update(HeroNode2 newHeroNode) {

		if (head.next == null) {
			System.out.println("鏈表為空");
			return;
		}

		HeroNode2 temp = head.next;
		boolean flag = false; // 是否找到節點

		while (true) {
			// 鏈表以遍歷完畢
			if (temp == null) {
				break;
			}

			// 找到
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}

			temp = temp.next;
		}

		// 根據flag 判斷是否找到修改節點
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickName = newHeroNode.nickName;
		} else {
			System.out.printf("尚未找到編號%d, 不能修改\n" + newHeroNode.no);
		}
	}

	// 遍歷雙向鏈表
	public void list() {

		// 判斷鏈表是否為空
		if (head.next == null) {
			System.out.println("鏈表為空");
			return;
		}

		// 用臨時節點遍歷找到最後的節點
		HeroNode2 temp = head.next;
		while (true) {
			// 判斷是否到底
			if (temp == null) {
				break;
			}

			System.out.println(temp);
			temp = temp.next;
		}
	}
}

class HeroNode2 {

	// 數據域
	public int no;

	public String name;

	public String nickName;

	// next域
	public HeroNode2 next; // 指向後一個節點

	// pre域
	public HeroNode2 pre; // 指向前一個節點

	public HeroNode2(int no, String name, String nickName) {
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
