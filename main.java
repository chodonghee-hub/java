package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class main {
	static ArrayList<HashMap<String, Object>> artcList = new ArrayList<HashMap<String, Object>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    
		while(new users()._selectMode_()) {
			new article();
		}
	}

}
class users{

    ArrayList<HashMap<String, Object>> userList = new ArrayList<HashMap<String, Object>>();
    Scanner sc = new Scanner(System.in);

    static String userName = null;
    static String userPos = null;

    users(){
        signUp("timandsunny",1234,"donghee","Admin");

    }

    boolean _selectMode_() {
        System.out.println("======================");
        System.out.println("▶ Select Mode < USERS > ");
        System.out.printf("members : %d\n",userList.size());
        while(userName == null) {
            System.out.println("======================");
            System.out.print("▷ Enter the next proccess \n>>> ");
            String cmd = sc.nextLine();
            if(cmd.equals("help")) {
                System.out.println("- [S] : sign-up");
                System.out.println("- [L] : login");
                System.out.println("- [break] : break");
            }
            else if (cmd.equals("s")) {
                System.out.println("======================");
                System.out.println("▶ Sign-Up Mode");
                System.out.print("▷ Enter new ID \n>>> ");
                String ID = sc.nextLine();
                System.out.print("▷ Enter new PW \n>>> ");
                int PW = sc.nextInt();
                sc.nextLine();
                System.out.print("▷ Enter new nick name \n>>> ");
                String Name = sc.nextLine();
                signUp(ID, PW, Name, "User");

            }
            else if (cmd.equals("l")) if(_login_()) return true;
            else if (cmd.equals("break")) {
                System.out.println("Finish Program ...");
                return false;
            }
        }return false;
    }

    void signUp(String ID, int PW, String Name, String pos){
        HashMap<String, Object> user = new HashMap<String, Object>();
        user.put("ID",ID);
        user.put("PW", PW);
        user.put("Name",Name);
        user.put("Position", pos);
        userList.add(user);

        System.out.printf("Success sign up - '%s'\n",Name);
    }

    boolean _login_() {
        System.out.println("======================");
        System.out.println("▶ Login Mode");
        System.out.print("▷ Enter your ID\n>>> ");
        String loginID = sc.nextLine();
        System.out.print("▷ Enter your PW\n>>> ");
        int loginPW = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<userList.size(); i++) {
            if (loginID.equals(userList.get(i).get("ID")) && (loginPW == (int) userList.get(i).get("PW"))) {
                userName = (String) userList.get(i).get("Name");
                userPos = (String) userList.get(i).get("Position");
                System.out.printf("* Success login - '%s'\n",userName);
                return true;
            }
        }if (userName == null) System.out.println("* Error - failed login ..");
        return false;
    }
}
class article{

    Scanner sc = new Scanner(System.in);
    
    int total_artc = 1;

    article(){
    	addArticle("test1", "test1","hong");
        addArticle("test2", "test2","cha");
        addArticle("test3", "test3","kim");
        
        selectMode(); 
    }
    
    boolean _Admin_() {
    	if (users.userPos.equals("Admin")) return true;
    	return false;
    }
    
    void selectMode() {
        System.out.println("======================");
        System.out.println("▶ Select Mode < ARTICLE >");
        System.out.printf("article : %d\n",main.artcList.size());
        while(true) {
        	
            System.out.println("======================");
            System.out.print("▷ Enter the next proccess \n>>> ");
            String cmd = sc.nextLine();
            if (cmd.equals("help")) {
                System.out.println("- [C] : add article");
                System.out.println("- [R] : read article");
                System.out.println("- [U] : update article");
                System.out.println("- [D] : delete article");
                System.out.println("- [X] : break");
            }

            if (cmd.equals("c")) {
                System.out.println("======================");
                System.out.println("▶ Create Mode");
                System.out.printf("▷ Enter new title \n>>> ");
                String title = sc.nextLine();
                System.out.printf("▷ Enter new detail \n>>> ");
                String detail = sc.nextLine();
                addArticle(title, detail, users.userName);
                System.out.printf("* '1' more article is added - 'by : %s\n",users.userName);
            }

            else if (cmd.equals("r")) chkReadType();
            else if (cmd.equals("u")) updateArticle();
            else if (cmd.equals("d")) deleteArticle();
            else if (cmd.equals("x")) {
                System.out.println("Finih Program ...");
                users.userName = null;
                break;
            }
        }

    }

    void addArticle(String title, Object detail, String user) {
        HashMap<String, Object> article = new HashMap<String, Object>();
        ArrayList<String> hit_list = new ArrayList<String>();
        article.put("Number", total_artc);
        article.put("Title", title);
        article.put("Writer", user);
        article.put("Detail", detail);
        article.put("View", 0);
        article.put("Hit", hit_list);

        main.artcList.add(article);
        total_artc ++;
    }

    void chkReadType() {
        System.out.println("======================");
        System.out.println("▶ Read Mode");
        System.out.print("▷ [A] : read all article \n▷ [N] : read especial article \n▷ [D] : read detail article \n>>> ");
        String cmdRead = sc.nextLine();
        if (cmdRead.equals("a")) {
        	if(main.artcList.size() != 0) {
	            for(int i=0; i<main.artcList.size(); i++) {
	                readArtc_Title(i);
	            }System.out.println("******************");
        	}else System.out.println("* Error - article list is empty ... ");
        }
        else if (cmdRead.equals("n")) {
        	System.out.println("\n▷ Select the type of keyword");
        	System.out.println("* [T] : Title");
        	System.out.println("* [D] : Detail");
        	System.out.print("* [W] : Writer \n>>> ");
        	String typeKey = sc.nextLine();
        	if (typeKey.equals("t")) typeKey = "Title";
        	else if (typeKey.equals("d")) typeKey = "Detail";
        	else if (typeKey.equals("w")) typeKey = "Wrtier";
        	
    		System.out.printf("\n▷ Enter the key-word (※ key-word in %s) \n>>> ",typeKey);
    		String artcKey = sc.nextLine();
        	
            if(_getArticle_key_(artcKey, typeKey).size() != 0) {
            	for(int i=0; i<_getArticle_key_(artcKey,typeKey).size(); i++) {
            		readArtc_Title(i);
            	}System.out.println("******************");
            }
            else System.out.println("* Error - can't find article ... ");
        }
        else if (cmdRead.equals("d")) {
        	System.out.print("\n▷ Enter the article number : ");
        	int artcNum = sc.nextInt();
        	sc.nextLine();
        	if(_isExitArticle_(artcNum)) readArtc_Detail(artcNum-1);
        	System.out.println("******************");
        }
    }
    
    void readArtc_Title(int num) {
    	System.out.println("******************");
    	System.out.printf("▷ Artc Num ['%d'] \n",main.artcList.get(num).get("Number"));
    	System.out.printf("* [Title] : %s\n\n",main.artcList.get(num).get("Title"));
    }
    
    void readArtc_Detail(int num) {
    	main.artcList.get(num).put("View", (int) main.artcList.get(num).get("View")+1);
    	
    	System.out.println("******************");
    	@SuppressWarnings("unchecked")
		ArrayList<String> temp_hit = (ArrayList<String>)main.artcList.get(num).get("Hit");
        System.out.printf("▷ Artc Num ['%d'] \n",main.artcList.get(num).get("Number"));
        System.out.printf("* [Title] : %s\n",main.artcList.get(num).get("Title"));
        System.out.printf("* [Writer] : %s\n",main.artcList.get(num).get("Writer"));
        System.out.printf("* [Detail] : %s \n",main.artcList.get(num).get("Detail"));
        System.out.printf("* [Hit] : %d \n",temp_hit.size());
        System.out.printf("* [View] : %d \n",main.artcList.get(num).get("View"));
    }
    
    void updateArticle() {
        System.out.println("======================");
        System.out.println("▶ Update Mode");
        System.out.print("▷ Enter the update article's number : ");
        int  artcNum  = sc.nextInt();
        sc.nextLine();
        if(_isExitArticle_(artcNum) ){
        	if (_Admin_() != true) {
	            if ( _isMyArticle_(artcNum)) {
	                System.out.print("▷ Enter the new data \n>>> ");
	                String newData = sc.nextLine();
	                main.artcList.get(artcNum-1).put("Detail",newData);
	                System.out.printf("* Success update article - artcNum : '%d'\n",artcNum);
	            }else System.out.println("* Error - can't touch other's article ... ");
        	}
        	else {
        		System.out.print("▷ Enter the new data \n>>> ");
                String newData = sc.nextLine();
                main.artcList.get(artcNum-1).put("Detail",newData);
                System.out.printf("* Success update article - artcNum : '%d'\n",artcNum);
        	}
        }else System.out.println("* Error - can't find article ... ");
        
    }

    void deleteArticle() {
    	System.out.println("======================");
        System.out.println("▶ Delete Mode");
        System.out.print("▷ Enter the delete article's number : ");
        int artcNum = sc.nextInt();
        if(_isExitArticle_(artcNum)) {
        	if (_Admin_() != true) {
	        	if (_isMyArticle_(artcNum)) {
	        		main.artcList.remove(artcNum-1);
	            	System.out.printf("* Artc number '%d' is deleted by '%s'\n",artcNum, users.userName);
	        	}
        	}else {
        		main.artcList.remove(artcNum-1);
            	System.out.printf("* Artc number '%d' is deleted by 'Admin'\n",artcNum);
        	}
        }
    }
    
    
//    ArrayList<HashMap<String, Object>> _paging_ = new ArrayList<HashMap<String, Object>>(){
//    	
//    }
    
    boolean _isMyArticle_(int artcNum) {
        if ((users.userName).equals((String) main.artcList.get(artcNum-1).get("Writer"))) return true;  
        return false;
    }
    
    boolean _isExitArticle_(int artcNum) {
        for (int i=0; i<main.artcList.size(); i++) if (artcNum == (int)main.artcList.get(i).get("Number")) return true;
        return false;
    }
    
    
    ArrayList<HashMap<String, Object>> _getArticle_key_(String artcKW, String typeKW) {
        ArrayList<HashMap<String, Object>> temp = new ArrayList<HashMap<String, Object>>();
        for(int i=0; i<main.artcList.size(); i++) {
            String findRst = (String) main.artcList.get(i).get(typeKW);
            if (findRst.contains(artcKW)) temp.add(main.artcList.get(i));
        }
        return temp;
    }
}