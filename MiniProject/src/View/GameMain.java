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

				UserDAO userDao = new UserDAO();
				UserDTO userDto = new UserDTO(id, pw, 0);
				int row = userDao.join(userDto);

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

				UserDAO userDao = new UserDAO();
				UserDTO userDto = userDao.login(id, pw);

				if (userDto != null) {
					System.out.println("개냥치 게임에 들어오신걸 환영합니다.");
					PetDAO petDao = new PetDAO();
					PetDTO petDto = userDao.getPetInfo(userDto.getId());

					if (petDto == null) {
						while (true) {
							System.out.println("동물을 선택해주세요.");
							System.out.println("[1]고양이 [2]강아지 [3]이전으로 가기");
							int choice = sc.nextInt();
							System.out.println("동물의 이름을 지어주세요.");
							String petName = sc.next();

							if (choice == 1) {
								String str = "고양이";
								// 동물의 종류를 데이터베이스에 전달해주는 메소드 작성
								int row = userDao.decideType(petName, str, userDto.getId());
								if (row <= 0) {
									System.out.println("이름을 다시 지어주세요.");
									continue;
								}
								break;
							} else if (choice == 2) {
								String str = "강아지";
								int row = userDao.decideType(petName, str, userDto.getId());
								if (row <= 0) {
									System.out.println("이름을 다시 지어주세요.");
									continue;
								}
								break;
							} else if (choice == 3) {
								System.out.println("이전으로 돌아갑니다.");
								break;
							} else {
								System.out.println("번호를 다시 선택해주세요.");
							}

						}
					} else {
						while (true) {
							String name = petDto.getName();
							int hp = petDto.getHp();
							int fullness = petDto.getFullness();
							int love = petDto.getLove();
							int money = userDto.getMoney();
							
					         System.out.println("[1]상태보기 [2]소지품확인 [3]알바하기 [4]병원가기 [5]놀아주기 [6]잠재우기 [7]게임메뉴로 돌아가기");
					         int choice = sc.nextInt();

					         if (choice == 1) {
					            if (hp > 0) {
					               System.out.println("=========" + name + "의 상태=========");
					               System.out.println("1. 체력 : " + hp);
					               System.out.println("2. 포만감 : " + fullness);
					               System.out.println("3. 애정 : " + love);
					               System.out.println();
					            } else {
					               System.out.println("hp가 0입니다.");
					               System.out.println("탈락");
					               break;
					            }

					         } else if (choice == 2) {
					            System.out.println("========= 소지품 ==========");
					            System.out.println("돈 :" + money + "원");
					            System.out.println();

					            if (hp == 0) {
					               System.out.println("hp가 0입니다.");
					               System.out.println("탈락");
					               break;
					            }

					         } else if (choice == 3) {
					            System.out.println("========= 아르바이트 =========");
					            System.out.println(name + "아 조금만 기다려...");

					            try {
					               // 2000 밀리초(2초) 동안 일시 중지
					               Thread.sleep(2000);
					            } catch (InterruptedException e) {
					               e.printStackTrace();
					            }

					            userDto.setMoney(userDto.getMoney() + 6000);
					            System.out.println("6000원을 획득하였습니다.");
					            System.out.println();

					            if (hp == 0) {
					               System.out.println("hp가 0입니다.");
					               System.out.println("탈락");
					               break;
					            }

					         } else if (choice == 6) {
					            System.out.println(name + "(을)를 재웁니다.");

					            int row = petDao.sleep(petDto);

					            if (row > 0) {
					               System.out.println("펫의 hp 5, fullness 5 올랐습니다.");
					            } else {
					               System.out.println("오류");
					            }

					            if (hp == 0) {
					               System.out.println("hp가 0입니다.");
					               System.out.println("탈락");
					               break;
					            }
					         } else if (choice == 7){
					        	 System.out.println("프로그램을 종료합니다.");
					        	 break;
					         } else {
					        	 System.out.println("번호를 다시 입력해주세요.");
					         }

					      }
					}

				} else {
					System.out.println("로그인에 실패했습니다.");
					System.out.println("아이디와 비밀번호를 확인해주세요.");
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
