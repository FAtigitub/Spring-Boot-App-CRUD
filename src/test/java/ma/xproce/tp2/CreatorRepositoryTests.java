package ma.xproce.tp2;


import ma.xproce.tp2.dao.entities.Creator;
import ma.xproce.tp2.dao.repositories.CreatorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CreatorRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CreatorRepository creatorRepository;

    @Test
    public void testSaveCreator() {
        // Given
        Creator creator = new Creator();
        creator.setName("FATIMA");
        creator.setEmail("Ouali@example.com");

        // When
        Creator savedCreator = creatorRepository.save(creator);

        // Then
        assertNotNull(savedCreator.getId());
        assertEquals("FATIMA", savedCreator.getName());
    }




}
