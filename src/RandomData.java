
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;
import javax.swing.*;

public class RandomData extends JFrame {
	JButton button1=new JButton("选择排序");
	JButton button2=new JButton("希尔排序");
	JButton button3=new JButton("归并排序");
	JButton button4=new JButton("插入排序");
	JButton button5=new JButton("冒泡排序");
	JButton button6=new JButton("快速排序");
	JLabel labels=new  JLabel("程序运行时间：");
	JLabel labelj=new  JLabel();
	JLabel label=new  JLabel("请输入生成数的个数：");
	JTextField field=new JTextField(12);	
	JTextArea text=new JTextArea(10,20);
	JScrollPane jsp1=new JScrollPane(text);
	JTextArea text1=new JTextArea(10,20);
	JScrollPane jsp2=new JScrollPane(text1);
	
	String regex1="[\\p{Digit}]+";
	Random r=new Random();
	
	
	public RandomData() {
		init();
	}
	void init() {
		button1.setFont(new Font("宋体",1,22));
		button2.setFont(new Font("宋体",1,22));
		button3.setFont(new Font("宋体",1,22));
		button4.setFont(new Font("宋体",1,22));
		button5.setFont(new Font("宋体",1,22));
		button6.setFont(new Font("宋体",1,22));
		label.setFont(new Font("宋体",1,22));
		labels.setFont(new Font("宋体",1,22));
		labelj.setFont(new Font("宋体",1,22));
		field.setFont(new Font("宋体",1,22));
		text.setFont(new Font("宋体",1,18));
		text1.setFont(new Font("宋体",1,18));
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		JPanel panel4=new JPanel();
		JPanel panel5=new JPanel();
		Box box1=Box.createVerticalBox();//声明列式盒
			
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Rand(1);				
			}
		});
						
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Rand(2);					
			}
		});
								
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Rand(3);							
			}
		});
		
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Rand(4);							
			}
		});
		
		button5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Rand(5);							
			}
		});
		
		button6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Rand(6);							
			}
		});
		
		panel1.add(label);
		panel1.add(field);
		panel4.add(button1);
		panel4.add(button2);
		panel4.add(button3);
		panel5.add(button4);
		panel5.add(button5);
		panel5.add(button6);
		panel2.add(jsp2);
		panel2.add(jsp1);
		panel3.add(labels);
		panel3.add(labelj);
		box1.add(panel1);
		box1.add(panel4);
		box1.add(panel5);
		box1.add(panel2);
		box1.add(panel3);
		add(box1);
		
	}
	
	public void Rand(int i) {		
		File f1=new File("random.txt");				
		File f2=new File("ord.txt");
		
		try {
			f1.createNewFile();
			f2.createNewFile();
										
		}
		catch (IOException e) {					
			System.out.println(e.toString());
		}
			
		try {
			Writer out1 = new FileWriter(f1);
			Writer out2 = new FileWriter(f2);
		if(field.getText().matches(regex1)) {						
			int N=Integer.parseInt(field.getText());
			if(N<1) {
				JOptionPane.showMessageDialog(null,"输入错误，请重新输入","提示",JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				int shuzu[]=new int[N];
				
				text1.setText("");//清空文本区			
				for(int x=0;x<shuzu.length;x++) {
					int s=r.nextInt(100000);
					shuzu[x]=s;
					String str1=Integer.toString(shuzu[x]);//数组整形转化成字符型
					text1.append(str1+"\n");//把数组放到文本区
											
					out1.write(str1);		
					out1.write("    ");
				   }
				out1.close();	
				
				int arr[]=new int[N];
				for(int x=0;x<arr.length;x++) {
					arr[x]=shuzu[x];
				}
				long start1 = System.currentTimeMillis();
				switch(i) {
				case 1:SelectSort(arr);break;
				case 2:shellSort(arr);break;
				case 3:mergesort(arr,0,arr.length-1);;break;
				case 4:InsertSort(arr);;break;
				case 5:BubbleSort(arr);;break;
				case 6:quickSort(arr,0,arr.length-1);;break;
				}
				
				long end1 = System.currentTimeMillis();
				long time = end1-start1;
				String sR=Long.toString(time);
				labelj.setText(sR+"毫秒");
				
				//输出排序后的数组
				text.setText("");//清空文本区				
				for(int x=0;x<arr.length;x++) {							
					String str1=Integer.toString(arr[x]);//数组整形转化成字符型
					text.append(str1+"\n");//把数组放到文本区
					
						out2.write(str1);
						out2.write("    ");
					} 
				    out2.close();																																
			}
		}
		
		else {
			JOptionPane.showMessageDialog(null,"输入错误，请重新输入","提示",JOptionPane.ERROR_MESSAGE);
		}
	}
		catch (IOException e) {				
			System.out.println(e.toString());
		}
	
}
	//直接插入排序方法
	public void InsertSort(int[] arrays) {
		int[] arr=arrays;
		for(int i=1;i<arr.length;i++) {
			int temp=arr[i],j;
			for(j=i-1;j>=0&&temp<arr[j];j--) {
				arr[j+1]=arr[j];
			}
			arr[j+1]=temp;
		}
	}
	
	//直接选择排序方法
	public void SelectSort(int[] arrays) {
		int[] arr=arrays;
		int temp = 0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	//冒泡排序方法
	public void BubbleSort(int[] arrays) {
		int[] arr=arrays;
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<arr.length-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	
	//快速排序方法
	public void quickSort(int[] arrays,int begin,int end) {
		int[] arr=arrays;
		if(begin<end&&begin>=0&&end<=arr.length) {
			int i=begin,j=end;
			int vot=arr[i];
			while(i!=j) {
				while(i<j && arr[j]>=vot) {
					j--;
				}
				if(i<j) {
					arr[i++]=arr[j];
				}
				while(i<j && arr[i]<=vot) {
					i++;
				}
				if(i<j) {
					arr[j--]=arr[i];
				}
			}
			arr[i]=vot;
			quickSort(arr,begin,j-1);
			quickSort(arr,i+1,end);
		}
	}
	
	//希尔排序方法
	public void shellSort(int[] arrays){            
        int delta = arrays.length/2;
        for(delta=arrays.length/2;delta>0;delta/=2) {
        	for(int i=delta;i<arrays.length;i++){
        		int temp=arrays[i];
        		int j;
        		for(j=i-delta;j>=0&&temp<arrays[j];j-=delta){
        			arrays[j+delta]=arrays[j];
        		}
        		arrays[j+delta]=temp;
        	}
        }		
    }
	
	//归并排序方法
	public static void mergesort(int[] a,int begin,int end){
        int mid = (begin+end)/2;
        if(begin<end){
            mergesort(a,begin,mid);
            mergesort(a,mid+1,end);
            //左右归并
            merge(a,begin,mid,end);
        }
    }
	public static void merge(int[] a, int begin, int mid, int end) {
        int[] temp = new int[end-begin+1];
        int i= begin;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=end){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }
            else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组 
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边剩余的数移入数组
        while(j<=end){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+begin] = temp[x];
        }
    }
	
	
	public static void main(String[] args) {
		RandomData win=new RandomData();
		win.setTitle("排序系统");
		win.setSize(800,430);
		win.setLocationRelativeTo(null);//窗口居中
		win.setResizable(false);//窗口大小不可改变
		win.setVisible(true);//窗口可见
		win.setLayout(new FlowLayout());
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
