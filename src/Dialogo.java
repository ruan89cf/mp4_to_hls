public class Dialogo {

    public void InitialScreen() {

        String text_initial_dialog = """
                                
                Olá, este é nosso script para converter videos usando java, use as opções com cuidado e responsabilidade!
                """;

        System.out.print(text_initial_dialog);

    }

    public String DialogScreen() {

        String text_option = """
                
                1 - Encodar videos na pasta
                2 - Encodar legendas na pasta
                3 - Check episodes 
                
                """;

        System.out.print(text_option);

        var scanner = new java.util.Scanner(System.in);
        String option_choose = scanner.next();

        String encoder_option = "";

        if(option_choose.equals("1")) {

            String encoder_option_text = """
                                    
                    1 - Encode 360p
                    2 - Encode 540p
                    3 - Encode 360p to 1080p (If video support) 
                                    
                    """;
            System.out.println(encoder_option_text);
            encoder_option = scanner.next();

        } else if (option_choose.equals("2")){
            String encoder_option_text = """
                                    
                    1 - Encode subtitle to SRT
                    2 - Encode subtitle to VTT
                    3 - Encode subtitle to VTT and SRT 
                                    
                    """;
            System.out.println(encoder_option_text);
            encoder_option = scanner.next();

        } else if (option_choose.equals("3")){
            String encoder_option_text = """
                                    
                    1 - Check if has new episodes on themoviedb
                    2 - Check if has episodes missin on folder
                                    
                    """;
            System.out.println(encoder_option_text);
            encoder_option = scanner.next();

        }

        return option_choose + encoder_option;

    }


    }
