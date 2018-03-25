import java.util.*;

//컴퓨터 vs 사용자
public class Tic_Tac_Toa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//게임판을 나타내는 2차원 배열을 생성한다.
		char[][] board = new char[3][3];
		//사용자와 컴퓨터의 좌표
		int x, y, cx, cy;
		//바둑판이 꽉 찼을 때와 다른 판정이 겹칠때, 판정이 두 번 나지 않도록 한다.
		int full = 0;
		//while문을 돌리기 위한 조건.
		boolean stop = true;
		
		Random generator = new Random();
		Scanner Scan = new Scanner(System.in);
		
		//게임판을 나타내는 2차원 배열을 초기화한다.
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				board[i][j] = ' ';
		
		//게임판을 그린다.
		//게임판 위에 좌표를 보기 쉽게 나타낸다
		System.out.println("  0 "+"  1 "+"  2 ");			
		for(int i=0; i<3; i++)
		{
			//게임판 좌측에 좌표를 보기 쉽게 나타낸다
			System.out.printf("%d", i);
				
			//게임판
			System.out.println(" "+board[i][0]+" "+"| "+board[i][1]+" "+"| "+board[i][2]+" ");
			if(i != 2) System.out.println(" ---|---|---");
		}
		
		//게임을 실행한다.
		do {
			//사용자에게서 좌표를 받는다.
			System.out.print("다음 수의 좌표를 입력하시오: ");
			x = Scan.nextInt();
			y = Scan.nextInt();
			
			//사용자가 놓은 위치를 검사한다.
			//받은 좌표가 공백이 아니면 좌표를 다시 받는다.
			if(board[x][y] != ' ')
			{
				System.out.println("잘못된 위치입니다.");
				continue;
			}
			else board[x][y] = 'X';
			
			//컴퓨터가 놓을 위치를 난수로 결정한다.
			//받은 좌표가 공백이 아니면 다시 받는다.			
			do
			{
				cx = generator.nextInt(3);
				cy = generator.nextInt(3);
				
				//바둑판이 꽉 찼는 지를 검사.
				int count = 0;
				for(int i=0; i<3; i++)
					for(int j=0; j<3; j++)
						if(board[i][j] != ' ') count++;
				//바둑판이 꽉 찼으면, 반복문을 벗어난다.
				if(count == 9) break;
			}while(board[cx][cy] != ' ');
			
			//컴퓨터의 좌표를 표시한다.
			board[cx][cy] = 'O';
				
			//게임판을 한 번 더 출력한다.
			System.out.println("  0 "+"  1 "+"  2 ");			
			for(int i=0; i<3; i++)
			{
				//게임판 좌측에 좌표를 보기 쉽게 나타낸다
				System.out.printf("%d", i);
				
				//게임판
				System.out.println(" "+board[i][0]+" "+"| "+board[i][1]+" "+"| "+board[i][2]+" ");
				if(i != 2) System.out.println(" ---|---|---");
			}
			
			//승리 판정
			//판정이 겹치지 않게 한다.
			//판정을 낸 후, 게임을 끝낸다(stop = false)
			
			// 'ㅡ'일때.
			//다른 판정과 겹치지 않을 때, 판정을 출력한다(full = 0)
			for(int i=0; i<3; i++)
			{
				if(full == 0 && board[i][0] == 'X') 
				{
					if(board[i][0] == board[i][1] && board[i][0] == board[i][2])
					{
						System.out.println("승리하셨습니다!");
						full = 1;
						stop = false;
					}
				}
				if(full == 0 && board[i][0] == 'O')
				{
					if(board[i][0] == board[i][1] && board[i][0] == board[i][2])
					{
						System.out.println("패배하셨습니다!");
						full = 1;
						stop = false;
					}
				}
			}
				
			// '|'일때.
			//다른 판정과 겹치지 않을 때, 판정을 출력한다(full = 0)
			for(int i=0; i<3; i++)
			{
				if(full == 0 && board[0][i] == 'X') 
				{
					if(board[0][i] == board[1][i] && board[0][i] == board[2][i])
					{
						System.out.println("승리하셨습니다!");
						full = 1;
						stop = false;
					}
				}
				if(full == 0 && board[0][i] == 'O')
				{
					if(board[0][i] == board[1][i] && board[0][i] == board[2][i])
					{
						System.out.println("패배하셨습니다!");
						full = 1;
						stop = false;
					}
				}
			}
				
			// '\'일때.
			//다른 판정과 겹치지 않을 때, 판정을 출력한다(full = 0)
			if(board[0][0] == board[1][1] && board[0][0] == board[2][2])
			{
				if(full == 0 && board[0][0] == 'X')
				{
					System.out.println("승리하셨습니다!");
					full = 1;
					stop = false;
				}
				
				if(full == 0 && board[0][0] == 'O')
				{
					System.out.println("패배하셨습니다!");
					full = 1;
					stop = false;
				}
			}
			
			// '/'일때.
			if(board[1][1] == board[2][0] && board[1][1] == board[0][2])
			{
				if(full == 0 && board[1][1] == 'X')
				{
					System.out.println("승리하셨습니다!");
					full = 1;
					stop = false;
				}
				
				if(full == 0 && board[1][1] == 'O')
				{
					System.out.println("패배하셨습니다!");
					full = 1;
					stop = false;
				}
			}
						
			//게임판이 꽉 찼을때.
			int count = 0;
			for(int i=0; i<3; i++)
				for(int j=0; j<3; j++)
					if(board[i][j] != ' ') count++;
			
			//다른 판정과 겹치지 않을 때, 판정을 출력한다(full = 0)
			if(full == 0 && count == 9)
			{
				System.out.println("바둑판이 꽉 찼습니다!");
				System.out.println("무승부입니다!");
				stop = false;
			}
		
		}while(stop);
	}
}