/* Class to implement a Maze solver */

public abstract class MazeSolver {
	
	public static Square solve(Maze maze, SearchWorklist wl) {
		/* Complete this method */
		wl.add(maze.start);
		maze.start.visit();
		while (!wl.isEmpty()){
			Square current = wl.remove();
			if (current == maze.finish){
				return current;
			}
			else {
				Square northSquare = null;
				Square southSquare = null;
				Square eastSquare = null;
				Square westSquare = null;
				if (current.getRow() != 0){
					northSquare = maze.contents[current.getRow()-1][current.getCol()];
				}
				if (current.getRow() != maze.contents.length-1){
					southSquare = maze.contents[current.getRow()+1][current.getCol()];
				}
				if (current.getCol() != maze.contents[0].length-1){
					eastSquare = maze.contents[current.getRow()][current.getCol()+1];
				}
				if (current.getCol() != 0){
					westSquare = maze.contents[current.getRow()][current.getCol()-1];
				}
				if (northSquare != null && !northSquare.getIsWall() && !northSquare.isVisited()){
					northSquare.visit();
					northSquare.setPrevious(current);
					wl.add(northSquare);
				}
				if (southSquare != null && !southSquare.getIsWall() && !southSquare.isVisited()){
					southSquare.visit();
					southSquare.setPrevious(current);
					wl.add(southSquare);
				}
				if (eastSquare != null && !eastSquare.getIsWall() && !eastSquare.isVisited()){
					eastSquare.visit();
					eastSquare.setPrevious(current);
					wl.add(eastSquare);
				}
				if (westSquare != null && !westSquare.getIsWall() && !westSquare.isVisited()){
					westSquare.visit();
					westSquare.setPrevious(current);
					wl.add(westSquare);
				}
			}
		}
		return null;
	}

	/* Add any helper methods you want */
}
