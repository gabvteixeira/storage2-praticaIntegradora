package br.com.viana.storageiipraticaintegradora1.service;

import br.com.viana.storageiipraticaintegradora1.model.Joia;

import java.util.List;

public interface IJoia {
   List<Joia> getAll();

    Joia create(Joia joia);

    void delete(long joiaId);

    Joia update(long joiaId, Joia updateJoia);
}
