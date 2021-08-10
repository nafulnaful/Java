//6/23[1]
package javachat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class JTextPaneDemo extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JTextPane tp;//텍스트페인도 모델이 있다.
	StyledDocument doc;//JTextPane문서 모델
	
	

	public JTextPaneDemo() {
		super("::JTextPaneDemo::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		tp=new JTextPane();
		p.add(new JScrollPane(tp), "Center");//스크롤바를 생성
		tp.setText("덴마크가 극적으로 2020 유럽축구선수권대회(이하 유로 2020) 16강에 올랐다. 22일 B조 마지막 경기(코펜하겐 파르켄 스타디움)에서 러시아를 4대1로 꺾고 1승 2패로 조 2위를 한 것이다. 벨기에는 이날 핀란드를 2대0으로 누르고 3전 전승으로 조 1위를 했다.\r\n"
				+ "\r\n"
				+ "덴마크는 앞선 핀란드, 벨기에전을 내리 지는 바람에 조 최하위에 머물러 있었다. 하지만 마지막 날 반전이 일어났다. 대승을 거둔 덴마크가 핀란드, 러시아와 나란히 1승 2패가 됐다. 세 팀은 상대 전적이 물고 물려 상대 골득실로 순위를 가렸다. 덴마크(+2)가 핀란드(0), 러시아(-2)에 앞서 2위로 올라섰다. 핀란드는 다른 조 경기 결과에 따라 16강행에 오를 가능성이 있다.\r\n"
				+ "\r\n"
				+ "스포츠 통계 전문 업체 옵타에 따르면 유로사상 첫 두 경기를 지고 16강 토너먼트에 오른 팀은 덴마크가 처음이다. 유로 2004(8강) 이후 17년 만에 조별 리그를 통과한 덴마크는 27일 A조 2위 웨일스와 8강 진출을 놓고 격돌한다.");

		//1. 문서 모델 얻기
		doc=tp.getStyledDocument();
		
		//2.SimpleAttributeSet객체를 생성해서 이 객체에 스타일 속성을 부여한다.
		//----> SytleConstants클래스의 static메소드를 통해서 스타일 속성을 성정한다.
		SimpleAttributeSet attr=new SimpleAttributeSet();
		StyleConstants.setFontFamily(attr, "궁서체");//서체
		StyleConstants.setFontSize(attr, 28);//글자크기
		
		//3.문서 모델에 해당 속성을 적용시킨다.
		//	-setCharacterAttributes(): 문자 특성(폰트, 기울임, 밑줄, 글자색...)
		//	-setParagraphAttributes():문단 특성(문단정렬, 들여쓰기, 문단 사이 간격....)
		doc.setCharacterAttributes(0, 30, attr, true);//0~30자까지 attr에서 (true->기존의 폰트를 덮어쓰겠다)
		
		
		attr=new SimpleAttributeSet();
		StyleConstants.setUnderline(attr, true);//밑줄 지정
		StyleConstants.setItalic(attr,  true);//이탤릭체
		StyleConstants.setForeground(attr, Color.magenta);//글자색
		StyleConstants.setBackground(attr, Color.yellow);//배경색
		
		doc.setCharacterAttributes(30, 20, attr, true);
		
		//문단 특성
		attr=new SimpleAttributeSet();
		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);//오른쪽 정렬
		doc.setParagraphAttributes(80, 100, attr, true);
		
		//tp.append()[x] tp에는 append가 있지만
		//문서 끝에 문자열을 추가
		//문서끝에 커릿 위치 알아내기
		int caretPos = doc.getEndPosition().getOffset()-1;//getEndPosition은 포지션 객체여서 getOffset해서 int값을 받는다.
		
		tp.setCaretPosition(caretPos);//문서 끝에 커릿을 위치시킨다.
		
		attr=new SimpleAttributeSet();
		StyleConstants.setFontSize(attr, 30);
		StyleConstants.setForeground(attr, Color.cyan);
		
		//문자열 삽입->메세지 추가할때 사용한다.
		try {
			doc.insertString(caretPos, "\r\n이만 총총....\r\n", attr);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		//텍스트 페인에 라벨 띄우기
		String str="\r\n[Happ님]\r\n";
		ImageIcon icon=new ImageIcon("src/images/icon1.png");//상대경로로
		
		JLabel lb=new JLabel(str, icon, JLabel.CENTER);
		
		attr=new SimpleAttributeSet();
		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_LEFT);
		
		caretPos=doc.getEndPosition().getOffset()-1;
		tp.setCaretPosition(caretPos);
		tp.insertComponent(lb);//jlabel이 컴퍼넌트 이니까
		
		doc.setParagraphAttributes(caretPos, str.length(), attr, true);
		
		
		
		
		p.setBackground(Color.white);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------

	public static void main(String[] args) {
		JTextPaneDemo my = new JTextPaneDemo();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}