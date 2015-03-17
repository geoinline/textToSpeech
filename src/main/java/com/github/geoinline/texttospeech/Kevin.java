package com.github.geoinline.texttospeech;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.EngineStateError;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;

public enum Kevin implements SpeechAgent {

    Instance;
    private static Synthesizer synthesizer;
    private boolean isInitialized = init();

    private static boolean init() {
        try {
            SynthesizerModeDesc desc = null;
            if (desc == null) {
                System.setProperty("freetts.voices",
                        "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                desc = new SynthesizerModeDesc(Locale.US);
                Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
                synthesizer = Central.createSynthesizer(desc);
                synthesizer.allocate();
                synthesizer.resume();
                SynthesizerModeDesc smd
                        = (SynthesizerModeDesc) synthesizer.getEngineModeDesc();
                Voice[] voices = smd.getVoices();
                Voice voice = null;
                for (int i = 0; i < voices.length; i++) {
                    if (voices[i].getName().equals("kevin16")) {
                        voice = voices[i];
                        break;
                    }
                }
                synthesizer.getSynthesizerProperties().setVoice(voice);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static void terminate() throws EngineException, EngineStateError {
        Kevin.synthesizer.deallocate();
    }

    public void speak(String input) {
        Kevin.synthesizer.speakPlainText(input, null);
        try {
            Kevin.synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
        } catch (InterruptedException ex) {
            Logger.getLogger(Kevin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Kevin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
