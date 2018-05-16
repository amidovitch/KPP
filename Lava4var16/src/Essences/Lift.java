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
import Main.Main;
import Essences.Human;
public class Lift extends Thread {
	
	public static final int LAST_FLOOR = 16;
	public static final int GROUND_FLOOR = 1;
	public static final int PEOPLE_IN_LIFT = 5;
	
	private  boolean isMoved = false; //�� ���������
	
	private int currentFloor = 1;
	
	private  Human[] arrayHuman;
	public Human emptyPlace = new Human(0,0);
	
	public  void addHuman(Human human) {
		
		for(int j = 0; j < PEOPLE_IN_LIFT; j++) {
			
			if(arrayHuman[j].equals(emptyPlace)) {
				arrayHuman[j] = human;
				break;
			}
		}		
	}
	
	public void goDown() {

		if(currentFloor>GROUND_FLOOR) {
			
			this.currentFloor--;
			Main.checkFloor(); // ���� �� ���� ������ ����
			checkExitLift();   // ���� �� ���� �������� ����� �� �����
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void goUp() {
		
		if(currentFloor<LAST_FLOOR) {
			
			this.currentFloor++;
			Main.checkFloor(); // ���� �� ���� ������ ����
			checkExitLift();   // ���� �� ���� �������� ����� �� �����
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void checkExitLift() {
			
			for(int i =0; i<Lift.PEOPLE_IN_LIFT; i++) {
				
				if(arrayHuman[i] == null) continue;
				if(arrayHuman[i].getWaitingFloor() == currentFloor) { // ���� �������� � ����� ����� �����
					isMoved = false;								  // �� ������������� ���
				}
			}		
		}
	
	public int getCurrentFloor() {
		return this.currentFloor;
	}
	
	public void setIsMoved(boolean value) {
		isMoved = value;
	}
	
	public Human getHuman(int i) {
		return arrayHuman[i];
	}
	
	
	public void run() {
		
		arrayHuman = new Human[] { emptyPlace, emptyPlace, emptyPlace, emptyPlace, emptyPlace };
		
		Display display = new Display ();
		Shell shell = new Shell(display, SWT.SHELL_TRIM & (~SWT.RESIZE));
		
		shell.setText("������, �������");
		shell.setSize(800,85);
		shell.setLayout(new GridLayout(6, false));
		shell.setLocation(415, 200);
		GridData gridData = new GridData();//����� �������
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		
	    Label placeLabel = new Label(shell,SWT.NONE);
	    placeLabel.setText("����� � �����:");
	    placeLabel.setLayoutData(gridData);
	    
	    gridData = new GridData();//����� �������
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		
	    Label[] arrayLabel = new Label[]{ 
                new Label(shell, SWT.CENTER),
                new Label(shell, SWT.CENTER),
                new Label(shell, SWT.CENTER),
                new Label(shell, SWT.CENTER),
                new Label(shell, SWT.CENTER)
        };
	    for(int i = 0; i < arrayLabel.length; i++) {
	    	arrayLabel[i].setText("��������");
	    	arrayLabel[i].setLayoutData(gridData);
	    }
	   
	    gridData = new GridData();//����� �������
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
	    Label operationLabel = new Label(shell, SWT.NONE);
	    operationLabel.setText("���������� ������:");
	    operationLabel.setLayoutData(gridData);
	 
	  
	    gridData = new GridData();//����� �������
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
	    Button upButton = new Button(shell, SWT.PUSH); 
	    upButton.setText("����� �����");
	    upButton.setLayoutData(gridData);
	    
	    
	    Button downButton = new Button(shell, SWT.PUSH); 
	    downButton.setText("����� ����");
	    downButton.setLayoutData(gridData);
	    
	    Button plantingButton = new Button(shell, SWT.PUSH); 
	    plantingButton.setText("�������");
	    plantingButton.setLayoutData(gridData);
	    
	    Label currentFloorLabel = new Label(shell, SWT.CENTER);
	    currentFloorLabel.setText("���� �� "+currentFloor+" �����");
	    currentFloorLabel.setLayoutData(gridData);
	        
	    upButton.addSelectionListener(new SelectionAdapter()
	     {		
	    	 @Override public void widgetSelected(final SelectionEvent e)
	    	 {
	    		 try {
 
	    			 isMoved = true;
	    			 
	    			 while(isMoved) {
	    				 
		    			 goUp();
		    			 currentFloorLabel.setText("���� �� "+currentFloor+" �����");
		    			 
		    			 if(currentFloor==LAST_FLOOR || isMoved == false) break;
	    			 }
	    		 }
	    		 catch(Exception ex ){
	    			 Main.showDialogMessage(shell, "UNKNOWN ERROR");
	    		 }
	    	 }
	     });
	    downButton.addSelectionListener(new SelectionAdapter()
	     {		
	    	 @Override public void widgetSelected(final SelectionEvent e)
	    	 {
	    		 try {
	    			 isMoved = true;
	    			 
	    			 while(isMoved) {
	    				 
	    				 goDown();
	    				 currentFloorLabel.setText("���� �� "+currentFloor+" �����");
	    				 
	    				 if(currentFloor<=GROUND_FLOOR || isMoved == false) break;
	    			 }
	    		}
	    		 catch(Exception ex ){
	    			 Main.showDialogMessage(shell, "UNKNOWN ERROR");
	    		 }
	    	 }
 
	     });
	    
	    plantingButton.addSelectionListener(new SelectionAdapter()
	     {		
	    	 @Override public void widgetSelected(final SelectionEvent e)
	    	 {
	    		 try {
	    			 int i;
	    			 	for(i = 0; i<PEOPLE_IN_LIFT; i++) {
	    			 		
	    			 		if(arrayHuman[i].equals(emptyPlace)) continue; // ����� �� ���������� �����
	    			 		
	    			 		if(arrayHuman[i].getWaitingFloor() == currentFloor) {
	    			 			
	    			 			arrayLabel[i].setText("C�������");
	    			 			
	    			 			Main.vectorHuman.get(arrayHuman[i].getNumberHuman()-1).isArrived = true;
	    			 			Main.vectorHuman.get(arrayHuman[i].getNumberHuman()-1).getDisplay().wake();
	    			 			arrayHuman[i] = emptyPlace;
	    			 		}
	    			  	}
	    			 	
	    			 	//if(i == PEOPLE_IN_LIFT ) Main.showDialogMessage(shell, "��� �����, ������� ����� ����� �� �����");
	    			 }
	
	    		 catch(Exception ex ){
	    			 Main.showDialogMessage(shell, "ERROR in planting button");
	    		 }
	    	 }

	     });
    	shell.open();
    	
    	while (!shell.isDisposed()) {
    		
    		for(int i = 0; i<PEOPLE_IN_LIFT; i++) {
    			if(arrayHuman[i]!= emptyPlace) {
    				arrayLabel[i].setText("������");
    			}
    		}	
    		if (!display.readAndDispatch())
            display.sleep();
    		}
    
   		display.dispose ();
		
	}
}
