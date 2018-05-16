package Essences;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import Essences.Lift;
import Main.Main;
public class Human extends Thread {
	
	public static int serialNumberHuman;
	private int numberHuman;
	private int waitingFloor;
	private int findingFloor;
	private Display display; 
	public boolean isArrived = false;
	
	public Human(int waitingFloor, int findingFloor) {
		this.waitingFloor = waitingFloor;
		this.findingFloor = findingFloor;
		this.numberHuman = serialNumberHuman;
		
	}
	
	public int getWaitingFloor() {
		return this.waitingFloor;
	}
	
	public int getFindingFloor() {
		return this.findingFloor;
	}
	
	public Display getDisplay() {
		return this.display;
	}
	
	public int getNumberHuman() {
		return this.numberHuman;
	}
	public void run() {
		
		display = new Display();
		Shell shell = new Shell(display, SWT.SHELL_TRIM & (~SWT.RESIZE));
		
		shell.setText("�������#"+numberHuman);
		shell.setSize(210,130);
		shell.setLayout(new GridLayout());
		
		GridData gridData = new GridData();//����� �������
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		
	    Label findingLabel = new Label(shell,SWT.NONE);
	    findingLabel.setText("��������� �� " + this.findingFloor + " ����e");
	    findingLabel.setLayoutData(gridData);
	    
	    Label waitingLabel = new Label(shell, SWT.NONE);
	    waitingLabel.setText("����� ������� �� "+ this.waitingFloor + " ����");
	    waitingLabel.setLayoutData(gridData);
	    
	    gridData = new GridData(); // ����� ������
	    gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
	    Button trySitButton = new Button(shell, SWT.PUSH); // ������ ���� ���
	    trySitButton.setText("����������� �����");
	    trySitButton.setLayoutData(gridData);
	   
	    Label informationLabel = new Label(shell, SWT.NONE);
	    informationLabel.setText("���� ����");
	    informationLabel.setLayoutData(gridData);
	    
	    trySitButton.addSelectionListener(new SelectionAdapter()
	     {		
	    	 @Override public void widgetSelected(final SelectionEvent e)
	    	 {
	    		 try {
	    			 int i;
	    			 
	    			 for(i = 0; i<Lift.PEOPLE_IN_LIFT; i++) {
	    				 
	    				 if(informationLabel.getText() != "���� �������") { 
	    					 
	    					 Main.showDialogMessage(shell, "�� ���� ������� �����, ���� ��� �� ��������");
	    					 break;
	    				 }
	    				 
	    				 if(Main.lift.getHuman(i).equals(Main.lift.emptyPlace)){ // ���� ���� ��������� �����
		    				
			    			Main.lift.addHuman(Main.vectorHuman.get(numberHuman-1));
			    			trySitButton.setEnabled(false);
			    			informationLabel.setText("�� � �����");
			    			break;
			    		 }
	    			 }	  
	    
	    			 if(i == Lift.PEOPLE_IN_LIFT) Main.showDialogMessage(shell, "���� ��������� ��������");
	    			 
	    		 }
	    		 
	    		 catch(Exception ex ){
	    			 Main.showDialogMessage(shell, "UNKNOWN ERROR");
	    		 }
	    	 }
   
	     });
	     
    	shell.open();
    	
    	while (!shell.isDisposed()) {
    		
    		if(Main.getLift().getCurrentFloor() == this.findingFloor) {
    			
    			try { // ����� ���� �� �������� ������, ��� �������� �������
					Thread.sleep(300);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
    			
    			informationLabel.setText("���� �������");
    			this.findingFloor = Lift.LAST_FLOOR +1; // ����� ������ �� ��������������� �� ���	
    		}
    		
    	/*	if (Main.getLift().getCurrentFloor()!= this.findingFloor && this.findingFloor == Lift.LAST_FLOOR +1) {
    			informationLabel.setText("���� ����");
    		}*/
    		
			if(this.isArrived == true) {  			
			    	informationLabel.setText("���, ��������, �������");
			    	this.waitingFloor = Lift.LAST_FLOOR +1; // ����� ������ �� ��������������� �� ���	
			    }
    		
    		if (!display.readAndDispatch())
            display.sleep();
    		}
    
   		display.dispose ();

	}	
	
}
	