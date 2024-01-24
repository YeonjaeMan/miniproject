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
				UserDTO userDto = new UserDTO(id, pw);
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
							System.out.println("[1]고양이 [2]강아지");
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
							} else {
								System.out.println("번호를 다시 선택해주세요.");
							}

						}
					}

					if (petDto != null) {
						String name = petDto.getName();
						String spec = petDto.getSpec();
						int hp = petDto.getHp();
						int fullness = petDto.getFullness();
						int love = petDto.getLove();
						int money = petDto.getMoney();
						boolean supply1 = petDto.isSupply1();
						boolean supply2 = petDto.isSupply2();

						while (true) {

							System.out.println("[1]상태보기 [2]소지품확인 [3]알바하기 [4]병원가기 [5]놀아주기 [6]잠재우기 [7]게임메뉴로 돌아가기");
							int choice = sc.nextInt();

							if (choice == 1) {

								System.out.println("=========" + name + "의 상태=========");
								System.out.println("1. 체력 : " + hp);
								System.out.println("2. 포만감 : " + fullness);
								System.out.println("3. 애정 : " + love);
								System.out.println();

							} else if (choice == 2) {
								System.out.println("========= 소지품 ==========");
								System.out.println("돈 :" + money + "원");
								System.out.println();

							} else if (choice == 3) {

								System.out.println("========= 아르바이트 =========");
								System.out.println(name + "아 조금만 기다려...");

								try {
									// 2000 밀리초(2초) 동안 일시 중지
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								money = money + 6000;
								System.out.println("6000원을 획득하였습니다.");
								System.out.println();

							} else if (choice == 4) {
								System.out.println("오늘도 우리 귀여운" + name + "무슨일로 병원에 왔는가");

								while (true) {
									System.out.print("[1]간식 [2]사료 [3]진료 [4]장난감 [5]애견용품 [6]나가기");
									int hosChoice = sc.nextInt();

									if (hosChoice == 1) {
										money -= -0;// 여기 0에는 감소되는 금액 작성
										System.out.println();
										System.out.println("<우리" + name + "왕자가 간식을 선택하였구나>");
										hp -= 5;
										fullness += 10;
										love += 10;
										printInfo(name, hp, fullness, love, money);
									} else if (hosChoice == 2) {
										money -= -0;
										System.out.println();
										System.out.println("이보게 주인 양반" + name + "왕자 밥좀 팍팍먹이게");
										hp += 5;
										fullness += 15;
										love += 5;
										printInfo(name, hp, fullness, love, money);
									} else if (hosChoice == 3) {
										money -= -0;
										System.out.println();
										System.out.println(name + "의 건강검진을 시작합니다.");
										hp += 20;
										fullness -= 20;
										love -= 30;
										printInfo(name, hp, fullness, love, money);
									} else if (hosChoice == 4) {
										money -= -0;
										System.out.println();
										System.out.println("껄껄 돈많은 양반이구만" + name + "재미있게 가지고 놀아라");
										hp -= 5;
										fullness -= 15;
										love += 15;
										printInfo(name, hp, fullness, love, money);
									} else if (hosChoice == 5) {
										if (spec.equals("강아지")) {
											while (true) {
												System.out.println("[1] 옷사기 [2] 목줄사기 [3]삑삑이 [4]나가기");
												int hosDogChoice = sc.nextInt();
												if (hosDogChoice == 1) {
													money -= -0;
													System.out.println();
													System.out.println("오늘은 이옷이 좋겠군 우리" + name + "왕자 오늘도 예쁘구나");
													love += 5;
													printInfo(name, hp, fullness, love, money);
												} else if (hosDogChoice == 2) {
													boolean lead = true;
													money -= -0;
													System.out.println();
													System.out.println("목줄을 획득합니다.");
													hp -= 0;
													fullness -= 0;
													love -= 0;
													printInfo(name, hp, fullness, love, money);
												} else if (hosDogChoice == 3) {
													boolean catwheel = true;
													money -= -0;
													System.out.println();
													System.out.println("삑삑이을 획득합니다.");
													hp -= 0;
													fullness -= 0;
													love -= 0;
													printInfo(name, hp, fullness, love, money);
												} else if (hosDogChoice == 4) {
													break;
												}
											}
										}
										if (spec.equals("고양이")) {
											while (true) {
												System.out.println("[1] 옷사기 [2] 켓휠 [3]레이저 [4]나가기");
												int hosCatChoice = sc.nextInt();
												if (hosCatChoice == 1) {
													money -= -0;
													System.out.println();
													System.out.println("오늘은 이옷이 좋겠군 우리" + name + "왕자 오늘도 예쁘구나");
													love += 5;
													printInfo(name, hp, fullness, love, money);
												} else if (hosCatChoice == 2) {
													boolean lead = true;
													money -= -0;
													System.out.println();
													System.out.println("켓휠을 획득합니다.");
													hp -= 5;
													fullness -= 10;
													love += 5;
													printInfo(name, hp, fullness, love, money);
												} else if (hosCatChoice == 3) {
													boolean catwheel = true;
													money -= -0;
													System.out.println();
													System.out.println("레이저을 획득합니다.");
													hp -= 0;
													fullness -= 0;
													love -= 0;
													printInfo(name, hp, fullness, love, money);
												} else if (hosCatChoice == 4) {
													break;
												}
											}
										}
									} else if (hosChoice == 6) {
										break;
									} else {
										System.out.println("고객님 무슨말을 하시는지 모르겠습니다.");
									}
								}

							} else if (choice == 5) {
								System.out.println(name + "(이)랑 놀아주기!!");
								if (spec.equals("강아지")) {
									System.out.println("[1]산책 [2]터그놀이");
									int dog_choice = sc.nextInt();
									boolean lead = true;
									boolean dogToy = true;

									if (dog_choice == 1) {
										if (lead == true) {
											System.out.println(name + "이와 함께 산책을 나섭니다.");
											// 딜레이 2초 넣기
											love += 15;
											fullness -= 15;
											hp -= 5;
											System.out.println("애정도가 15 올라갔습니다.");
										} else {
											System.out.println("목줄이 없어 산책을 할 수 없습니다ㅠㅠ");
										}
									} else if (dog_choice == 2) {
										if (dogToy == true) {
											System.out.println("삑삑이 인형으로 터그놀이를 해줍니다.");
											love += 10;
											fullness -= 10;
											hp -= 5;
											System.out.println("애정도가 10 올라갔습니다.");
										} else {
											System.out.println("터그놀이를 해줍니다.");
											love += 5;
											fullness -= 10;
											hp -= 5;
											System.out.println("애정도가 5 올라갔습니다.");
										}
									}
								} else if (spec.equals("고양이")) {

									System.out.println("[1]캣휠 [2]사냥놀이");
									int catChoice = sc.nextInt();
									boolean catWheel = true;
									boolean catToy = true;
									if (catChoice == 1) {
										if (catWheel == true) {
											System.out.println(name + "(이)가 캣휠을 타고있습니다.");
											// 딜레이 2초 넣기
											love += 15;
											fullness -= 15;
											hp -= 5;
											System.out.println("애정도가 15 올라갔습니다.");
										} else {
											System.out.println("캣휠이 없어서 캣휠을 태울 수 없습니다ㅠㅠ");
										}
									} else if (catChoice == 2) {
										if (catToy == true) {
											System.out.println("레이저로 사냥놀이를 해줍니다.");
											love += 10;
											fullness -= 10;
											hp -= 5;
											System.out.println("애정도가 10 올라갔습니다.");
										} else {
											System.out.println("사냥놀이 해줍니다.");
											love += 5;
											fullness -= 10;
											hp -= 5;
											System.out.println("애정도가 5 올라갔습니다.");
										}

									}

								}

							} else if (choice == 6) {
								System.out.println(name + "(을)를 재웁니다.");

								hp += 5;
								fullness -= 5;

								PetDTO lastPetDto = new PetDTO(name, spec, hp, fullness, love, money, supplies);

								int row = petDao.sleep(lastPetDto);

								if (row > 0) {
									System.out.println("펫의 hp 5, fullness 5 올랐습니다.");
									System.out.println("펫 정보를 저장합니다.");
								} else {
									System.out.println("오류");
								}

							} else if (choice == 7) {
								System.out.println("메인화면으로 돌아갑니다.");
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

	public static void printInfo(String name, int hp, int fullness, int love, int money) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("현재 " + name + "의 체력 :" + hp + "\t" + "포만감 :" + fullness + "\t" + "애정 :" + love);
		System.out.println("님의 잔액은" + money + "입니다.");
	}

}
