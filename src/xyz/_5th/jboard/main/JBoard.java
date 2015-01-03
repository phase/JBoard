package xyz._5th.jboard.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class JBoard implements NativeKeyListener {

	public static void main(String[] args) {
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			System.err.println("Problem registering native hook.");
			System.err.println(e.getMessage());
			System.exit(1);
		}
		GlobalScreen.getInstance().addNativeKeyListener(new JBoard());
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		String keyText = NativeKeyEvent.getKeyText(e.getKeyCode());
		if (keyText.startsWith("NumPad ")) {
			System.out.println("Key Pressed: " + keyText);
			int code = Integer.parseInt(keyText.split(" ")[1]);
			try {

				List<AudioInputStream> sounds = new ArrayList<AudioInputStream>();
				sounds.add(AudioSystem.getAudioInputStream(new File("res/AIRHORN.wav"))); // 0
				sounds.add(AudioSystem.getAudioInputStream(new File("res/SMOKE WEED EVERYDAY.wav")));// 1
				sounds.add(AudioSystem.getAudioInputStream(new File("res/2SAD4ME.wav"))); // 2
				sounds.add(AudioSystem.getAudioInputStream(new File("res/Oh Baby A Triple.wav"))); // 3
				sounds.add(AudioSystem.getAudioInputStream(new File("res/wow.wav"))); // 4
				sounds.add(AudioSystem.getAudioInputStream(new File("res/HITMARKER.wav"))); // 5
				sounds.add(AudioSystem.getAudioInputStream(new File("res/gunshot.wav"))); // 6
				sounds.add(AudioSystem.getAudioInputStream(new File("res/NEVER DONE THAT.wav"))); // 7
				sounds.add(AudioSystem.getAudioInputStream(new File("res/SANIC.wav"))); // 8
				sounds.add(AudioSystem.getAudioInputStream(new File("res/MOM GET THE CAMERA.wav")));// 9

				Clip c = AudioSystem.getClip();
				c.open(sounds.get(code));
				c.start();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (LineUnavailableException e1) {
				e1.printStackTrace();
			} catch (UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {

	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {

	}

}
