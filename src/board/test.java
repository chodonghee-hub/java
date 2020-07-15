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
			else if(cmd.equals("delte")) {
				//
			}
		}
	}

}

class users{
	String userName = "dh";
	
	
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
    	String title = sc.next();
        data.put("제목", title);
    	System.out.print("* 내용 : ");
    	String detail = sc.next();
        data.put("내용", detail);
        data.put("작성자", u.userName);
        dList.add(data);
        System.out.println("데이터 생성이 완료 되었습니다. ");
    }
    void read_data() {
        System.out.println("▶ Read Mode");
        if(isEmpty()) System.out.println("데이터가 존재하지 않습니다..");
        else for (int i=0; i<dList.size(); i++) for (String key : data.keySet()) System.out.printf("* [%s] : %s \n",key, data.get(key));
    }
    void delete_data() {
        System.out.println("▶ Delete Mode");
        System.out.println("삭제할 데이터 제목을 입력해주세요 : ");
        String quest = sc.next();
        if (isEmpty() != true) {
            for(int i=0; i<dList.size(); ) {
                // 데이터 찾기 (findDataNum)  구현 
            }
        }
    }
    boolean isEmpty() {
        if (this.dList.size() == 0) return true;
        else return false;
    }
    boolean findDataNum() {
        if (isEmpty()) System.out.println("Error - data list is empty ..");
        else {
            for(int i=0; i<dList.size(); i++) {
                for(String key : dList.get(i).keySet()) {
//                    if (key == title) {
//                         dataNum = i;
//                         return true;
//                    }
                }
            }
        }return true;
    }

    
    
    
    
    
}