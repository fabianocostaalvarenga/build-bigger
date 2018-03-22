package com.udacity.libjokes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jokes {

    public static String getRandomJoke(){
        Random random = new Random();
        int position = random.nextInt(listJokes().size());
        return listJokes().get(position);
    }

    private static List<String> listJokes() {
        ArrayList<String> jokes = new ArrayList<String>();
        jokes.add("Três pedreiros entram de férias e vão a praia pela primeira vez.\n" +
                "\n" +
                "O primeiro diz: tanta água!\n" +
                "\n" +
                "O segundo diz: tanta areia!\n" +
                "\n" +
                "Aí o terceiro diz : vamos embora antes que alguém traga o cimento! ");
        jokes.add("Mamãe, mamãe, de onde viemos??\n" +
                "\n" +
                "– Filho o homem é descendente de Adão e Eva.\n" +
                "– Mas o papai me disse que o homem descende do macaco.\n" +
                "– Uma coisa é a família de seu pai, outra coisa é a minha.");
        jokes.add("Pai vou me divorciar… Faz 6 meses que minha mulher não fala comigo.\n" +
                "\n" +
                "O pai fica em silêncio…da um gole na cerveja e diz:\n" +
                "\n" +
                "– Pense bem meu filho… mulher assim é difícil de arranjar…");
        jokes.add("A mulher vê o marido chegar em casa:\n" +
                "– Nossa, Dagoberto! Como cinco uísques te modificam!\n" +
                "– Que papo é esse, mulher? Eu não bebi cinco uísques.\n" +
                "– Mas eu bebi…");
        jokes.add("O bêbado atravessa a rua e um carro buzina bibi…\n" +
                "\n" +
                "O bêbado olha pro carro e diz:\n" +
                "\n" +
                "– Eu também bibi, e muito!!");
        jokes.add("Um homem chega correndo em casa e diz à mulher:\n" +
                "– Pode fazer as malas. Ganhei na loteria!\n" +
                "\n" +
                "A mulher pergunta:\n" +
                "– Eu preciso pegar roupa de inverno ou de verão?\n" +
                "\n" +
                "Ele responde:\n" +
                "– Pegue todas. Você vai embora!");
        jokes.add("Um mendigo se aproxima de uma senhora cheia de sacolas de compras que ia andando na rua e fala:\n" +
                "\n" +
                "— Madame, eu estou sem comer há 4 dias.\n" +
                "\n" +
                "E a madame:\n" +
                "\n" +
                "— Meu Deus! Eu gostaria de ter sua força de vontade!");
        jokes.add("2 amigos conversando…\n" +
                "– Meu pai quer que eu faça Direito e seja um bom Advogado.\n" +
                "– Que bom, vai seguir a profissão do velho?\n" +
                "– Não, ele quer que tire ele da cadeia.");
        jokes.add("O marido perguntou pra mulher:\n" +
                "\n" +
                "– Vamos tentar uma posição diferente essa noite?\n" +
                "\n" +
                "A mulher respondeu :\n" +
                "\n" +
                "– Boa ideia, você fica na pia lavando a louça e eu sento no sofá…");
        jokes.add("O português está no elevador com o casal de namorados e solta aquele peido. Então o cara pergunta:\n" +
                "\n" +
                "\u0097 – Você peidou?\n" +
                "\n" +
                "\u0097 – Claro, ou você acha que eu fedo assim o tempo todo? ");
        return jokes;
    }

}
