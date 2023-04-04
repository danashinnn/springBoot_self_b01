package org.zerock.self_b01.service;

import org.zerock.self_b01.dto.BoardDTO;
import org.zerock.self_b01.dto.PageRequestDTO;
import org.zerock.self_b01.dto.PageResponseDTO;

public interface BoardService {
    Long register(BoardDTO boardDTO);
    BoardDTO readOne(Long bno);
    void modify(BoardDTO boardDTO);
    void remove(Long bno);
    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
}
