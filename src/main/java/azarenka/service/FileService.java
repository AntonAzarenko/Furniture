package azarenka.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileService {

    void upload(MultipartFile file) throws Exception;

    void update(MultipartFile file, Long id) throws Exception;

    void remove(Long id);

    File getPath(String name);

    Resource loadFile(String filename);

    void abort(String name);
}
