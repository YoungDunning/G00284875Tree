package ie.gmit.computing;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DynamicTreePage extends Activity {
	
	public Node currentNode = new Node("", null);
	private int n = 20;
	int i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dynamic_tree_page, menu);
		return true;
	}
	
	public void refreshScreen(Node node)
	{
		setContentView(R.layout.activity_dynamic_tree_page);
		LinearLayout buttons = (LinearLayout)findViewById(R.id.dynamicBtns);

		Button backBtn = (Button) findViewById(R.id.btnBack);
		backBtn.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View view)
			{
				if(currentNode.getParent() != null)
				{
					refreshScreen(currentNode.getParent());
				}
			}
		});
		
		currentNode = node;
		TextView title = (TextView) findViewById(R.id.current);
		title.setText(currentNode.getName());
		if(currentNode.getChildren() != null)
		{
			List<Node> children = currentNode.getChildren();
			for (i = 0; i < children.size(); i++) 
			{
				Button button = new Button(this);
				button.setText(children.get(i).getName().toString());
				button.setId(i);
				final int buttonID = button.getId();
				buttons.addView(button);
				button.setOnClickListener(new View.OnClickListener() 
				{
					public void onClick(View view) 
					{
						refreshScreen(currentNode.getChildren().get(buttonID));
					}
				});
			}
		}/****/
	}
}
