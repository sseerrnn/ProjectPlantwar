package element;

import java.nio.file.Paths;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class Audio {

	public static void createBackgroundMusic() {
		String bip = "audio/bg.mp3";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
		mediaPlayer.setVolume(5);
		mediaPlayer.play();
	}

	public static void createBackgroundMusicStop() {
		String bip = "audio/bg.mp3";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.stop();
	}

	public static void createChooseMapMusic() {
		String bip = "audio/wait.mp3";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
		mediaPlayer.setVolume(5);
		mediaPlayer.play();
	}

	public static void createChooseMapMusicStop() {
		String bip = "audio/wait.mp3";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.stop();
	}

	public static void createMouseClickedSound() {
		String bip = "audio/click.wav";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createMouseClickedErrorSound() {
		String bip = "audio/click_error.wav";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createGameSound() {
		String bip = "audio/start.mp3";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createGameSoundStop() {
		String bip = "audio/start.mp3";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.stop();
	}

	public static void createPlaceSound() {
		String bip = "audio/place.mp3";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createCollectSunSound() {
		String bip = "audio/collect.mp3";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createCrashSound() {
		String bip = "audio/crash.mp3";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createExplodeSound() {
		String bip = "audio/explode.mp3";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}
	
	public static void createMowerSound() {
		String bip = "audio/mower.mp3";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createGameEndingLoseMusic() {
		String bip = "audio/lose.mp3";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

	public static void createGameEndingWinMusic() {
		String bip = "audio/win.mp3";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		AudioClip mediaPlayer = new AudioClip(hit.getSource());
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
	}

}
