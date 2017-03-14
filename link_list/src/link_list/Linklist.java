package link_list;

import java.util.ArrayList;

class Node{
	public int data;
	public Node link;
	
	public Node(){
		data=0;
		link=null;
	}

	public Node(int data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}
	
}

class Linklist{
	public Node start,end;
	public int size;
	
	public Linklist(){
		start=end=null;
		size=0;
	}
	public int getSize(){
		return size;
	}
	public Boolean isEmpty(){
		return start==null;
	}
	public void addFirst(int data){
		Node tmp=new Node(data, null);
		if(start==null){
			start=end=tmp;
		}
		else {
			tmp.setLink(start);
			start=tmp;
		}
		size++;
	}
	public void addLast(int data){
		Node tmp=new Node(data, null);
		if(start==null){
			start=end=tmp;
		}
		else {
			end.setLink(tmp);
			end=tmp;
		}
		size++;
	}
	public void addByIndex(int data,int pos){
		Node tmp=new Node(data,null);
		Node carrier;
		if(start==null){
			start=end=tmp;
		}
		else{
			carrier=start;
			pos=pos-1;
			for(int i=1;i<size;i++){
				if(i==pos){
					tmp.setLink(carrier.getLink());
					carrier.setLink(tmp);
				}
				else {
					carrier=carrier.getLink();
				}
			}
		}
		size++;
	}
	public int removeByPosition(int pos){
		int data;
		if(start!=null){
			if(pos==1){
				data=start.getData();
				start=start.getLink();
				size--;
				return data;
			}
			if(pos==size){
				Node tmp=start,prev=start;
				while(tmp!=end){
					prev=tmp;
					tmp=tmp.getLink();
				}
				data=end.getData();
				end=prev;
				end.setLink(null);
				size--;
				return data;
			}
			Node tmp=start;
			pos=pos-1;
			for(int i=0;i<size;i++){
				if(i==(pos-1)){
					Node next=tmp.getLink();
					tmp.setLink(next.getLink());
					break;
				}
			}
			data=tmp.getData();
			tmp=tmp.getLink();
			size--;
			return data;
		}
		return 0;
	}
	public ArrayList<Integer> getAllItemSorted(){
		ArrayList<Integer> list=new ArrayList<Integer>();
		Node tmp=start;
		for(int i=0;i<size;i++){
			list.add(tmp.getData());
			tmp=tmp.getLink();
		}
		list.sort(null);
		return list;
	}
}