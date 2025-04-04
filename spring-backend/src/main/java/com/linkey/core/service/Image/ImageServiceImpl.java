package com.linkey.core.service.Image;

import com.linkey.core.domain.dto.request.ReqUpdateImageDto;
import com.linkey.core.domain.dto.response.ResImageListDto;
import com.linkey.core.domain.entity.Image;
import com.linkey.core.global.exception.CustomException;
import com.linkey.core.global.exception.ErrorCode;
import com.linkey.core.repository.image.ImageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
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
    public ResImageListDto getImagesBySprintId(long sprintId) throws CustomException {
        try {
            List<Image> imageList = imageRepository.findImagesBySprintId(sprintId);
            if (imageList.isEmpty()) {
                throw new CustomException(ErrorCode.IMAGE_NOT_FOUND);
            }
            return ResImageListDto.fromEntity(imageList);
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_FIND_IMAGE);
        }
    }

    @Override
    public ResImageListDto getImagesByProjectId(int projectId) throws CustomException {
        try {
            List<Image> imageList = imageRepository.findImagesByProjectId(projectId);
            if (imageList.isEmpty()) {
                throw new CustomException(ErrorCode.IMAGE_NOT_FOUND);
            }
            return ResImageListDto.fromEntity(imageList);
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_FIND_IMAGE);
        }
    }

    @Override
    public long createImage(MultipartFile imageFile) throws CustomException {
        try {
            // imageFile 저장
            if (imageFile.isEmpty()) {
                throw new CustomException(ErrorCode.IMAGE_FILE_CAN_NOT_NULL);
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
                            .createdAt(LocalDateTime.now())
                            .build()
            );
            return image.getImgId();
        } catch (CustomException e) {
            throw e;
        } catch (IOException e) {
            throw new CustomException(ErrorCode.CAN_NOT_WRITE);
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_CREATE_IMAGE);
        }
    }

    @Override
    public long updateImage(ReqUpdateImageDto reqUpdateImageDto) throws CustomException {
        try {
            Image target = imageRepository.findById(reqUpdateImageDto.getImgId())
                    .orElseThrow(() -> new CustomException(ErrorCode.IMAGE_NOT_FOUND));
            Image updatedTarget = target.update(reqUpdateImageDto);
            imageRepository.save(updatedTarget);
            return updatedTarget.getImgId();
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_UPDATE_IMAGE);
        }
    }

    @Override
    public long deleteImage(long reqImgId) throws CustomException {
        try {
            Image target = imageRepository.findById(reqImgId)
                    .orElseThrow(() -> new CustomException(ErrorCode.IMAGE_NOT_FOUND));
            imageRepository.delete(target);
            return target.getImgId();
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_DELETE_IMAGE);
        }
    }

}
