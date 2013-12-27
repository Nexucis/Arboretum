package com.ricm.arboretum;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * The sound class can play audio fragments.
 * The audio fragment must first be added (Sound.add), before it can be played (Sound.play).
 * The Sound.add method loads the audio fragment from the APK resources. 
 * The maximum number of audio fragments that can be loaded is set in the constructor.
 *
 * <p><strong>Example</strong> Add sound file res/raw/rollingswitch.ogg</p>
 * <pre class="prettyprint">
 *   Sound mSoundManager;
 *   mSoundManager = new Sound(this,5);
 *   int mRollingSwitch= mSoundManager.add(this, R.raw.rollingswitch);
 *   mSoundManager.play(mRollingSwitch, 0, 4f );
 * </pre>
 * 
 * @author Maarten Pennings
 * 2011 oct 10
 *
 */
public class SoundManager {

	private SoundPool     mSoundPool;    // to store and play sound fragments
	private AudioManager  mAudioManager; // to control the volume.

	/**
	 * Creates a Sound object that plays audio fragments (using play). 
	 * The audio fragments have to be added first to the object (using add) before they can be played.
	 *  
	 * @param context    The context that holds the audio service.
	 * @param max        The maximum number of audio fragments that can be played simultaneously.
	 */
	public SoundManager( Context context, int max ) {
		mSoundPool    = new SoundPool( max, AudioManager.STREAM_MUSIC, 0 );
		mAudioManager = (AudioManager)context.getSystemService( Context.AUDIO_SERVICE );
	}

	/**
	 * Adds an audio resource to the Sound object. The audio resource is identified through its 
	 * resource id (resId), which should be a resource of the passed context.
	 * 
	 * @param context The context of the resource identified by resId.
	 * @param resId   The id of the audio resource.
	 * @return        The sound id; this is a handle to the added audio resource, to be used when calling play. 
	 */
	public int add( Context context, int resId ) {
		int soundId= mSoundPool.load( context, resId ,1 );
		return soundId;
	}

	/**
	 * Plays the audio fragment that was previously add'ed.
	 * It can be played multiple times (see repeat), and slower or faster then real time (see rate).
	 * 
	 * @param soundId The id of the sound, as returned by add.
	 * @param repeat  The number of <em>repeats</em> (so repeat=0 to play once); repeat=-1 for infinite.
	 * @param rate    Speed-up factor (1=normal speed, 2 is twice as fast, 0.5 is half the speed). 
	 * @return        The stream id; this is a handle to the fragment being played, to be used when calling stop. 
	 */
	public int play( int soundId, int repeat, float rate ) {
		float streamVolume= mAudioManager.getStreamVolume (AudioManager.STREAM_MUSIC );
		streamVolume= streamVolume / mAudioManager.getStreamMaxVolume( AudioManager.STREAM_MUSIC );
		int streamId= mSoundPool.play( soundId, streamVolume, streamVolume, 1, repeat, rate );
		return streamId;
	}

	/**
	 * Plays the audio fragment from left to right within the specific duration (see panDuration)
	 * 
	 * @param soundId The id of the sound, as returned by add.
	 * @param repeat  The number of <em>repeats</em> (so repeat=0 to play once); repeat=-1 for infinite.
	 * @param rate    Speed-up factor (1=normal speed, 2 is twice as fast, 0.5 is half the speed). 
	 * @param panDuration 	After that time the audio sound should be on the right channel in ms.
	 * @return 				The stream id; this is a handle to the fragment being played, to be used when calling stop. 
	 */
	public int play3DPan(final int soundId, final int panDuration) {

		int streamId = -1;
		
		// Put your code here
		
		return streamId;
	}

	/**
	 * Plays the audio fragment that was previously add'ed.
	 * The audio fragment is played once at normal speed; for other choices see alternate play method.
	 * 
	 * @param soundId The id of the sound, as returned by add.
	 * @return        The stream id; this is a handle to the fragment being played, to be used when calling stop. 
	 */
	public int play( int soundId ) {
		return play( soundId, 0, 1.0f );
	}

	/**
	 * Stops the audio fragment that was started with play.
	 * 
	 * @param streamId  The id of the stream, as was returned by play.
	 */
	public void stop( int streamId) {
		mSoundPool.stop( streamId );
	}

}


