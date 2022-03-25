//Para registrar viagens e para uso do administrador da agência ou Gerente do bd.

package tardis.agencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ViagemRepository extends JpaRepository<Viagem,Long>{

}
