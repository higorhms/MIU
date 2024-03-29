package prog81sortsearch;

import java.util.Arrays;

public class MyStringList {
	private final int INITIAL_LENGTH = 4;
	private String[] strArray; 
	private int size;
	
	public MyStringList() {
		strArray = new String[INITIAL_LENGTH];
		size = 0;
	}
	
	/******* sorting methods ********/
	public void minSort(){
		for(int index = 0; index < this.size; index++){
			for(int secondIndex = index; secondIndex < this.size; secondIndex++){
				if(strArray[index].compareTo(strArray[secondIndex]) > 0){
					String aux = strArray[index];
					strArray[index] = strArray[secondIndex];
					strArray[secondIndex] = aux;
				}
			}
		}
	}
	/********* end sorting methods ********/
	
	public void add(String s){
		if(size == strArray.length) resize();
		strArray[size++] = s;
	}
	
	public String get(int i){
		if(i < 0 || i >= size){
			return null;
		}
		return strArray[i];
	}
	
	public boolean find(String s){
		for(String test : strArray){
			if(test.equals(s)) return true;
		}
		return false;
	}
	
	public void insert(String s, int pos){
		if(pos > size) return;
		if(pos >= strArray.length||size+1 > strArray.length) {
			resize();
		}
		String[] temp = new String[strArray.length+1];
		System.arraycopy(strArray,0,temp,0,pos);
		temp[pos] = s;
		
		System.arraycopy(strArray,pos,temp,pos+1, strArray.length - pos);
		strArray = temp;
		++size;
	}
	
	public boolean remove(String s){
		if(size == 0) return false;
		int index = -1;
		for(int i = 0; i < size; ++i ){
			if(strArray[i].equals(s)){
				index = i;
				break;
			}
		}
		if(index==-1) return false;
		String[] temp = new String[strArray.length];
		System.arraycopy(strArray,0,temp,0,index);
		System.arraycopy(strArray,index+1,temp,index,strArray.length-(index+1));
		strArray = temp;
		--size;
		return true;
	}
	
	
	private void resize(){
		System.out.println("resizing");
		int len = strArray.length;
		int newlen = 2*len;
		String[] temp = new String[newlen];
		System.arraycopy(strArray,0,temp,0,len);
		strArray = temp;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0; i < size-1; ++i){
			sb.append(strArray[i]+", ");
		}
		sb.append(strArray[size-1]+"]");
		return sb.toString();
	}
	public int size() {
		return size;
	}

	public static void main(String[] args){
		String[] testArr = {"big", "small", "tall", "short", "round", "square", "enormous", "tiny","gargantuan", "lilliputian", "numberless", "none", "vast", "miniscule"};
		MyStringList list = new MyStringList();
		for(int i = 0; i < testArr.length; ++i) {
			list.add(testArr[i]);
		}
		list.minSort();
		System.out.println("The list in sorted order:");
		System.out.println(list.toString());
		System.out.println();
		System.out.println("\"number\" is in the list? "+list.binSearchIt("number"));
		System.out.println("\"tiny\" is in the list? "+list.binSearchIt("tiny"));
		System.out.println("\"big\" is in the list? "+list.binSearchIt("big"));
		System.out.println("\"vast\" is in the list? "+list.binSearchIt("vast"));
		System.out.println("\"miniscule\" is in the list? "+list.binSearchIt("miniscule"));
	}

	/******** binary search methods ********/

	//search a sorted array
	boolean binSearchIt(String val) {
		if(this.size() == 0) return false;
		minSort();
		String[] aux = this.strArray;
		int middle = this.size;

		while(aux.length != 0){
			middle = middle / 2;
			if(aux[middle].equalsIgnoreCase(val)) return true;
			boolean left = val.compareTo(aux[middle]) < 0 ? true : false;
			String[] aux2 = new String[middle];
			if(left){
				System.arraycopy(aux, 0, aux2, 0, middle);
			}else{
				System.arraycopy(aux, middle + 1, aux2, 0, middle);
			}
			aux = aux2;
		}

		return false;
	}

	/********* end binary search methods *****/

}
