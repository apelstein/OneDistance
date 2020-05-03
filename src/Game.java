
public class Game {
	
	public Graph<String> graph;
	
	public void buildGraph(String[] strings, int wordSize){
		graph = new GameGraph(wordSize);
		graph.addManyNewNodes(strings);
		graph.printGraph();
	}
	
	public static void main(String[] args){
		Game game = new Game();
		String[] strings = {"aaa", "aba", "abb","bab", "bbb","bac", "cac", "ccc"};
		game.buildGraph(strings, 3);
		game.graph.printPath("aaa", "ccc");
	}

}
