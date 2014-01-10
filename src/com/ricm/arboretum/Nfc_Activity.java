package com.ricm.arboretum;



import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

public class Nfc_Activity extends Activity {

	public final static String EXTRA_MESSAGE = "com.ricm.arboretum.PLANETE";
	private static final String TAG = "NFC_Activity";
	private static boolean no_nfc=false;
	
	protected NfcAdapter mNfcAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//Toast.makeText(this, getPackageName(), Toast.LENGTH_SHORT).show();
		this.mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
		if (mNfcAdapter == null || !mNfcAdapter.isEnabled()) {
			Toast.makeText(this, R.string.no_NFC, Toast.LENGTH_SHORT).show();
			no_nfc= true;
		}
//		Intent intent = getIntent();
//		resolveIntent(intent);
	}
	
	private void resolveIntent(Intent intent) { //Pour resoudre les differents intent, en particulier ceux du NFC
		// When an NFC tag is being written, call the write tag function when an intent is
		// received that says the tag is within range of the device and ready to be written to
		Log.v(TAG, "resolveIntent : "+intent.getAction().toString());
		String action = intent.getAction();
		if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)){
			Log.v(TAG, "Intent NDEF receved");
			Log.v(TAG, "Lecture d'un NFC de type "+intent.getType());
			if(intent.getType() != null && intent.getType().equals("application/" + getPackageName())) {
				// Read the first record which contains the NFC data
				Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
				NdefRecord relayRecord = ((NdefMessage)rawMsgs[0]).getRecords()[0];
				String nfcData = new String(relayRecord.getPayload());

				Log.v(TAG, "Message lu : "+nfcData);
				//Rajouté ici le traitement associé au tag 
				//Toast.makeText(this, "Message lu :" + nfcData, Toast.LENGTH_SHORT).show();
				
				Intent intentWeb = new Intent(this,DescriptionArbo.class);
				String message = nfcData.toString();
			    intentWeb.putExtra(EXTRA_MESSAGE, message);
				startActivity(intentWeb);

				
			} else {
				Log.e(TAG, "Type du NFC inconnu");
				Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
				NdefRecord relayRecord = ((NdefMessage)rawMsgs[0]).getRecords()[0];
				Log.e(TAG, relayRecord.toString());
			}
		} else { 
			Log.e(TAG,"Intent non traité : "+intent.getAction());
		}

	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Intent intent = new Intent(this, this.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
		
		IntentFilter ndef = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
	    try {
	        ndef.addDataType("application/"+getPackageName());    /* Handles all MIME based dispatches.
	                                       You should specify only the ones that you need. */
	    }
	    catch (MalformedMimeTypeException e) {
	        throw new RuntimeException("fail", e);
	    }
		
		IntentFilter[] filters = {ndef,};
		String[][] techListArray = null;
		if (!no_nfc)mNfcAdapter.enableForegroundDispatch(this, pIntent, filters, techListArray);
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if (!no_nfc)mNfcAdapter.disableForegroundDispatch(this);
	}
	
	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Log.v(TAG, "onNewIntent");
		resolveIntent(intent);
	}
}
