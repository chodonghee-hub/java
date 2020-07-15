package board;
import java.util.*;

public class jav_0715 {

	public static void main(String[] args) {
        // TODO Auto-generated method stub        
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> comlist = new HashMap<String, String>();

        //cmdList
        comlist.put("add","데이터 추가");
        comlist.put("read","데이터 조회");
        comlist.put("update","데이터 수정");
        comlist.put("delete","데이터 삭제");

        //data_list
        
        //global variable
        String store = null;
        
        while(true){
          System.out.print("=========================\n명령어를 입력해주세요 : ");
          String cmd = sc.next();
          if(cmd.equals("exit")){
            System.out.println("프로그램을 종료 합니다..");
            break;
          }else if (cmd.equals("help")){
            for(String key : comlist.keySet()) System.out.printf("%s : %s\n",key,comlist.get(key));
          }else if (cmd.equals("read")) {
             //read
             if (store != null) System.out.printf("Store : %s\n",store);
             else System.out.println("Error - store is empty");
          }else if (cmd.equals("delete")) {
              //delete
          }else if (cmd.equals("add")) {
              //add
              if (store == null) {
                  System.out.print("어떤값을 저장하시겠습니까? : ");
                  store = sc.next();
                  System.out.println("저장이 완료 되었습니다.");
              }else System.out.println("Error - store is exit.. please use update");
          }else if (cmd.equals("update")) {
              //update
              System.out.printf("저장된 값을 변경 하시겠습니까 -- [Y] - yes / [N] - no\n현재값 : %s\n>>>",store);
              String quest = sc.next();
              if (store == null) {
                  System.out.print("Error - store is empty");
              }else {
                  if (quest.equals("Y")) {
                      store = sc.next();
                      System.out.println("수정이 완료 되었습니다.");
                  }else if (quest.equals("N")) System.out.println("pass ..");
                  else System.out.println("Error - please enter Y / N ");
              }
              
          }else System.out.println("Error - cannot find commadns ..");
          
        }
        
    }

}

class datas{
    //data type = {"제목" , "작성자", "내용"}
    HashMap<String, String> data = new HashMap<String, String>();
    ArrayList<HashMap<String, String>> dList = new ArrayList<HashMap<String, String>>();
    Scanner sc = new Scanner(System.in);
    static int dataNum = -1;
    datas(){
        
    }
    void make_data(String title, String userName, String detail) {
        data.put("제목", title);
        data.put("작성자", userName);
        data.put("내용", detail);
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
                //
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