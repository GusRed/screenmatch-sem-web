package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {

    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("sk-b_QvI-IG_09v0i101IroK-tTQjOjEot3sbDXtEpzyFT3BlbkFJPCJ3tLSMna3kAWoNyujRT5CPqJh40UKftWwOe1604A");

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .prompt("Traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }

}
