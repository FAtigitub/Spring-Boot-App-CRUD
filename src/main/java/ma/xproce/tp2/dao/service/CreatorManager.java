package ma.xproce.tp2.dao.service;

import ma.xproce.tp2.dao.entities.Creator;

import java.util.List;

public interface CreatorManager {
    List<Creator> getAllCreators();
    Creator getCreatorById(Integer id);
    void saveCreator(Creator creator);
    boolean deleteCreator(Integer id);

}