package tic_tac_toe;

public class Board {

	private char board[][];
	final static int PLAYER_1_WINS = 1;
	final static int PLAYER_2_WINS = 2;
	final static int DRAW = 3;
	final static int INCOMPLETE = 4;
	private Player p1;
	private Player p2;

	public Board(Player p1, Player p2) {
		board = new char[3][3];
		this.p1 = p1;
		this.p2 = p2;
	}

	public  int getStatus() {
		
		for(int i = 0; i < 3; i++){
			if(board[i][0] != '\0' && board[i][0] == board[i][1] && board[i][0] == board[i][2]){
				if(board[i][0] == p1.symbol){
					return PLAYER_1_WINS;
				}else{
					return PLAYER_2_WINS;
				}
			}
		}
		for(int i = 0; i < 3; i++){
			if(board[0][i] != '\0' && board[0][i] == board[1][i] && board[0][i] == board[2][i]){
				if(board[0][i] == p1.symbol){
					return PLAYER_1_WINS;
				}else{
					return PLAYER_2_WINS;
				}
			}
		}
		
		if(board[0][0] != '\0' && board[0][0] == board[1][1] && board[0][0] == board[2][2]){
			if(board[0][0] == p1.symbol){
				return PLAYER_1_WINS;
			}else{
				return PLAYER_2_WINS;
			}
		}
		
		if(board[2][0] != '\0' && board[2][0] == board[1][1] && board[2][0] == board[0][2]){
			if(board[2][0] == p1.symbol){
				return PLAYER_1_WINS;
			}else{
				return PLAYER_2_WINS;
			}
		}
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == '\0'){
					return INCOMPLETE;
				}
			}
		}
		
		return DRAW;
	}

	public void move(char symbol, int x, int y) throws InvalidMoveException {
		if(x >= 0 && x < 3 && y >= 0 && y < 3 && board[x][y] == '\0' ){
			board[x][y] = symbol;	
		}else{
			throw new InvalidMoveException(); 
		}
	}

	public void print() {
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(" | " + board[i][j] +" | ");
			}
			System.out.println();
		}
	}

}

