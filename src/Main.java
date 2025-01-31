import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        //Pasta de origem dos arquivos de videos
        String origem_video_path = "C:\\Users\\Ruan\\IdeaProjects\\encode\\out\\production\\encode\\";
        String destino_video_path = "C:\\Users\\Ruan\\IdeaProjects\\encode\\out\\production\\encode\\";

        if (origem_video_path.isEmpty()){
            origem_video_path = Paths.get("").toAbsolutePath().toString();
        }

        String os = System.getProperty("os.name").toLowerCase();
        String ffmpegPath = "";

        if (os.contains("win")) {
            // Caminho para o FFmpeg no Windows (dentro dos recursos)
            ffmpegPath = "resources/windows/bin/ffmpeg.exe";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            // Caminho para o FFmpeg no Linux (dentro dos recursos)
            ffmpegPath = "resources/linux/bin/ffmpeg";
        }

        // Inicia o encoder na Stack
        var encoder = new Encoder(origem_video_path,destino_video_path);

        // Inicia Checkfiles
        var checkfiles = new Checkfiles();
        checkfiles.setDirectory(origem_video_path);


        var Dialogo = new Dialogo();
        Dialogo.InitialScreen();
        String userChoice = Dialogo.DialogScreen();
        String fileInProcess =  Checkfiles.getFile();

        if(userChoice.equals("11")){

            Encoder.Execute(ffmpegPath + " " + Encoder.Encode360p(origem_video_path + fileInProcess, destino_video_path + "saida.mkv"));

        } else if(userChoice.equals("12")){

            Encoder.Execute(ffmpegPath + " " + Encoder.Encode360p(origem_video_path + fileInProcess, destino_video_path + "saida.mkv"));
            Encoder.Execute(ffmpegPath + " " + Encoder.Encode540p(origem_video_path + fileInProcess, destino_video_path + "saida.mkv"));

        } else if(userChoice.equals("13")){

            Encoder.Execute(ffmpegPath + " " + Encoder.Encode360p(origem_video_path + fileInProcess, destino_video_path + "saida.mkv"));
            Encoder.Execute(ffmpegPath + " " + Encoder.Encode540p(origem_video_path + fileInProcess, destino_video_path + "saida.mkv"));
            Encoder.Execute(ffmpegPath + " " + Encoder.Encode720p(origem_video_path + fileInProcess, destino_video_path + "saida.mkv"));
            Encoder.Execute(ffmpegPath + " " + Encoder.Encode1080p(origem_video_path + fileInProcess, destino_video_path + "saida.mkv"));

        }

        if(userChoice.equals("2")){

            System.out.println("  2 - Encodar legendas na pasta");

        } else if(userChoice.equals("3")){

            System.out.println("   3 - Check episodes");

        }



        var Checkfiles = new Checkfiles();
        Checkfiles.setDirectory(origem_video_path);




    }

}


