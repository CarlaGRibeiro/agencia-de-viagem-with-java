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
@RequestMapping("/api/v1")
public class UsuarioController {
	
@Autowired
private UsuarioRepository usuarioRepository;

//pegar todos os usuarios
@GetMapping("/usuarios")
public List<Usuario>getAllUsuarios(){
	return usuarioRepository.findAll();
}


//get usuarios by id rest api
@GetMapping("/usuarios/{id}")
public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
Usuario usuario = usuarioRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Usuario not exist with id :" + id));
return ResponseEntity.ok(usuario);
}


//criar novos usuarios na api
@PostMapping("/usuarios")
public Usuario createUsuario(@RequestBody Usuario usuario) {
	return usuarioRepository.save(usuario);
}
	
//atualização de dados na tabela usuarios na api

@PutMapping("/usuarios/{id}")
public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails){
Usuario usuario = usuarioRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Usuario not exist with id :" + id));


usuario.setNome(usuarioDetails.getNome());
usuario.setSobrenome(usuarioDetails.getSobrenome());
usuario.setEmail(usuarioDetails.getEmail());
usuario.setCPF(usuarioDetails.getCPF());
usuario.setEndereco(usuarioDetails.getEndereco());
usuario.setNumero(usuarioDetails.getNumero());
usuario.setComplemento(usuarioDetails.getComplemento());
usuario.setBairro(usuarioDetails.getBairro());
usuario.setCidade(usuarioDetails.getCidade());
usuario.setEstado(usuarioDetails.getEstado());
usuario.setPais(usuarioDetails.getPais());
usuario.setSenha(usuarioDetails.getSenha());

Usuario updateUsuario = usuarioRepository.save(usuario);
return ResponseEntity.ok(updateUsuario);

}

//deletar registros da tabela de usuarios
@DeleteMapping("/usuarios/{id}")
public ResponseEntity<Map<String, Boolean>> deleteUsuario(@PathVariable Long id){
Usuario usuario = usuarioRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Usuario not exist with id :" + id));
usuarioRepository.delete(usuario);
Map<String, Boolean> response = new HashMap<>();
response.put("deleted", Boolean.TRUE);
return ResponseEntity.ok(response);
}
}


