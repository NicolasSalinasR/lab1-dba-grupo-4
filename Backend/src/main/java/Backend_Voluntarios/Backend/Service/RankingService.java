package Backend_Voluntarios.Backend.Service;

import Backend_Voluntarios.Backend.Entity.RankingEntity;
import Backend_Voluntarios.Backend.Repository.RankingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {
    private RankingRepository repositoryRanking;

    public List<RankingEntity> listaFiltro(String palabraClave) {
        return repositoryRanking.findAll(palabraClave);
    }

    public List<RankingEntity> tablaCompleta() {
        return repositoryRanking.listAll();
    }

    public List<RankingEntity> listaRanking() {
        return repositoryRanking.listRanking();
    }

    public List<RankingEntity> tablaId(Long idVoluntario) {
        return repositoryRanking.buscarIdRanking(idVoluntario);
    }

    public RankingEntity nuevoRanking(RankingEntity rankingEntity) {
        return repositoryRanking.crearRanking(rankingEntity.getIdRanking(),
                rankingEntity.getIdTarea(),
                rankingEntity.getIdVoluntario(),
                rankingEntity.getNivelRanking(),
                rankingEntity.getTareaRanking());
    }

    public RankingEntity borrarRanking(RankingEntity rankingEntity) {
        return repositoryRanking.borrarRanking(rankingEntity.getIdRanking());
    }

    public RankingEntity buscarId(Long idRanking) {
        return repositoryRanking.idRanking(idRanking);
    }

    public int puntajeRanking(String zona, List<String> equipo) {
        int contador = 0;
        if (repositoryRanking.matchZona(zona) != null) {
            contador = contador + 1;
        }
        contador = contador + repositoryRanking.matchEquipo(equipo);
        return contador;
    }
}
