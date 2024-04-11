package ma.xproce.tp2.dao.service;

import ma.xproce.tp2.dao.entities.Video;
import ma.xproce.tp2.dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoManagerService implements VideoManager {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @Override
    public Video getVideoById(Integer id) {
        return videoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveVideo(Video video) {
        videoRepository.save(video);
    }

    @Override
    public void deleteVideo(Integer id) {
        videoRepository.deleteById(id);
    }
}

