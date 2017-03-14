package link_list;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Llist extends JFrame{
	public JButton submit;
	public JLabel name,lnumber;
	public JTextField tnumber;
	public JComboBox<Integer> box;
	//public int indexNumber;
	public Font bold,normal,nor_bold;
	public JTextArea result;
	public JRadioButton insert,delete,lsort,finsert,linsert,pinsert,fdelete,ldelete,pdelete;
	public Linklist list;
	public Llist() {
		list=new Linklist();
		Container con=this.getContentPane();
		con.setLayout(null);
				
		bold=new Font("Arial",Font.BOLD,20);
		nor_bold=new Font("Arial",Font.BOLD,15);
		normal=new Font("Arial",Font.ITALIC,15);
		
		name=new JLabel("Function Of LinkList");
		name.setFont(bold);
		name.setBounds(10, 5, 250, 30);
		
		insert=new JRadioButton("Insert");
		delete=new JRadioButton("Delete");
		ButtonGroup mejor=new ButtonGroup();
		mejor.add(insert);
		mejor.add(delete);
		insert.setFont(nor_bold);
		delete.setFont(nor_bold);
		insert.setBounds(15, 40, 120, 30);
		delete.setBounds(135, 40, 120, 30);
		
		finsert=new JRadioButton("Fisrt");
		linsert=new JRadioButton("last");
		pinsert=new JRadioButton("Position");
		
		ButtonGroup mi=new ButtonGroup();
		mi.add(finsert);
		mi.add(linsert);
		mi.add(pinsert);
		
		finsert.setFont(normal);
		linsert.setFont(normal);
		pinsert.setFont(normal);
		
		finsert.setBounds(20, 70,90, 20);
		linsert.setBounds(20, 90,90, 20);
		pinsert.setBounds(20, 110,90, 20);
		
		fdelete=new JRadioButton("Fisrt");
		ldelete=new JRadioButton("last");
		pdelete=new JRadioButton("Position");
		
		ButtonGroup m2=new ButtonGroup();
		m2.add(fdelete);
		m2.add(ldelete);
		m2.add(pdelete);
		
		fdelete.setFont(normal);
		ldelete.setFont(normal);
		pdelete.setFont(normal);
		
		fdelete.setBounds(145, 70,90, 20);
		ldelete.setBounds(145, 90,90, 20);
		pdelete.setBounds(145, 110,90, 20);
		
		JLabel position=new JLabel("Position");
		position.setFont(nor_bold);
		position.setBounds(255, 40, 80, 30);
		
		box=new JComboBox<Integer>();
		box.setFont(normal);
		box.setBounds(255, 70, 80, 20);
		box.setEditable(false);
		box.addItem(0);
		
		lnumber=new JLabel("Enter Number :");
		lnumber.setBounds(20,140, 100, 20);
		lnumber.setFont(normal);
		
		tnumber=new JTextField();
		tnumber.setBounds(20,165, 130, 20);
		tnumber.setFont(normal);
		
		lsort=new JRadioButton("Sort");
		lsort.setBounds(170,165,60,20);
		lsort.setFont(normal);
		
		result=new JTextArea("Result: ");
		result.setFont(normal);
		result.setBounds(20,200,280,40);
		
		submit=new JButton("Ok");
		submit.setFont(normal);
		submit.setBounds(320,190,60,40);
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int data=Integer.parseInt(tnumber.getText());
				int pos=(Integer)box.getSelectedItem();
				if(lsort.isSelected()){
					ArrayList<Integer> arr=list.getAllItemSorted();
					int list_size=list.size;
					list=new Linklist();
					for(int i=0;i<list_size;i++)
						list.addLast(arr.get(i));
					
				}else{
					if(insert.isSelected()){
						if(finsert.isSelected())
							list.addFirst(data);
						if(linsert.isSelected())
							list.addLast(data);
						if(pinsert.isSelected())
							list.addByIndex(data, pos);
						box.addItem(list.size);
					}
					if(delete.isSelected()){
						if(fdelete.isSelected())
							list.removeByPosition(1);
						if(ldelete.isSelected())
							list.removeByPosition(list.size);
						if(pdelete.isSelected())
							list.removeByPosition(pos);
						box.removeItem(list.size+1);
						
					}
				}
				int size=list.size;
				Node tmp=list.start;
				result.setText(null);
				for(int i=0;i<size;i++){
					
					result.append(Integer.toString(tmp.getData())+" ");
					tmp=tmp.getLink();
				}
			}
		});
		
		
		con.add(result);
		con.add(submit);
		con.add(lsort);
		con.add(lnumber);
		con.add(tnumber);
		con.add(position);
		con.add(box);
		con.add(fdelete);
		con.add(ldelete);
		con.add(pdelete);
		con.add(finsert);
		con.add(linsert);
		con.add(pinsert);
		con.add(insert);
		con.add(delete);
		con.add(name);
	}
}