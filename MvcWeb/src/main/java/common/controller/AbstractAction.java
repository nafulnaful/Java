package common.controller;

public abstract class AbstractAction implements Action{
	
	//execute()�߻�޼ҵ带 ��ӹ޾Ƽ� ������ ����
	private String viewPage; //������ �������� �̸�
	private boolean isRedirect=false;
	//������ �̵������ redirect����̸� true, forward����̸� false�� �� ����
	
	//setter, getter����----------
	public String getViewPage() {
		return viewPage;
	}
	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	

}///////////////////////////////////
