package org.unibl.etf.hakaton.repositories;

import org.springframework.stereotype.Repository;
import org.unibl.etf.hakaton.models.entities.PredmetEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PredmetEntityRepository
{
    private static List<PredmetEntity> predmets=new ArrayList<>();
    static
    {
        predmets.add(new PredmetEntity("Baze podataka","2251",true,"prof. dr Mika Mikic",5,6,3));
        predmets.add(new PredmetEntity("Mdp","2247",true,"prof. dr Janko Jankovic",5,6,3));
        predmets.add(new PredmetEntity("Opos","2234",true,"prof. dr Marko Mitrovic",6,5,3));
        predmets.add(new PredmetEntity("Arhitektura racunara","2234",true,"prof. dr Uros Djuric",5,5,3));
        predmets.add(new PredmetEntity("Internet tehnologije","2247",true,"prof. dr Nemanja Djukic",6,6,3));
    }

    public List<PredmetEntity> getPredmetsForVerifyByStudentId()
    {
        return predmets.stream().filter(p->p.getSemestar()==5).collect(Collectors.toList());
    }

    public List<PredmetEntity> getPredmetsForEnrolByStuddentId()
    {
        return predmets.stream().filter(p->p.getSemestar()==6).collect(Collectors.toList());
    }
}
