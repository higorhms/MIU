package prog82code;

public class MyStringLinkedList {
	Node header;
	MyStringLinkedList(){
		header = new Node(null);
	}
	//adds to the front of the list
	public void addFirst(String item){
		Node n = new Node(item);
		//place new node after header and 
		//establish links from new node to 
		//surrounding nodes
		n.next = header.next;
		n.previous = header;
		
		//establish links from surrounding 
		//nodes to the new node
		if(header.next != null){
			header.next.previous = n;
		}		
		header.next = n;	
	}
	
	//adds to the end of the list
	public void addLast(String item) {
		Node n = new Node(item);
		//find last node
		Node last = header;
		while(last.next != null) {
			last = last.next;
		}
		//now last.next == null
        last.next = n;
        n.previous = last;
	}
	
	//removes node in last position
	public void removeLast( ) {
		//if list is empty, return
		if(header.next == null) return;
		
		Node current = header;
		//traverse the list until current.next is 
		//null - then remove current
		while(current.next != null) {
			current = current.next;
		}
		//now current.next == null, so remove current
		Node previous = current.previous; 
		//previous is not null since current is not header
		previous.next = null;
		current.previous = null;
	}
	
	//determines whether the input string is in the list
	public boolean search(String s) {
		Node next = header.next;
		while(next != null && !next.value.equals(s)) {
			next = next.next;
		}
		//either next == null or next.value is s
		if(next == null) return false;
		else {//next.value.equals(s) 
			return true;
		}
	}
	public String toString() { 
		var sb = new StringBuffer();
		Node next = header.next;
		while(next != null) {
			sb.append(next.toString() + ", ");
			next = next.next;
		}
		var result = sb.toString().trim();
		if(result.length() == 0) return "<empty list>";
		if(result.charAt(result.length()-1) == ',') {
			return result.substring(0,result.length()-1);
		}
		return result;			
	}
	class Node {
		String value;
		Node next;
		Node previous;
		Node(String value){
			this.value = value;
		}
		
		public String toString() {
			return value == null ? "null" : value;
		}
	}

	void insert(String data, int pos){
		Node toAdd = new Node(data);
		if(pos == 0) {
			addFirst(data);
			return;
		}
		int aux = 0;

		Node entry = header;

		while(entry.next != null){
			if(aux == pos + 1){
				entry.previous.next = toAdd;
				toAdd.previous = entry.previous;
				entry.previous = toAdd;
				toAdd.next = entry;
				break;
			}
			entry = entry.next;
			aux++;
		}
	}

	boolean remove(String data){
		Node entry = header;
		while(entry.next != null){
			if(data.equalsIgnoreCase(entry.value)){
				boolean hasPrevious = entry.previous != null ? true : false;
				boolean hasNext = entry.next != null ? true : false;

				if(hasPrevious && hasNext){
					entry.previous.next = entry.next;
					entry.next.previous = entry.previous;
					return true;
				}

				if(hasPrevious && !hasNext){
					entry.previous.next = null;
					return true;
				}

				header.next = entry.next;
				return true;
			}

			entry = entry.next;
		}

		return false;
	}

	void minSort(){
		Node entry = header;

		while(entry.next != null){
			if(entry.value != null){
				Node next = entry.next;

				while(next.next != null){
					if(next.value.compareTo(entry.value) < 0){
						boolean hasPrevious = entry.previous != null ? true : false;
						boolean hasNext = next.next != null ? true : false;

						if(hasPrevious && hasNext){
							entry.previous.next = next;
							entry.previous = next;
							entry.next = next.next;
							next.next.previous = entry;
							next.next = entry;
							next.previous = entry.previous;
						}

						if(!hasPrevious && hasNext){
							next.next.previous = entry;
							entry.previous = next;
							next.previous = null;
							entry.next = next.next;
							next.next = entry;
						}

						if(hasPrevious && !hasNext){
							entry.previous.next = next;
							next.previous = entry.previous;
							entry.previous = next;
							entry.next = null;
							next.next = entry;
						}
					}

					next = next.next;
				}
			}

			entry = entry.next;
		}
	}

	public static void main(String[] args){
		var list = new MyStringLinkedList();
		list.addLast("Rich");
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.addFirst("Bob");
		list.addFirst("Harry");
		list.addFirst("Steve");
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		System.out.println(list.search("Harry"));
		System.out.println(list.search("Bob"));
		list.addLast("Tom");

		System.out.println("-------------------------");


		list.insert("Higor", 1);
		System.out.println("Insert to position 1 \"Higor\": " + list);
		boolean result = list.remove("Higor");
		System.out.println("Removed \"Higor\": " + list + result);
		list.minSort();
		System.out.println("Ordered: " + list);
	}
}
