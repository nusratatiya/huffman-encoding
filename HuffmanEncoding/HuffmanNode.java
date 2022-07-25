
class HuffmanNode implements Comparable<HuffmanNode>{
	
	int weight;
	char c;
	
	
	HuffmanNode left;
	HuffmanNode right;
	
	//constructors
	HuffmanNode(){};
	
	
	HuffmanNode(char c, Integer freq){
		this.c = c;
		this.weight= freq;
	}
	
	//compareTo
	public int compareTo (HuffmanNode node) {
		return weight- this.weight;
	}
	
	
	public String toString() {
		String temp = "";
		temp +=c;
		return temp;
	}
	
	
	//getters and setters
	
	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public char getC() {
		return c;
	}


	public void setC(char c) {
		this.c = c;
	}


	public HuffmanNode getLeft() {
		return left;
	}


	public void setLeft(HuffmanNode left) {
		this.left = left;
	}


	public HuffmanNode getRight() {
		return right;
	}


	public void setRight(HuffmanNode right) {
		this.right = right;
	}
}
