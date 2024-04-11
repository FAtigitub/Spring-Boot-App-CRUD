package ma.xproce.tp2;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import ma.xproce.tp2.dao.entities.Video;
import ma.xproce.tp2.dao.repositories.VideoRepository;
import ma.xproce.tp2.dao.service.VideoManagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



public class VideoManagerServiceTests{

    @Mock
    private VideoRepository videoRepository;

    @InjectMocks
    private VideoManagerService videoManagerService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllVideos() {
        // Mock data
        Video video1 = new Video();
        video1.setId(1);
        Video video2 = new Video();
        video2.setId(2);
        List<Video> videos = Arrays.asList(video1, video2);

        // Mocking repository behavior
        when(videoRepository.findAll()).thenReturn(videos);

        // Test
        List<Video> result = videoManagerService.getAllVideos();

        assertEquals(2, result.size());
    }


}
