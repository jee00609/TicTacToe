import java.util.Random;
import java.util.Scanner;

public class TTT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//게임판 출력(총 9번) -->칸이 9개이기 때문
		//사용자(선공 5번)
		//컴퓨터(후공 4번) --> 랜덤함수
		//승리조건  --> 먼저 O나 X를 3개가 직선으로 이어지게 만들면 승리
		//무승부조건 --> 9칸이 다채워지면 무승부

	
		
		char [][] board = new char [3][3]; //게임판
		
		
		for(int i=0; i<3; i++) // 사용자와 컴퓨터가 선택할 공간들을 초기화한다.
		{
			for(int j=0; j<3; j++)
			{
				board[i][j] = ' ';
			}
		}
		
		
		int x1=0,y1=0; // 사용자의 선택을 의미하는 변수
		int i=0,j=0;//반복문에 쓸 변수, i는 행 y는열
		
		int rotate=0;//사용자 컴퓨터 선택횟수를 의미한다.
		//따라서 rotate가 9가 되는 순간 보드의 칸이 다 채워지는 것을 의미하며 무승부를 의미한다.
		
		int escape=0;//do while() 을 탈출하기 위해 만든 변수
		
		Scanner scan = new Scanner (System.in);
		Random generator = new Random(); //랜덤 객체 생성
		
		
		
		System.out.println("사용자가 선공입니다.\n");
		
		do
		{
			////////////////////////////////////////////////////게임판 출력
			for(i=0;i<3;i++)
			{
				System.out.println(" " + board[i][0] + " | "+board[i][1]+" | "+board[i][2]);
				
				if(i != 2)
				{
					System.out.println("---|---|---");
				}
				
			}
			
			
			
			/*
			 * 숭리 조건문과 무승부 조건문들을 사용자와 컴퓨터의 턴을 감싸도록 만들었다
			 * 이를 통해 선공과 후공에 있어서 조건을 확인가능하여 
			 * 이기고 난 후에도 컴퓨터의 턴이 오는 것을 방지했다.
			 * 
			 * */
			
			/////////////////////////////////////////////////////승리 조건 1 )) [X][] 에 따른 승리
			
			
			for(i=0;i<3;i++)
			{
				if(board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X')
				{
					System.out.println("사용자가 승리했습니다.\n");
					escape=1;
					break;

				}

				if(board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O')
				{
					System.out.println("컴퓨터가 승리했습니다.\n");
					escape=1;
					break;

				}

			}


			////////////////////////////////////////////////////////승리 조건 2 )) [][Y] 에  따른 승리

			for(j=0;j<3;j++)
			{
				if(board[0][j] == 'X' && board[1][j] == 'X' && board[2][j] == 'X')
				{
					System.out.println("사용자가 승리했습니다.\n");
					escape=1;
					break;
					
				}

				if(board[0][j] == 'O' && board[1][j] == 'O' && board[2][j] == 'O')
				{
					System.out.println("컴퓨터가 승리했습니다.\n");
					escape=1;
					break;

				}


			}

			/////////////////////////////////////////////////////////승리 조건3 )) 대각선에 따른 승리

			if(board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X')
			{
				System.out.println("사용자가 승리했습니다.\n");
				escape=1;
				break;
			}

			if(board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O')
			{
				System.out.println("컴퓨터가 승리했습니다.\n");
				escape=1;
				break;
			}

			if(board[2][0]=='X' && board[1][1]=='X' && board[0][2]=='X')
			{
				System.out.println("사용자가 승리했습니다.\n");
				escape=1;
				break;
				
			}

			if(board[2][0]=='O' && board[1][1]=='O' && board[0][2]=='O')
			{
				System.out.println("컴퓨터가 승리했습니다.\n");
				escape=1;
				break;
			}

			////////////////////////////////////////////////////////// 무승부

			if(rotate==9)
			{
				System.out.println("무승부 입니다.\n");
				escape=1;
				break;
			}
			
			
			
			
			/////////////////////////////////////////////////////사용자의 턴
			
			System.out.print("다음 수의 좌표를 입력하시오: ");
			x1=scan.nextInt();
			y1=scan.nextInt();
			
			if(board[x1][y1] != ' ')
			{
				System.out.println("잘못된 위치입니다.");
				continue;
			}
			else
			{
				board[x1][y1]='X';
				rotate++;
			}
			
			
			////////////////////////////////////////////////////컴퓨터의 턴
			
			outer :
			for (i = 0; i < 3; i++)
			{
				for (j = 0; j < 3; j++) 
				{
					if (board[i][j] == ' ') 
						{
							break outer;
						}
				}
				
			}			
			
			if (i < 3 && j < 3)
			{
				board[i][j] = 'O';
				rotate++;
			}

			/////////////////////////////////////////////////////승리 조건 1 )) [X][] 에 따른 승리
			
			
			for(i=0;i<3;i++)
			{
				if(board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X')
				{
					System.out.println("사용자가 승리했습니다.\n");
					escape=1;
					break;

				}

				if(board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O')
				{
					System.out.println("컴퓨터가 승리했습니다.\n");
					escape=1;
					break;

				}

			}


			////////////////////////////////////////////////////////승리 조건 2 )) [][Y] 에  따른 승리

			for(j=0;j<3;j++)
			{
				if(board[0][j] == 'X' && board[1][j] == 'X' && board[2][j] == 'X')
				{
					System.out.println("사용자가 승리했습니다.\n");
					escape=1;
					break;
					
				}

				if(board[0][j] == 'O' && board[1][j] == 'O' && board[2][j] == 'O')
				{
					System.out.println("컴퓨터가 승리했습니다.\n");
					escape=1;
					break;

				}


			}

			/////////////////////////////////////////////////////////승리 조건3 )) 대각선에 따른 승리

			if(board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X')
			{
				System.out.println("사용자가 승리했습니다.\n");
				escape=1;
				break;
			}

			if(board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O')
			{
				System.out.println("컴퓨터가 승리했습니다.\n");
				escape=1;
				break;
			}

			if(board[2][0]=='X' && board[1][1]=='X' && board[0][2]=='X')
			{
				System.out.println("사용자가 승리했습니다.\n");
				escape=1;
				break;
				
			}

			if(board[2][0]=='O' && board[1][1]=='O' && board[0][2]=='O')
			{
				System.out.println("컴퓨터가 승리했습니다.\n");
				escape=1;
				break;
			}

			////////////////////////////////////////////////////////// 무승부

			if(rotate==9)
			{
				System.out.println("무승부 입니다.\n");
				escape=1;
				break;
			}			
			
						
			

		}while(escape==0);
		

	}
	


}