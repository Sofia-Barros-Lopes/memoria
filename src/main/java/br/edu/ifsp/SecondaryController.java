package br.edu.ifsp;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class SecondaryController implements Initializable {

    @FXML
    private VBox fundoDois;

    @FXML
    private ImageView iv00, iv01, iv02, iv03, iv04,
                       iv10, iv11, iv12, iv13, iv14,
                       iv20, iv21, iv22, iv23, iv24,
                       iv30, iv31, iv32, iv33, iv34,
                       iv40, iv41, iv42, iv43, iv44,
                       iv50, iv51, iv52, iv53, iv54;

    private ImageView[] imageViews;
    private Image fundoCarta;
    private int pontos; // Variável para armazenar a pontuação
    private Label pontosLabel;
    private List<Image> cartasImagens;

    @FXML
    private void switchToPrimary() throws IOException {
        // Reiniciar o jogo e embaralhar as cartas
        inicializarCartas();  // Embaralha as cartas
        pontos = 0;  // Reiniciar a pontuação
        pontosLabel.setText("Pontos: " + pontos);  // Atualizar a pontuação
        App.setRoot("primary");  // Volta para a tela principal
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Definir fundo para o VBox
        BackgroundFill bf1 = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background bg2 = new Background(bf1);
        fundoDois.setBackground(bg2);

        // Inicializa o array de ImageView
        imageViews = new ImageView[] { iv00, iv01, iv02, iv03, iv04,
                                      iv10, iv11, iv12, iv13, iv14,
                                      iv20, iv21, iv22, iv23, iv24,
                                      iv30, iv31, iv32, iv33, iv34,
                                      iv40, iv41, iv42, iv43, iv44, 
                                      iv50, iv51, iv52, iv53, iv54 };
        fundoCarta = new Image(this.getClass().getResource("interrogacao.jpg").toString());
        mostrarCartasPor5Segundos();
        // Inicializar as imagens das cartas e pontuação
        inicializarCartas();
        pontos = 0; // Iniciar a pontuação
        pontosLabel.setText("Pontos: " + pontos); // Atualizar o label com a pontuação
    }

    private void inicializarCartas() {
        // Criar uma lista de imagens para as cartas
        cartasImagens = new ArrayList<>();
        cartasImagens.add(new Image(this.getClass().getResource("imagemarara.png").toString()));
        cartasImagens.add(new Image(this.getClass().getResource("imagembaleia.png").toString()));
        cartasImagens.add(new Image(this.getClass().getResource("imagemcachorro.png").toString()));
        cartasImagens.add(new Image(this.getClass().getResource("imagemcavalo.png").toString()));
        cartasImagens.add(new Image(this.getClass().getResource("imagemcobra.png").toString()));
        cartasImagens.add(new Image(this.getClass().getResource("imagemelefante.png").toString()));
        cartasImagens.add(new Image(this.getClass().getResource("imagemfoca.png").toString()));
        cartasImagens.add(new Image(this.getClass().getResource("imagemgato.png").toString()));
        cartasImagens.add(new Image(this.getClass().getResource("imagemhamster.png").toString()));
        cartasImagens.add(new Image(this.getClass().getResource("imagemleao.png").toString()));
        cartasImagens.add(new Image(this.getClass().getResource("imagemMacaco.png").toString()));
        cartasImagens.add(new Image(this.getClass().getResource("imagemovelha.png").toString()));
        cartasImagens.add(new Image(this.getClass().getResource("imagempeixe.png").toString()));
        cartasImagens.add(new Image(this.getClass().getResource("imagemtigre.png").toString()));
        cartasImagens.add(new Image(this.getClass().getResource("imagemvaca.png").toString()));


        
        // Duplicar as imagens para criar os pares
        List<Image> cartasComPares = new ArrayList<>(cartasImagens);
        cartasComPares.addAll(cartasImagens);

        // Embaralhar as imagens
        Collections.shuffle(cartasComPares);

        // Atribuir as imagens embaralhadas aos ImageViews
        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i].setImage(fundoCarta); // Definir imagem de fundo inicialmente
        }
    }

    private void mostrarCartasPor5Segundos() {
        // Exibe todas as cartas (imagens reais) no início
        for (ImageView iv : imageViews) {
            iv.setImage(new Image(this.getClass().getResource("imagemelefante.png").toString()));
        }

        // Criar um temporizador para esconder as cartas após 10 segundos
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> esconderTodasCartas()));
        timeline.play();  // Inicia o temporizador
    }

     // Método para verificar se o par foi encontrado
     //private void checarPar() {
        // Se as duas cartas selecionadas forem iguais, aumenta a pontuação
        // Aqui, implementamos uma verificação de cartas selecionadas e aumentamos os pontos
        // A lógica de verificação e de esconder cartas será implementada na sequência do jogo
        //pontos++;
        //pontosLabel.setText("Pontos: " + pontos);  // Atualiza a exibição da pontuação
   // }

    // Método que esconde todas as cartas com a imagem de fundo
    private void esconderTodasCartas() {
        for (ImageView iv : imageViews) {
            iv.setImage(fundoCarta);  // Definindo a imagem do fundo (interrogacao.jpeg)
        }
    }

   @FXML
    public void virarCarta() {
        // Itera sobre todos os ImageViews e alterna a opacidade
        for (ImageView iv : imageViews) {
            // Se a opacidade for 0, exibe a carta, se não, esconde
            iv.setOpacity(iv.getOpacity() == 0.0 ? 1.0 : 0.0);
        }
    }

   private boolean clicou = false;

    @FXML
    public void esconderCarta() {
        if (!clicou) {
            //Se ainda não clicou, carrega a imagem
            Image image = new Image(this.getClass().getResource("imagemelefante.png").toString());
            iv00.setImage(image);  // Define a imagem no ImageView
            clicou = true;  // Marca que a imagem foi carregada
        } else {
            // Se já clicou, volta o botão ao estado inicial
            iv00.setImage(fundoCarta);  // Remove a imagem
            clicou = false;  // Marca que a imagem foi removida
        }
    }
}