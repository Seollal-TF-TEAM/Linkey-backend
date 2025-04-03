package com.linkey.core.service.Image;

import com.linkey.core.domain.dto.response.ResImageListDto;
import com.linkey.core.domain.entity.Image;
import com.linkey.core.global.exception.CustomException;
import com.linkey.core.global.exception.ErrorCode;
import com.linkey.core.repository.image.ImageRepository;
import com.linkey.core.service.Image.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Value("${IMAGE_UPLOAD_DIR}")
    private String uploadDir;

    @Override
    public ResImageListDto getImagesBySprintId(long sprintId) {
        return null;
    }

    @Override
    public ResImageListDto getImagesByProjectId(int projectId) {
        return null;
    }

    @Override
    public long createImage(MultipartFile imageFile) throws CustomException {
        try {
            // imageFile 저장
            if (imageFile.isEmpty()) {
                throw new CustomException(ErrorCode.CAN_NOT_CREATE_IMAGE);
            }
            String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                throw new CustomException(ErrorCode.UPLOAD_DIR_NOT_EXIST);
            }
            imageFile.transferTo(filePath.toFile());

            // image DB 저장
            Image image = imageRepository.save(
                    Image.builder()
                            .imageUrl("")
                            .imagePath("")
                            .fileSize(imageFile.getSize())
                            .fileType(imageFile.getContentType())
                            .build()
            );
            return image.getImgId();
        } catch (IOException e) {
            throw new CustomException(ErrorCode.CAN_NOT_WRITE);
        } catch (RuntimeException e) {
            throw new CustomException(ErrorCode.CAN_NOT_CREATE_IMAGE);
        }
    }
}
