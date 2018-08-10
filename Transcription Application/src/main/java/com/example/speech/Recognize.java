package com.example.speech;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeMetadata;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeResponse;
import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig.AudioEncoding;
import com.google.cloud.speech.v1p1beta1.RecognizeResponse;
import com.google.cloud.speech.v1p1beta1.SpeechClient;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;
import com.google.cloud.speech.v1p1beta1.WordInfo;
import com.google.protobuf.ByteString;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Recognize {
	public static String god1="";
	public static  List<SpeechRecognitionResult> results1;
  /** Run speech recognition tasks. */
  public static void main(String... args) throws Exception {
	  //AuthExample.authExplicit("./Transcriber-1f087732c43a.json");
	  asyncRecognizeGcs("gs://transcriberproject/output2.flac");

  }
  	
 
  public static void syncRecognizeFile(String fileName) throws Exception {
    try (SpeechClient speech = SpeechClient.create()) {
      Path path = Paths.get(fileName);
      byte[] data = Files.readAllBytes(path);
      ByteString audioBytes = ByteString.copyFrom(data);

      // Configure request with local raw PCM audio
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

      RecognizeResponse response = speech.recognize(config, audio);
      List<SpeechRecognitionResult> results = response.getResultsList();

      for (SpeechRecognitionResult result : results) {
       
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcription: %s%n", alternative.getTranscript());
      }
    }
  }


  public static void syncRecognizeWords(String fileName) throws Exception {
    try (SpeechClient speech = SpeechClient.create()) {
      Path path = Paths.get(fileName);
      byte[] data = Files.readAllBytes(path);
      ByteString audioBytes = ByteString.copyFrom(data);

     
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .setEnableWordTimeOffsets(true)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

      // Use blocking call to get audio transcript
      RecognizeResponse response = speech.recognize(config, audio);
      List<SpeechRecognitionResult> results = response.getResultsList();

      for (SpeechRecognitionResult result : results) {
       
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcription: %s%n", alternative.getTranscript());
        for (WordInfo wordInfo : alternative.getWordsList()) {
          System.out.println(wordInfo.getWord());
          System.out.printf(
              "\t%s.%s sec - %s.%s sec\n",
              wordInfo.getStartTime().getSeconds(),
              wordInfo.getStartTime().getNanos() / 100000000,
              wordInfo.getEndTime().getSeconds(),
              wordInfo.getEndTime().getNanos() / 100000000);
        }
      }
    }
  }



 
  public static void asyncRecognizeFile(String fileName) throws Exception {
  
    try (SpeechClient speech = SpeechClient.create()) {

      Path path = Paths.get(fileName);
      byte[] data = Files.readAllBytes(path);
      ByteString audioBytes = ByteString.copyFrom(data);


      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

    
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> response =
          speech.longRunningRecognizeAsync(config, audio);

      while (!response.isDone()) {
        System.out.println("Waiting for response...");
        Thread.sleep(10000);
      }

      List<SpeechRecognitionResult> results = response.get().getResultsList();

      for (SpeechRecognitionResult result : results) {
       
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcription: %s%n", alternative.getTranscript());
      }
    }
  }

  
  public static void asyncRecognizeGcs(String gcsUri) throws Exception {
	 
		SpeechClient speech = SpeechClient.create();		
	
    
  
      // Configure remote file request for Linear16
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.FLAC)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

    
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> response =
          speech.longRunningRecognizeAsync(config, audio);
      while (!response.isDone()) {
        System.out.println("Waiting for response...");
        Thread.sleep(10000);
      }

      List<SpeechRecognitionResult> results = response.get().getResultsList();
      god1=results.toString();
      results1=results;
      for (SpeechRecognitionResult result : results) {
    
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcription: %s\n", alternative.getTranscript());
      }
    }
  


 
 

   
  
}