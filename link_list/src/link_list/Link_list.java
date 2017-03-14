package link_list;

import javax.swing.JFrame;


public class Link_list {
	public static void main(String a[]){
		Llist mlist=new Llist();
		mlist.setVisible(true);
		mlist.setTitle("Link List");
		mlist.setBounds(100,50,400, 300);
		mlist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
