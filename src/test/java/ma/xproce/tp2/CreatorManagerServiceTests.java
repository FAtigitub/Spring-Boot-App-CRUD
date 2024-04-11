package ma.xproce.tp2;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import ma.xproce.tp2.dao.entities.Creator;
import ma.xproce.tp2.dao.repositories.CreatorRepository;
import ma.xproce.tp2.dao.service.CreatorManagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class CreatorManagerServiceTests{

    @Mock
    private CreatorRepository creatorRepository;

    @InjectMocks
    private CreatorManagerService creatorManagerService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCreators() {
        // Mock data
        Creator creator1 = new Creator();
        creator1.setId(1);
        Creator creator2 = new Creator();
        creator2.setId(2);
        List<Creator> creators = Arrays.asList(creator1, creator2);

        // Mocking repository behavior
        when(creatorRepository.findAll()).thenReturn(creators);

        // Test
        List<Creator> result = creatorManagerService.getAllCreators();

        assertEquals(2, result.size());
    }


}
