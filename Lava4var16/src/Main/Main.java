package Main;
import java.io.IOException;
import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import Essences.*;
public class Main {

	public static Vector<Human> vectorHuman = new Vector<Human>(); 
	public static Lift lift = new Lift();
	
	public static void main(String[] args) {	

		lift.start();
		Human.serialNumberHuman = 0;
		
		Display display = new Display ();
		Shell shell = new Shell(display, SWT.SHELL_TRIM & (~SWT.RESIZE));
		
		shell.setText("Поехали...");
		shell.setSize(210,200);
		shell.setLayout(new GridLayout());
		shell.setLocation(200, 200);
		GridData gridData = new GridData();
		
		Button сreateHumanButton = new Button(shell, SWT.PUSH); // Кнопка типа ПУШ
	    сreateHumanButton.setText("Вызвать лифт");
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		сreateHumanButton.setLayoutData(gridData);
		
		Label findingLabel = new Label(shell,SWT.NONE);
	    findingLabel.setText("На каком этаже вы находитесь?))");
	    findingLabel.setLayoutData(gridData);
	    
	    Text findingText = new Text(shell, SWT.NONE);
	    findingText.setLayoutData(gridData);
	    
	    Label waitingLabel = new Label(shell, SWT.NONE);
	    waitingLabel.setText("На какой этаж вы хотите поехать?))");
	    waitingLabel.setLayoutData(gridData);
	   
	    Text waitingText = new Text(shell, SWT.NONE);
	    waitingText.setLayoutData(gridData);
	   
	    сreateHumanButton.addSelectionListener(new SelectionAdapter()
	     {		
	    	 @Override public void widgetSelected(final SelectionEvent e)
	    	 {
	    		 try {
	    			 
	    		 Integer waitingFloor = Integer.parseInt(waitingText.getText());
	    		 Integer findingFloor = Integer.parseInt(findingText.getText());
	    		 
	    		 if(waitingFloor == findingFloor) throw new IOException();
	    		 if(waitingFloor < Lift.GROUND_FLOOR || waitingFloor > Lift.LAST_FLOOR || findingFloor < Lift.GROUND_FLOOR || findingFloor > Lift.LAST_FLOOR)   	
	    		 		throw new Exception();
	    		 
	    		 createHuman(waitingFloor, findingFloor);
	    		 findingText.setText("");
    			 waitingText.setText("");
	    		 }
	    		 catch(IOException ww) {
	    			 
	    			 showDialogMessage(shell, " Вы не можете поехать на тот этаж, на котором находитесь");
	    			 findingText.setText("");
	    			 waitingText.setText("");
	    			 
	    		 }
	    		 catch(Exception ex ){
	    			 
	    			 showDialogMessage(shell, "Вы находитесь в "+Lift.LAST_FLOOR+"-этажном здании, введите корректные значения");
	    			 findingText.setText("");
	    			 waitingText.setText("");
	    			 
	    		 }
	    	 }
   
	     });
	     
    	shell.open();
    	while (!shell.isDisposed()) {
    		if (!display.readAndDispatch())
            display.sleep();
    		}
   		display.dispose ();
	}
	
	public static void showDialogMessage(Shell shell, String message) {
		
        MessageBox messageBox = new MessageBox(shell);
        messageBox.setText ("ERROR");
        messageBox.setMessage (message);
        messageBox.open();  
    }
	
		public static void createHuman(int waitingFloor, int findingFloor){
			
		 Human.serialNumberHuman++;
		 vectorHuman.add(new Human(waitingFloor, findingFloor ));
		 vectorHuman.get(vectorHuman.size()-1).start();	 
	}
		
	public static void checkFloor() {
		for(int i = 0; i<vectorHuman.size(); i++) {
			if(lift.getCurrentFloor() == vectorHuman.get(i).getFindingFloor()) {
				
					lift.setIsMoved(false);
					vectorHuman.get(i).getDisplay().wake();	// чтобы обновилось окно с этим человеком	
				}	
		}
	}
	
	public static Lift getLift() {
		return lift;
	}
}
