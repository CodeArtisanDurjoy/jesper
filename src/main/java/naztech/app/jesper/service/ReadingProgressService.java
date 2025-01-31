package naztech.app.jesper.service;

import naztech.app.jesper.dto.ReadingProgressDTO;

import java.util.List;

public interface ReadingProgressService {
    ReadingProgressDTO createProgress(ReadingProgressDTO readingProgressDTO);
    ReadingProgressDTO getProgressById(Long id);
    List<ReadingProgressDTO> getAllProgress();
    ReadingProgressDTO updateProgress(Long id, ReadingProgressDTO readingProgressDTO);
    void deleteProgress(Long id);
}
