package ma.xproce.tp2.dao.service;

import ma.xproce.tp2.dao.entities.Creator;
import ma.xproce.tp2.dao.repositories.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatorManagerService implements CreatorManager {

    @Autowired
    private CreatorRepository creatorRepository;

    @Override
    public List<Creator> getAllCreators() {

        return creatorRepository.findAll();
    }

    @Override
    public Creator getCreatorById(Integer id) {
        return creatorRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCreator(Creator creator) {
        creatorRepository.save(creator);
    }

    @Override
    public boolean deleteCreator(Integer id) {
        creatorRepository.deleteById(id);
        return false;
    }
}
