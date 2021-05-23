package element;

import java.nio.file.Paths;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class Audio {

	public static void createBackgroundMusic() {
		String bip = "bg.mp3";
		AudioClip mediaPlayer = new AudioClip(ClassLoader.getSystemResource(bip).toString());
		mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
		mediaPlayer.setVolume(5);
		mediaPlayer.play();
	}

	public static void createBackgroundMusicStop() {
		String bip = "bg.mp3";
		AudioClip mediaPlayer = new AudioClip(ClassLoader.getSystemResource(bip).toString());
		mediaPlayer.stop();
	}

	public static void createChooseMapMusic() {
		String bip = "wait.mp3";
		AudioClip mediaPlayer = new AudioClip(ClassLoader.getSystemResource(bip).toString());
		mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
		mediaPlayer.setVolume(5);
		mediaPlayer.play();
	}

	public static void createChooseMapMusicStop() {
		String bip = "wait.mp3";
		AudioClip mediaPlayer = new AudioClip(ClassLoader.getSystemResource(bip).toString());
		mediaPlayer.stop();
	}

	public static void createMouseClickedSound() {
		String bip = "click.wav";
		AudioClip mediaPlayer = new AudioClip(ClassLoader.getSystemResource(bip).toString());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createMouseClickedErrorSound() {
		String bip = "click_error.wav";
		AudioClip mediaPlayer = new AudioClip(ClassLoader.getSystemResource(bip).toString());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createGameSound() {
		String bip = "start.mp3";
		AudioClip mediaPlayer = new AudioClip(ClassLoader.getSystemResource(bip).toString());
		mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createGameSoundStop() {
		String bip = "start.mp3";
		AudioClip mediaPlayer = new AudioClip(ClassLoader.getSystemResource(bip).toString());
		mediaPlayer.stop();
	}

	public static void createPlaceSound() {
		String bip = "place.mp3";
		AudioClip mediaPlayer = new AudioClip(ClassLoader.getSystemResource(bip).toString());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createCollectSunSound() {
		String bip = "collect.mp3";
		AudioClip mediaPlayer = new AudioClip(ClassLoader.getSystemResource(bip).toString());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createCrashSound() {
		String bip = "crash.mp3";
		AudioClip mediaPlayer = new AudioClip(ClassLoader.getSystemResource(bip).toString());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createExplodeSound() {
		String bip = "explode.mp3";
		AudioClip mediaPlayer = new AudioClip(ClassLoader.getSystemResource(bip).toString());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}
	
	public static void createMowerSound() {
		String bip = "mower.mp3";
		AudioClip mediaPlayer = new AudioClip(ClassLoader.getSystemResource(bip).toString());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createGameEndingLoseMusic() {
		String bip = "lose.mp3";
		AudioClip mediaPlayer = new AudioClip(ClassLoader.getSystemResource(bip).toString());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createGameEndingWinMusic() {
		String bip = "win.mp3";
		AudioClip mediaPlayer = new AudioClip(ClassLoader.getSystemResource(bip).toString());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

}
