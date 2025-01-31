    import java.io.File;

    public class Checkfiles
    {

        public static String directory;

        public void setDirectory(String directory){
            this.directory = directory;
        }

        public static String getFile(){

        File directory_stack = new File(directory);

        File[] mp4Files = directory_stack.listFiles((dir, name) -> name.endsWith(".mp4"));

            if (mp4Files != null && mp4Files.length > 0) {
                for (File file : mp4Files) {
                    System.out.println("Arquivo encontrado: " + file.getName());
                    return file.getName();
                }

            }
            return "Nenhum arquivo .mp4 encontrado ou o diretório está vazio.";
        }



    }
