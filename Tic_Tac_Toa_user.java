import java.util.*;

//����� vs �����
public class Tic_Tac_Toa_user {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�������� ��Ÿ���� 2���� �迭�� �����Ѵ�.
		char[][] board = new char[3][3];
		//�����1�� �����2�� ��ǥ
		int x1, y1, x2, y2;
		//�ٵ����� �� á�� ���� �ٸ� ������ ��ĥ��, ������ �� �� ���� �ʵ��� �Ѵ�.
		int full = 0;
		//while���� ������ ���� ����.
		boolean stop = true;
		
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
			//�����1���Լ� ��ǥ�� �޴´�.
			System.out.print("�����1 => ���� ���� ��ǥ�� �Է��Ͻÿ�: ");
			x1 = Scan.nextInt();
			y1 = Scan.nextInt();
			
			//�����1�� ���� ��ġ�� �˻��Ѵ�.
			//���� ��ǥ�� ������ �ƴϸ� ��ǥ�� �ٽ� �޴´�.
			if(board[x1][y1] != ' ')
			{
				System.out.println("�߸��� ��ġ�Դϴ�.");
				continue;
			}
			else board[x1][y1] = 'X';
			
			//�������� �� �� �� ����Ѵ�.
			//�����1�� ��ǥ�� ǥ���Ѵ�.
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
						System.out.println("�����1��(X)�� �¸��ϼ̽��ϴ�!");
						full = 1;
						stop = false;
					}
				}
				if(full == 0 && board[i][0] == 'O')
				{
					if(board[i][0] == board[i][1] && board[i][0] == board[i][2])
					{
						System.out.println("�����2��(O)�� �¸��ϼ̽��ϴ�!");
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
						System.out.println("�����1��(X)�� �¸��ϼ̽��ϴ�!");
						full = 1;
						stop = false;
					}
				}
				if(full == 0 && board[0][i] == 'O')
				{
					if(board[0][i] == board[1][i] && board[0][i] == board[2][i])
					{
						System.out.println("�����2��(O)�� �¸��ϼ̽��ϴ�!");
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
					System.out.println("�����1��(X)�� �¸��ϼ̽��ϴ�!");
					full = 1;
					stop = false;
				}
				
				if(full == 0 && board[0][0] == 'O')
				{
					System.out.println("�����2��(O)�� �¸��ϼ̽��ϴ�!");
					full = 1;
					stop = false;
				}
			}
			
			// '/'�϶�.
			if(board[1][1] == board[2][0] && board[1][1] == board[0][2])
			{
				if(full == 0 && board[1][1] == 'X')
				{
					System.out.println("�����1��(X)�� �¸��ϼ̽��ϴ�!");
					full = 1;
					stop = false;
				}
				
				if(full == 0 && board[1][1] == 'O')
				{
					System.out.println("�����2��(O)�� �¸��ϼ̽��ϴ�!");
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
				full = 1;
				stop = false;
			}
			
			//�����1�� �Ͽ��� ������ ������ ��� ���� �ʴ´�.
			if(full == 0)
			{
				//�����2���Լ� ��ǥ�� �޴´�.
				System.out.print("�����2 => ���� ���� ��ǥ�� �Է��Ͻÿ�: ");
				x2 = Scan.nextInt();
				y2 = Scan.nextInt();
				
				//�����2�� ���� ��ġ�� �˻��Ѵ�.
				//���� ��ǥ�� ������ �ƴϸ� ��ǥ�� �ٽ� �޴´�.
				if(board[x2][y2] != ' ')
				{
					System.out.println("�߸��� ��ġ�Դϴ�.");
					continue;
				}
				else board[x2][y2] = 'O';
					
				//�������� �� �� �� ����Ѵ�.
				//�����2�� ��ǥ�� ǥ���Ѵ�.
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
							System.out.println("�����1��(X)�� �¸��ϼ̽��ϴ�!");
							full = 1;
							stop = false;
						}
					}
					if(full == 0 && board[i][0] == 'O')
					{
						if(board[i][0] == board[i][1] && board[i][0] == board[i][2])
						{
							System.out.println("�����2��(O)�� �¸��ϼ̽��ϴ�!");
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
							System.out.println("�����1��(X)�� �¸��ϼ̽��ϴ�!");
							full = 1;
							stop = false;
						}
					}
					if(full == 0 && board[0][i] == 'O')
					{
						if(board[0][i] == board[1][i] && board[0][i] == board[2][i])
						{
							System.out.println("�����2��(O)�� �¸��ϼ̽��ϴ�!");
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
						System.out.println("�����1��(X)�� �¸��ϼ̽��ϴ�!");
						full = 1;
						stop = false;
					}
					
					if(full == 0 && board[0][0] == 'O')
					{
						System.out.println("�����2��(O)�� �¸��ϼ̽��ϴ�!");
						full = 1;
						stop = false;
					}
				}
				
				// '/'�϶�.
				if(board[1][1] == board[2][0] && board[1][1] == board[0][2])
				{
					if(full == 0 && board[1][1] == 'X')
					{
						System.out.println("�����1��(X)�� �¸��ϼ̽��ϴ�!");
						full = 1;
						stop = false;
					}
					
					if(full == 0 && board[1][1] == 'O')
					{
						System.out.println("�����2��(O)�� �¸��ϼ̽��ϴ�!");
						full = 1;
						stop = false;
					}
				}
							
				//�������� �� á����.
				count = 0;
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
			}
		
		}while(stop);
	}
}