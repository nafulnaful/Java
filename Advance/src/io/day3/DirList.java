//6/16[1]
package io.day3;
import java.io.File;
import java.util.Date;

import javax.swing.JOptionPane;
import java.text.*;

public class DirList {

	public static void main(String[] args) {
		String dirName=JOptionPane.showInputDialog("디렉토리명을 입력하세요");
		if(dirName==null) return;//입력을 하지 않으면 종료
		
		File dir=new File(dirName);
		// boolean isDirectory() : 디렉토리명 true를 반환
		// boolean isFile() : 파일이면 true를 반환
		System.out.println(dir.isDirectory());//dir이 directiory가 맞는가?
		//String[] list()  
		//[1] 해당 디렉토리에 있는 파일이나 디렉토리 이름을 가져와 출력하기
		String[] fList=dir.list();
		if(fList!=null) {
			for(String fname:fList) {
				System.out.println(fname);//파일의 이름이나 디렉토리의 이름은 잘나오지만 정보는 안 알려줌
			}
		}
	
		//[2] 해당 디렉토리의 파일/dir의 이름과 파일크기, File/dir, 마지막수정일
		//정보를 출력하기
		//File[] listFiles()
		File[] fList2 = dir.listFiles();
		if(fList2!=null) {
			String fsize="";
			String time="";
			Date d=null;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");//yy:년도 MM:월
			//오라클에서는 => mm:월 mi:분
			System.out.println("------------------------------------------");
			System.out.println("마지막수정일\tFILE/DIR\t파일명\t파일크기");
			System.out.println("------------------------------------------");
			
			for(File f:fList2) {
				String fname=f.getName();
				String str=(f.isFile())?"FILE":"DIR";
				if(!f.isDirectory()) {//파일일 경우
					fsize=f.length()+"bytes";
					long time_long =f.lastModified();
					d=new Date(time_long);
					time=sdf.format(d);
				}else {//여기는 디렉토리일 경우
					fsize="";
					time="";
				}
				System.out.println(time+"\t"+str+"\t"+fname+"\t"+fsize);
			}
				System.out.println("------------------------------------------");
		}//if()-------------------------------------------

	}

}
