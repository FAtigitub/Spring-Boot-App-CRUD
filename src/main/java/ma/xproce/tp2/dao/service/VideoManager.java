package ma.xproce.tp2.dao.service;


import ma.xproce.tp2.dao.entities.Video;

import java.util.List;

public interface VideoManager {
    List<Video> getAllVideos();
    Video getVideoById(Integer id);
    void saveVideo(Video video);
    void deleteVideo(Integer id);
}

