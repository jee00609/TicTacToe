import java.util.Random;
import java.util.Scanner;

public class TTT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//������ ���(�� 9��) -->ĭ�� 9���̱� ����
		//�����(���� 5��)
		//��ǻ��(�İ� 4��) --> �����Լ�
		//�¸�����  --> ���� O�� X�� 3���� �������� �̾����� ����� �¸�
		//���º����� --> 9ĭ�� ��ä������ ���º�

	
		
		char [][] board = new char [3][3]; //������
		
		
		for(int i=0; i<3; i++) // ����ڿ� ��ǻ�Ͱ� ������ �������� �ʱ�ȭ�Ѵ�.
		{
			for(int j=0; j<3; j++)
			{
				board[i][j] = ' ';
			}
		}
		
		
		int x1=0,y1=0; // ������� ������ �ǹ��ϴ� ����
		int i=0,j=0;//�ݺ����� �� ����, i�� �� y�¿�
		
		int rotate=0;//����� ��ǻ�� ����Ƚ���� �ǹ��Ѵ�.
		//���� rotate�� 9�� �Ǵ� ���� ������ ĭ�� �� ä������ ���� �ǹ��ϸ� ���ºθ� �ǹ��Ѵ�.
		
		int escape=0;//do while() �� Ż���ϱ� ���� ���� ����
		
		Scanner scan = new Scanner (System.in);
		Random generator = new Random(); //���� ��ü ����
		
		
		
		System.out.println("����ڰ� �����Դϴ�.\n");
		
		do
		{
			////////////////////////////////////////////////////������ ���
			for(i=0;i<3;i++)
			{
				System.out.println(" " + board[i][0] + " | "+board[i][1]+" | "+board[i][2]);
				
				if(i != 2)
				{
					System.out.println("---|---|---");
				}
				
			}
			
			
			
			/*
			 * ���� ���ǹ��� ���º� ���ǹ����� ����ڿ� ��ǻ���� ���� ���ε��� �������
			 * �̸� ���� ������ �İ��� �־ ������ Ȯ�ΰ����Ͽ� 
			 * �̱�� �� �Ŀ��� ��ǻ���� ���� ���� ���� �����ߴ�.
			 * 
			 * */
			
			/////////////////////////////////////////////////////�¸� ���� 1 )) [X][] �� ���� �¸�
			
			
			for(i=0;i<3;i++)
			{
				if(board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X')
				{
					System.out.println("����ڰ� �¸��߽��ϴ�.\n");
					escape=1;
					break;

				}

				if(board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O')
				{
					System.out.println("��ǻ�Ͱ� �¸��߽��ϴ�.\n");
					escape=1;
					break;

				}

			}


			////////////////////////////////////////////////////////�¸� ���� 2 )) [][Y] ��  ���� �¸�

			for(j=0;j<3;j++)
			{
				if(board[0][j] == 'X' && board[1][j] == 'X' && board[2][j] == 'X')
				{
					System.out.println("����ڰ� �¸��߽��ϴ�.\n");
					escape=1;
					break;
					
				}

				if(board[0][j] == 'O' && board[1][j] == 'O' && board[2][j] == 'O')
				{
					System.out.println("��ǻ�Ͱ� �¸��߽��ϴ�.\n");
					escape=1;
					break;

				}


			}

			/////////////////////////////////////////////////////////�¸� ����3 )) �밢���� ���� �¸�

			if(board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X')
			{
				System.out.println("����ڰ� �¸��߽��ϴ�.\n");
				escape=1;
				break;
			}

			if(board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O')
			{
				System.out.println("��ǻ�Ͱ� �¸��߽��ϴ�.\n");
				escape=1;
				break;
			}

			if(board[2][0]=='X' && board[1][1]=='X' && board[0][2]=='X')
			{
				System.out.println("����ڰ� �¸��߽��ϴ�.\n");
				escape=1;
				break;
				
			}

			if(board[2][0]=='O' && board[1][1]=='O' && board[0][2]=='O')
			{
				System.out.println("��ǻ�Ͱ� �¸��߽��ϴ�.\n");
				escape=1;
				break;
			}

			////////////////////////////////////////////////////////// ���º�

			if(rotate==9)
			{
				System.out.println("���º� �Դϴ�.\n");
				escape=1;
				break;
			}
			
			
			
			
			/////////////////////////////////////////////////////������� ��
			
			System.out.print("���� ���� ��ǥ�� �Է��Ͻÿ�: ");
			x1=scan.nextInt();
			y1=scan.nextInt();
			
			if(board[x1][y1] != ' ')
			{
				System.out.println("�߸��� ��ġ�Դϴ�.");
				continue;
			}
			else
			{
				board[x1][y1]='X';
				rotate++;
			}
			
			
			////////////////////////////////////////////////////��ǻ���� ��
			
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

			/////////////////////////////////////////////////////�¸� ���� 1 )) [X][] �� ���� �¸�
			
			
			for(i=0;i<3;i++)
			{
				if(board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X')
				{
					System.out.println("����ڰ� �¸��߽��ϴ�.\n");
					escape=1;
					break;

				}

				if(board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O')
				{
					System.out.println("��ǻ�Ͱ� �¸��߽��ϴ�.\n");
					escape=1;
					break;

				}

			}


			////////////////////////////////////////////////////////�¸� ���� 2 )) [][Y] ��  ���� �¸�

			for(j=0;j<3;j++)
			{
				if(board[0][j] == 'X' && board[1][j] == 'X' && board[2][j] == 'X')
				{
					System.out.println("����ڰ� �¸��߽��ϴ�.\n");
					escape=1;
					break;
					
				}

				if(board[0][j] == 'O' && board[1][j] == 'O' && board[2][j] == 'O')
				{
					System.out.println("��ǻ�Ͱ� �¸��߽��ϴ�.\n");
					escape=1;
					break;

				}


			}

			/////////////////////////////////////////////////////////�¸� ����3 )) �밢���� ���� �¸�

			if(board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X')
			{
				System.out.println("����ڰ� �¸��߽��ϴ�.\n");
				escape=1;
				break;
			}

			if(board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O')
			{
				System.out.println("��ǻ�Ͱ� �¸��߽��ϴ�.\n");
				escape=1;
				break;
			}

			if(board[2][0]=='X' && board[1][1]=='X' && board[0][2]=='X')
			{
				System.out.println("����ڰ� �¸��߽��ϴ�.\n");
				escape=1;
				break;
				
			}

			if(board[2][0]=='O' && board[1][1]=='O' && board[0][2]=='O')
			{
				System.out.println("��ǻ�Ͱ� �¸��߽��ϴ�.\n");
				escape=1;
				break;
			}

			////////////////////////////////////////////////////////// ���º�

			if(rotate==9)
			{
				System.out.println("���º� �Դϴ�.\n");
				escape=1;
				break;
			}			
			
						
			

		}while(escape==0);
		

	}
	


}