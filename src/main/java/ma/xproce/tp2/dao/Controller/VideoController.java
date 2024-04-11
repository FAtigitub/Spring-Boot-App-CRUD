package ma.xproce.tp2.dao.Controller;


import ma.xproce.tp2.dao.entities.Video;
import ma.xproce.tp2.dao.service.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoManager videoManager;

    // Afficher la liste des vidéos
    @GetMapping
    public List<Video> getAllVideos() {
        return videoManager.getAllVideos();
    }

    // Ajouter une nouvelle vidéo
    @PostMapping
    public ResponseEntity<Void> addVideo(@RequestBody Video video) {
        videoManager.saveVideo(video);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Modifier une vidéo existante
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVideo(@PathVariable Integer id, @RequestBody Video video) {
        Video existingVideo = videoManager.getVideoById(id);
        if (existingVideo != null) {
            video.setId(id);
            videoManager.saveVideo(video);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer une vidéo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Integer id) {
        Video existingVideo = videoManager.getVideoById(id);
        if (existingVideo != null) {
            videoManager.deleteVideo(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
