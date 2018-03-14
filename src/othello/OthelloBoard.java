package othello;

public class OthelloBoard {
	int xDir[] = {-1,-1,0,1,1,1,0,-1};
	int yDir[] = {0,1,1,1,0,-1,-1,-1};
	
	public boolean move(char symbol, int x, int y){
		
		// check for valid move 
		
		
		for(int i = 0; i < xDir.length; i++){
			int stepX = xDir[i];
			int stepY = yDir[i];
			int currentX = x + stepX;
			int currentY = y + stepY;
			int count = 0;
			while( // condition){
					
					if(board[currentX][currentY] == symbol){
						if(count > 0){
							// valid move
							// make board changes
						}else if(board[currentX][currentY] == 0){
							break;
						}else{
							count++;
							currentX = currentX + stepX;
							currentY = currentY + stepY;
						}
					}
					
			
		}
		
	}
	


}
