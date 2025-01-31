package naztech.app.jesper.service.impl;

import naztech.app.jesper.dto.ReadingProgressDTO;
import naztech.app.jesper.model.ReadingProgress;
import naztech.app.jesper.repo.ReadingProgressRepository;
import naztech.app.jesper.service.ReadingProgressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReadingProgressServiceImpl implements ReadingProgressService {
    private final ReadingProgressRepository readingProgressRepository;

    public ReadingProgressServiceImpl(ReadingProgressRepository readingProgressRepository) {
        this.readingProgressRepository = readingProgressRepository;
    }

    @Override
    public ReadingProgressDTO createProgress(ReadingProgressDTO readingProgressDTO) {
        ReadingProgress readingProgress = new ReadingProgress();
        readingProgress.setUserId(readingProgressDTO.getUserId());
        readingProgress.setBookId(readingProgressDTO.getBookId());
        readingProgress.setProgressPercentage(readingProgressDTO.getProgressPercentage());
        readingProgress.setLastReadAt(readingProgressDTO.getLastReadAt());
        readingProgress = readingProgressRepository.save(readingProgress);
        return convertToDTO(readingProgress);
    }

    @Override
    public ReadingProgressDTO getProgressById(Long id) {
        ReadingProgress readingProgress = readingProgressRepository.findById(id).orElseThrow(() -> new RuntimeException("Reading progress not found"));
        return convertToDTO(readingProgress);
    }

    @Override
    public List<ReadingProgressDTO> getAllProgress() {
        return readingProgressRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReadingProgressDTO updateProgress(Long id, ReadingProgressDTO readingProgressDTO) {
        ReadingProgress readingProgress = readingProgressRepository.findById(id).orElseThrow(() -> new RuntimeException("Reading progress not found"));
        readingProgress.setUserId(readingProgressDTO.getUserId());
        readingProgress.setBookId(readingProgressDTO.getBookId());
        readingProgress.setProgressPercentage(readingProgressDTO.getProgressPercentage());
        readingProgress.setLastReadAt(readingProgressDTO.getLastReadAt());
        readingProgress = readingProgressRepository.save(readingProgress);
        return convertToDTO(readingProgress);
    }

    @Override
    public void deleteProgress(Long id) {
        readingProgressRepository.deleteById(id);
    }

    private ReadingProgressDTO convertToDTO(ReadingProgress readingProgress) {
        ReadingProgressDTO dto = new ReadingProgressDTO();
        dto.setId(readingProgress.getId());
        dto.setUserId(readingProgress.getUserId());
        dto.setBookId(readingProgress.getBookId());
        dto.setProgressPercentage(readingProgress.getProgressPercentage());
        dto.setLastReadAt(readingProgress.getLastReadAt());
        return dto;
    }
}
