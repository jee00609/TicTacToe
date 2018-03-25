import java.util.*;

//��ǻ�� vs �����
public class Tic_Tac_Toa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�������� ��Ÿ���� 2���� �迭�� �����Ѵ�.
		char[][] board = new char[3][3];
		//����ڿ� ��ǻ���� ��ǥ
		int x, y, cx, cy;
		//�ٵ����� �� á�� ���� �ٸ� ������ ��ĥ��, ������ �� �� ���� �ʵ��� �Ѵ�.
		int full = 0;
		//while���� ������ ���� ����.
		boolean stop = true;
		
		Random generator = new Random();
		Scanner Scan = new Scanner(System.in);
		
		//�������� ��Ÿ���� 2���� �迭�� �ʱ�ȭ�Ѵ�.
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				board[i][j] = ' ';
		
		//�������� �׸���.
		//������ ���� ��ǥ�� ���� ���� ��Ÿ����
		System.out.println("  0 "+"  1 "+"  2 ");			
		for(int i=0; i<3; i++)
		{
			//������ ������ ��ǥ�� ���� ���� ��Ÿ����
			System.out.printf("%d", i);
				
			//������
			System.out.println(" "+board[i][0]+" "+"| "+board[i][1]+" "+"| "+board[i][2]+" ");
			if(i != 2) System.out.println(" ---|---|---");
		}
		
		//������ �����Ѵ�.
		do {
			//����ڿ��Լ� ��ǥ�� �޴´�.
			System.out.print("���� ���� ��ǥ�� �Է��Ͻÿ�: ");
			x = Scan.nextInt();
			y = Scan.nextInt();
			
			//����ڰ� ���� ��ġ�� �˻��Ѵ�.
			//���� ��ǥ�� ������ �ƴϸ� ��ǥ�� �ٽ� �޴´�.
			if(board[x][y] != ' ')
			{
				System.out.println("�߸��� ��ġ�Դϴ�.");
				continue;
			}
			else board[x][y] = 'X';
			
			//��ǻ�Ͱ� ���� ��ġ�� ������ �����Ѵ�.
			//���� ��ǥ�� ������ �ƴϸ� �ٽ� �޴´�.			
			do
			{
				cx = generator.nextInt(3);
				cy = generator.nextInt(3);
				
				//�ٵ����� �� á�� ���� �˻�.
				int count = 0;
				for(int i=0; i<3; i++)
					for(int j=0; j<3; j++)
						if(board[i][j] != ' ') count++;
				//�ٵ����� �� á����, �ݺ����� �����.
				if(count == 9) break;
			}while(board[cx][cy] != ' ');
			
			//��ǻ���� ��ǥ�� ǥ���Ѵ�.
			board[cx][cy] = 'O';
				
			//�������� �� �� �� ����Ѵ�.
			System.out.println("  0 "+"  1 "+"  2 ");			
			for(int i=0; i<3; i++)
			{
				//������ ������ ��ǥ�� ���� ���� ��Ÿ����
				System.out.printf("%d", i);
				
				//������
				System.out.println(" "+board[i][0]+" "+"| "+board[i][1]+" "+"| "+board[i][2]+" ");
				if(i != 2) System.out.println(" ---|---|---");
			}
			
			//�¸� ����
			//������ ��ġ�� �ʰ� �Ѵ�.
			//������ �� ��, ������ ������(stop = false)
			
			// '��'�϶�.
			//�ٸ� ������ ��ġ�� ���� ��, ������ ����Ѵ�(full = 0)
			for(int i=0; i<3; i++)
			{
				if(full == 0 && board[i][0] == 'X') 
				{
					if(board[i][0] == board[i][1] && board[i][0] == board[i][2])
					{
						System.out.println("�¸��ϼ̽��ϴ�!");
						full = 1;
						stop = false;
					}
				}
				if(full == 0 && board[i][0] == 'O')
				{
					if(board[i][0] == board[i][1] && board[i][0] == board[i][2])
					{
						System.out.println("�й��ϼ̽��ϴ�!");
						full = 1;
						stop = false;
					}
				}
			}
				
			// '|'�϶�.
			//�ٸ� ������ ��ġ�� ���� ��, ������ ����Ѵ�(full = 0)
			for(int i=0; i<3; i++)
			{
				if(full == 0 && board[0][i] == 'X') 
				{
					if(board[0][i] == board[1][i] && board[0][i] == board[2][i])
					{
						System.out.println("�¸��ϼ̽��ϴ�!");
						full = 1;
						stop = false;
					}
				}
				if(full == 0 && board[0][i] == 'O')
				{
					if(board[0][i] == board[1][i] && board[0][i] == board[2][i])
					{
						System.out.println("�й��ϼ̽��ϴ�!");
						full = 1;
						stop = false;
					}
				}
			}
				
			// '\'�϶�.
			//�ٸ� ������ ��ġ�� ���� ��, ������ ����Ѵ�(full = 0)
			if(board[0][0] == board[1][1] && board[0][0] == board[2][2])
			{
				if(full == 0 && board[0][0] == 'X')
				{
					System.out.println("�¸��ϼ̽��ϴ�!");
					full = 1;
					stop = false;
				}
				
				if(full == 0 && board[0][0] == 'O')
				{
					System.out.println("�й��ϼ̽��ϴ�!");
					full = 1;
					stop = false;
				}
			}
			
			// '/'�϶�.
			if(board[1][1] == board[2][0] && board[1][1] == board[0][2])
			{
				if(full == 0 && board[1][1] == 'X')
				{
					System.out.println("�¸��ϼ̽��ϴ�!");
					full = 1;
					stop = false;
				}
				
				if(full == 0 && board[1][1] == 'O')
				{
					System.out.println("�й��ϼ̽��ϴ�!");
					full = 1;
					stop = false;
				}
			}
						
			//�������� �� á����.
			int count = 0;
			for(int i=0; i<3; i++)
				for(int j=0; j<3; j++)
					if(board[i][j] != ' ') count++;
			
			//�ٸ� ������ ��ġ�� ���� ��, ������ ����Ѵ�(full = 0)
			if(full == 0 && count == 9)
			{
				System.out.println("�ٵ����� �� á���ϴ�!");
				System.out.println("���º��Դϴ�!");
				stop = false;
			}
		
		}while(stop);
	}
}