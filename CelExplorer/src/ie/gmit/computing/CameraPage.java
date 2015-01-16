package ie.gmit.computing;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class CameraPage extends Activity {

	Button btnTakePhoto;
	ImageView imgTakenPhoto;
	private static final int CAM_REQUEST = 1313;
	private static final float LOCATION_REFRESH_DISTANCE = 0;
	private static final long LOCATION_REFRESH_TIME = 0;
	private final LocationListener mLocationListener = new LocationListener() {
		
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			
		}
	};	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_page);
        
        btnTakePhoto = (Button) findViewById(R.id.button1);
        imgTakenPhoto = (ImageView) findViewById(R.id.imageview1);
        
        btnTakePhoto.setOnClickListener(new btnTakePhotoClicker());
    
        LocationManager mLocationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_REFRESH_TIME
        		,LOCATION_REFRESH_DISTANCE, mLocationListener);
        
        
        /**
         * GPSTracking code snippet
         */
        GPSTracker mGPS = new GPSTracker(this);
		
		TextView text = (TextView) findViewById(R.id.texts);
		if(mGPS.canGetLocation ){
		mGPS.getLocation();
		text.setText("Lat"+mGPS.getLatitude()+"\nLon"+mGPS.getLongitude());
		}
		else
		{
		    text.setText("Unabletofind");
		    System.out.println("Unable");
		}
		
		Button treeScreen = (Button)findViewById(R.id.dynamicTree);
		treeScreen.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(CameraPage.this, DynamicTreePage.class);
				startActivity(intent);
			}
		});
    }
    
    

    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == CAM_REQUEST)
		{
			Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
			imgTakenPhoto.setImageBitmap(thumbnail);
		}
	}


    class btnTakePhotoClicker implements Button.OnClickListener
    {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(cameraIntent, CAM_REQUEST);
		}
    	
    }
}
