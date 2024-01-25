package View;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Model.PetDAO;
import Model.PetDTO;
import Model.UserDAO;
import Model.UserDTO;
import javazoom.jl.player.MP3Player;

public class GameMain {

	public static void main(String[] args) {

		// MP3파일 3개 부재 주석으로 처리해놨음
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		MP3Player mp3 = new MP3Player();
		MP3Player mp3_2 = new MP3Player();

		String comPath = "C:\\Users\\smhrd\\Desktop\\miniproject\\MiniProject\\개냥고치BGM\\";

		ArrayList<mp3> musiclist = new ArrayList<mp3>();
		ArrayList<mp3_2> musiclist2 = new ArrayList<mp3_2>();

		musiclist.add(new mp3(comPath + "강아지선택.mp3"));// 0
		musiclist.add(new mp3(comPath + "고양이선택.mp3"));
		musiclist.add(new mp3(comPath + "소지품보기.mp3"));
		musiclist.add(new mp3(comPath + "병원로비소리.mp3"));
		musiclist.add(new mp3(comPath + "진료.mp3"));
		musiclist.add(new mp3(comPath + "개간식사료.mp3"));// 5
		musiclist.add(new mp3(comPath + "고양이사료.mp3"));
		musiclist.add(new mp3(comPath + "산책.mp3"));
		musiclist.add(new mp3(comPath + "캣휠.mp3"));
		musiclist.add(new mp3(comPath + "아르바이트.mp3"));
		musiclist.add(new mp3(comPath + "알바비받음.mp3"));// 10
		musiclist.add(new mp3(comPath + "터그놀이.mp3"));
		musiclist.add(new mp3(comPath + "배경음.mp3"));
		musiclist2.add(new mp3_2(comPath + "배경음.mp3"));
		musiclist.add(new mp3(comPath + "레이저놀아주기.mp3"));
		musiclist.add(new mp3(comPath + "상태보기.mp3"));
		musiclist.add(new mp3(comPath + "시작음.mp3"));// 15
		musiclist.add(new mp3(comPath + "강아지 성공음.mp3"));// 16
		musiclist.add(new mp3(comPath + "고양이 성공음.mp3"));// 17
		musiclist.add(new mp3(comPath + "실패음.mp3"));// 18
		
		while (true) {
			ConsoleClear();
			if (mp3.isPlaying()) {
				mp3.stop();
			}
			if(mp3_2.isPlaying()) {
				mp3.stop();
			}
			mp3.play(musiclist.get(15).getPath());
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠤⠤⠤⢒⠒⠒⢢⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⢀⠀⢒⠒⠈⠀⠀⠀⠀⠀⠙⢳⣆⠀⠈⠓⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⡐⠈⢰⡿⠀⠀⠀⠀⠀⠀⣀⡀⠀⢹⣆⠀⠀⣿⣄⣠⣤⣄⣀⡀⢀⣀⣀⣀\r\n"
					+ "⠀⢸⠃⠀⢸⡇⠀⠂⠀⠀⠀⠀⢈⢥⣄⠀⢿⣤⣴⣿⡇⠹⠹⠀⠙⡏⠛⣉⣴⠾\r\n"
					+ "⠀⢿⡄⢀⣸⡇⣴⣀⣦⠀⠀⠀⢷⣾⣿⡇⠈⣿⣿⡿⠀⡄⠀⠀⠀⢀⡀⠹⡇⢀\r\n"
					+ "⠀⠈⠻⣿⣿⡇⠛⢿⡿⠀⢠⡄⠈⠙⠋⠀⢀⣼⡿⣠⠶⣥⠀⠀⠀⣤⣭⣀⢻⡟\r\n"
					+ "⠀⠀⠀⠀⠙⠿⣃⣀⠀⠀⠈⠉⢀⡀⢤⣶⣿⣟⠀⢿⣿⡿⠀⠀⠸⣿⣿⡿⢘⡇\r\n"
					+ "⠀⠀⠀⠀⠀⢀⣾⠟⠋⠉⠉⠉⠉⠀⠀⠁⠈⣿⡒⠂⠀⠀⠀⠹⠁⠈⠉⢒⡒⠁\r\n"
					+ "⠀⠀⠀⠀⠀⣼⡛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠓⠒⠦⠤⠤⠤⠶⠎⠁⠀⠀\r\n"
					+ "⠉⠀⡠⠀⣰⣿⣇⠀⠀⠀⡀⠀⠀⠀⢀⠀⠀⣸⣇⢠⠀⠄⠀⠀⠀⠀⣿⠀⠀⠀\r\n"
					+ "⡔⠉⢠⠊⠈⢻⣿⠄⠀⠀⠻⣦⠀⣴⠃⠀⠀⣿⣿⠆⠀⠒⢦⠀⠀⣴⣿⡀⠀⠀\r\n"
					+ "⢄⠀⣾⡁⠀⠀⣿⡆⠀⠀⠀⢿⡀⠿⠀⠀⢀⣿⣿⣶⡋⠉⠉⢧⣿⠋⢸⣷⠀⠀\r\n"
					+ "⣨⣷⣿⣷⣤⣾⠿⢿⡆⠀⠀⠸⣧⡄⠀⠀⢺⠿⠿⡋⠃⠀⠀⠈⣇⠀⠸⡟⠠⣄\r\n"
					+ "⣿⣿⣿⣿⣿⡀⠀⢰⡇⠀⠀⠀⣿⠀⠀⠀⠀⣧⠀⣸⣀⣇⠀⠀⢈⡀⠀⣘⣀⣼\r\n"
					+ "⠈⠉⠙⠉⠉⠛⠋⠉⠗⠖⠒⠛⠛⠛⠒⠶⠒⠛⠟⠋⠋⠙⠛⠉⠉⠉⠉⠉⠉⠀");
			System.out.println("========== 메인 메뉴 ==========");
			System.out.println("[0]게임종료 [1]회원가입 [2]로그인 [3]랭킹");
			int input = sc.nextInt();

			if (input == 1) { // 회원가입
				ConsoleClear();
				System.out.println("========== 회원가입 ==========");
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("PW 입력 : ");
				String pw = sc.next();

				UserDAO userDao = new UserDAO();
				UserDTO userDto = new UserDTO(id, pw, 0, false);
				int row = userDao.join(userDto);

				if (row > 0) {
					System.out.println("회원가입 성공!");
				} else {
					System.out.println("회원가입 실패..");
				}

			} else if (input == 2) { // 로그인
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("PW 입력 : ");
				String pw = sc.next();

				UserDAO userDao = new UserDAO();
				UserDTO userDto = userDao.login(id, pw);

				if (userDto != null) {
					if (mp3.isPlaying()) {
						mp3.stop();
					}
					if(mp3_2.isPlaying()) {
						mp3.stop();
					}
					mp3.play(musiclist.get(12).getPath()); // 계속 깔려있을 노래
					ConsoleClear();
					System.out.println("========== 게임 접속 ==========");
					System.out.println("개냥치 게임에 들어오신걸 환영합니다.");
					PetDAO petDao = new PetDAO();
					PetDTO petDto = userDao.getPetInfo(userDto.getId());

					if (petDto == null) {
						while (true) {
							ConsoleClear();
							System.out.println("========== 동물 종류 선택 ==========");
							System.out.println("[1]고양이 [2]강아지");
							int choice = sc.nextInt();
							System.out.println("========== 동물 이름 짓기 ==========");
							String petName = sc.next();

							if (choice == 1) {
								System.out.println("⠀⡘⠠⢮⣅⠂⢀⣠⠤⠤⠦⠀⣀⣀⣀⠀⢔⡒⡄⠀⠀⠀⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠀⡇⠀⢀⡙⠃⠀⠀⠀⠀⠀⠀⠀⠁⣶⠛⠋⠀⡇⠀⠀⠀⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠀⣇⣰⠆⠀⠀⠠⠄⠰⠀⠀⢀⡀⠀⠙⣷⣄⣼⡇⠀⠀⠀⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠀⢸⡇⠀⢠⣶⣲⡆⠀⠀⠀⡠⢤⣄⠀⢹⣿⡟⠀⠀⠀⠀⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠀⣼⣧⠀⠈⠹⠏⠁⠠⠀⠀⠿⣿⠟⠃⣸⣿⠁⠀⠀⠀⠀⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⡁⠼⢶⠒⠂⠀⠀⠀⠀⠐⠀⠀⠀⠬⣳⣾⡟⠣⠄⠀⠀⠀⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠁⠀⠀⠈⠑⢲⣄⠀⢀⠀⠀⣀⡀⣠⣤⡟⠛⠁⠑⠢⠀⠀⠀⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠀⠀⠀⢰⠿⠁⠀⠈⠙⠛⠋⢻⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣘⣿⣿⡀⠀⠀⢐⠒⢀⠀⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⢦⡀⠀⠀⠀⠆⠀⢨⣿⣿⣿⡆⠀⠘⠄⠘⣦⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠀⠀⢀⣼⠀⠈⢿⣦⣼⠇⠀⢠⣾⣟⠉⠙⣷⡀⠀⢸⣠⣼⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠔⠒⠺⢿⠀⠀⣿⣿⡟⠀⣠⣾⡿⠷⣦⣤⣿⣧⣤⣾⣿⡿⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⣤⣤⣤⡎⠀⠀⣸⡏⠀⠀⢈⣋⠀⠀⠈⣿⣿⣿⣿⣿⠉⠀⠀⠀⠀");
								mp3.play(musiclist.get(1).getPath());
								String str = "고양이";
								// 동물의 종류를 데이터베이스에 전달해주는 메소드 작성
								int row = userDao.decideType(petName, str, userDto.getId());
								if (row <= 0) {
									System.out.println("이름 또는 종류를 다시 지어주세요.");
									continue;
								}
								
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								break;
							} else if (choice == 2) {
								System.out.println("⠀⠀⠀⠀⢀⣀⣀⣀⡴⠶⠶⠶⠶⠶⠶⢦⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠀⡶⢈⣹⠛⠉⠁⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠶⡀⠀⠀⠀⠀⠀\r\n"
										+ "⠀⠀⠀⡄⠒⠀⢠⡟⢃⡀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠐⢶⡀⠀⠀⠑⠒⢢⣄⠀⠀\r\n"
										+ "⠀⠀⢸⠀⠀⢠⣾⠁⣈⡁⠀⠀⠀⠀⠀⠀⣈⣉⠀⠀⠈⣿⠀⠀⠀⠀⠀⠈⢧⣤\r\n"
										+ "⠀⢸⡇⠀⠀⢸⣧⡜⠉⣷⠀⠀⠀⠀⢠⣞⠉⣹⣿⡄⠀⣿⠀⠀⠀⠀⠀⠀⠀⣿\r\n"
										+ "⠀⠸⢇⠀⠀⣸⡟⢿⣏⠛⠠⣤⡤⠀⠘⢻⣿⣿⡉⠃⠀⣿⠀⠀⠀⠀⠀⠀⣀⣿\r\n"
										+ "⠀⠀⠸⣀⣀⡏⠀⠀⠀⠀⣀⣸⣀⡄⠀⠀⠀⠀⠀⠀⠀⠹⣾⣀⠀⠀⢀⣶⠟⠀\r\n"
										+ "⠀⠀⠀⠉⠉⢷⡀⠀⠀⠀⠉⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠈⣉⠶⠶⠎⠁⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠀⠙⠶⢦⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣠⠶⠾⠉⠀⠀⠀⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠀⠀⠀⣠⡿⠋⠉⠉⠉⠉⠉⠉⠉⠉⠙⢿⣦⠀⠀⠀⠀⣤⢤⣤⠀\r\n"
										+ "⠀⢀⡰⠶⢆⡀⠀⣀⡿⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣻⣿⣀⡀⠀⢷⡀⠹⣶\r\n"
										+ "⢰⡏⠁⠀⠈⠛⠛⣿⠀⠀⠀⣴⠀⢀⡇⠀⠀⠀⠀⡾⠉⠉⠉⠉⢧⣴⠿⠀⠀⣿\r\n"
										+ "⠸⢇⡀⠀⠀⠀⣀⠿⠀⠀⠀⣿⣧⡜⠇⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⣿⠀⠀⣀⠿\r\n"
										+ "⠀⠘⢃⠀⠀⠸⣧⡀⠀⠀⠀⣿⣿⠁⠀⠀⠀⣴⣿⡇⠀⠀⠀⢀⣴⣿⣤⡞⠋⠀\r\n"
										+ "⠀⠀⠘⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠀");
								mp3.play(musiclist.get(0).getPath());
								String str = "강아지";
								int row = userDao.decideType(petName, str, userDto.getId());
								if (row <= 0) {
									System.out.println("이름 또는 종류를 다시 지어주세요.");
									continue;
								}
								
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
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
						int snack = petDto.getSnack();
						int feed = petDto.getFeed();
						boolean supply1 = petDto.isSupply1();
						boolean supply2 = petDto.isSupply2();
						int rank = userDto.getRank();

						int howmany = 0;

						while ((hp > 0 && fullness > 0 && love > 0)
								&& (hp < 75 || fullness < 75 || love < 85 || (hp + fullness + love) / 3 < 85)) {
							System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠤⠤⠤⢒⠒⠒⢢⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⢀⠀⢒⠒⠈⠀⠀⠀⠀⠀⠙⢳⣆⠀⠈⠓⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⡐⠈⢰⡿⠀⠀⠀⠀⠀⠀⣀⡀⠀⢹⣆⠀⠀⣿⣄⣠⣤⣄⣀⡀⢀⣀⣀⣀\r\n"
									+ "⠀⢸⠃⠀⢸⡇⠀⠂⠀⠀⠀⠀⢈⢥⣄⠀⢿⣤⣴⣿⡇⠹⠹⠀⠙⡏⠛⣉⣴⠾\r\n"
									+ "⠀⢿⡄⢀⣸⡇⣴⣀⣦⠀⠀⠀⢷⣾⣿⡇⠈⣿⣿⡿⠀⡄⠀⠀⠀⢀⡀⠹⡇⢀\r\n"
									+ "⠀⠈⠻⣿⣿⡇⠛⢿⡿⠀⢠⡄⠈⠙⠋⠀⢀⣼⡿⣠⠶⣥⠀⠀⠀⣤⣭⣀⢻⡟\r\n"
									+ "⠀⠀⠀⠀⠙⠿⣃⣀⠀⠀⠈⠉⢀⡀⢤⣶⣿⣟⠀⢿⣿⡿⠀⠀⠸⣿⣿⡿⢘⡇\r\n"
									+ "⠀⠀⠀⠀⠀⢀⣾⠟⠋⠉⠉⠉⠉⠀⠀⠁⠈⣿⡒⠂⠀⠀⠀⠹⠁⠈⠉⢒⡒⠁\r\n"
									+ "⠀⠀⠀⠀⠀⣼⡛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠓⠒⠦⠤⠤⠤⠶⠎⠁⠀⠀\r\n"
									+ "⠉⠀⡠⠀⣰⣿⣇⠀⠀⠀⡀⠀⠀⠀⢀⠀⠀⣸⣇⢠⠀⠄⠀⠀⠀⠀⣿⠀⠀⠀\r\n"
									+ "⡔⠉⢠⠊⠈⢻⣿⠄⠀⠀⠻⣦⠀⣴⠃⠀⠀⣿⣿⠆⠀⠒⢦⠀⠀⣴⣿⡀⠀⠀\r\n"
									+ "⢄⠀⣾⡁⠀⠀⣿⡆⠀⠀⠀⢿⡀⠿⠀⠀⢀⣿⣿⣶⡋⠉⠉⢧⣿⠋⢸⣷⠀⠀\r\n"
									+ "⣨⣷⣿⣷⣤⣾⠿⢿⡆⠀⠀⠸⣧⡄⠀⠀⢺⠿⠿⡋⠃⠀⠀⠈⣇⠀⠸⡟⠠⣄\r\n"
									+ "⣿⣿⣿⣿⣿⡀⠀⢰⡇⠀⠀⠀⣿⠀⠀⠀⠀⣧⠀⣸⣀⣇⠀⠀⢈⡀⠀⣘⣀⣼\r\n"
									+ "⠈⠉⠙⠉⠉⠛⠋⠉⠗⠖⠒⠛⠛⠛⠒⠶⠒⠛⠟⠋⠋⠙⠛⠉⠉⠉⠉⠉⠉⠀");
							System.out.println("========== 홈 ==========");
							System.out.println(
									"[0]로그인 이동 [1]상태보기 [2]가방확인 [3]도박하기 [4]알바하기 [5]밥주기 [6]동물병원가기 [7]놀아주기 [8]잠재우기(저장)");
							int choice = sc.nextInt();

							if (choice == 1) {
								mp3.play(musiclist.get(14).getPath());
								statusCheck(name, hp, fullness, love);

							} else if (choice == 2) {
								mp3.play(musiclist.get(2).getPath());
								bagCheck(money, snack, feed, spec, supply1, supply2);

							} else if (choice == 3) {
								ConsoleClear();
								System.out.println("========== 도박장 ==========");
								if(money > 0) {
									mp3.play(musiclist.get(9).getPath());
									System.out.println(name + "...");
									System.out.println(" (담배 한모금빨며) 쓰읍 후...");
									
									try {
										Thread.sleep(2500);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
	
									System.out.println("조금만 기다려...");
	
									try {
										Thread.sleep(2500);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									
									mp3.play(musiclist.get(10).getPath());
									int randMoney = (rand.nextInt(60) + 1) * 500;
									int rMoney = rand.nextInt(2);
									hp -= 10;
									fullness -= 10;
									love -= 10;
									
									if(rMoney % 2 == 0) {
										money = money + randMoney;
										printInfo(name, hp, fullness, love, money);
										System.out.println("돈" + randMoney + "원을 벌었습니다.");
									} else {
										money = money - randMoney;
										printInfo(name, hp, fullness, love, money);
										System.out.println("돈" + randMoney + "원을 잃었습니다.");
									}
								} else {
									System.out.println("도박 할 수 없습니다.");
								}

							} else if(choice == 4) {
								ConsoleClear();
								System.out.println("========== 아르바이트 ==========");
								mp3.play(musiclist.get(9).getPath());
								System.out.println(name + ".. 금방 갈게");

								try {
									Thread.sleep(5000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								System.out.println("알바중...");

								try {
									Thread.sleep(5000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								
								mp3.play(musiclist.get(10).getPath());
								
								hp -= 5;
								fullness -= 5;
								love -= 5;
								money = money + 2000;
								
								printInfo(name, hp, fullness, love, money);
								System.out.println("돈 2000원을 벌었습니다.");
								
							} else if (choice == 5) {
								ConsoleClear();
								while ((hp > 0 && fullness > 0 && love > 0)
										&& (hp < 75 || fullness < 75 || love < 85 || (hp + fullness + love) / 3 < 85)) {
									System.out.println("========== 밥주기 ==========");
									System.out.println("[0]이전으로 [1]간식(포만+5 애정+10) [2]사료(건강+10 포만+15 애정+5) [3]상태보기 [4]가방확인");
									int babChoice = sc.nextInt();
									if (babChoice == 1) {
										ConsoleClear();
										System.out.println("========== 간식주기 ==========");
										System.out.print("간식 몇개를 주시겠습니까? : ");
										int snackNum = sc.nextInt();
										if (snackNum <= snack) {
											mp3.play(musiclist.get(5).getPath());
											try {
												Thread.sleep(4500);
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
											snack = snack - snackNum;
											hp -= 5 * snackNum;
											fullness += 5 * snackNum;
											love += 10 * snackNum;
											System.out.println("간식을 주었습니다.");
											printInfo(name, hp, fullness, love, money);
										} else {
											System.out.println("간식이 부족합니다.");
										}
									} else if (babChoice == 2) {
										ConsoleClear();
										System.out.println("========== 사료주기 ==========");
										System.out.print("사료 몇개를 주시겠습니까? : ");
										int feedNum = sc.nextInt();
										if (feedNum <= feed) {
											mp3.play(musiclist.get(5).getPath());
											try {
												Thread.sleep(4500);
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
											feed = feed - feedNum;
											hp += 10 * feedNum;
											fullness += 15 * feedNum;
											love += 5 * feedNum;
											System.out.println("사료을 주었습니다.");
											// 사료먹는 소리
											printInfo(name, hp, fullness, love, money);
										} else {
											System.out.println("간식이 부족합니다.");
										}
									} else if(babChoice == 3) {
										mp3.play(musiclist.get(14).getPath());
										statusCheck(name, hp, fullness, love);
									} else if(babChoice == 4) {
										mp3.play(musiclist.get(2).getPath());
										bagCheck(money, snack, feed, spec, supply1, supply2);
									} else if (babChoice == 0) {
										ConsoleClear();
										System.out.println("이전으로 돌아갑니다.");
										break;
									} else {
										ConsoleClear();
										System.out.println("번호를 다시 입력해주세요.");
									}
								}
							} else if (choice == 6) {
								mp3.play(musiclist.get(3).getPath());
								ConsoleClear();
								System.out.println("========== 동물 병원 입장 ==========");

								while ((hp > 0 && fullness > 0 && love > 0)
										&& (hp < 75 || fullness < 75 || love < 85 || (hp + fullness + love) / 3 < 85)) {
									System.out.print(
											"[0]집 이동 [1]간식사기(3000원) [2]사료사기(4000원) [3]진료받기(5000원 건강+20) [4]애견용품 [5]상태보기 [6]가방확인");
									int hosChoice = sc.nextInt();

									if (hosChoice == 1) {
										ConsoleClear();
										System.out.println("========== 간식사기 ==========");
										System.out.println("얼마나 살텐가? ");
										howmany = sc.nextInt();
										if (money > howmany * 3000) {
											mp3.play(musiclist.get(10).getPath());
											System.out.println("간식을" + howmany + "개 구매했습니다.");
											snack += howmany;
											money -= howmany * 3000;// 여기 0에는 감소되는 금액 작성
										} else {
											System.out.println("흠... 그걸론 안되겠는데...");
										}
									} else if (hosChoice == 2) {
										ConsoleClear();
										System.out.println("========== 사료사기 ==========");
										System.out.println("얼마나 살텐가? ");
										howmany = sc.nextInt();
										if (money > howmany * 4000) {
											mp3.play(musiclist.get(10).getPath());
											System.out.println("간식을" + howmany + "개 구매했습니다.");
											feed += howmany;
											money -= howmany * 4000;// 여기 0에는 감소되는 금액 작성
										} else {
											System.out.println("흠... 그걸론 안되겠는데...");
										}
									} else if (hosChoice == 3) {
										ConsoleClear();
										System.out.println("========== 진료받기 ==========");
										if (money < 4000) {
											System.out.println("돈이 부족합니다.");
										} else {
											mp3.play(musiclist.get(4).getPath());

											try {
												Thread.sleep(4250);
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
											money -= 5000;
											hp += 20;
											fullness -= 10;
											love -= 20;
											printInfo(name, hp, fullness, love, money);
										}
									} else if (hosChoice == 4) {
										ConsoleClear();
										if (spec.equals("강아지")) {
											while ((hp > 0 && fullness > 0 && love > 0)
													&& (hp < 75 || fullness < 75 || love < 85 || (hp + fullness + love) / 3 < 85)) {
												System.out.println(
														"[0]나가기 [1]옷사기(10000원 애정+5) [2]목줄사기(25000원 애정+5) [3]인형(20000원 애정+5) [4]상태보기 [5]가방확인");
												int hosDogChoice = sc.nextInt();
												if (hosDogChoice == 1) {
													ConsoleClear();
													if (money < 10000) {
														System.out.println("돈이 부족합니다.");
													} else {
														System.out.println("옷을 획득합니다.");
														mp3.play(musiclist.get(10).getPath());
														money -= 10000;
														love += 5;
														printInfo(name, hp, fullness, love, money);
													}
												} else if (hosDogChoice == 2) {
													ConsoleClear();
													if (supply1 == false) {
														if (money < 25000) {
															System.out.println("돈이 부족합니다.");
														} else {
															supply1 = true;
															System.out.println("목줄을 획득합니다.");
															mp3.play(musiclist.get(10).getPath());
															money -= 25000;
															hp -= 5;
															fullness -= 10;
															love += 5;
															printInfo(name, hp, fullness, love, money);
														}
													} else {
														System.out.println("목줄이 이미 있습니다.");
													}
												} else if (hosDogChoice == 3) {
													ConsoleClear();
													if (supply2 == false) {
														if (money < 20000) {
															System.out.println("돈이 부족합니다.");
														} else {
															supply2 = true;
															System.out.println("인형을 획득합니다.");
															mp3.play(musiclist.get(10).getPath());
															money -= 20000;
															hp -= 5;
															fullness -= 10;
															love += 5;
															printInfo(name, hp, fullness, love, money);
														}
													} else {
														System.out.println("인형이 이미 있습니다.");
													}
												} else if(hosDogChoice == 4) {
													mp3.play(musiclist.get(14).getPath());
													statusCheck(name, hp, fullness, love);
												} else if(hosDogChoice == 5) {
													mp3.play(musiclist.get(2).getPath());
													bagCheck(money, snack, feed, spec, supply1, supply2);
												} else if (hosDogChoice == 0) {
													ConsoleClear();
													break;
												}
											}
										}
										if (spec.equals("고양이")) {
											while ((hp > 0 && fullness > 0 && love > 0)
													&& (hp < 75 || fullness < 75 || love < 85 || (hp + fullness + love) / 3 < 85)) {
												System.out.println(
														"[0]나가기 [1]옷사기(10000원 애정+5) [2]캣휠(25000원 애정+5) [3]레이저(20000원 애정+5) [4]상태보기 [5]가방확인");
												int hosCatChoice = sc.nextInt();
												if (hosCatChoice == 1) {
													ConsoleClear();
													if (money < 10000) {
														System.out.println("돈이 부족합니다.");
													} else {
														System.out.println("옷을 획득합니다.");
														mp3.play(musiclist.get(10).getPath());
														money -= 10000;
														love += 5;
														printInfo(name, hp, fullness, love, money);
													}
												} else if (hosCatChoice == 2) {
													ConsoleClear();
													if (supply1 == false) {
														if (money < 25000) {
															System.out.println("돈이 부족합니다.");
														} else {
															supply1 = true;
															System.out.println("캣휠을 획득합니다.");
															mp3.play(musiclist.get(10).getPath());
															money -= 25000;
															hp -= 5;
															fullness -= 10;
															love += 5;
															printInfo(name, hp, fullness, love, money);
														}
													} else {
														System.out.println("캣휠이 이미 있습니다.");
													}
												} else if (hosCatChoice == 3) {
													ConsoleClear();
													if (supply2 == false) {
														if (money < 20000) {
															System.out.println("돈이 부족합니다.");
														} else {
															supply2 = true;
															money -= 20000;
															hp -= 5;
															fullness -= 10;
															love += 5;
															System.out.println("레이저을 획득합니다.");
															mp3.play(musiclist.get(10).getPath());
															printInfo(name, hp, fullness, love, money);
														}
													} else {
														System.out.println("레이저가 이미 있습니다.");
													}
												} else if(hosCatChoice == 4) {
													mp3.play(musiclist.get(14).getPath());
													statusCheck(name, hp, fullness, love);
												} else if(hosCatChoice == 5) {
													mp3.play(musiclist.get(2).getPath());
													bagCheck(money, snack, feed, spec, supply1, supply2);
												} else if (hosCatChoice == 0) {
													ConsoleClear();
													break;
												}
											}
										}
									} else if (hosChoice == 0) {
										ConsoleClear();
										break;
									} else {
										System.out.println("번호를 다시 입력해주세요.");
									}
								}

							} else if (choice == 7) {
								ConsoleClear();
								System.out.println("========== 놀아주기 ==========");
								while ((hp > 0 && fullness > 0 && love > 0)
										&& (hp < 75 || fullness < 75 || love < 85 || (hp + fullness + love) / 3 < 85)) {
									if (spec.equals("강아지")) {
										System.out.println("[0]나가기 [1]산책(애정+15) [2]터그놀이(애정+10) [3]상태보기 [4]가방확인");
										int playDogChoice = sc.nextInt();

										if (playDogChoice == 1) {
											if (supply1 == true) {
												ConsoleClear();
												System.out.println("========== 산책하기 ==========");
												mp3.play(musiclist.get(7).getPath());
												try {
													Thread.sleep(4500);
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
												hp -= 5;
												fullness -= 15;
												love += 15;
												printInfo(name, hp, fullness, love, money);
											} else {
												System.out.println("목줄을 구매해주세요.");
											}
										} else if (playDogChoice == 2) {
											ConsoleClear();
											if (supply2 == true) {
												System.out.println("========== 터그놀이 ==========");
												mp3.play(musiclist.get(11).getPath());
												try {
													Thread.sleep(4500);
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
												hp -= 5;
												fullness -= 10;
												love += 10;
												printInfo(name, hp, fullness, love, money);
											} else {
												System.out.println("인형을 구매해주세요.");
											}
										} else if (playDogChoice == 0) {
											ConsoleClear();
											System.out.println("이전으로 돌아갑니다.");
											break;
										}

									} else if (spec.equals("고양이")) {

										System.out.println("[0]나가기 [1]캣휠(애정+15) [2]사냥놀이(애정+10)");
										int playCatChoice = sc.nextInt();

										if (playCatChoice == 1) {
											ConsoleClear();
											System.out.println("========== 캣휠 ==========");
											if (supply1 == true) {
												mp3.play(musiclist.get(8).getPath());
												try {
													Thread.sleep(4000);
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
												hp -= 5;
												fullness -= 15;
												love += 15;
												printInfo(name, hp, fullness, love, money);
											} else {
												ConsoleClear();
												System.out.println("캣휠이 없어서 캣휠을 태울 수 없습니다ㅠㅠ");
											}
										} else if (playCatChoice == 2) {
											ConsoleClear();
											System.out.println("========== 사냥놀이 ==========");
											mp3.play(musiclist.get(13).getPath());
											try {
												Thread.sleep(1000);
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
											if (supply2 == true) {
												System.out.println("사냥놀이 해줍니다.");
												hp -= 5;
												fullness -= 10;
												love += 10;
												printInfo(name, hp, fullness, love, money);
											} else {
												ConsoleClear();
												System.out.println("레이저가 없어서 사냥놀이를 할 수 없습니다 ㅠㅠ");
											}

										} else if(playCatChoice == 4) {
											mp3.play(musiclist.get(14).getPath());
											statusCheck(name, hp, fullness, love);
										} else if(playCatChoice == 5) {
											mp3.play(musiclist.get(2).getPath());
											bagCheck(money, snack, feed, spec, supply1, supply2);
										} else if (playCatChoice == 0) {
											ConsoleClear();
											System.out.println("이전으로 돌아갑니다.");
											break;
										}

									}
								}

							} else if (choice == 8) {
								ConsoleClear();
								System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⠀⠀⠀⠀⠐⡶⠂⣤⣤⣄⡀⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠀⠀⠀⣀⡤⠖⠋⠉⠉⠉⠉⠙⠓⠦⣄⡚⠓⠂⠀⣨⡿⠃⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠀⣠⠞⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠿⣦⠄⢾⣿⣤⡄⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⡼⠃⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⢷⡀⠀⠀⠀⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⢸⠃⠀⠻⢶⣤⣤⡶⠀⠀⠀⠀⣄⠀⠀⠀⠀⠀⠈⣷⠲⠤⣀⠀⣀⠀\r\n"
										+ "⠀⠀⠀⠀⣸⠀⠀⠀⠀⠀⠀⢰⡄⠀⢀⡀⠻⢶⣤⣤⡶⠀⠀⣿⠀⠀⠈⠋⢉⡇\r\n"
										+ "⠀⠀⢠⠞⢻⡆⠀⠀⠀⠀⠀⠈⠙⠛⠛⠁⠀⠀⠀⠀⠀⠀⢀⡿⠀⠀⠀⢀⢹⠀\r\n"
										+ "⠀⢰⠃⠀⠘⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣾⣅⠀⠀⢀⡞⣸⠀\r\n"
										+ "⢠⠿⠀⠀⠀⠈⢷⣄⠀⠀⠀⠀⠀⠀⠀⠀⣠⡴⠚⠉⠁⠀⠀⠀⠀⣠⠎⣰⠃⠀\r\n"
										+ "⠘⠶⠚⠦⣀⡈⠛⠛⠳⢦⣤⣀⣀⠀⠴⠋⠁⠀⠀⠀⠀⠀⢀⡤⠞⢁⠞⠁⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠉⠛⠒⠲⠶⠤⠤⣀⣀⠀⠀⠀⠀⠀⣴⠀⣮⡉⠤⠚⠁⠀⠀⠀⠀\r\n"
										+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠓⠁⠀⠀⠀⠀⠀⠀⠀⠀");
								System.out.println("========== 잠재우기 ==========");

								rank++;
								hp += 15;
								
								printInfo(name, hp, fullness, love, money);

								PetDTO lastPetDto = new PetDTO(name, spec, hp, fullness, love, money, snack, feed,
										supply1, supply2);
								
								int row = petDao.update(lastPetDto);

								System.out.println("토닥토닥... 닥토닥토...");

								try {
									Thread.sleep(4000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								if (row > 0) {
									System.out.println("펫 정보를 저장합니다.");
								} else {
									System.out.println("오류");
								}

							} else if (choice == 0) {
								if (mp3.isPlaying()) {
									mp3.stop();
								}
								System.out.println("로그인화면으로 돌아갑니다.");
								break;
							} else {
								System.out.println("번호를 다시 입력해주세요.");
							}

						}

						if (hp <= 0 || fullness <= 0 || love <= 0) {
							ConsoleClear();
							System.out.println("게임 오버");
							mp3.play(musiclist.get(18).getPath());
							// 게임 오버 시 해당 id의 동물 정보를 'delete'하기
							PetDTO lastPetDto = new PetDTO(name, spec, hp, fullness, love, money, snack, feed, supply1,
									supply2);
							int row = petDao.delete(lastPetDto);
							if (row > 0) {
								System.out.println(name + "을(를) 삭제했습니다.");
								System.out.println("로그인 후 펫을 다시 생성해주세요.");
							} else {
								System.out.println("데이터 삭제 오류");
							}
						} else if (hp >= 75 && fullness >= 75 && love >= 85 && (hp + fullness + love) / 3 >= 85) {
							ConsoleClear();
							if (spec.equals("강아지")) {
								mp3.play(musiclist.get(16).getPath());
								
								System.out.println("⣿⣿⣿⣿⣿⡙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢹⣿⣿⣿⣿⣿\r\n"
										+ "⣿⣿⣿⣿⣿⡻⣦⡙⠿⡿⣿⣿⣿⣿⡿⣽⣿⣿⢿⣿⣿⣿⣿⡟⣾⣿⣿⣿⣿⣿\r\n"
										+ "⣿⣿⣿⣿⣿⣿⣾⣟⡂⠈⠻⣿⢿⡏⣞⡉⣌⡍⠻⢿⡿⠻⠟⢹⣿⣿⣿⣿⣿⣿\r\n"
										+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⠀⢡⢍⣷⣾⠛⠻⣆⠈⠁⠐⢠⣿⣿⣿⣿⣿⣿⣿\r\n"
										+ "⣿⣿⣿⣿⣿⣻⣿⣿⣿⣿⣿⣷⣄⢂⣿⣃⣶⣦⠏⠀⢂⣾⣿⡿⠿⣻⣿⣿⣿⣿\r\n"
										+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠻⠿⢿⣿⣿⣿⣿⣿⣵⣿⣟⣿⣶⣧⣿⣿⣿⣿⣿\r\n"
										+ "⡿⢿⣿⣿⣿⣿⣿⣿⡏⣶⣦⣴⣴⡏⠀⠹⣿⡏⠉⢩⣈⣉⠛⣿⣿⣿⣿⣿⣿⣿\r\n"
										+ "⡀⠀⠙⠿⢿⣿⣿⢡⣤⠙⢛⢿⣿⣿⣶⣶⣷⢷⣶⣶⣽⡿⣷⠼⢿⣿⣿⣿⣿⣿\r\n"
										+ "⣿⣷⣦⠀⠀⠉⠉⣹⣇⠰⠿⣿⣿⣿⣿⣟⣾⣷⣿⣿⡿⣧⣤⡀⠂⢩⣿⣿⡿⣿\r\n"
										+ "⣿⣿⣿⣇⠀⠀⠀⢿⣿⠗⠆⠀⠉⣿⢿⣿⣿⣿⣿⠀⠀⠈⢻⠁⡆⠸⠿⠟⢀⣿\r\n"
										+ "⣿⣿⣿⣿⣶⣄⠀⠈⠻⢿⣦⡀⢀⣿⣿⣿⣷⣾⣿⣷⠀⢀⣤⡬⠂⠀⠀⠀⣸⣿\r\n"
										+ "⣿⣿⣿⣿⣿⠿⠷⠀⠀⠈⠙⢿⣷⣤⢽⣿⡿⢿⣿⣷⣴⣿⡿⠃⠀⠀⠀⣸⠉⣿\r\n"
										+ "⠅⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⡋⠁⠀⠀⠀⠀⠈⠏⣀⣿\r\n"
										+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠁⣿\r\n"
										+ "⣀⣾⣿⣆⣀⠀⠀⠀⠀⠀⢀⣻⣿⣿⣛⣻⣿⣿⣿⣻⣟⠀⠀⠀⠀⢀⣀⣀⣀⣿");
								System.out.println("훌륭한 강아지로 자랐습니다");
								// 훌륭한 강아지 정보 데이터 베이스에 'update'하기
								UserDTO lastUserDto = new UserDTO(id, pw, rank, true);
								int row = userDao.userUpdate(lastUserDto);
								if (row > 0) {
									System.out.println("랭킹에 등록되었습니다.");
								}
								printInfo(name, hp, fullness, love, money);
								PetDTO lastPetDto = new PetDTO(name, spec, hp, fullness, love, money, snack, feed,
										supply1, supply2);
								petDao.update(lastPetDto);
								try {
									Thread.sleep(30000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							} else {
								mp3.play(musiclist.get(17).getPath());
								System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
										+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⠙⠻⠅⠸⠟⠋⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
										+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢳⠷⠀⠀⠾⡞⢺⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
										+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢫⡡⠖⠢⢌⡉⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
										+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠓⠁⣸⣧⣬⣧⣼⣯⠙⠚⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
										+ "⣿⣿⣿⣿⣿⠟⠉⠉⠉⠀⠦⠶⠿⠜⣿⣿⠫⠿⠶⠴⠀⠉⠉⠉⠻⣿⣿⣿⣿⣿\r\n"
										+ "⣿⣿⣿⣿⠃⣀⠀⠀⢀⡄⠀⠀⠀⠀⢹⡏⠀⠀⠀⠀⢠⣀⠀⠀⣠⠘⣿⣿⣿⣿\r\n"
										+ "⣿⣿⡿⠋⠘⢿⡿⠿⢿⣷⣄⡀⢀⣀⣼⣧⡀⡀⢀⣀⣾⡿⠿⢿⡿⠉⠙⢿⣿⣿\r\n"
										+ "⣿⣿⣥⠖⢀⠈⠀⠀⣸⣿⣿⣿⡿⠟⢛⡛⠻⢿⣿⣿⣿⣇⠀⠀⠁⡀⠸⣬⣿⣿\r\n"
										+ "⣿⣯⣸⠃⠈⠑⢿⡾⡟⢿⡿⣿⣷⠟⢺⡗⠻⣾⣿⣿⡿⢻⢷⡿⠚⠁⠐⣇⣽⣿\r\n"
										+ "⣿⣥⡿⣷⣄⠀⠀⣴⣿⣾⣌⢿⣿⣏⣹⣏⣻⣿⡿⣉⣷⣿⣦⠀⠀⣠⣾⠿⣬⣿\r\n"
										+ "⣿⣿⣷⡚⢿⣿⣦⣕⠈⠿⠿⠀⣿⣷⣾⣷⣾⣿⠀⠿⠿⠁⣪⣼⣾⡿⢓⣾⣿⣿\r\n"
										+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣤⡀⠀⣠⣽⣿⣿⣏⣤⠀⢠⣤⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
										+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣼⣿⣿⣿⣿⣿⣶⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
										+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
								System.out.println("훌륭한 고양이로 자랐습니다.");
								// 훌륭한 고양이 정보 데이터 베이스에 'update'하기
								UserDTO lastUserDto = new UserDTO(id, pw, rank, true);
								int row = userDao.userUpdate(lastUserDto);
								if (row > 0) {
									System.out.println("랭킹에 등록되었습니다.");
								}
								printInfo(name, hp, fullness, love, money);
								PetDTO lastPetDto = new PetDTO(name, spec, hp, fullness, love, money, snack, feed,
										supply1, supply2);
								petDao.update(lastPetDto);
								try {
									Thread.sleep(30000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						} else {
							System.out.println("메인메뉴로 돌아갑니다.");
						}

					}

				} else {
					ConsoleClear();
					System.out.println("로그인에 실패했습니다.");
					System.out.println("아이디와 비밀번호를 확인해주세요.");
				}
			} else if (input == 0) {// 게임종료
				if (mp3.isPlaying()) {
					mp3.stop();
				} // 게임종료
				ConsoleClear();
				System.out.println("게임을 종료합니다.");
				break;
			} else if (input == 3) {
				UserDAO userDao = new UserDAO();
				ArrayList<PetDTO> list = userDao.getRank();
				for(int i = 0; i < list.size(); i++) {
					System.out.println((i+1) + "위. " + "이름 : " + list.get(i).getName() + "\t" + "종류 : " + list.get(i).getSpec() + "\t" + "hp : " + list.get(i).getHp() + "\t" + "포만감 : " +list.get(i).getFullness() + "\t" + "애정 : " + list.get(i).getLove());
				}
				System.out.println("=================================");
				while (true) {
					System.out.println("[0]메뉴로 돌아가기");
					int rankInput = sc.nextInt();
					
					if(rankInput == 0) {
						break;
					}
				}

			} else {
				ConsoleClear();
				System.out.println("다시 입력해주세요.");
			}
		}

	}

	public static void printInfo(String name, int hp, int fullness, int love, int money) {

		if ((hp > 0 && hp <= 20) || (fullness > 0 && fullness <= 20) || (love > 0 && love <= 20)) {
			System.out.println(name + " 이(가) 위험합니다!!!!");
			System.out.println("상태창을 확인하세요!!!!");
		}

		if (hp > 100) {
			hp = 100;
		} else if (hp < 0) {
			hp = 0;
		}
		if (fullness > 100) {
			fullness = 100;
		} else if (fullness < 0) {
			fullness = 0;
		}
		if (love > 100) {
			love = 100;
		} else if (love < 0) {
			love = 0;
		}
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

//		System.out.println("현재 " + name + "의 체력 :" + hp + "\t" + "포만감 :" + fullness + "\t" + "애정 :" + love);
//		System.out.println("님의 잔액은" + money + "입니다.");
	}

	public static void ConsoleClear() {
		// 화면을 지우기 위해 여러 줄을 출력
		for (int i = 0; i < 50; ++i)
			System.out.println();

	}
	
	public static void statusCheck(String name, int hp, int fullness, int love) {
		ConsoleClear();
		System.out.println("========== " + name + "의 상태 ==========");
		System.out.println("건강 : " + hp);
		System.out.println("포만감 : " + fullness);
		System.out.println("애정 : " + love);
	}
	
	public static void bagCheck(int money, int snack, int feed, String spec, boolean supply1, boolean supply2) {
		ConsoleClear();
		System.out.println("========== 가방 ==========");
		System.out.println("돈 : " + money + "원");
		System.out.println("간식 : " + snack + "개");
		System.out.println("사료 : " + feed + "개");
		if (spec.equals("강아지")) {
			if (supply1 == true) {
				System.out.println("목줄 有");
			} else {
				System.out.println("목줄 無");
			}
			if (supply2 == true) {
				System.out.println("삑삑이 有");
			} else {
				System.out.println("삑삑이 無");
			}
		}
	}

}
