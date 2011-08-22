package droidWork.TheBeamers.ca;

public class TicTacToeController  {
  private Integer[][] mGameArray = new Integer[3][3];;
  private Integer currentPlayer;
  private boolean gameOver;
  
  /**
   * Constructor of TicTacToeController.  
   * Sets up the board and X as the first player
   */
  public TicTacToeController (){
    resetGame();	
  }

  public Integer getCurrentPlayer() {
	  return currentPlayer;	 
  }
  
  /**
   * Allows a game reset.
   */
  public void resetGame(){
	initGameArray();
	gameOver = false;
	currentPlayer = 1;	  
  }
  
  /**
   *  set game elements to 0 (no owner) 
   */
  private void initGameArray() {
	  	  
	  for (int r=0; r<mGameArray.length; r++) {
		  for (int c=0; c<mGameArray.length; c++) {
			  mGameArray[r][c] = 0;
		  }
	  }	  
  }
  
  /**
   *  set current player.  Checks for valid placement rely on this.
   * @param newPlayer Sets the player, X or O
   * @throws invalidPlayerException 
   */
  public void setPlayer(String newPlayer) throws invalidPlayerException {
	  if (newPlayer == "X") {
		  currentPlayer = 1;		  
	  } else if (newPlayer == "O") {
		  currentPlayer = 2;		 
	  } else {
		  throw new invalidPlayerException("newPlayer must be X or O");
	  }
  }
  
  /**
   * Toggle the current player
   */
  private void toggleCurrentPlayer() {
	  if (currentPlayer == 1) {
		  currentPlayer = 2;
	  } else {
		  currentPlayer = 1;
	  }
  }
  
  /**
   *  All in on method for taking a turn.  Just requires the position attempting to be taken 
   * @param position the grid position 
   * @return true if the position was valid and the turn was successful.  Otherwise false.
   */
  public boolean takeTurn(Integer row, Integer col) {
	if (gameOver) { // Test for Game already over
		return false;
	} else if (mGameArray[row][col] != 0) { // Test for position already taken
		return false;
	} else { // Take position and update the player turn
		mGameArray[row][col] = currentPlayer;
		toggleCurrentPlayer();
		return true;
	}
  }
  
  /**
   * isGameOver tests for a winning condition
   * @return true if game is over, otherwise false
   */
  public boolean isGameOver() {
	  // test row-wise win
	  for (int r=0; r<mGameArray.length; r++) {
		  if ((mGameArray[r][0] == mGameArray[r][1]) && (mGameArray[r][0] == mGameArray[r][2])) {
			  if (mGameArray[r][0] != 0) {
				  return true;
			  }
		  }
	  }
	  // test col-wise win
	  for (int c=0; c<mGameArray[0].length; c++) {
		  if ((mGameArray[0][c] == mGameArray[1][c]) && (mGameArray[1][c] == mGameArray[2][c])) {
			  if (mGameArray[0][c] != 0) {
				  return true;
			  }
		  }
	  }
	  
	  // test X-wise win
	  if ((mGameArray[0][0] == mGameArray[1][1]) && (mGameArray[1][1] == mGameArray[2][2])) {
		  if (mGameArray[0][0] != 0) {
			  return true;
		  }
	  } else if ((mGameArray[2][0] == mGameArray[1][1]) && (mGameArray[1][1] == mGameArray[0][2])) {
		  if (mGameArray[2][0] != 0) {
			  return true;
		  }
	  }
	  return false; // if we get here, the game isn't over.
  }
}
  
