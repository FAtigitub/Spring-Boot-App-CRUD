package ma.xproce.tp2;

import ma.xproce.tp2.dao.entities.Creator;
import ma.xproce.tp2.dao.entities.Video;
import ma.xproce.tp2.dao.repositories.CreatorRepository;
import ma.xproce.tp2.dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class Tp2Application {
    @Autowired
    private CreatorRepository creatorRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }

    @Bean
    public CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {

            Creator creator1 = new Creator();
            creator1.setName("Fatima Ouali");
            creator1.setEmail("Fatima@example.com");

            Creator creator2 = new Creator();
            creator2.setName("OUALI sara");
            creator2.setEmail("sara@example.com");

            creatorRepository.saveAll(Arrays.asList(creator1, creator2));

            // Création des vidéos
            Video video1 = new Video();
            video1.setName("Video 1");
            video1.setUrl("example.com/video1");
            video1.setDescription("Description de la vidéo 1");
            video1.setDatePublication(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-04"));

            video1.setCreator(creator1);

            Video video2 = new Video();
            video2.setName("Video 2");
            video2.setUrl("example.com/video2");
            video2.setDescription("Description de la vidéo 2");
            video2.setDatePublication(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-03"));

            video2.setCreator(creator2);

            videoRepository.saveAll(Arrays.asList(video1, video2));
        };
    }




    }





