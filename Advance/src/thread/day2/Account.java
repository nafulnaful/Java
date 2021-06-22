//6/11 2-1
package thread.day2;
/*wait()/notify() 메소드를 이용해서
 * 입금/출금 번갈아 수행하도록 해보자.
 * wait(), notify(), notifyAll()메소드는 동기화 블럭에서만 호출 가능하다.
 * */

public class Account {
	private int money=10;
	private boolean flag=false;//번갈아하게 하기위해서 변수 선언해준다
	
	//synchronized를 붙이면 해당 객체의 lock을 주어야만 메소드를 수행할 수 있다.
	synchronized public void get(int val) {
		//두번째 왔을때 true로 오기 때문에 if문에 걸리지 않는다 밑에 걸림
		//세번째 왔을때는 밑에 입금을 하고 왔기 때문에 false로 들어옴
		if(!flag) {//flag가 false라면
			try {
				wait();
			//wait()가 호출이 되면 스레드는 수행권한을 포기하고 waiting pool에 가서 대기함
			//이 때 락을 반납하고 대기상태로 들어간다.
			} catch (InterruptedException e) {
			}	
		}//if-----------------------------------
		
		if(money-val<0) {
			System.out.println("현금 부족: 현재 잔액="+money+", 요청 금액:"+val);
			flag=false;
			notify();
			return;
		}
		money-=val;
		System.out.println("출금액: "+val+", 출금후 잔액: "+money);
		flag=false;
		notify();
	}//get()-------------
	
	public void save(int val) {
	/////////////동기화 시작 부분
	synchronized(this) {
		if(flag) {//한번하고 또입금할려고 할거니까 여기서 wait걸어줌
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
			money+=val;
			System.out.println("입금액: "+val+", 입금후 잔액: "+money);
		
		flag=true;//출금스레드를 수행하게 하기위해
		notify();//waiting pool에 대기 중인 스레드 하나를 깨워 runnable한 상태로
		//전환시킴. notifyAll()=>대기 중인 스레드 모두를 깨움
		}//synch-------------
		
		
	}//save()-----------
}///////////////////////
