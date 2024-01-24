package View;

import java.util.Scanner;

import Model.PetDAO;
import Model.PetDTO;
import Model.UserDAO;
import Model.UserDTO;

public class GameMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("[1]회원가입 [2]로그인 [3]게임종료");
			int input = sc.nextInt();

			if (input == 1) { // 회원가입
				System.out.println("===== 회원가입 =====");
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("PW 입력 : ");
				String pw = sc.next();

				UserDAO dao = new UserDAO();
				UserDTO dto = new UserDTO(id, pw, 0);
				int row = dao.join(dto);

				if (row > 0) {
					System.out.println("회원가입 성공!");
				} else {
					System.out.println("회원가입 실패..");
				}

			} else if (input == 2) { // 로그인
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();

				UserDAO dao = new UserDAO();
				UserDTO dto = dao.login(id, pw);

				if (dto != null) {
					System.out.println("개냥치 게임에 들어오신걸 환영합니다.");

					System.out.println("동물을 선택해주세요.");
					System.out.println("[1]고양이 [2]강아지");
					int choice = sc.nextInt();
					// 동물의 종류를 데이터베이스에 전달해주는 메소드 작성

					System.out.println("동물의 이름을 지어주세요.");
					String petName = sc.next();
					// 동물의 이름을 데이터베이스에 전달해주는 메소드 작성

					// + 해당 동물의 상태(Hp, Satiety, Affection)을 만땅으로 초기화해주는 메소드 작성

//					int day = 0;
//					while(hp > 0 && fullness > 0 && love > 0) {
//						day++;
//						System.out.println("[1]상태보기 [2]소지품확인 [3]알바하기 [4]병원가기 [5]놀아주기 [6]잠재우기");
//						
//						
//						
//						
//						
//						
//						
//						// 각종 기능 구현
//						
//						
//						
//						
//						
//						
//						
//						
//						
//						
//						
//						if(hp == 100 && fullness == 100 && love == 100) {
//							System.out.println("축하합니다 게임을 클리어 하셨습니다.");
//							System.out.println("클리어 시간 : OO초");
//						}
//					}
//					
//				} else {
//					System.out.println("로그인에 실패했습니다.");
//					System.out.println("아이디와 비밀번호를 확인해주세요.");
				}
			} else if (input == 3) { // 게임종료
				System.out.println("게임을 종료합니다.");
				break;
			} else {
				System.out.println("다시 입력해주세요.");
			}
		}

	}

}
