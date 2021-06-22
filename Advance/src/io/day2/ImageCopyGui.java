//6/15[8]
package io.day2;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/* [실습]
 * [1] copy버튼에 대한 액션이벤트 처리 
 * [2]
 * FileInputStream/FileOutputStream
 * BufferedInputStream/BufferedOutputStream
 * 등을 활용해서
 * 원본파일을 목적파일로 카피한 뒤에
 * [3]JLabel에 해당 이미지파일이 나타나도록 처리해보자.
 * 
 * [4] 진행바에 카피되는 퍼센티지를 함께 진행시키도록 처리
 * */

public class ImageCopyGui extends JFrame
implements Runnable{

	JPanel p = new JPanel(new GridLayout(2,1));
	JPanel p2 =new JPanel(new GridLayout(4,1,10,10));
	
	JTextField tfSource, tfTarget;
	JButton btCopy;
	JProgressBar bar;
	JLabel lb;
	
	FileInputStream fis;
	BufferedInputStream bis;
	
	FileOutputStream fos;
	BufferedOutputStream bos;

	public ImageCopyGui() {
		super("::ImageCopyGui::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		//상단 판넬
		tfSource=new JTextField();
		tfTarget=new JTextField();
		btCopy=new JButton("Copy");
		bar=new JProgressBar();
		
		p2.add(tfSource);
		p2.add(tfTarget);
		p2.add(btCopy);
		p2.add(bar);
		
		bar.setStringPainted(true);//???????????????????????????????????????????
		
		//타이틀 주기
		tfSource.setBorder(new TitledBorder("::원본 파일::"));
		tfTarget.setBorder(new TitledBorder("::목적 파일::"));
		
		btCopy.addActionListener(e ->{
			//스레드 생성 및 동작
			Thread tr=new Thread(this);
			tr.start();
			
		});//카피버튼에 액션리스너
		
		
		
		//하단 판넬
		p.add(p2);
		lb=new JLabel("NO IMAGE",JLabel.CENTER);
		p.add(new JScrollPane(lb));//new JScrollPane()이게 스크롤바가 생기게 해준다

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------
	
	public void run() {
		try {
		fileCopy();
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	synchronized public void fileCopy() throws IOException {//synchronized는 스레드가 순차적으로 한번에 하나씩만 작동하게 한다.
		//tfSource, tfTarget에 입력한 값 얻어오기
		String f1=tfSource.getText();
		String f2=tfTarget.getText();
		
		if(f1==null||f2==null||f1.trim().isEmpty()||f2.trim().isEmpty()){//isEmpty 빈문자열
		JOptionPane.showMessageDialog(this,"원본파일명, 목적파일명을 모두 입력하세요");
		tfSource.requestFocus();
		return;
		}//값을 지정하지 않았을때 걸러주기 위한 안내문
		
		//원본파일의 크기를 알아내자.
		//bar의 최대값을 원본파일(File클래스의 length()) 크기로 설정
		File file1=new File(f1);
		long fsize=file1.length();//파일의 크기 보여주기
		setTitle("원본파일 크기: "+fsize+"bytes");
		
		bar.setMaximum((int)fsize);//바에 맥시멈 값을 넣어주기
		//프로그래스바의 최대값을 파일 크기로 설정
		
		//스트림 연결
		fis=new FileInputStream(file1);
		bis=new BufferedInputStream(fis);
		
		fos=new FileOutputStream(f2);
		bos=new BufferedOutputStream(fos);
		
		//반복문 돌면서 읽고 읽은 바이트 수 만큼 bar에 값을 setting
		int n=0, count=0;
		while((n=bis.read())!=-1) {
			bos.write(n);
			bos.flush();
			count++;//읽은 바이트수
			bar.setValue(count);
		}
		bos.close(); fos.close();
		bis.close(); fis.close();
		
		//밑에 이미지를 보여지게 만들기
		lb.setIcon(new ImageIcon(f2));
		lb.setText("");
	}

	public static void main(String[] args) {
		ImageCopyGui my = new ImageCopyGui();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}