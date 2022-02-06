package hello.thymeleaf.basic.itemservice.upload.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class Item {
    private Long id;
    private String itemName;
    private UploadFile attachFile;
    private List<UploadFile> imageFiles;
}
