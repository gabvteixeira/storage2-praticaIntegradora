package br.com.viana.storageiipraticaintegradora1.service;

import br.com.viana.storageiipraticaintegradora1.model.Joia;
import br.com.viana.storageiipraticaintegradora1.repository.JoiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoiaService implements IJoia{

    @Autowired
    private JoiaRepo repo;

    @Override
    public List<Joia> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Joia create(Joia joia) {
        Joia newJoia = this.repo.save(joia);
        return newJoia;
    }

    @Override
    public void delete(long joiaId) {
        this.repo.deleteById(joiaId);
    }

    @Override
    public Joia update(long joiaId, Joia updateJoia) {
        Optional<Joia> optionalJoia = this.repo.findById(joiaId);

        if(optionalJoia.isEmpty()){
            return null; // TODO: Handle with an exception here
        }

        Joia newJoia = optionalJoia.get();

        if(updateJoia.getPeso() != null){
            newJoia.setPeso(updateJoia.getPeso());
        }

        if(updateJoia.getMaterial() != null) {
            newJoia.setMaterial(updateJoia.getMaterial());
        }

        return this.repo.save(newJoia);
    }
}
