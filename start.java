import javax.swing.SwingUtilities;




public class start {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run()
			{
				new SwingCode();
			}
			
		});

	}
}
