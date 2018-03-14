package tic_tac_toe;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		startGame();
	}

	private static void startGame() {
		Scanner s = new Scanner(System.in);
		Player p1 = takePlayerInput(1);
		Player p2 = takePlayerInput(2);
		while(p2.symbol == p1.symbol){
			p2 = takePlayerInput(2);
		}

		Board b = new Board(p1, p2);
		boolean player1Turn = true;
		boolean done = false;

		while(b.getStatus() == Board.INCOMPLETE  ){
			done = false;
			if(player1Turn){
				System.out.println("Player 1 turn " );
				while(! done){
					System.out.println("Enter x ");
					int x = s.nextInt();
					System.out.println("Enter  ");
					int y = s.nextInt();
					try {
						b.move(p1.symbol, x, y);
						player1Turn = false;
						done = true;
					} catch (InvalidMoveException e) {
						System.out.println("Invalid Move !!!");
					}
				}
			}else{
				System.out.println("Player 2 turn " );
				while(! done){
					System.out.println("Enter x ");
					int x = s.nextInt();
					System.out.println("Enter  ");
					int y = s.nextInt();
					try {
						b.move(p2.symbol, x, y);
						player1Turn = true;
						done = true;
					} catch (InvalidMoveException e) {
						System.out.println("Invalid Move !!!");
					}
				}
			}
			b.print();
		}
		int status  = b.getStatus();
		if( status == Board.PLAYER_1_WINS){
			System.out.println(p1.name + " wins !!");
		}else if(status == Board.PLAYER_2_WINS){
			System.out.println(p2.name + " wins !!");
		}else{
			System.out.println("Draw !!!");
		}

	}

	private static Player takePlayerInput(int i) {
		Scanner s = new Scanner(System.in);
		Player p = new Player();
		System.out.println("Enter player "+ i + "name ");
		p.name = s.next();
		System.out.println("Enter player "+ i + "symbol ");
		p.symbol = s.next().charAt(0);
		return p;
	}


}
