package com.linkey.core.repository.image;

import com.linkey.core.domain.entity.Image;
import com.linkey.core.repository.image.custom.ImageRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long>, ImageRepositoryCustom {
}
