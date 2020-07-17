package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);		
		users u = new users();
		datas dt = new datas();
		
		System.out.println("===========================");
		System.out.println("프로그램을 시작합니다.");
		while(true) {
			System.out.println("===========================");
			System.out.print("▶ 명령어를 입력해주세요 >>> ");
			String cmd = sc.next();
			if(cmd.equals("help")) dt.help_data();
			else if(cmd.equals("a")) dt.make_data();
			else if(cmd.equals("r")) dt.read_data();
			else if(cmd.equals("u")) {
				//
			}
			else if(cmd.equals("d")) dt.delete_data();
		}
	}

}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class users{
	HashMap<String, Object> user = new HashMap<String, Object>();
	ArrayList<HashMap<String, Object>> user_list = new ArrayList<HashMap<String, Object>>();
	HashMap<String, String> user_cmd = new HashMap<String, String>();
	
	static String userName = null;
	
	users(){
		//user - Commands
		user_cmd.put("[S] sign_up","회원가입");
		user_cmd.put("[L] login","로그인");
		
		this.users_main();
	}
	Scanner sc = new Scanner(System.in);
	
	void users_main() {
		System.out.println("===========================");
		System.out.println("▶ Select Mode ◀");
		while (userName == null) {
			System.out.println("===========================");
			System.out.printf("총 회원수 : %d\n", user_list.size());
			System.out.print("모드를 선택해주세요 : ");
			String cmd = sc.nextLine();
//			cmd.toLowerCase();
			if (cmd.equals("help")) this.help();
			else if (cmd.equals("s")) this.signUp();
			else if (cmd.equals("l")) this.login();
		}
	}
	
	
	boolean login() {
		System.out.println("===========================");
		System.out.println("▶ Login Mode ◀");
		System.out.print("▷ ID >>> ");
		String ID = sc.nextLine();
		System.out.print("▷ PW >>> ");
		int PW = sc.nextInt();
		sc.nextLine();
		for (int i=0; i<this.user_list.size(); i++) {
			if (this.user_list.get(i).get("ID").equals((String)ID)) {
				if(this.user_list.get(i).get("PW").equals((Integer)PW)) {
					this.userName =  (String)(this.user_list.get(i).get("Name"));
					System.out.printf("\n★ '%s'님이 로그인 하였습니다 \n", this.userName);
					return true;
				}
			}
		}
		System.out.println("Error - failed login your ID .. ");
		return false;
	}
	
	void help() {
		System.out.println("===========================");
		for(String key : user_cmd.keySet()) System.out.printf("* %s : %s \n",key,user_cmd.get(key));
	}
	
	void signUp() {
		System.out.println("===========================");
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
		this.user_list.add(user);
		System.out.printf("\n★ '%s'님의 회원가입이 완료되었습니다. \n",Name);
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class datas{
    //data type = {"제목" , "작성자", "내용"}
    HashMap<String, String> data = new HashMap<String, String>();
    HashMap<String, String> data_cmd = new HashMap<String, String>();
    ArrayList<HashMap<String, String>> dList = new ArrayList<HashMap<String, String>>();
    Scanner sc = new Scanner(System.in);
    
    //variable 
    static int dataNum = -1;
    datas(){
    	//datas_commads
        data_cmd.put("[A] add", "데이터 추가");
        data_cmd.put("[R] read", "데이터 조회");
        data_cmd.put("[U] update", "데이터 수정");
        data_cmd.put("[D] delete", "데이터 삭제");
    }
    void help_data() {
    	for (String key : data_cmd.keySet()) System.out.printf("*%s : %s\n", key, data_cmd.get(key));
    }
    void make_data() {
    	System.out.println("===========================");
    	System.out.println("▶ Make Mode");
    	System.out.print("* 제목 : ");
    	String title = sc.nextLine();
        data.put("제목", title);
    	System.out.print("* 내용 : ");
    	String detail = sc.nextLine();
        data.put("내용", detail);
        data.put("작성자", users.userName);
        this.dList.add(data);
        System.out.println("데이터 생성이 완료 되었습니다. ");
    }
    
    void read_data() {
    	System.out.println("===========================");
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
    	System.out.println("===========================");
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
    	System.out.println("===========================");
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