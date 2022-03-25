//Para registrar viagens e para uso do administrador da agência ou Gerente do bd.

package tardis.agencia;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/ad")
public class ViagemController {
	
@Autowired
private ViagemRepository viagemRepository;

//pegar todos as viagens
@GetMapping("/viagens")
public List<Viagem>getAllViagens(){
	return viagemRepository.findAll();
}


//get viagens by id rest api
@GetMapping("/viagens/{id}")
public ResponseEntity<Viagem> getViagemById(@PathVariable Long id) {
Viagem viagem = viagemRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Viagem not exist with id :" + id));
return ResponseEntity.ok(viagem);
}


//criar novos viagens na api
@PostMapping("/viagens")
public Viagem createViagem(@RequestBody Viagem viagem) {
	return viagemRepository.save(viagem);
}
	
//atualização de dados na tabela viagens na api

@PutMapping("/viagens/{id}")
public ResponseEntity<Viagem> updateViagem(@PathVariable Long id, @RequestBody Viagem viagemDetails){
Viagem viagem = viagemRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Viagem not exist with id :" + id));


viagem.setNomeSobrenome(viagemDetails.getNomeSobrenome());
viagem.setOrigem(viagemDetails.getOrigem());

viagem.setDestino(viagemDetails.getDestino());
viagem.setDataHoraViagem(viagemDetails.getDataHoraViagem());


Viagem updateViagem = viagemRepository.save(viagem);
return ResponseEntity.ok(updateViagem);

}

//deletar registros da tabela de viagens
@DeleteMapping("/viagens/{id}")
public ResponseEntity<Map<String, Boolean>> deleteViagem(@PathVariable Long id){
Viagem viagem = viagemRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Viagem not exist with id :" + id));
viagemRepository.delete(viagem);
Map<String, Boolean> response = new HashMap<>();
response.put("deleted", Boolean.TRUE);
return ResponseEntity.ok(response);
}
}


