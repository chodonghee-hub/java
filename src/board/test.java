package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> comlist = new HashMap<String, String>();

        //cmdList
        comlist.put("add","데이터 추가");
        comlist.put("read","데이터 조회");
        comlist.put("update","데이터 수정");
        comlist.put("delete","데이터 삭제");
		
		datas dt = new datas();
		System.out.println("프로그램을 시작합니다.");
		while(true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = sc.next();
			if(cmd.equals("help")) for(String key : comlist.keySet()) System.out.printf("* ['%s'] : %s \n",key,comlist.get(key));
			else if(cmd.equals("add")) {
				dt.make_data();
			}
			else if(cmd.equals("read")) {
				dt.read_data();
			}
			else if(cmd.equals("update")) {
				//
			}
			else if(cmd.equals("delete")) {
				dt.delete_data();
			}
		}
	}

}

class users{
	String userName = null;
	users(){
		this.users_main();
	}
	
	 
	HashMap<String, Object> user = new HashMap<String, Object>();
	ArrayList<HashMap<String, Object>> user_list = new ArrayList<HashMap<String, Object>>();
	HashMap<String, String>  uCommands = new HashMap<String, String>();
	
	//user - Commands
	
	Scanner sc = new Scanner(System.in);
	
	void users_main() {
		System.out.println("▶ Select Mode ◀");
		System.out.print("모드를 선택해주세요 : ");
		String cmd = sc.nextLine();
		if (cmd.equals("help")) {
			//help()
		}
		else if (cmd.equals("signUp")) {
			this.signUp();
		}
		else if (cmd.equals("login")) {
			//login()
		}
	}
	
	void login() {
		System.out.println("▶ Login Mode ◀");
		System.out.print("▷ ID >>> ");
		String ID = sc.nextLine();
		System.out.print("▷ PW >>> ");
		int PW = sc.nextInt();
		for (int i=0; i<user_list.size(); i++) {
			HashMap<String, Object> nowUser = user_list.get(i);
			
				
		}
	}
		
	
	
	void signUp() {
		System.out.println("▶ Sign-Up Mode ◀");
		System.out.print("▷ ID >>> ");
		String ID = sc.nextLine();
		System.out.print("▷ PW >>> ");
		int PW = sc.nextInt();
		sc.nextLine();
		System.out.print("▷ User-Name >>> ");
		String Name = sc.nextLine();
		user.put("ID", ID);
		user.put("PW", PW);
		user.put("Name", Name);
		user_list.add(user);
		System.out.printf("'%s'님의 회원가입이 완료되었습니다. \n",Name);
	}
	
	
}


class datas{
    //data type = {"제목" , "작성자", "내용"}
    HashMap<String, String> data = new HashMap<String, String>();
    ArrayList<HashMap<String, String>> dList = new ArrayList<HashMap<String, String>>();
    Scanner sc = new Scanner(System.in);
    
    //userName 
    users u = new users();
    
    //variable 
    static int dataNum = -1;
    datas(){
        
    }
    void make_data() {
    	System.out.println("▶ Make Mode");
    	System.out.print("* 제목 : ");
    	String title = sc.nextLine();
        data.put("제목", title);
    	System.out.print("* 내용 : ");
    	String detail = sc.nextLine();
        data.put("내용", detail);
        data.put("작성자", u.userName);
        dList.add(data);
        System.out.println("데이터 생성이 완료 되었습니다. ");
    }
    
    void read_data() {
    	String kTitle = null;
    	String kDetail = null;
    	String kUser = null;
        System.out.println("▶ Read Mode");
        if(isEmpty()) System.out.println("Error - data list is empty ..");
        else {
        	for (int i=0; i<this.dList.size(); i++) {
        		for (String key : data.keySet()) {
        			if (key == "제목") kTitle = data.get(key);
        			else if (key == "내용") kDetail = data.get(key);
        			else if (key == "작성자") kUser = data.get(key);
        		}
        	}System.out.printf("* [제목] : %s \n* [내용] : %s\n* [작성자] : %s\n",kTitle, kDetail, kUser);
        }
    }
    
    void delete_data() {
    	int delNum = -1;
        System.out.println("▶ Delete Mode");
        System.out.print("삭제할 데이터 제목을 입력해주세요 : ");
        String quest = sc.next();
        if (isEmpty() != true) {
        	for(int i=0; i<this.dList.size(); i++) {
            	delNum = this.findDataNum(quest);
            	if(delNum != -1) {
            		this.dList.remove(delNum);
            		System.out.println("데이터가 삭제되었습니다.");
            		break;
            	}
            }
        }
    }
    
    void update_data() {
    	// ArrayList - set 사용하기
    }
    
    boolean isEmpty() {
        if (this.dList.size() == 0) return true;
        else return false;
    }
    
    boolean isMyData() {
    	// update , delete 에 적용
    	return true;
    }
    
    int findDataNum(String fTitle) {
    	// == 연산자와 equals의 차이점 알아보기 
        if (isEmpty()) System.out.println("Error - data list is empty ..");
        else {
            for(int i=0; i<this.dList.size(); i++) if (fTitle.equals(this.dList.get(i).get("제목"))) return (i);
        }return -1;
    }
 
    
    
    
    
    
    
}