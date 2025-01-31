import java.io.IOException;

public class Encoder {

    public String origem_video_path;
    public String destino_video_path;

    public Encoder(String origem_video_path, String destino_video_path){
        this.origem_video_path = origem_video_path;
        this.destino_video_path = destino_video_path;
    }

    public static String CheckVersion(){
        String command = "-version";
        return command;
    }


    public static String Encode360p(String input, String output){
        String command = " -i " + input + " -vf scale=-1:540 -c:v libx264 -preset fast -crf 23 -c:a aac -b:a 128k " + output;
        return command;
    }

    public static String Encode540p(String input, String output){
        String command = "-loglevel quiet -i " + input + " -vf scale=-1:540 -c:v libx264 -preset fast -crf 23 -c:a aac -b:a 128k " + output;
        return command;
    }

    public static String Encode720p(String input, String output){
        String command = "-loglevel quiet -i " + input + " -vf scale=-1:720 -c:v libx264 -preset fast -crf 23 -c:a aac -b:a 128k " + output;
        return command;
    }

    public static String Encode1080p(String input, String output){
        String command = "-loglevel quiet -i " + input + " -vf scale=-1:1080 -c:v libx264 -preset fast -crf 23 -c:a aac -b:a 128k " + output;
        return command;
    }

    public static void Execute(String fullCommand){

        // Divide a string completa em partes
        String[] command = fullCommand.split(" ");

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.inheritIO(); // Para mostrar a saída no console
            Process process = processBuilder.start();
            int exitCode = process.waitFor(); // Aguarda o término do processo

            if (exitCode == 0) {
                System.out.println("Conversão concluída com sucesso!");
            } else {
                System.err.println("Erro na conversão. Código de saída: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }


}
