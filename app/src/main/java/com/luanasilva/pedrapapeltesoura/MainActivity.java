package com.luanasilva.pedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void selecionarPedra(View view) {
        verificarGanhador("pedra");
    }

    public void selecionarPapel(View view) {
        verificarGanhador("papel");
    }

    public void selecionarTesoura(View view) {
        verificarGanhador("tesoura");
    }

    private String gerarEscolhaAleatoriaApp() {
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.image_app);
        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp) {
            case "pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return escolhaApp;
    }

    private void verificarGanhador(String escolhaUsuario){
        String escolhaApp = gerarEscolhaAleatoriaApp();
        TextView textoResultado = findViewById(R.id.viewResultado);

        if (
            Objects.equals(escolhaApp, "pedra") && Objects.equals(escolhaUsuario, "tesoura") ||
            Objects.equals(escolhaApp, "tesoura") && Objects.equals(escolhaUsuario, "papel") ||
            Objects.equals(escolhaApp, "papel") && Objects.equals(escolhaUsuario, "pedra")
        ){
            textoResultado.setText(R.string.voce_perdeu);
        } else if (
            Objects.equals(escolhaUsuario, "pedra") && Objects.equals(escolhaApp, "tesoura") ||
            Objects.equals(escolhaUsuario, "tesoura") && Objects.equals(escolhaApp, "papel") ||
            Objects.equals(escolhaUsuario, "papel") && Objects.equals(escolhaApp, "pedra")
        ) {
            textoResultado.setText(R.string.voce_ganhou);
        }else {
            textoResultado.setText(R.string.empate);
        }

    }

}