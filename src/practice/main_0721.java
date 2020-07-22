package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class main_0721 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new users();
		new article();
		
	}

}

class users{
	
	ArrayList<HashMap<String, Object>> userList = new ArrayList<HashMap<String, Object>>();
	Scanner sc = new Scanner(System.in);
	
	static String userName = null;
	
	users(){
		signUp("timandsunny",1234,"donghee");
		selectMode();
	}
	
	void selectMode() {
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
				System.out.println("- [X] : break");
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
				signUp(ID, PW, Name);
				
			}
			else if (cmd.equals("l")) login();
			else if (cmd.equals("x")) {
				System.out.println("Finish Program ...");
				break;
			}
		}
	}
	
	void signUp(String ID, int PW, String Name){
		HashMap<String, Object> user = new HashMap<String, Object>();
		user.put("ID",ID);
		user.put("PW", PW);
		user.put("Name",Name);
		userList.add(user);
				
		System.out.printf("Success sign up - '%s'\n",Name);
	}
	
	void login() {
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
				System.out.printf("* Success login - '%s'\n",userName);
			}
		}if (userName == null) System.out.println("* Error - failed login ..");
	}
	
}

class article{
	
	Scanner sc = new Scanner(System.in);
	ArrayList<HashMap<String, Object>> artcList = new ArrayList<HashMap<String, Object>>(); 
	
	article(){
		selectMode();
	}
	
	int total_artc = artcList.size();
	
	void selectMode() {
		System.out.println("======================");
		System.out.println("▶ Select Mode < ARTICLE >");
		System.out.printf("article : %d\n",artcList.size());
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
				addArticle(title, detail);
				System.out.printf("* '1' more article is added - 'by : %s\n",users.userName);
			}
			
			else if (cmd.equals("r")) {
				chkReadType();
			}
			
			else if (cmd.equals("u")) {
				
			}
			else if (cmd.equals("d")) {
				
			}
			else if (cmd.equals("x")) {
				System.out.println("Finih Program ...");
				break;
			}
		}
		
	}
	
	void addArticle(String title, Object detail) {
		HashMap<String, Object> article = new HashMap<String, Object>();
		article.put("Number", total_artc);
		article.put("Title", title);
		article.put("Writer", users.userName);
		article.put("Detail", detail);
		
		artcList.add(article);
		total_artc ++;
	}
	
	void chkReadType() {
		System.out.println("======================");
		System.out.println("▶ Read Mode");
		System.out.print("▷ [A] : read all article \n▷ [N] : read especial article \n>>> ");
		String cmdRead = sc.nextLine();
		if (cmdRead.equals("a")) {
			for(int i=0; i<artcList.size(); i++) {
				readArticle(i);
			}System.out.println("********************");
		}
		else if (cmdRead.equals("n")) {
			System.out.print("▷ Enter the key-word (※ key-word in title) \n>>> ");
			String artcNum = sc.nextLine();
			if(isExitArticle(artcNum).size() != 0) {
				for(int i=0; i<isExitArticle(artcNum).size(); i++) readArticle(i);
				System.out.println("********************");
			}
			else System.out.println("* Error - can't find article ... ");
		}
	}
	void readArticle(int num) {
		System.out.println("********************");
		System.out.printf("▷ Artc Num ['%d'] \n",artcList.get(num).get("Number"));
		System.out.printf("* Title : %s\n",artcList.get(num).get("Title"));
		System.out.printf("* Writer : %s\n",artcList.get(num).get("Writer"));
		System.out.printf("* Detail : %s \n",artcList.get(num).get("Detail"));
	}
	
	void updateArticle() {
		System.out.println("======================");
		System.out.println("▶ Update Mode");
		
	}
	
	
	void deleteArticle() {
		
	}
	
	void isMyArticle() {
		
	}
	
	ArrayList<HashMap<String, Object>> isExitArticle(String artcKW) {
		ArrayList<HashMap<String, Object>> temp = new ArrayList<HashMap<String, Object>>();
		for(int i=0; i<artcList.size(); i++) {
			String findTitle = (String) artcList.get(i).get("Title");
			if (findTitle.contains(artcKW)) temp.add(artcList.get(i));
		}
		return temp;
	}
}


















