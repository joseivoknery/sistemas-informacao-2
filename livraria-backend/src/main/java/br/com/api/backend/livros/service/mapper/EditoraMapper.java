/**
 *
 */
package br.com.api.backend.livros.service.mapper;

import java.util.List;
import java.util.stream.Collectors;
import br.com.api.backend.livros.persistence.dto.editora.EditoraDto;
import br.com.api.backend.livros.persistence.dto.editora.EditoraUpdate;
import br.com.api.backend.livros.persistence.model.Editora;

/**
 * @author José Ivo K. Nery
 *
 */
public class EditoraMapper {

  public static Editora mapper(EditoraDto editoraDto) {

    Editora editora = new Editora();

    editora.setId(editoraDto.getId());

    editora.setNome(editoraDto.getNomeEditora());

    return editora;
  }

  public static Editora mapperCadastro(EditoraUpdate editoraDto) {

    Editora editora = new Editora();

    editora.setNome(editoraDto.getNomeEditora());

    return editora;
  }

  public static Editora mapperUpdate(EditoraUpdate editoraDto, Editora editora) {

    editora.setNome(editoraDto.getNomeEditora());

    return editora;
  }

  public static EditoraDto mapper(Editora editora) {

    EditoraDto editoraDto = new EditoraDto();

    editoraDto.setId(editora.getId());

    editoraDto.setNomeEditora(editora.getNome());

    return editoraDto;
  }

  public static List<EditoraDto> mapper(List<Editora> editoras) {

    return editoras.stream().map(EditoraMapper::mapper).collect(Collectors.toList());
  }

}
