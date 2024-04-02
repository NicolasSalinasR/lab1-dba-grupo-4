package Backend_Voluntarios.Backend.Service;

import Backend_Voluntarios.Backend.Entity.Entity_Ranking;
import Backend_Voluntarios.Backend.Repository.Interface_Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service_Ranking {
    @Autowired
    private Interface_Ranking interfaceRanking;

    public List<Entity_Ranking> ListALL(String palabraClave){
        if(palabraClave != null){
            return  interfaceRanking.findAll(palabraClave);
        }
        return  interfaceRanking.findAll();
    }
}
