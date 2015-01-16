package ie.gmit.computing;




import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class PreferencesC extends Activity {
	
	private TextView checkbox=null;
	private TextView txtName=null;
	private TextView txtShip=null;
	private TextView txtEmail=null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.xml.preferences);
		
		checkbox=(TextView)findViewById(R.id.checkbox);
		txtName=(TextView)findViewById(R.id.sName);
		txtShip=(TextView)findViewById(R.id.shipName);
		txtEmail=(TextView)findViewById(R.id.sEmail);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		SharedPreferences prefs=PreferenceManager
						.getDefaultSharedPreferences(this);
		checkbox.setText(new Boolean(prefs.getBoolean("checkbox", false))
								.toString());
		txtName.setText(prefs.getString("text", "<sName>"));
		txtShip.setText(prefs.getString("text", "<txtShip>"));
		txtEmail.setText(prefs.getString("text", "<shipName>"));
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.my_menu, menu);
    	return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {       
			case R.id.edit_pref:
			startActivity(new Intent(PreferencesC.this, EditPreferences.class));        
			return true;      
		}  
		return(super.onOptionsItemSelected(item));
	}
}