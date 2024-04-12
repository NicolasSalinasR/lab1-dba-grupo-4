package Backend_Voluntarios.Backend.Service;

import Backend_Voluntarios.Backend.Entity.RankingEntity;
import Backend_Voluntarios.Backend.Repository.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {
    @Autowired
    private RankingRepository repositoryRanking;

    public List<RankingEntity> Lista_filtro(String PalabraClave){
        return repositoryRanking.findAll(PalabraClave);
    }

    public List<RankingEntity> Tabla_completa(){
        return repositoryRanking.ListAll();
    }

    public List<RankingEntity> Tabla_Id(Long Id_voluntario){
        return repositoryRanking.BuscarId_ranking(Id_voluntario);
    }

    public RankingEntity Nuevo_ranking(RankingEntity entity_ranking){
        return repositoryRanking.Crear_ranking(entity_ranking.getId_ranking(), entity_ranking.getId_tarea(), entity_ranking.getId_voluntario(), entity_ranking.getNivel_ranking(), entity_ranking.getTarea_ranking());
    }

    public RankingEntity Borrar_ranking(RankingEntity entity_ranking){
        return repositoryRanking.Borrar_ranking(entity_ranking.getId_ranking());
    }

    public RankingEntity Buscar_Id(Long Id_ranking){
        return repositoryRanking.Id_ranking(Id_ranking);
    }
}
