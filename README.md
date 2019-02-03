# Transcriber
Google Speech API Based Speech Recognition Application Through .flac Files


Most computers have this but ensure that your computer has Java installed, specifically the Java Runtime Environment. You will also have to download an audio managing software called "FFmpeg". Here is the link to the download for that:


https://ffmpeg.zeranoe.com/builds/


On this screen, for version, you want to select the Nightly Build, which is titled as the current day, for example "20180803". Then, for architecture, select Windows 32 bit. For Linking, select Static.

![1](https://user-images.githubusercontent.com/30887959/43978739-27b2c38e-9c9d-11e8-8745-2fb849bdb31c.png)

Once you download the software, you will have to unzip the file to a location that is available. Now that you have done that, go inside the ffmpeg folder you unzipped and you will see a folder called bin. You need to set the bin folder as an environment variable on your computer. To do this, click the windows button and in the search bar, search "edit environment variables for your account" and click on that. There you will see a screen like this:

![2](https://user-images.githubusercontent.com/30887959/43978750-33e021e2-9c9d-11e8-9da2-dc3fefa24f58.png)

Under the "user variables" section, click new and for Variable Name, put in "Path" and in the variable value, put the location of the bin folder in your computer. For example, your bin folder location could be :"C:\Users\kevinx20\Desktopffmpeg-20180803-5aeb3b0-win32-static\bin".

![3](https://user-images.githubusercontent.com/30887959/43978759-39d9f9ba-9c9d-11e8-8249-1f12bb231795.png)

While doing this, you will need to add another variable called "GOOGLE_APPLICATION_CREDENTIALS". For the variable value, create a Google API Services account and then download a Google Applications Credentials files from Google. The instructions to this are located here:

https://cloud.google.com/docs/authentication/production

Now that you have downloaded the file, put the location of the downloaded file as the variable value. For example, it could be: "C:\Users\kevinx20\Desktop\Test\Transcriber-1f087732c43a.json"

![4](https://user-images.githubusercontent.com/30887959/43978769-4240b616-9c9d-11e8-85f2-b038917b9bbc.png)

In order to verify that all this worked, open up command prompt. To do this, search "cmd.exe" in the windows search bar. In the window, simply type "ffmpeg". If all is correct, you should see something like this:

![5](https://user-images.githubusercontent.com/30887959/43978778-4926e388-9c9d-11e8-9575-08622785612f.png)

Now it's time to actually use ffmpeg. What it will do is convert whatever audio file you want to transcribe into an audio format that is compatible with the application. Since the application only accepts ".flac" file formats, that is what you will be converting your audio into. Also, the audio needs to mono-channel and at a sampling rate of 16000 HZ but that will be important later. Head back to your command prompt window and traverse to where your audio file is located. To do this, we will need to utilize several command prompt commands, primarily the "cd" command which allows us to change directories within the command prompt window. This is a little more complicated so if you are stuck you can go online and look up some tutorials such as this one:

https://www.digitalcitizen.life/command-prompt-how-use-basic-commands (read the section on how to navigate folders)


Let's say your audio file named "output.mp3" is currently on your Desktop in a folder called "Test", then from the initial directory, you will have to use the command "cd Desktop" and press enter and then enter "cd test" and press enter again. 

![6](https://user-images.githubusercontent.com/30887959/43978782-4ef0144c-9c9d-11e8-8e8d-b86c6e84b20e.png)


You will cd to different locations depending on where your audio file is located. Now that you are in the directory of your audio file. You will use a command to convert the files. The command format is: 

ffmpeg -i [original file name] -ac 1 -ar 16000 [desired output name]


For Example, if you wanted to convert an .mp3 audio file called "output" to a .flac file called "output2" which we need to do in this situation, then the command would be: 
ffmpeg -i output.mp3 -ac 1 -ar 16000 output2.flac
If the command worked, then you should see something like this:

![7](https://user-images.githubusercontent.com/30887959/43978790-54fa3dd6-9c9d-11e8-8def-757772f110e5.png)

In the folder where your original audio file was, there will be a new .flac file that you just created. We need to upload that .flac file to the Google Cloud Storage. The storages are known as buckets and in order to access them, you will need a google account and a corresponding Gmail account. Then, I will need to give you permission to manage the buckets in order to upload and manage the items within. In order to do that, I need your gmail address so respond to this email with your gmail address so that I can add you to the bucket. However, in order for your gmail address to be valid, your Google account needs to be valid and active. I think this means that your Google account needs to registered for Google+ so if you don't have a corresponding Google+ account, register for one. Once you gain permissions, follow this link to manage the bucket:

https://console.cloud.google.com/storage/transcriberproject/

![8](https://user-images.githubusercontent.com/30887959/52184749-158ec300-27cc-11e9-97ec-41938407cf3e.png)


Here, there are options to upload files. You want to upload the .flac file you just converted. In the picture above, I uploaded a file called "output2.flac" to the bucket. Once you have done that, you can finally open up the .jar application that I have attached to repository under the name of "TranscriptionApplication" or you can open up the classes and download those if you are interested in the project. Anyway, download the jar file and simply run it by double clicking. You should be directed to a screen like this:

![9](https://user-images.githubusercontent.com/30887959/43978807-6595d132-9c9d-11e8-858e-3e1efd02a24f.png)

Follow the instructions and click the "Select .flac File" button and use the window that pops out in order to find the .flac file:

 ![10](https://user-images.githubusercontent.com/30887959/43978808-6b5d2cc8-9c9d-11e8-9d73-7d2341e5b77f.png)

Do the same thing for the output location where you want the final text file with the transcription inside to be made. Once you setup all the locations, you should fill both of the boxes that designate the locations like this:

![11](https://user-images.githubusercontent.com/30887959/43978820-71b05154-9c9d-11e8-96ab-d686734f176d.png)

Click "Run". If it is working correctly, you will have to wait for a while before you are notified that the transcription is complete and the text file called "transcription.txt" is created:

![12](https://user-images.githubusercontent.com/30887959/43978831-7a00bea2-9c9d-11e8-90a9-1b71650037e5.png)

Thanks for making it this far. I hope you've learned something. If you want to learn more about how it works, you can head over to Google Speech API which is the underlying technology behind the application:
https://cloud.google.com/speech-to-text/
